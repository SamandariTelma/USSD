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

String numeroInitiateur="${numeroInitiateur}"
String numeroARecharger="${numeroARecharger}"
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

'Je saisis 2 (Envoyer 1 000 Ar) et je valide'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis un numéro GP'
String actualMenu=CustomKeywords.'ussd.Send.response'(numeroARechargerTo034)

'Je saisis un mauvais code Pin (Alphanumerique)'
CustomKeywords.'ussd.Send.response'('3397')

'Je confirme l\'envoi en saisissant 1 (Oui)'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Le code secret saisi est incorrect\\. Ref: \\d{1,10}','Diso ny kaodinao\\. Ref: \\d{1,10}')

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