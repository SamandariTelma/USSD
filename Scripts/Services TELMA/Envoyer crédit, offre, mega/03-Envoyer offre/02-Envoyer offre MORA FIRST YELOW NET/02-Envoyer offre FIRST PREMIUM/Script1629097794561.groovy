import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import java.text.NumberFormat as NumberFormat
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

String numeroInitiateur = "$numeroInitiateur"

String numeroRecepteur = "$numeroRecepteur"

String pinNumeroInitiateur = "$pinNumeroInitiateur"

String frais = "$frais"

String montantOffre = "$montantOffre"

'Je consulte mon crédit restant avant d\'envoyer du crédit'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur], 
    FailureHandling.CONTINUE_ON_FAILURE)

int soldeEnvoyeurAvantEnvoi = GlobalVariable.soldeCredit

println('Crédit envoyeur: ' + soldeEnvoyeurAvantEnvoi)

'Je shortcode #130*4*4#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode + '#', numeroInitiateur)

'Je saisis 2 (Envoyer offre) et valide'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis correctement un MSISDN du destinataire et je valide'
numeroRecepteur = CustomKeywords.'ussd.Util.to034'(numeroRecepteur)

CustomKeywords.'ussd.Send.response'(numeroRecepteur)

'Je saisis 2 (FIRST)'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis 1 (FIRST PREMIUM)'
String actualMenu = CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du prompt'
String menu = CustomKeywords.'ussd.Expected.menu'(('Pour accepter d\'acheter l\'offre FIRST PREMIUM a 10000 Ar pour le numero ' + 
    numeroRecepteur) + ', Entrer le code secret:', ('Raha manaiky ny handefa ny tolotra FIRST PREMIUM amin\'ny sarany '+montantOffre+' Ar ho an\'ny laharana ' + numeroRecepteur) + 
    ', Ampidiro ny kaody miafina:')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis mon code secret'
NumberFormat formatter = NumberFormat.getInstance(new Locale('FR'))

actualMenu = CustomKeywords.'ussd.Send.response'(pinNumeroInitiateur)

'Vérifier la conformité du message'
int soldeRestant = soldeEnvoyeurAvantEnvoi - Integer.valueOf(montantOffre)

String solde = CustomKeywords.'ussd.Util.separateThousand'(soldeRestant)

menu = CustomKeywords.'ussd.Expected.menu'(((((('L\'envoi de l\'offre FIRST PREMIUM au tarif de ' + montantOffre) + ' Ar vers le numero ') + 
    numeroRecepteur) + ' est reussi\\. Votre nouveau solde est ') + solde) + ' Ar. Telma Safidiko N1 Malagasy\\.',
'Tontosa ny fandefasanao ny tolotra FIRST PREMIUM amin\'ny sarany '+montantOffre+' Ar ho an ny laharana '+numeroRecepteur+'\\. '+ solde + ' Ar sisa ny credit-nao\\. Telma Safidiko N1 Malagasy\\.')

WS.verifyMatch(actualMenu, menu, true)

'Vérifier si le numéro beneficiaire a reçu l\'offre FIRST PREMIUM'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/03-FIRST/05-Consulter offre FIRST (359)/01-Info conso - PREMIUM'), 
    [('numeroInitiateur') : numeroRecepteur], FailureHandling.CONTINUE_ON_FAILURE)

