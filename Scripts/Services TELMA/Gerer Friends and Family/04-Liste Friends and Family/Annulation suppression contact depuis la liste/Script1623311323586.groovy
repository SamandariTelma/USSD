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

String numeroASupprime = "${numeroASupprime}"

'En tant que client TELMA, je vais dans le menu Gerer Friends and family en composant *130*4*3#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'#', numeroInitiateur)

'Je saisis 3 (Liste Friends & Family) et je valide'
CustomKeywords.'ussd.Send.response'('3')

'Je choisi un numéro en saisissant par exemple 1'
String actualMenu = CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du prompt'
String menu = CustomKeywords.'ussd.Expected.menu'('Confirmez la suppression du numero '+numeroASupprime+' \\? \\(1\\-Oui \\; 0\\-Non\\)\\.', 'Ho fafana ny numerao '+numeroASupprime+' \\? \\(1\\-Eny ; 0\\-Tsia\\)\\.')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 0 pour annuler la suppression'
actualMenu=CustomKeywords.'ussd.Send.response'('0')

menu=CustomKeywords.'ussd.Expected.menu'('Votre demande a ete annulee',	'Najanona ny fangatahanao\\.')

WS.verifyMatch(actualMenu, menu, true)