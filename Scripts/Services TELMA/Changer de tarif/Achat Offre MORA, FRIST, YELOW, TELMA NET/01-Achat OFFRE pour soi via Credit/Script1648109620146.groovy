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

String montant = "$montant"

String offre = "$offre"

String groupeOffre = "$groupeOffre"

String rangMenu = "$rangMenu"

String rangOffreNivI = "$rangOffreNivI"

String rangOffreNivII = "$rangOffreNivII"

String volumeData = "$volumeData"

String confirmation = "$confirmation"

String validite = "$validite"

String actualMenu

'Consulter mon solde avant d\' effectuer un achat OFFRE'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur], 
    FailureHandling.CONTINUE_ON_FAILURE)

int soldeAvant = GlobalVariable.soldeCredit

'Je shortcode *130*4*6*# et je valide'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode + '#', numeroInitiateur)

'Je saisis je saisie le rang du menu ex :1 pour MORA'
CustomKeywords.'ussd.Send.response'(rangMenu)

'Je saisis le rang de l\'offre ex :1 pour MORA 500 et je valide'
actualMenu = CustomKeywords.'ussd.Send.response'(rangOffreNivI)

//Si il existe encore un menu en dessous :
if (rangOffreNivII != 'null') {
    'Je saisis le rang du sous offre'
    actualMenu = CustomKeywords.'ussd.Send.response'(rangOffreNivII)
}

//S'il existe de confirmation avant d'acheter un offre
if (confirmation.equals('oui')) {
    'Vérifier la conformité du prompt de confirmation'
    menu = WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/00 - Prompt et Message achat offre/Message de confirmation achat via Credit'), 
        [('montant') : montant, ('offre') : offre, ('groupeOffre') : groupeOffre, ('volumeData') : volumeData, ('validite') : validite], 
        FailureHandling.CONTINUE_ON_FAILURE)

    WS.verifyMatch(actualMenu, menu, true) 
    'Je confirme l\'achat en repondant par 1'
    actualMenu = CustomKeywords.'ussd.Send.response'('1')
    
}


'Vérifier la conformité du menu'
String menu = WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/00 - Prompt et Message achat offre/Message de reussite d achat offre'), 
    [('montant') : montant, ('offre') : offre, ('groupeOffre') : groupeOffre, ('volumeData') : volumeData], FailureHandling.CONTINUE_ON_FAILURE)

WS.verifyMatch(actualMenu, menu, true)

'Je vérifie que mon solde est déduit du montant de OFFRE acheté'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur], 
    FailureHandling.CONTINUE_ON_FAILURE)

int soldeApresAchatOffre = GlobalVariable.soldeCredit

int soldeExcepted = soldeAvant - Integer.valueOf(montant)

WS.verifyEqual(soldeApresAchatOffre, soldeExcepted)

//Initialiser la date d'expiration
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/00 - Prompt et Message achat offre/Date d expiration offres'), 
    [('offre') : offre], FailureHandling.CONTINUE_ON_FAILURE)


