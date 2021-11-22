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

String numeroEnvoyeur="${numeroEnvoyeur}"
String numeroRecepteur="${numeroRecepteur}"
String montantStock="${montantStock}"
int montant=(montantStock.replaceAll("\\s","")).toInteger()

'Consulter le solde du Livreur avant l\'envoi'
WebUI.callTestCase(findTestCase('2TMV/00 - Called test case/Consulter solde 2tmv'), [('numeroInitiateur') : numeroEnvoyeur
		, ('pinInitiateur') : GlobalVariable.pinEnvoyeur], FailureHandling.CONTINUE_ON_FAILURE)
int soldeEnvoyeurAvant=GlobalVariable.solde2tmv

'Consulter le solde du Grossiste avant l\'envoi'
WebUI.callTestCase(findTestCase('2TMV/00 - Called test case/Consulter solde 2tmv'), [('numeroInitiateur') :numeroRecepteur
		, ('pinInitiateur') : GlobalVariable.pinEnvoyeur], FailureHandling.CONTINUE_ON_FAILURE)
int soldeRecepteurAvant=GlobalVariable.solde2tmv

'En tant que numero de type Livreur, j\'envoi du stock à un autre numéro de type Grossiste'
WebUI.callTestCase(findTestCase('2TMV/01 - Envoyer Stock/00-Called test case/Envoi stock - destinataire non eligible'), [('numeroEnvoyeur') : numeroEnvoyeur
        , ('numeroRecepteur') : numeroRecepteur , ('pinEnvoyeur') : GlobalVariable.pinEnvoyeur, ('montantStock') : montantStock], FailureHandling.CONTINUE_ON_FAILURE)

'Consulter le solde du Livreur après l\'envoi'
WebUI.callTestCase(findTestCase('2TMV/00 - Called test case/Consulter solde 2tmv'), [('numeroInitiateur') : numeroEnvoyeur
		, ('pinInitiateur') : GlobalVariable.pinEnvoyeur], FailureHandling.CONTINUE_ON_FAILURE)
int soldeEnvoyeurApres=GlobalVariable.solde2tmv

WS.verifyEqual(soldeEnvoyeurApres, soldeEnvoyeurAvant)

'Consulter le solde du Grossiste après l\'envoi'
WebUI.callTestCase(findTestCase('2TMV/00 - Called test case/Consulter solde 2tmv'), [('numeroInitiateur') : numeroRecepteur
		, ('pinInitiateur') : GlobalVariable.pinEnvoyeur], FailureHandling.CONTINUE_ON_FAILURE)
int soldeReceveurApres=GlobalVariable.solde2tmv

WS.verifyEqual(soldeReceveurApres, soldeRecepteurAvant)


