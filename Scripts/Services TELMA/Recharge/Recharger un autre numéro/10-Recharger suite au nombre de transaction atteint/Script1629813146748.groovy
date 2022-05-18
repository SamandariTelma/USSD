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
String numeroRecepteur="${numeroRecepteur}"
String codeRecharge="${codeRecharge}"
String montantRecharge="${montantRecharge}"

'Je consulte le solde crédit du numéro beneficiaire avant de recharger son compte'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroRecepteur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeAvantRecharge = GlobalVariable.soldeCredit
println 'Solde avant recharge: '+soldeAvantRecharge

'En tant que client TELMA, je vais dans le menu pour Recharge en composant #130*4# > 2'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'#', numeroInitiateur)

'Je saisis 2 (Recharger un autre numéro)'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis correctement un numéro MSISDN valide et je valide'
numeroRecepteur=CustomKeywords.'ussd.Util.to034'(numeroRecepteur)
CustomKeywords.'ussd.Send.response'(numeroRecepteur)

'Je saisis 1 pour continuer'
String actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Entrer numero de tel\\. Destinataire :', 'Nomerao tel\\. andefasana :')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis correctement le code de recharge et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'(codeRecharge)


'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('Vous venez de recharger le compte du '+numeroRecepteur+' de '+montantRecharge+' Ar\\.',
	'Voafahana '+montantRecharge+' Ar ny kaontin\'ny '+numeroRecepteur+'\\.')

'Je consulte le solde crédit du numéro beneficiarie après avoir recharger son compte'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroRecepteur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeApresRecharge = GlobalVariable.soldeCredit

'Vérifier que le crédit rechargé est ajouté au solde du numéro beneficiaire'

WS.verifyEqual(soldeApresRecharge, soldeAvantRecharge + montantRecharge)