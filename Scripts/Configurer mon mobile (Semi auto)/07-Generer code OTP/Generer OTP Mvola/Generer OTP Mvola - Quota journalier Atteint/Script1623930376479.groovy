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

String numeroInitiateur = "$numeroInitiateur"

String pinNumeroInitiateur = "$pinNumeroInitiateur"

'2ème tentative ok'
WebUI.callTestCase(findTestCase('Configurer mon mobile (Semi auto)/07-Generer code OTP/Generer OTP Mvola/Generer OTP Mvola - Succès'), 
    [('numeroInitiateur') : numeroInitiateur, ('pinNumeroInitiateur') : pinNumeroInitiateur], FailureHandling.CONTINUE_ON_FAILURE)

'3ème tentative ok'
WebUI.callTestCase(findTestCase('Configurer mon mobile (Semi auto)/07-Generer code OTP/Generer OTP Mvola/Generer OTP Mvola - Succès'), 
    [('numeroInitiateur') : numeroInitiateur, ('pinNumeroInitiateur') : pinNumeroInitiateur], FailureHandling.CONTINUE_ON_FAILURE)

'4ème tentative'
'Je shortcode *130*9#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode + '#', numeroInitiateur)

'Je saisis 5 ( Generer le code OTP)'
CustomKeywords.'ussd.Send.response'('5')

'Je saisis 2 (MVola)'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis le bon PIN'
String actualMenu = CustomKeywords.'ussd.Send.response'(pinNumeroInitiateur)

'Vérifier la conformité du message'
String menu = CustomKeywords.'ussd.Expected.menu'('Desole, vous avez utilise toutes vos demandes de code unique pour aujourd hui\\. Vous avez droit a 3 demandes demain\\.')

WS.verifyMatch(actualMenu, menu, true)

