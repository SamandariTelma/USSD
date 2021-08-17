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
String numeroRecepteur="${numeroRecepteur}"

'En tant que client Telma qui dispose aucune offre, Je shortcode #130*4*4#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 3 (Partager du Mega) et je valide '
String actualMenu=CustomKeywords.'ussd.Send.response'('3')

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Vous n avez pas d offre eligible a ce service\\. Acheter une offre a partir du NET ONE MONTH 250Mo pour beneficier du partage Mega', 
	'Tsy manana tolotra ahafahanao mampiasa an ny partage mega ianao\\. Mividiana tolotra manomboka @ NET ONE MONTH 250Mo ahafahanao mampiasa azy\\.')

WS.verifyMatch(actualMenu, menu, true)
