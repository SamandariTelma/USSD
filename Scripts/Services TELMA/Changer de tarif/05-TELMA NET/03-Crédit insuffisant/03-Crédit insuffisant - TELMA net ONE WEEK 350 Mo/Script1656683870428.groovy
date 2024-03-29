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

'Je vais dans le menu Changer de tarif en shortcodant #130*4*6#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodde+'#', numeroInitiateur)

'Je saisis 4 (TELMA Net (INTERNET)) et valide'
CustomKeywords.'ussd.Send.response'('4')

'Je saisis 2 (TELMA NET Hebdomadaire)'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis 1 (NET WEEK 350 Mo)'
String actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Je vérifie la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Votre credit est insuffisant pour le changement d\'offre que vous demandez\\.',
	'Tsy ampy ny fahana anananao raha hiova io tolotra nangatahanao io ianao\\.')

WS.verifyMatch(actualMenu, menu, true)
