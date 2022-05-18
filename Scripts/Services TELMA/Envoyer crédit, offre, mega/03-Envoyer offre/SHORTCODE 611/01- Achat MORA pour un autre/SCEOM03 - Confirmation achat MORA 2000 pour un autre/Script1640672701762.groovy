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


'En tant que GP, j\'effectue un achat offre Mora + 2000 pour un autre:  *611*32*2*numero#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeDirectEnvoiOffre+'*32*2*'+numeroRecepteur+'#', numeroInitiateur)

'Vérifier la conformité du message'
String menu = CustomKeywords.'ussd.Expected.menu'(('Pour accepter d\'acheter l\'offre MORA\\+ 2000 a '+montant+' Ar pour le numero ' + numeroRecepteur) + ', Entrer le code secret:', 
('Raha manaiky ny handefa ny tolotra MORA\\+ 2000 amin\'ny sarany '+montant+' Ar ho an\'ny laharana ' + numeroRecepteur) + ', Ampidiro ny kaody miafina:')

WS.verifyMatch(actualMenu, menu, true)