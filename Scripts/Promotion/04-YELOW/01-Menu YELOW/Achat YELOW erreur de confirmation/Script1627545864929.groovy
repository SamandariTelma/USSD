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

'Je me rends sur le menu promotion YELOW en shortCodant *130*5*3#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodde+'*4#', numeroInitiateur)

'Je saisis un menu offre YELOW'
CustomKeywords.'ussd.Send.response'('2')

'Dans le prompt de confirmation, je saisi un chiffre inexistant'
String actualMenu=CustomKeywords.'ussd.Send.response'('3')

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Merci d\'avoir utliser le service Telma\\.', 'Misaotra anao nampiasa ny tolotra Telma\\.')

WS.verifyMatch(actualMenu, menu, true)