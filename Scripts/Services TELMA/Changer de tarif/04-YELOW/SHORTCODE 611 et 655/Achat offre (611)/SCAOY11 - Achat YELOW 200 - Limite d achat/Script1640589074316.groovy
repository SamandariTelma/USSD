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

'2 ème tentative d achate yelow 200'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/SHORTCODE 611 et 655/Achat offre (611)/SCAOY05 - Achat YELOW 200'), 
    [('numeroInitiateur') : numeroInitiateur], FailureHandling.CONTINUE_ON_FAILURE)

'3 ème tentative d achate yelow 200'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/SHORTCODE 611 et 655/Achat offre (611)/SCAOY05 - Achat YELOW 200'), 
    [('numeroInitiateur') : numeroInitiateur], FailureHandling.CONTINUE_ON_FAILURE)

'4 ème tentative d achate yelow 200'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/SHORTCODE 611 et 655/Achat offre (611)/SCAOY05 - Achat YELOW 200'), 
    [('numeroInitiateur') : numeroInitiateur], FailureHandling.CONTINUE_ON_FAILURE)

'5 ème tentative d achate yelow 200'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/SHORTCODE 611 et 655/Achat offre (611)/SCAOY05 - Achat YELOW 200'), 
    [('numeroInitiateur') : numeroInitiateur], FailureHandling.CONTINUE_ON_FAILURE)

'6 ème tentative d achate yelow 200'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/SHORTCODE 611 et 655/Achat offre (611)/SCAOY05 - Achat YELOW 200'), 
    [('numeroInitiateur') : numeroInitiateur], FailureHandling.CONTINUE_ON_FAILURE)

'7 ème tentative d achate yelow 200'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/SHORTCODE 611 et 655/Achat offre (611)/SCAOY05 - Achat YELOW 200'), 
    [('numeroInitiateur') : numeroInitiateur], FailureHandling.CONTINUE_ON_FAILURE)

'8 ème tentative d achate yelow 200'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/SHORTCODE 611 et 655/Achat offre (611)/SCAOY05 - Achat YELOW 200'), 
    [('numeroInitiateur') : numeroInitiateur], FailureHandling.CONTINUE_ON_FAILURE)

'9 ème tentative d achate yelow 200'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/SHORTCODE 611 et 655/Achat offre (611)/SCAOY05 - Achat YELOW 200'), 
    [('numeroInitiateur') : numeroInitiateur], FailureHandling.CONTINUE_ON_FAILURE)

'10 ème tentative d achate yelow 200'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/SHORTCODE 611 et 655/Achat offre (611)/SCAOY05 - Achat YELOW 200'), 
    [('numeroInitiateur') : numeroInitiateur], FailureHandling.CONTINUE_ON_FAILURE)

'Je tente d acheter un offre YELOW 200 pour la 11ème fois:  *611*63#'
String actualMenu = CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodeDirectAchat + '*63#', numeroInitiateur)

'Vérifier la conformité du message'
String menu = CustomKeywords.'ussd.Expected.menu'('Desole, vous avez utilise toutes vos demandes pour aujourd\'hui\\. Vous pourrez envoyer 10 demande\\(s\\) demain\\.', 
    'Tapitra ny fahafahanao mampiasa io tolotra io androany\\. Rahampitso indray ianao afaka mividy 10\\.')

WS.verifyMatch(actualMenu, menu, true)

