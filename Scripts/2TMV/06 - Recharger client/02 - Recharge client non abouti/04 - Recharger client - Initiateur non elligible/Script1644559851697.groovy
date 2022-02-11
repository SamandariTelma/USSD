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

numeroARecharger=CustomKeywords.'ussd.Util.to034'(numeroARecharger)

'En tant que MSISDN non revendeur , je compose le *130*2*1#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*1#', numeroInitiateur)

'Je saisis 1 (Autre montant) et je valide'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis le montant souhaité'
CustomKeywords.'ussd.Send.response'('20000')

'Je saisis correctement un numéro Client GP et je valide'
CustomKeywords.'ussd.Send.response'(numeroARecharger)

'Je saisis le bon code PIN'
CustomKeywords.'ussd.Send.response'(codeNumeroInitiateur)

'Je confirme l\'envoi en saisissant 1 (Oui)'
String actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Desole, vous n\'etes pas autorise a acceder a ce service\\.', 
	'Tsy afaka mampiasa io tolotra io ianao\\.')

WS.verifyMatch(actualMenu, menu, true)