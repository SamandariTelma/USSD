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

'Je short code *111*5*2# pour consulter le menu MORA et valide'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*2#', numeroInitiateur)

'Je vérifie la conformité du menu'
String menu=CustomKeywords.'ussd.Expected.menu'('MORA \\(VOIX \\- SMS \\- INTERNET\\)\n1 MORA 500 \\(500 Ar\\)\n2 MORA ONE \\(1 000 Ar\\)\n3 MORA\\+ 2000 \\(2 000 Ar\\)\n4 MORA\\+ 5000 \\(5 000 Ar\\)\n5 MORA NIGHT \\(500 Ar\\)\n0 Page suivante',
	'MORA \\(VOIX \\- SMS \\- INTERNET\\)\n1 MORA 500 \\(500 Ar\\)\n2 MORA ONE \\(1 000 Ar\\)\n3 MORA\\+ 2000 \\(2 000 Ar\\)\n4 MORA\\+ 5000 \\(5 000 Ar\\)\n5 MORA NIGHT \\(500 Ar\\)\n0 Pejy manaraka')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis # (Page suivante) et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('0')

'Vérifier la conformité du sous menu'
menu=CustomKeywords.'ussd.Expected.menu'('6 MORA TEAM \\(1 000 Ar\\)\n7 MORA INTERNATIONAL \\(5 000 Ar\\)\n00 Page precedente', '6 MORA TEAM \\(1 000 Ar\\)\n7 MORA INTERNATIONAL \\(5 000 Ar\\)\n00 Pejy aloha')

WS.verifyMatch(actualMenu, menu, true)

'Je retourne sur la page précedente en saisissant 00'
actualMenu=CustomKeywords.'ussd.Send.response'('00')

'Vérifier la conformité du menu'
menu=CustomKeywords.'ussd.Expected.menu'('MORA \\(VOIX \\- SMS \\- INTERNET\\)\n1 MORA 500 \\(500 Ar\\)\n2 MORA ONE \\(1 000 Ar\\)\n3 MORA\\+ 2000 \\(2 000 Ar\\)\n4 MORA\\+ 5000 \\(5 000 Ar\\)\n5 MORA NIGHT \\(500 Ar\\)\n0 Page suivante',
	'MORA \\(VOIX \\- SMS \\- INTERNET\\)\n1 MORA 500 \\(500 Ar\\)\n2 MORA ONE \\(1 000 Ar\\)\n3 MORA\\+ 2000 \\(2 000 Ar\\)\n4 MORA\\+ 5000 \\(5 000 Ar\\)\n5 MORA NIGHT \\(500 Ar\\)\n0 Pejy manaraka')

WS.verifyMatch(actualMenu, menu, true)
