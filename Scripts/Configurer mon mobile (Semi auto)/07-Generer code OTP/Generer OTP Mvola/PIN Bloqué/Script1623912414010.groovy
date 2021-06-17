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

WebUI.callTestCase(findTestCase('Configurer mon mobile (Semi auto)/07-Generer code OTP/Generer OTP Mvola/Called test case/Pin erreur x tentative'), 
    [('numeroInitiateur') : numeroInitiateur, ('nbrTentative') : '1'], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Configurer mon mobile (Semi auto)/07-Generer code OTP/Generer OTP Mvola/Called test case/Pin erreur x tentative'), 
    [('numeroInitiateur') : numeroInitiateur, ('nbrTentative') : '2'], FailureHandling.CONTINUE_ON_FAILURE)

'Je shortcode *130*9#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 5 ( Generer le code OTP)'
CustomKeywords.'ussd.Send.response'('5')

'Je saisis 2 (MVola)'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis un PIN erroné mais avec 4 chiffres'
String actualMenu=CustomKeywords.'ussd.Send.response'('9999')

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Votre compte est bloque car vous avez atteint le maximum d essais de code secret\\. Tapez le #111\\*1#')

WS.verifyMatch(actualMenu, menu, true)