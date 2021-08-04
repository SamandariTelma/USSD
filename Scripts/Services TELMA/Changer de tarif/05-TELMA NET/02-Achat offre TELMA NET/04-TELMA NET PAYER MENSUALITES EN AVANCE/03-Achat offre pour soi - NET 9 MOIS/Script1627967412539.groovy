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
WebUI.callTestCase(findTestCase('Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeAvant = GlobalVariable.soldeCredit

'Je vais dans le menu Changer de tarif en shortcodant #130*4*6#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 4 (TELMA Net (INTERNET)) et valide'
CustomKeywords.'ussd.Send.response'('4')

'Je saisi 4 (TELMA NET Payer mensualités en avance)'
CustomKeywords.'ussd.Send.response'('4')

'Je saisis 3(NET 9 MOIS)'
String actualMenu=CustomKeywords.'ussd.Send.response'('3')

'Je vérifie la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Votre NET 9 MOIS est activee\\. Vous avez 250 Mo/mois pendant 9 mois\\. Bonus restant #359#\\. Achetez via MVola et gagnez un bonus Kadoa de 20%\\. \\(#111\\*1#\\)',
	'Tafiditra ny tolotra NET 9 MOIS\\.Manana 250Mo isam bolana ianao mandritry ny 9 volana\\. Bonus #359#\\.Vidio @Mvola ny tolotra ary mahazoa bonus KADOA 20%\\. \\(#111\\*1#\\)')

WS.verifyMatch(actualMenu, menu, true)
'Je vérifie que mon solde est déduit du montant de TELMA NET acheté'
WebUI.callTestCase(findTestCase('Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeApresTelmaNet = GlobalVariable.soldeCredit

int soldeExcepted=soldeAvant - Integer.valueOf(montantTelmaNet)
WS.verifyEqual(soldeApresTelmaNet, soldeExcepted)