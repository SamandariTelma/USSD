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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
String menuactuel = CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode, GlobalVariable.msisdnSend)

'choisir menu rappelle moi'
CustomKeywords.'ussd.Send.response'('2')

'verifier menu'
String menuA = CustomKeywords.'ussd.Expected.menu'('^.*2 Rappelle Moi.*$') 
WS.verifyMatch(menuactuel, menuA, true)

'choisir 1'
CustomKeywords.'ussd.Send.response'('1')
'verifier menu attendu'
String menuB = CustomKeywords.'ussd.Expected.menu'('^Rappelle moi\n1 Envoyer un rappelle moi\n2 Aide$')
WS.verifyMatch(menuactuel, menuB, true)

'Inserer numeros receveur'
CustomKeywords.'ussd.Send.response'(GlobalVariable.msisdnHost)

