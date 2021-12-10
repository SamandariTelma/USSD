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
String montantSOS="${montantSOS}"

numeroRecepteur=CustomKeywords.'ussd.Util.to034'(numeroRecepteur)

'En tant que GP, je shortCode le SOS Credit  en composant *659*1*034xxx*montantxx#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodeDirect+'*'+numeroRecepteur+'*'+montantSOS+'#', numeroInitiateur)

'Vérifier la conformité du message'
int montant=montantSOS.toInteger()
montantSOS=CustomKeywords.'ussd.Util.separateThousand'(montant)

String menu=CustomKeywords.'ussd.Expected.menu'('Votre demande de recharge de '+montantSOS+'Ar a ete envoyee au '+numeroRecepteur+'\\.',
	'Tontosa ny fangatahanao fahana '+montantSOS+'Ar mankany amin\'ny laharana '+numeroRecepteur+'\\.')

WS.verifyMatch(actualMenu, menu, true)