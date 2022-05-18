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

String nextDate

'Achat yelow 200 2 eme tentative'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/02-Acheter offre Yelow (SMS - INTERNET)/Achat offre YELOW 200 pour soi'), 
    [('numeroInitiateur') : numeroInitiateur, ('montantYelow200') : '200'], FailureHandling.CONTINUE_ON_FAILURE)

'Achat yelow 200 3 eme tentative'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/02-Acheter offre Yelow (SMS - INTERNET)/Achat offre YELOW 200 pour soi'), 
    [('numeroInitiateur') : numeroInitiateur, ('montantYelow200') : '200'], FailureHandling.CONTINUE_ON_FAILURE)

'Achat yelow 200 4 eme tentative'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/02-Acheter offre Yelow (SMS - INTERNET)/Achat offre YELOW 200 pour soi'), 
    [('numeroInitiateur') : numeroInitiateur, ('montantYelow200') : '200'], FailureHandling.CONTINUE_ON_FAILURE)

'Achat yelow 200 5 eme tentative'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/02-Acheter offre Yelow (SMS - INTERNET)/Achat offre YELOW 200 pour soi'), 
    [('numeroInitiateur') : numeroInitiateur, ('montantYelow200') : '200'], FailureHandling.CONTINUE_ON_FAILURE)

'Achat yelow 200 6 eme tentative'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/02-Acheter offre Yelow (SMS - INTERNET)/Achat offre YELOW 200 pour soi'), 
    [('numeroInitiateur') : numeroInitiateur, ('montantYelow200') : '200'], FailureHandling.CONTINUE_ON_FAILURE)

'Achat yelow 200 7 eme tentative'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/02-Acheter offre Yelow (SMS - INTERNET)/Achat offre YELOW 200 pour soi'), 
    [('numeroInitiateur') : numeroInitiateur, ('montantYelow200') : '200'], FailureHandling.CONTINUE_ON_FAILURE)

'Achat yelow 200 8 eme tentative'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/02-Acheter offre Yelow (SMS - INTERNET)/Achat offre YELOW 200 pour soi'), 
    [('numeroInitiateur') : numeroInitiateur, ('montantYelow200') : '200'], FailureHandling.CONTINUE_ON_FAILURE)

'Achat yelow 200 9 eme tentative'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/02-Acheter offre Yelow (SMS - INTERNET)/Achat offre YELOW 200 pour soi'), 
    [('numeroInitiateur') : numeroInitiateur, ('montantYelow200') : '200'], FailureHandling.CONTINUE_ON_FAILURE)

'Achat yelow 200 10 eme tentative'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/02-Acheter offre Yelow (SMS - INTERNET)/Achat offre YELOW 200 pour soi'), 
    [('numeroInitiateur') : numeroInitiateur, ('montantYelow200') : '200'], FailureHandling.CONTINUE_ON_FAILURE)

'Achat Yelow SMS 11eme tentative'

'Je shortcode #111*4*6#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode + '#', numeroInitiateur)

'Je saisis 3 (YELOW (SMS - INTERNET)) et valide'
CustomKeywords.'ussd.Send.response'('3')

'Je saisis 5 (YELOW 200) et je valide'
String actualMenu = CustomKeywords.'ussd.Send.response'('5')

'Vérifier la conformité du message'
String menu = CustomKeywords.'ussd.Expected.menu'('Desole, vous avez utilise toutes vos demandes pour aujourd\'hui\\. Vous pourrez envoyer 10 demande\\(s\\) demain\\.', 
    'Tapitra ny fahafahanao mampiasa io tolotra io androany\\. Rahampitso indray ianao afaka mividy 10\\.')

WS.verifyMatch(actualMenu, menu, true)

