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

String montantMora = "${montantMoraNIGHT}"

'Consulter mon solde avant d\' effectuer un achat MORA'
WebUI.callTestCase(findTestCase('Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeAvant = GlobalVariable.soldeCredit

'Je shortcode *130*5# et je valide'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 2(MORA)'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis  5 (MORA NIGHT) et je valide'
CustomKeywords.'ussd.Send.response'('5')

'Je confirme l\'achat en saisissant 1 (OUI)'
String actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du menu'
String menu=CustomKeywords.'ussd.Expected.menu'('Vous avez choisi MORA NIGHT, desormais valable 24 HEURES\\. Beneficiez de 60 Mn et/ou 60 SMS utlisables de 21h a 6h vers TELMA\\. Solde bonus : #359#\\.',
	'Nisafidy ny MORA NIGHT ianao, manankery 24 ORA manomboka izao\\. Antso 60 Mn sy/na SMS 60 azo ampiasaina @21h h@6h manakany @ nomerao Telma\\. Bonus tavela: #359#\\. ')

WS.verifyMatch(actualMenu, menu, true)

'Je vérifie que mon solde est déduit du montant de MORA acheté'
WebUI.callTestCase(findTestCase('Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeApresMora = GlobalVariable.soldeCredit

int soldeExcepted=soldeAvant - Integer.valueOf(montantMora)
WS.verifyEqual(soldeApresMora, soldeExcepted)