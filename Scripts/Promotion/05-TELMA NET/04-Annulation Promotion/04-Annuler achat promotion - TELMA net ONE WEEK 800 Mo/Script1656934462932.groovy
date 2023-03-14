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

'Je me rends sur le menu TELMA net en shortCodant *130*5*5#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodde+'*5#', numeroInitiateur)

'Je saisis 2 (TELMA NET Hebdomadaire)'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis 2 (NET WEEK 800 Mo)'
String actualMenu=CustomKeywords.'ussd.Send.response'('2')

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('NET ONE WEEK 800 Mo! Beneficiez de 800 Mo de DATA utilisable a toute heure pendant 7 jours pour seulement 5\\.000 Ar\\. En profiter\\? 1\\-OUI ; 0\\-NON',
	'NET ONE WEEK 800 Mo! Mahazoa 800 Mo DATA azo ampiasaina @ ora rehetra @ sarany 5\\.000Ar monja mandritry ny 7 andro\\. Hanararoatra\\? 1\\-ENY ; 0\\-TSIA')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 0 (NON) et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('0')

'Vérifier la conformité du menu'
menu=CustomKeywords.'ussd.Expected.menu'('Merci d\'avoir utliser le service Telma\\.',
	'Misaotra anao nampiasa ny tolotra Telma\\.')

WS.verifyMatch(actualMenu, menu, true)