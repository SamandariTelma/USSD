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
String montant="${montant}"
numeroRecepteur=CustomKeywords.'ussd.Util.to034'(numeroRecepteur)


'En tant que GP, j\'effectue un envoi offre NET One Week 350 Mo avec MVola:  *611*70*1*numero#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodeDirectEnvoiOffre+'*70*1*'+numeroRecepteur+'#', numeroInitiateur)

'Vérifier la conformité du message'
String menu = CustomKeywords.'ussd.Expected.menu'('Pour accepter d acheter l offre NET ONE WEEK 350 Mo d\'un montant de '+montant+' Ar pour le '+ numeroRecepteur +' depuis votre compte Mvola, entrez votre code secret :', 
	'Raha manaiky ny fandefasana ny tolotra NET ONE WEEK 350 Mo @ sarany '+montant+' Ar ho an\'ny laharana ' + numeroRecepteur + ' avy @ kaonty Mvola nao ianao, ampidiro ny code secret:')

WS.verifyMatch(actualMenu, menu, true)