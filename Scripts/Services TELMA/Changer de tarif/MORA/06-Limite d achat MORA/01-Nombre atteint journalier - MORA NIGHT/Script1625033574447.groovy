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

'Achat MORA NIGHT 2 ème tentative'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/MORA/02-Acheter offre MORA/05-Achat MORA pour soi - MORA NIGHT'), 
    [('numeroInitiateur') : numeroInitiateur, ('montantMoraNIGHT') : '500'], FailureHandling.CONTINUE_ON_FAILURE)

'J\'effectue un achat MORA NIGHT 3e tentative'
'Je shortcode *130*4*6*# et je valide'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode, numeroInitiateur)

'Je saisis 1(MORA)'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis  5 (MORA NIGHT) et je valide'
String actualMenu = CustomKeywords.'ussd.Send.response'('5')

'Vérifier la conformité du menu'
String menu = CustomKeywords.'ussd.Expected.menu'('Desole, vous avez utilise toutes vos demandes pour aujourd\'hui\\. Vous pourrez envoyer 2 demande\\(s\\) demain\\.', 
    'Tapitra ny fahafahanao mampiasa io tolotra io androany\\. Rahampitso indray ianao afaka mividy  2\\.')

WS.verifyMatch(actualMenu, menu, true)

