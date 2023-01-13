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
'Je shortcode *130*9*1# '
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*1#', numeroInitiateur)

'Vérifier la conformité du sous menu'
String menu=CustomKeywords.'ussd.Expected.menu'('1 Activer INTERNET sur Compte principal\n2 Desactiver INTERNET sur Compte Principal')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 1 (Activer INTERNET) '
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Voulez vous confirmer l activation de votre DATA sur votre compte principal \\? \\(1 \\- Oui, 0 \\- Non\\)')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 0 -Non'
actualMenu=CustomKeywords.'ussd.Send.response'('0')

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('Merci d avoir utilise ce service\\.')

WS.verifyMatch(actualMenu, menu, true)