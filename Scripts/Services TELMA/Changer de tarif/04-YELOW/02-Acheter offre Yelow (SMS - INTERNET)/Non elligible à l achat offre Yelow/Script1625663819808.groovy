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

String menuYelowAAcherter="${menuYelowAAcherter}"

'Je shortcode #111*4*6#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodde+'#', numeroInitiateur)

'Je saisis 3 (YELOW (SMS - INTERNET)) et valide'
CustomKeywords.'ussd.Send.response'('3')

'Je choisis un menu quelconque'
String actualMenu=CustomKeywords.'ussd.Send.response'(menuYelowAAcherter)

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Votre demande n\'a pas abouti\\. Vous n\'avez pas acces a cette fonction\\. Si besoin, contactez le Service Clientele au 807\\. Ref: \\d{1,10}',
	'Tsy tontosa ny fangatahanao\\. Tsy afaka manatontosa ity fifanakalozana ity ianao\\. Raha mila fanazavana fanampiny, antsoy ny 807\\. Ref: \\d{1,10}')

WS.verifyMatch(actualMenu, menu, true)

