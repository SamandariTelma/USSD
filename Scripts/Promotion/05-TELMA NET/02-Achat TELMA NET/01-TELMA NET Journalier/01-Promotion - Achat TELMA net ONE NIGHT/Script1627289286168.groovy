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
String montantTelmaNet="${montantTelmaNet}"

'Consulter mon solde avant d\' effectuer un TELMA NET'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeAvant = GlobalVariable.soldeCredit

'Je vais dans le menu TELMA NET en shortcodant #130*5*5#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'*5#', numeroInitiateur)

'Je saisi 1 (TELMA NET Journalier)'
String actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Je saisis 1(NET ONE NIGHT)'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis 1 (OUI) et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Je vérifie la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('L achat de votre NET ONE NIGHT est reussi\\. Vous avez 40 Mo utilisable de 0h a 6h et de 21h a 00h\\. Achetez via Mvola et gagnez 20% de bonus\\. #111\\*1#\\.',
	'Tafiditra ny tolotra NET ONE NIGHT novidianao\\. Manana 40 Mo ianao azo ampiasaina @ 0h\\-6h sy 21h\\-0h\\. Vidio @Mvola ny tolotra ary mahazoa bonus 20%\\. \\(#111\\*1#\\)\\.')

WS.verifyMatch(actualMenu, menu, true)
'Je vérifie que mon solde est déduit du montant de TELMA NET acheté'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeApresTelmaNet = GlobalVariable.soldeCredit

int soldeExcepted=soldeAvant - Integer.valueOf(montantTelmaNet)
WS.verifyEqual(soldeApresTelmaNet, soldeExcepted)