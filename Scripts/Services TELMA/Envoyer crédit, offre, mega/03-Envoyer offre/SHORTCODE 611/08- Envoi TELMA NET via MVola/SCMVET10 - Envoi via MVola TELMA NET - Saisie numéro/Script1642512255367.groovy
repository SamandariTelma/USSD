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
String numeroRecepteur=CustomKeywords.'ussd.Util.to034'(numeroInitiateur)

'En tant que GP, j\'effectue un envoi offre NET One Month 100 Go via MVola avec un numéro non Telma:  *611*15*1*numeroInvalide#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodeDirectAchat+'*15*2*0325785400#', numeroInitiateur)

'Vérifier la conformité du message'
String menu = CustomKeywords.'ussd.Expected.menu'('Desole, vous ne pouvez pas utiliser ce service\\.',
	'Azafady, tsy afaka mampiasa an\'io servisy io ianao\\.')

WS.verifyMatch(actualMenu, menu, true)

'En tant que GP, j\'effectue un envoi offre NET One Month 100 Go à mon numéro:  *611*68*1*monNumero#'
actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodeDirectAchat+'*68*1*'+numeroRecepteur+'#', numeroInitiateur)

'Vérifier la conformité du message'
menu = CustomKeywords.'ussd.Expected.menu'('Vous ne pouvez pas transferer de credit a votre numero\\. Merci de saisir un autre numero TELMA Mobile\\.',
	'Tsy afaka mamindra fahana mankany amin ny nomeraonao ianao\\. Mampidira nomerao TELMA Mobile hafa\\.')

WS.verifyMatch(actualMenu, menu, true)