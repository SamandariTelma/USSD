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

String nextDate=CustomKeywords.'ussd.Util.nextDate'(3)

'Achat Yelow Facebobaka 2 eme tentative'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/02-Acheter offre Yelow (SMS - INTERNET)/Achat Yelow Facebobaka pour soi'), 
    [('numeroInitiateur') : numeroInitiateur, ('montantYelowFacebobaka') : '500'], FailureHandling.CONTINUE_ON_FAILURE)

'Achat Yelow SMS 3eme tentative'

'Je shortcode #111*4*6#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode + '#', numeroInitiateur)

'Je saisis 3 (YELOW (SMS - INTERNET)) et valide'
CustomKeywords.'ussd.Send.response'('3')

'Je saisis 3 (YELOW FACEBOBAKA) et je valide'
String actualMenu = CustomKeywords.'ussd.Send.response'('3')

'Vérifier la conformité du message'
String menu = CustomKeywords.'ussd.Expected.menu'(('Desole, vous avez utilise toutes vos demandes\\. Vous pourrez envoyer 2 demandes à partir du ' + 
    nextDate) + ' ', ('Tapitra ny fahafahanao mampiditra io tolotra io\\. Amin ny ' + nextDate) + ' indray ianao afaka mividy 2\\.')

WS.verifyMatch(actualMenu, menu, true)

