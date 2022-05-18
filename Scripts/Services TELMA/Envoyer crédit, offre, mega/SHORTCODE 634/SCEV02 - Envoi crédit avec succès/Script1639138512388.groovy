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
import java.text.NumberFormat

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

//-----DEBUT CODE TR CREDIT------

numeroRecepteur=CustomKeywords.'ussd.Util.to034'(numeroRecepteur)

'En tant que GP,  je shortCode le Transfert de crédit  en composant *634*Montant*MSISDN*Pin#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeDirect+'*'+montantAEnvoyer+'*'+numeroRecepteur+'*'+pinNumeroInitiateur+'#', numeroInitiateur)

int soldeExcepted=soldeEnvoyeurAvantEnvoi - Integer.valueOf(montantAEnvoyer) - Integer.valueOf(frais)
String soldeExceptedStr=CustomKeywords.'ussd.Util.separateThousand'(soldeExcepted)

'Vérifier la conformité du message'
String menu = CustomKeywords.'ussd.Expected.menu'('Transfert effectue de '+montantAEnvoyer+' Ar pour le '+numeroRecepteur+'\\. Frais de transfert '+frais+' Ar\\.Nouveau solde : '+soldeExceptedStr+' Ar.',
	'Voarain\'ny '+numeroRecepteur+' ny fahana : '+montantAEnvoyer+' Ar\\. Saran\'ny fandefasana '+frais+' Ar.Fahana sisa tavela '+soldeExceptedStr+' Ar.')

WS.verifyMatch(actualMenu, menu, true)

//-----FIN CODE TR CREDIT------

'Je vérifie que mon solde est déduit du crédit envoyé'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeEnvoyerApresEnvoi=GlobalVariable.soldeCredit

WS.verifyEqual(soldeEnvoyerApresEnvoi, soldeExcepted)


'Je vérifie que le solde du recepteur a beneficier du crédit envoyé '
numeroRecepteur = CustomKeywords.'ussd.Util.to261'(numeroRecepteur)

WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroRecepteur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeRecepApresEnvoi=GlobalVariable.soldeCredit
soldeExcepted=soldeRecepteurAvantRecep + Integer.valueOf(montantAEnvoyer)

WS.verifyEqual(soldeRecepApresEnvoi, soldeExcepted)

