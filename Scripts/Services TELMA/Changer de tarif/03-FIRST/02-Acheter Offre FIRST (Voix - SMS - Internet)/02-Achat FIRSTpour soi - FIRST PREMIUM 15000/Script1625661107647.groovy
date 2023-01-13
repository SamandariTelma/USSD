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

String montantFirstPrenium = "${montantFirstPrenium}"

'Consulter mon solde avant d\' effectuer un FIRST PRENIUM 15000'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeAvant = GlobalVariable.soldeCredit

'Je shortcode *130*4*6*# et je valide'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 2(FIRST)'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis  2 (First Premium+) et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('2')

'Vérifier la conformité du menu'
String menu=CustomKeywords.'ussd.Expected.menu'('L achat de votre FIRST PREMIUM\\+ est reussi\\. Bonus restants: #359#\\. Achetez via MVola et gagnez a chaque fois un bonus kadoa de 20%\\.Tapez vite le #111\\*1#\\.',
	'Tafiditra ny tolotra FIRST PREMIUM\\+ novidianao\\. Bonus\\-nao: #359#\\. Vidio @MVola ny tolotrao ary mahazoa hatrany Bonus kadoa 20%\\. Tsindrio ny #111\\*1#\\.')

WS.verifyMatch(actualMenu, menu, true)

'Je vérifie que mon solde est déduit du montant de FIRST PRENIUM 15000'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeApresFirst15000 = GlobalVariable.soldeCredit

int soldeExcepted=soldeAvant - Integer.valueOf(montantFirstPrenium)
WS.verifyEqual(soldeApresFirst15000, soldeExcepted)
