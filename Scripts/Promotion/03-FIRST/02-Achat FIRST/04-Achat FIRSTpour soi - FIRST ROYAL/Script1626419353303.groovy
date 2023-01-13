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

String montantFirstRoyal = "${montantFirstRoyal}"

'Consulter mon solde avant d\' effectuer un FIRST ROYAL'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeAvant = GlobalVariable.soldeCredit

'Je shortcode *130*5# et je valide'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 3(FIRST)'
CustomKeywords.'ussd.Send.response'('3')

'Je saisis  4 (First Royal) et je valide'
CustomKeywords.'ussd.Send.response'('4')

'Je confirme l\'achat en saisissant 1 (OUI)'
String actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du menu'
String menu=CustomKeywords.'ussd.Expected.menu'('L achat de votre FIRST ROYAL est reussi\\. Bonus restants: #359#\\. Achetez via MVola et gagnez a chaque fois un bonus kadoa de 20%\\.Tapez vite le #111\\*1#\\.',
	'Tafiditra ny tolotra FIRST ROYAL novidianao\\. Bonus\\-nao: #359#\\. Vidio @MVola ny tolotrao  ary mahazoa hatrany Bonus kadoa 20%\\. Tsindrio ny #111\\*1#\\.')

WS.verifyMatch(actualMenu, menu, true)

'Je vérifie que mon solde est déduit du montant de FIRST ROYAL'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeApresFirstRoyal = GlobalVariable.soldeCredit

int soldeExcepted=soldeAvant - Integer.valueOf(montantFirstRoyal)
WS.verifyEqual(soldeApresFirstRoyal, soldeExcepted)
