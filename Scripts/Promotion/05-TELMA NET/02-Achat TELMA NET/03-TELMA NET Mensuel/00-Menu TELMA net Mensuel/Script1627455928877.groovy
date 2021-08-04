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
String menu=CustomKeywords.'ussd.Expected.menu'('NET MENSUEL\n1 NET ONE MONTH 1,5Go \\(15 000 Ar\\)\n2 NET ONE MONTH 3Go \\(25 000 Ar\\)\n3 NET ONE MONTH 10Go \\(75 000 Ar\\)\n4 NET ONE MONTH 20Go \\(125 000 Ar\\)\n0 Page suivante',
	'NET MENSUEL\n1 NET ONE MONTH 1,5Go \\(15 000 Ar\\)\n2 NET ONE MONTH 3Go \\(25 000 Ar\\)\n3 NET ONE MONTH 10Go \\(75 000 Ar\\)\n4 NET ONE MONTH 20Go \\(125 000 Ar\\)\n0 Pejy manaraka')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 0 (Page suivante)'
actualMenu=CustomKeywords.'ussd.Send.response'('0')

'Je vérifie la conformité du menu dans la page suivante'
menu=CustomKeywords.'ussd.Expected.menu'('5 NET ONE MONTH 100Go \\(195 000 Ar\\)\n00 Page precedente', '5 NET ONE MONTH 100Go \\(195 000 Ar\\)\n00 Pejy aloha')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 00 pourretourner sur le menu précedent'
actualMenu=CustomKeywords.'ussd.Send.response'('00')

menu=CustomKeywords.'ussd.Expected.menu'('NET MENSUEL\n1 NET ONE MONTH 1,5Go \\(15 000 Ar\\)\n2 NET ONE MONTH 3Go \\(25 000 Ar\\)\n3 NET ONE MONTH 10Go \\(75 000 Ar\\)\n4 NET ONE MONTH 20Go \\(125 000 Ar\\)\n0 Page suivante',
	'NET MENSUEL\n1 NET ONE MONTH 1,5Go \\(15 000 Ar\\)\n2 NET ONE MONTH 3Go \\(25 000 Ar\\)\n3 NET ONE MONTH 10Go \\(75 000 Ar\\)\n4 NET ONE MONTH 20Go \\(125 000 Ar\\)\n0 Pejy manaraka')

WS.verifyMatch(actualMenu, menu, true)