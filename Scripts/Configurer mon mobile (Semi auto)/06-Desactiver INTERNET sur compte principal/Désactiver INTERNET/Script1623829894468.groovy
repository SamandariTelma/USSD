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

'Je shortcode *130*9*4#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*1#', numeroInitiateur)

'Je saisis 2 (Desactiver INTERNET) '
String actualMenu=CustomKeywords.'ussd.Send.response'('2')

'Vérifier la conformité du sous menu'
String menu=CustomKeywords.'ussd.Expected.menu'('Voulez vous confirmer la desactivation de votre DATA sur votre compte principal \\? \\(1 \\- Oui, 0 \\- Non\\)')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 1 (Oui) et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('L usage internet sur votre compte principal a été désactivé\\. Achetez une offre pour profiter de l\'internet ou tapez #322\\*1# pour l activer a tout moment\\.',
	'Tontosa ny fanafoanana ny fampiasana internet @ compte principal\\-nao\\. Mividiana tolotra raha hampiasa ny internet na tsindrio ny #322\\*1# hamerenana izany')

WS.verifyMatch(actualMenu, menu, true)
