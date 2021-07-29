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

'Je me rend sur le menu TELMA NET en saisissant le shortCode *130*5*5#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*5#', numeroInitiateur)

'Je saisis 2 NET HEBDOMADAIRE'
String actualMenu=CustomKeywords.'ussd.Send.response'('2')

'Je vérifie la conformité du menu'
String menu=CustomKeywords.'ussd.Expected.menu'('NET HEBDOMADAIRE\n1 NET ONE WEEK 250 Mo \\(3 000 Ar\\)\n2 NET ONE WEEK 500 Mo \\(5 000 Ar\\)\n3 NET ONE WEEK 1,5Go \\(10 000 Ar\\)')

WS.verifyMatch(actualMenu, menu, true)