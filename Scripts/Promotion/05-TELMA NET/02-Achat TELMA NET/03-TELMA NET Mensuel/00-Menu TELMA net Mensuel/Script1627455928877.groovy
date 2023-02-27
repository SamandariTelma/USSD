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

'Je saisis 3 NET MENSUEL'
String actualMenu=CustomKeywords.'ussd.Send.response'('3')

'Je vérifie la conformité du menu'
String menu=CustomKeywords.'ussd.Expected.menu'('NET MENSUEL\n1 NET ONE MONTH 2 Go \\(15000 Ar\\)\n2 NET ONE MONTH 4 Go \\(25000 Ar\\)\n3 NET ONE MONTH 12 Go \\(75000 Ar\\)\n4 NET ONE MONTH 25 Go \\(125000 Ar\\)\n0 Page suivante',
	'NET MENSUEL\n1 NET ONE MONTH 2 Go \\(15000 Ar\\)\n2 NET ONE MONTH 4 Go \\(25000 Ar\\)\n3 NET ONE MONTH 12 Go \\(75000 Ar\\)\n4 NET ONE MONTH 25 Go \\(125000 Ar\\)\n0 Pejy manaraka')

WS.verifyMatch(actualMenu, menu, true)