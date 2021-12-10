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

String numeroInitiateur = "$numeroInitiateur"

String numeroRecepteur = "$numeroRecepteur"

String montantAEnvoyer = "$montantAEnvoyer"

String pinNumeroInitiateur = "$pinNumeroInitiateur"

String frais = "$frais"

'J\'envoie du crédit à un numéro invalide'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodeDirect+'*'+montantAEnvoyer+'*0325785400*'+pinNumeroInitiateur+'#', numeroInitiateur)

'Vérifier la conformité du message'
String menu= CustomKeywords.'ussd.Expected.menu'('Verifiez le numero svp\\.',
	'Hamarino ny nomerao azafady\\.')

WS.verifyMatch(actualMenu, menu, true)

'J\'envoie du crédit à un numéro au format incorecte'
actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodeDirect+'*'+montantAEnvoyer+'*261346848017*'+pinNumeroInitiateur+'#', numeroInitiateur)

'Vérifier la confromité du message'
WS.verifyMatch(actualMenu, menu, true)

'J\'envoie du crédit à mon numéro'
numeroInitiateur=CustomKeywords.'ussd.Util.to034'(numeroInitiateur)
actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodeDirect+'*'+montantAEnvoyer+'*'+numeroInitiateur+'*'+pinNumeroInitiateur+'#', numeroInitiateur)

'Vérifier la conformité du message'
menu= CustomKeywords.'ussd.Expected.menu'('Vous ne pouvez pas transferer de credt a votre numero\\. Merci de saisir un autre numero TELMA Mobile\\.', 
	'Tsy afaka mamindra fahana mankany amin ny nomeraonao ianao\\. Mampidira nomerao TELMA Mobila hafa\\.')

WS.verifyMatch(actualMenu, menu, true)

