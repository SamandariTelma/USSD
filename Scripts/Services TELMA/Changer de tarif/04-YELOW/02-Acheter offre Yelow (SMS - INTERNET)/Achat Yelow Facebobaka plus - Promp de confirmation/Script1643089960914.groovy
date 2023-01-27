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

String numeroInitiateur = "${numeroInitiateur}"

String montantYelowFacebobaka = "${montantYelowFacebobaka}"

String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(3,'dd/MM/yyy')

String heureExpiration=CustomKeywords.'ussd.Util.nextDate'(3,'HH:mm')

'Consulter mon solde avant d\' effectuer un Yelow facebobaka+'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur], 
    FailureHandling.CONTINUE_ON_FAILURE)

int soldeAvant = GlobalVariable.soldeCredit

'Je shortcode #111*4*6#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodde + '#', numeroInitiateur)

'Je saisis 3 (YELOW (SMS - INTERNET)) et valide'
CustomKeywords.'ussd.Send.response'('3')

'Je saisis 6(YELOW FACEBOBAKA +) et je valide'
String actualMenu = CustomKeywords.'ussd.Send.response'('6')

'Vérifier la conformité du pormpt de confirmation'
String menu=CustomKeywords.'ussd.Expected.menu'('YELOW FACEBOOBAKA\\+ : vous avez 1,5 Go pour acceder a vos videos et photos sur Facebook,Instagram et WhatsApp pendant 7j pour 2000 Ar\\. En profiter\\? 1\\-OUI; 0\\-NON', 
	'YELOW FACEBOOBAKA \\+: Manana 2 Go ianao ahafahana mampiasa Facebook,Instagram sy WhatsApp, manan\\-kery 7 andro @ sarany 2000 Ar\\. Hanararaotra\\? 1\\-ENY ; 0\\-TSIA')

WS.verifyMatch(actualMenu, menu, true)

'Je choisis 2 Non'
actualMenu = CustomKeywords.'ussd.Send.response'('2')

'Je vérifie que mon solde n\' est pas déduit du montant de Yelow facebobaka+'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur], 
    FailureHandling.CONTINUE_ON_FAILURE)

int soldeApresYelow100 = GlobalVariable.soldeCredit

WS.verifyEqual(soldeApresYelow100, soldeAvant)

