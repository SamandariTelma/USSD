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

'Je saisis 1 (MORA) et je valide'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis un numero autre qu\'affichés sur le menu et je valide '
String actualMenu=CustomKeywords.'ussd.Send.response'('12')

'Vérifier que je reste sur le menu MORA'
String menu=CustomKeywords.'ussd.Expected.menu'('MORA \\(VOIX \\- SMS \\- INTERNET\\)\n1 MORA 500 \\(500 Ar\\)\n2 MORA ONE \\(1 000 Ar\\)\n3 MORA\\+ 2000 \\(2 000 Ar\\)\n4 MORA\\+ 5000 \\(5 000 Ar\\)\n5 MORA NIGHT \\(500 Ar\\)\n0 Page suivante',
	'MORA \\(VOIX \\- SMS \\- INTERNET\\)\n1 MORA 500 \\(500 Ar\\)\n2 MORA ONE \\(1 000 Ar\\)\n3 MORA\\+ 2000 \\(2 000 Ar\\)\n4 MORA\\+ 5000 \\(5 000 Ar\\)\n5 MORA NIGHT \\(500 Ar\\)\n0 Pejy manaraka')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis # (Page suivante) et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('0')

'Je saisis un numero autre qu\'affichés sur le menu et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('10')

WS.verifyMatch(actualMenu, menu, true)