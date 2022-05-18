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

'Desactivation 2ème tentative'
WebUI.callTestCase(findTestCase('Configurer mon mobile (Semi auto)/06-Desactiver INTERNET sur compte principal/Désactiver INTERNET'), [('numeroInitiateur') : numeroInitiateur], 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Configurer mon mobile (Semi auto)/06-Desactiver INTERNET sur compte principal/RéActiver internet désactivé'), [('numeroInitiateur') : numeroInitiateur], 
    FailureHandling.CONTINUE_ON_FAILURE)

'Desactivation 3ème tentative'
WebUI.callTestCase(findTestCase('Configurer mon mobile (Semi auto)/06-Desactiver INTERNET sur compte principal/Désactiver INTERNET'), [('numeroInitiateur') : numeroInitiateur], 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Configurer mon mobile (Semi auto)/06-Desactiver INTERNET sur compte principal/RéActiver internet désactivé'), [('numeroInitiateur') : numeroInitiateur], 
    FailureHandling.CONTINUE_ON_FAILURE)

'Pour la 4ème tentative je désactive mon internet en tappant le shortcode Je shortcode *130*9*4#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode + '*4#', numeroInitiateur)

'Je saisis 2 (Desactiver INTERNET)'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis 1 (Oui) et je valide'
String actualMenu = CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du prompt'
String menu = CustomKeywords.'ussd.Expected.menu'('Vous avez atteint la limite mensuelle de désactivation de l\'accès d\'usage internet sur votre compte principal\\.', 
    'Nahatratra ny fetra ahafahana manafoana ny fampiasana internet @compte principal\\-nao ianao\\. Misaotra tompoko\\.')

WS.verifyMatch(actualMenu, menu, true)