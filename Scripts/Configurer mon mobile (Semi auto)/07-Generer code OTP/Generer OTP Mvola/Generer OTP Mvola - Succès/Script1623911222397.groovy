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

String pinNumeroInitiateur="${pinNumeroInitiateur}"

'Je shortcode *130*9#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 5 ( Generer le code OTP)'
String actualMenu=CustomKeywords.'ussd.Send.response'('5')

'Vérifier la conformité du sous menu'
String menu=CustomKeywords.'ussd.Expected.menu'('\\*\\* Generer code OTP \\*\\*\n1 OTP pour Telma & Moi\n2 OTP pour MVola')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 2 (OTP Mvola) '
actualMenu=CustomKeywords.'ussd.Send.response'('2')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Pour confirmer la reception d un code OTP pour l installation de l application Mvola, entrer votre code secret MVola:')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis correctement mon Pin et je valide '
actualMenu=CustomKeywords.'ussd.Send.response'(pinNumeroInitiateur)

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('Vous allez recevoir un OTP par SMS\\.')

WS.verifyMatch(actualMenu, menu, true)