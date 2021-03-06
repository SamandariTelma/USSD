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

String numeroInitiateur= "${numeroInitiateur}"
String codeRecharge= "${codeRecharge}"

'Je consulte mon solde crédit avant de recharger mon compte'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeAvantRecharge = GlobalVariable.soldeCredit
println 'Solde avant recharge: '+soldeAvantRecharge

'En tant que client TELMA, je vais dans le menu pour Recharger mon numéro en composant #130*4*2#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'#', numeroInitiateur)

'Je saisis 1 (Recharger mon numero) et je valide'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis un numero de code expiré'
String actualMenu=CustomKeywords.'ussd.Send.response'(codeRecharge)

'Vérifier la conformité du message ussd'
String menu=CustomKeywords.'ussd.Expected.menu'('Votre carte de recharge est expiree', 'Lany andro ny karatra famahananao')

WS.verifyMatch(actualMenu, menu, true)

'Je consulte mon solde crédit après avoir recharger mon compte'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeApresRecharge = GlobalVariable.soldeCredit

'Vérifier que le crédit rechargé n\'est ajouté à mon solde'

WS.verifyEqual(soldeApresRecharge, soldeAvantRecharge)

