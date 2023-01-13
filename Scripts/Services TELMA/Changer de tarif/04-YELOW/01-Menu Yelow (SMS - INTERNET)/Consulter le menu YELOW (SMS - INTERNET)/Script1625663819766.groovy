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

'Je shortcode #111*4*6#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 3 (YELOW (SMS - INTERNET)) et valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('3')

'Vérifier la conformité du sous menu'
String menu=CustomKeywords.'ussd.Expected.menu'('YELOW \\(SMS \\- INTERNET\\)\n1 YELOW100 \\(100 Ar\\)\n2 YELOW SMS \\(200 Ar\\)\n3 YELOW FACEBOBAKA \\(500 Ar\\)\n4 YELOW 1000 \\(1000 Ar\\)\n5 YELOW 200 \\(200 Ar\\)\n0 Page suivante',
	'YELOW \\(SMS \\- INTERNET\\)\n1 YELOW100 \\(100 Ar\\)\n2 YELOW SMS \\(200 Ar\\)\n3 YELOW FACEBOBAKA \\(500 Ar\\)\n4 YELOW 1000 \\(1000 Ar\\)\n5 YELOW 200 \\(200 Ar\\)\n0 Pejy manaraka')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 0 (Page suivant)'
actualMenu=CustomKeywords.'ussd.Send.response'('0')

'Vérifier la conformité du sous menu'
menu=CustomKeywords.'ussd.Expected.menu'('6 YELOW FACEBOOBAKA \\+ \\(2000 Ar\\)\n7 YELOW ONE \\(1000 Ar\\)\n00 Page precedente', 
	'6 YELOW FACEBOOBAKA \\+ \\(2000 Ar\\)\n7 YELOW ONE \\(1000 Ar\\)\n00 Pejy aloha')

WS.verifyMatch(actualMenu, menu, true)