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

'Je me rends sur le menu Service TELMA en shortcodant \'*130*4#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeTELMA+'4#', numeroInitiateur)

'Vérifier la présence du menu Envoyer crédit'
String menu=CustomKeywords.'ussd.Expected.menu'('^.*\n4 Envoyer Credit/Offre/Mega.*$','^.*\n4 Handefa Fahana/Tolotra/Mega.*$')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 4 (Envoyer Credit/Offre/Mega)'
actualMenu=CustomKeywords.'ussd.Send.response'('4')

'Vérifier la conformité du menu'
menu=CustomKeywords.'ussd.Expected.menu'('Envoyer Credit/Offre/Mega\n1 Envoyer du credit\n2 Envoyer une offre\n3 Partager du Mega\n4 Aide', 'Handefa Fahana/Tolotra/Mega\n1 Andefa fahana\n2 Andefa Tolotra\n3 Hizara Mega\n4 Fanampiana')

WS.verifyMatch(actualMenu, menu, true)
