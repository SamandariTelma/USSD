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

'Je saisis 4 (TELMA NET)'
CustomKeywords.'ussd.Send.response'('4')

'Je saisis 1 (NET JOURNALIER)'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis 2 (NET ONE DAY)'
String actualMenu = CustomKeywords.'ussd.Send.response'('2')

'Vérifier la conformité du prompt'
String menu = CustomKeywords.'ussd.Expected.menu'(('Pour accepter d\'acheter l\'offre NET ONE DAY a 1000 Ar pour le numero ' + 
    numeroRecepteur) + ', Entrer le code secret:', ('Raha handefa ny tolotra NET ONE DAY @ sarany 1000 Ar ho an ny ' + numeroRecepteur) + 
    ' ianao, ampidiro ny kaody miafina:')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis mon code secret'
NumberFormat formatter = NumberFormat.getInstance(new Locale('FR'))

actualMenu = CustomKeywords.'ussd.Send.response'(pinNumeroInitiateur)

'Vérifier la conformité du message'
int soldeRestant = soldeEnvoyeurAvantEnvoi - Integer.valueOf(montantOffre)

String solde = CustomKeywords.'ussd.Util.separateThousand'(soldeRestant)

menu = CustomKeywords.'ussd.Expected.menu'('L\'envoi de l\'offre NET ONE DAY au tarif de ' + montantOffre + ' Ar vers le numero ' +numeroRecepteur+ ' est reussi\\. Votre nouveau solde est ' + solde + ' Ar\\. Telma Safidiko N1 Malagasy\\.',
'Tontosa ny fandefasanao ny tolotra NET ONE DAY amin ny sarany ' + montantOffre+ ' Ar ho an ny laharana '+numeroRecepteur+'\\. ' +solde+ ' Ar sisa ny credit-nao\\. Telma Safidiko N1 Malagasy\\.')

WS.verifyMatch(actualMenu, menu, true)

'Vérifier si le numéro beneficiaire a reçu l\'offre NET ONE DAY'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/05-TELMA NET/04-Consulter offre Telma net (359)/02-Info conso - ONE DAY'), 
    [('numeroInitiateur') : numeroRecepteur], FailureHandling.CONTINUE_ON_FAILURE)

