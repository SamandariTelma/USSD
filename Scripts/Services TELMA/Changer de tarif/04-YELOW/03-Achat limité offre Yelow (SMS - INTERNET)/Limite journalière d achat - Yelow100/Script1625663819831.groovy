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

'Achat Yelow 100 2eme tentative'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/02-Acheter offre Yelow (SMS - INTERNET)/Achat offre YELOW100 pour soi'), 
    [('numeroInitiateur') : numeroInitiateur, ('montantYelow100') : '100'], FailureHandling.CONTINUE_ON_FAILURE)

'Achat Yelow 100 3eme tentative'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/02-Acheter offre Yelow (SMS - INTERNET)/Achat offre YELOW100 pour soi'), 
    [('numeroInitiateur') : numeroInitiateur, ('montantYelow100') : '100'], FailureHandling.CONTINUE_ON_FAILURE)

'Achat Yelow 100 4eme tentative'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/02-Acheter offre Yelow (SMS - INTERNET)/Achat offre YELOW100 pour soi'), 
    [('numeroInitiateur') : numeroInitiateur, ('montantYelow100') : '100'], FailureHandling.CONTINUE_ON_FAILURE)

'Achat Yelow 100 5eme tentative'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/02-Acheter offre Yelow (SMS - INTERNET)/Achat offre YELOW100 pour soi'), 
    [('numeroInitiateur') : numeroInitiateur, ('montantYelow100') : '100'], FailureHandling.CONTINUE_ON_FAILURE)

'Achat Yelow 100 6eme tentative'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/02-Acheter offre Yelow (SMS - INTERNET)/Achat offre YELOW100 pour soi'), 
    [('numeroInitiateur') : numeroInitiateur, ('montantYelow100') : '100'], FailureHandling.CONTINUE_ON_FAILURE)

'Achat Yelow 100 7eme tentative'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/02-Acheter offre Yelow (SMS - INTERNET)/Achat offre YELOW100 pour soi'), 
    [('numeroInitiateur') : numeroInitiateur, ('montantYelow100') : '100'], FailureHandling.CONTINUE_ON_FAILURE)

'Achat Yelow 100 8eme tentative'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/02-Acheter offre Yelow (SMS - INTERNET)/Achat offre YELOW100 pour soi'), 
    [('numeroInitiateur') : numeroInitiateur, ('montantYelow100') : '100'], FailureHandling.CONTINUE_ON_FAILURE)

'Achat Yelow 100 9eme tentative'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/02-Acheter offre Yelow (SMS - INTERNET)/Achat offre YELOW100 pour soi'), 
    [('numeroInitiateur') : numeroInitiateur, ('montantYelow100') : '100'], FailureHandling.CONTINUE_ON_FAILURE)

'Achat Yelow 100 10eme tentative'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/02-Acheter offre Yelow (SMS - INTERNET)/Achat offre YELOW100 pour soi'), 
    [('numeroInitiateur') : numeroInitiateur, ('montantYelow100') : '100'], FailureHandling.CONTINUE_ON_FAILURE)

'Achat Yelow 100 11eme tentative'

'Je shortcode #111*4*6#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodde + '#', numeroInitiateur)

'Je saisis 3 (YELOW (SMS - INTERNET)) et valide'
CustomKeywords.'ussd.Send.response'('3')

'Je saisis 1 (YELOW 100) et je valide'
String actualMenu = CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du message'
String menu = CustomKeywords.'ussd.Expected.menu'('Desole, vous avez utilise toutes vos demandes pour aujourd\'hui\\. Vous pourrez envoyer 10 demande\\(s\\) demain\\.', 
    'Tapitra ny fahafahanao mampiasa io tolotra io androany\\. Rahampitso indray ianao afaka mividy  10\\.')

WS.verifyMatch(actualMenu, menu, true)

