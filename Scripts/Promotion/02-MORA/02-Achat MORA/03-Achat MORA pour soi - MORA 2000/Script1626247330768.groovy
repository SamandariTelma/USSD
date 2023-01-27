import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

String numeroInitiateur="${numeroInitiateur}"

String montantMora = "${montantMora2000}"

'Consulter mon solde avant d\' effectuer un achat MORA'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeAvant = GlobalVariable.soldeCredit

'Je shortcode *130*5# et je valide'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 2(MORA)'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis  3 (MORA+ 2000) et je valide'
CustomKeywords.'ussd.Send.response'('3')

'Je confirme l\'achat en saisissant 1 (OUI)'
String actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du menu'
String menu=CustomKeywords.'ussd.Expected.menu'('KADOA POUR TOI DADA\\! 400 Mo de bonus DATA à l achat de ton MORA\\+2000, valable 2j, à toute heure\\. Consulte ton bonus sur #359#\\. TELMA N1 des KADOA\\.',
	'KADOA HO AN NY DADA\\! 400 Mo bonus DATA ho anao noho ny MORA\\+2000 novidinao, manankery 2 andro\\. Jereo ao @\\#359\\# ny bonus azonao\\. TELMA N1 DES KADOA')

WS.verifyMatch(actualMenu, menu, true)

'Je vérifie que mon solde est déduit du montant de MORA acheté'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeApresMora = GlobalVariable.soldeCredit

int soldeExcepted=soldeAvant - Integer.valueOf(montantMora)
WS.verifyEqual(soldeApresMora, soldeExcepted)