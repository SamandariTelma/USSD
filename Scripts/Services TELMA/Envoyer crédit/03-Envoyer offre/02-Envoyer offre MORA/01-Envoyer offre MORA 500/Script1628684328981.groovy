import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import java.text.NumberFormat

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

String numeroInitiateur = "$numeroInitiateur"

String numeroRecepteur = "$numeroRecepteur"

String pinNumeroInitiateur = "$pinNumeroInitiateur"

String frais = "$frais"

String montantOffre ="$montantOffre"

'Je consulte mon crédit restant avant d\'envoyer du crédit'
WebUI.callTestCase(findTestCase('Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeEnvoyeurAvantEnvoi = GlobalVariable.soldeCredit
println 'Crédit envoyeur: '+soldeEnvoyeurAvantEnvoi

'Je shortcode #130*4*4#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode + '#', numeroInitiateur)

'Je saisis 2 (Envoyer offre) et valide'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis correctement un MSISDN du destinataire et je valide'
numeroRecepteur=CustomKeywords.'ussd.Util.to034'(numeroRecepteur)

CustomKeywords.'ussd.Send.response'(numeroRecepteur)

'Je saisis 1 (MORA)'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis 1 (MORA 500)'
String actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Pour accepter d\'acheter l\'offre MORA 500 a 500 Ar pour le numero '+numeroRecepteur+', Entrer le code secret:', 
	'Raha handefa ny tolotra MORA 500 ho an ny '+numeroRecepteur+', Ampidiro ny kaody miafina MVola:')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis mon code secret'
NumberFormat formatter = NumberFormat.getInstance(new Locale("FR"))

actualMenu=CustomKeywords.'ussd.Send.response'(pinNumeroInitiateur)

'Vérifier la conformité du message'
int soldeRestant=soldeEnvoyeurAvantEnvoi - Integer.valueOf(montantOffre)
String solde=CustomKeywords.'ussd.Util.separateThousand'(soldeRestant)

menu=CustomKeywords.'ussd.Expected.menu'('L\'envoi de l\'offre MORA 500 au tarif de '+montantOffre+' Ar vers le numero '+numeroRecepteur+' est reussi\\. Votre nouveau solde est '+solde+' Ar. Telma toujours plus pour vous.', 
	'')

WS.verifyMatch(actualMenu, menu, true)