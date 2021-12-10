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

numeroRecepteur=CustomKeywords.'ussd.Util.to034'(numeroRecepteur)
'J\'envoie du crédit avec un montant invalide'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodeDirect+'*1000Ar*'+numeroRecepteur+'*'+pinNumeroInitiateur+'#', numeroInitiateur)

'Vérifier la conformité du message'
String menu= CustomKeywords.'ussd.Expected.menu'('Montant incorrect\\. Veuillez entrer un montant entre 500 Ar et 200 000 Ar',
	'Diso ny sandam\\-bola\\. Ampidiro ny sanda eo anelanelan ny 500 Ar sy 200 000 Ar')

WS.verifyMatch(actualMenu, menu, true)

'J\'envoie du crédit inférieur à 500Ar'
actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodeDirect+'*499*'+numeroRecepteur+'*'+pinNumeroInitiateur+'#', numeroInitiateur)

'Vérifier la confromité du message'
WS.verifyMatch(actualMenu, menu, true)

'J\'envoie du crédit supérieur à 200000Ar'
actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodeDirect+'*200001*'+numeroRecepteur+'*'+pinNumeroInitiateur+'#', numeroInitiateur)

'Vérifier la confromité du message'
WS.verifyMatch(actualMenu, menu, true)

