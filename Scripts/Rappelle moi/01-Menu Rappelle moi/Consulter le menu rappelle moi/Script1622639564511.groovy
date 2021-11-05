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

'En tant que client TELMA, je vais dans mon USSD en composant le short code *130#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeTELMA, GlobalVariable.msisdnGrossiste)

String menu=CustomKeywords.'ussd.Expected.menu'('^.*Rappelle moi.*$', '^.*Rappelle moi.*$')

'Vérifier la présence du menu Rappelle moi parmis les menus Telma'
WS.verifyMatch(actualMenu, menu, true)

'Je saisis 2 (Rappelle moi) et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('2')

menu=CustomKeywords.'ussd.Expected.menu'('^Rapelle moi \n1 Envoyer un rappelle moi\n2 Aide$','^Rapelle moi \n1 Andefa rappelle moi\n2 Fanampiana$')

'Vérifier la conformité des menus Rappelle moi'
WS.verifyMatch(actualMenu, menu, true)