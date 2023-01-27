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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String numeroInitiateur = "$numeroInitiateur"

String numeroRecepteur = "$numeroRecepteur"

numeroRecepteurTo034 = CustomKeywords.'ussd.Util.to034'(numeroRecepteur)

'Je fais un rappelle moi 5 fois succéssive'
WebUI.callTestCase(findTestCase('Rappelle moi/SHORT CODE 659/SCRM02-Rappelle moi avec succès'), [('numeroInitiateur') : numeroInitiateur
        , ('numeroRecepteur') : numeroRecepteur], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Rappelle moi/SHORT CODE 659/SCRM02-Rappelle moi avec succès'), [('numeroInitiateur') : numeroInitiateur
        , ('numeroRecepteur') : numeroRecepteur], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Rappelle moi/SHORT CODE 659/SCRM02-Rappelle moi avec succès'), [('numeroInitiateur') : numeroInitiateur
        , ('numeroRecepteur') : numeroRecepteur], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Rappelle moi/SHORT CODE 659/SCRM02-Rappelle moi avec succès'), [('numeroInitiateur') : numeroInitiateur
        , ('numeroRecepteur') : numeroRecepteur], FailureHandling.CONTINUE_ON_FAILURE)

'Je fais un rappelle moi 6ème tentative'

String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCoddeDirect+'*'+numeroRecepteurTo034+'#', numeroInitiateur)

String menu = CustomKeywords.'ussd.Expected.menu'('Desole, vous avez utilise toutes vos demandes pour aujourd\'hui\\. Vous pourrez envoyer 5 demandes demain\\.', 
    'Tapitra ny fahafahanao mampiasa io servisy io androany\\.Rahampitso  indray  mandefa hafatra 5\\.')

'Vérifier la conformité du message'
WS.verifyMatch(actualMenu, menu, true)

