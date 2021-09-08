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

String pinMsisdnInitiateur="${pinMsisdnInitiateur}"

'Je shortcode *130*9#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 5 ( Generer le code OTP)'
CustomKeywords.'ussd.Send.response'('5')

'Je saisis 1 (OTP T&M)'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis correctement mon Pin et je valide '
String actualMenu=CustomKeywords.'ussd.Send.response'(pinMsisdnInitiateur)

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Application deja installee sur un autre appareil\\. Une seule application active autorisee par SIM\\. Tapez 1 pour continuer sinon ignorer:')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 1 (Continuer)'
actualMenu=CustomKeywords.'ussd.Expected.menu'('1')

'Vérifier la congormité du message'
menu=CustomKeywords.'ussd.Expected.menu'('Vous allez recevoir un OTP par SMS\\.')

WS.verifyMatch(actualMenu, menu, true)
