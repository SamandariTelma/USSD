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

String numeroInitiateur ="${numeroInitiateur}"
String numeroARecharger ="${numeroARecharger}"
String codeNumeroInitiateur="${codeNumeroInitiateur}"

numeroARechargerTo034=CustomKeywords.'ussd.Util.to034'(numeroARecharger)

'Consulter le stock du Revendeur avant la recharge client'
WebUI.callTestCase(findTestCase('2TMV/00 - Called test case/Consulter solde 2tmv'), [('numeroInitiateur') : numeroInitiateur
		, ('pinInitiateur') : codeNumeroInitiateur], FailureHandling.CONTINUE_ON_FAILURE)

int soldeEnvoyeurAvant = GlobalVariable.solde2tmv

'Consulter le solde crédit du client avant la recharge 2tmv'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroARecharger],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeCreditAvantRecharge = GlobalVariable.soldeCredit

'En tant que MSISDN Revendeur , je compose le *130*2*1#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*1#', numeroInitiateur)

'Je saisis 4 (Envoyer 5000 Ar) et je valide'
CustomKeywords.'ussd.Send.response'('4')

'Je saisis correctement le numero du client qui est GP et je valide'
CustomKeywords.'ussd.Send.response'(numeroARechargerTo034)

'Je saisis le bon code PIN'
String actualMenu=CustomKeywords.'ussd.Send.response'(codeNumeroInitiateur)

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Envoyer 5000 Ar au 0346848017 \\? \\(1\\-Oui ; 0\\-Non\\)', 'Andefa 5000 Ar ny 0346848017 \\? \\(1\\-Eny; 0\\-Tsia\\)')

WS.verifyMatch(actualMenu, menu, true)

'J\'annule l\'envoi en saisissant 0 (Non)'
actualMenu=CustomKeywords.'ussd.Send.response'('0')

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('Votre demande de transfert a bien ete annulee\\.', 'Tsy nekena ny fividiana fahana ho an ny laharako\\.')

WS.verifyMatch(actualMenu, menu, true)

'Vérifier que le solde 2tmv du revendeur n\'est pas déduit du montant de recharge'
WebUI.callTestCase(findTestCase('2TMV/00 - Called test case/Consulter solde 2tmv'), [('numeroInitiateur') : numeroInitiateur
		, ('pinInitiateur') : codeNumeroInitiateur], FailureHandling.CONTINUE_ON_FAILURE)

int soldeEnvoyeurApres = GlobalVariable.solde2tmv

WS.verifyEqual(soldeEnvoyeurApres, soldeEnvoyeurAvant)

'Vérifier que le solde crédit du client est pas augmenté du montant que le revendeur à envoyer'

WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroARecharger],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeCreditApresRecharge = GlobalVariable.soldeCredit

WS.verifyEqual(soldeCreditApresRecharge, soldeCreditAvantRecharge)