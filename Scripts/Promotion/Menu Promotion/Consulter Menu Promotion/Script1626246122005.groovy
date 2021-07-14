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

'Je short code *111# et valide'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeTELMA, numeroInitiateur)

'Je vérifie la présence du menu Promotion'
String menu=CustomKeywords.'ussd.Expected.menu'('^.*Promotion.*$','^.*Tolotra.*$')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 5 (promotion)'
actualMenu=CustomKeywords.'ussd.Send.response'('5')

'Je vérifie la conformité du menu promotion'
menu=CustomKeywords.'ussd.Expected.menu'('PROMOTIONS\n1 MVola\n2 MORA \\(VOIX \\- SMS \\- INTERNET\\)\n3 FIRST \\(VOIX \\- SMS \\- INTERNET\\)\n4 YELOW \\(SMS \\- INTERNET\\)\n5 TELMA Net \\(INTERNET\\)',
	'TOLOTRA\n1 MVola\n2 MORA \\(VOIX \\- SMS \\- INTERNET\\)\n3 FIRST \\(VOIX \\- SMS \\- INTERNET\\)\n4 YELOW \\(SMS \\- INTERNET\\)\n5 TELMA Net \\(INTERNET\\)')

WS.verifyMatch(actualMenu, menu, true)