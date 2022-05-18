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

String numeroRecepteur = "$numeroRecepteur"

String montantAEnvoyer = "$montantAEnvoyer"

String pinNumeroInitiateur = "$pinNumeroInitiateur"

String frais = "$frais"

'Je consulte mon crédit restant avant d\'envoyer du crédit'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur], 
    FailureHandling.CONTINUE_ON_FAILURE)

int soldeEnvoyeurAvantEnvoi = GlobalVariable.soldeCredit
println 'Crédit envoyeur: '+soldeEnvoyeurAvantEnvoi

'Je consulte le crédit du numéro recepteur avant de recevoir du crédit'

WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroRecepteur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeRecepteurAvantRecep = GlobalVariable.soldeCredit
println 'Crédit recepteur: '+soldeRecepteurAvantRecep

'Je shortcode #130*4*4#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode + '#', numeroInitiateur)

'Je saisis 1 (Envoyer du credit) et valide'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis un montant correct et je valide'
CustomKeywords.'ussd.Send.response'(soldeEnvoyeurAvantEnvoi.toString())

'Je saisis correctement un MSISDN du destinataire et je valide'
numeroRecepteur = CustomKeywords.'ussd.Util.to034'(numeroRecepteur)

println(numeroRecepteur)

CustomKeywords.'ussd.Send.response'(numeroRecepteur)

'Je saisis mon PIN et je valide'
String actualMenu = CustomKeywords.'ussd.Send.response'(pinNumeroInitiateur)

'Vérifier la conformité du message'
String menu = CustomKeywords.'ussd.Expected.menu'('Credit insuffisant: rechargez votre Compte puis essayez a nouveau ou diminuez le montant a transferer\\.', 
	'Tsy ampy ny fahana anananao\\. Fahano ny kaontinao na ahenao ny fahana hafindra\\.')

WS.verifyMatch(actualMenu, menu, true)

'Je vérifie que mon solde n\'est déduit du crédit envoyé'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeEnvoyerApresEnvoi=GlobalVariable.soldeCredit 

WS.verifyEqual(soldeEnvoyerApresEnvoi, soldeEnvoyeurAvantEnvoi)


'Je vérifie que le solde du recepteur n\'a pas bougé'

numeroRecepteur = CustomKeywords.'ussd.Util.to261'(numeroRecepteur)
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroRecepteur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeRecepApresEnvoi=GlobalVariable.soldeCredit

WS.verifyEqual(soldeRecepApresEnvoi, soldeRecepteurAvantRecep)


