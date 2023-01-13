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

'Je shortcode *130*5# et je valide'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 2(MORA)'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis  6 (MORA TEAM) et je valide'
CustomKeywords.'ussd.Send.response'('6')

'Je confirme l\'achat en saisissant 1 (OUI)'
String actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du menu'
String menu=CustomKeywords.'ussd.Expected.menu'('Vous ne pouvez pas acceder a cette offre\\. Pour plus d\'informations, veuillez contacter le service client Telma au 800 \\(Cout : 200 Ar/ Appel\\)',
	'Tsy afaka misafidy io tolotra io ianao\\. Raha mila fanazavana fanampiny, antsoy ny service client Telma 800 \\(Sandany : 200 Ar/ Antso\\)')

WS.verifyMatch(actualMenu, menu, true)
