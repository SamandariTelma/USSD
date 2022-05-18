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

String numeroInitiateur = "$numeroInitiateur"

String numeroRecepteur = "$numeroRecepteur"

'Je shortcode #130*4*4#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode + '#', numeroInitiateur)

'Je saisis 2 (Envoyer offre) et valide'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis correctement un MSISDN du destinataire et je valide'
numeroInitiateur=CustomKeywords.'ussd.Util.to034'(numeroInitiateur)

CustomKeywords.'ussd.Send.response'(numeroInitiateur)

'Je selectionne 1 MORA et je valide '
CustomKeywords.'ussd.Send.response'('1')

'Je choisis une valeur hors proposition et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('22')

'Vérifier que je reste sur le menu offre MORA'
String menu=CustomKeywords.'ussd.Expected.menu'('MORA \\(VOIX \\- SMS \\- INTERNET\\)\n1 MORA 500 \\(500 Ar\\)\n2 MORA ONE \\(1000 Ar\\)\n3 MORA\\+ 2000 \\(2000 Ar\\)\n4 MORA\\+ 5000 \\(5000 Ar\\)\n5 MORA NIGHT \\(500 Ar\\)\n6 MORA TEAM \\(1000 Ar\\)\n0 Page suivante',
	'MORA \\(VOIX \\- SMS \\- INTERNET\\)\n1 MORA 500 \\(500 Ar\\)\n2 MORA ONE \\(1000 Ar\\)\n3 MORA\\+ 2000 \\(2000 Ar\\)\n4 MORA\\+ 5000 \\(5000 Ar\\)\n5 MORA NIGHT \\(500 Ar\\)\n6 MORA TEAM \\(1000 Ar\\)\n0 Pejy manaraka')

WS.verifyMatch(actualMenu, menu, true)