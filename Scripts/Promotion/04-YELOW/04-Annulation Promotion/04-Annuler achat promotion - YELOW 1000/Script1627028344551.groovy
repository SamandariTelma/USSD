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

'Je shortcode *130*5# et je valide'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode + '#', numeroInitiateur)

'Je saisis 4(YELOW)'
CustomKeywords.'ussd.Send.response'('4')

'Je saisis  4 (Yelow 1000) et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('4')

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('^.*Vous voulez en profiter\\? 1\\-OUI ; 0\\-NON.*$','^.*Hanararaotra\\? 1\\-ENY ; 0\\-TSIA.*$')

WS.verifyMatch(actualMenu, menu, true)

'Je confirme l\'achat en saisissant 0 (NON)'
actualMenu = CustomKeywords.'ussd.Send.response'('0')

'Vérifier la conformité du menu'
menu=CustomKeywords.'ussd.Expected.menu'('Merci d\'avoir utliser le service Telma\\.',
	'Misaotra anao nampiasa ny tolotra Telma\\.')

WS.verifyMatch(actualMenu, menu, true)

