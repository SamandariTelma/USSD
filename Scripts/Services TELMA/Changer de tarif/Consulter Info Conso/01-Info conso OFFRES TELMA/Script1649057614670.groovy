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
String offre = "$offre"
String groupeOffre = "${groupeOffre}"

'Après achat Offre avec succès , je consulte mon solde en saisissant #359#'
String actualMenu = CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode359 + '#', numeroInitiateur)

WS.delay(2)

'Je saisis 1 (Mes offres) et valide'
actualMenu = CustomKeywords.'ussd.Send.response'('1')

'Vérifier si l\'offre apparait dans la liste offre'
String rangMenu = WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/Consulter Info Conso/Called Test case/Liste des offres achetés'), 
    [('offre') : offre, ('actualMenu') : actualMenu], FailureHandling.CONTINUE_ON_FAILURE)

'Je saisis le rang de l\'offre affiché dans le menu puis je valide'
actualMenu = CustomKeywords.'ussd.Send.response'(rangMenu)

'Je saisis 1 (Info conso) et valide'
actualMenu = CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du message'
String menu = WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/00 - Prompt et Message achat offre/Message info conso offre'), 
    [('offre') : offre, ('groupeOffre') : groupeOffre,], FailureHandling.CONTINUE_ON_FAILURE)

WS.verifyMatch(actualMenu, menu, true)

