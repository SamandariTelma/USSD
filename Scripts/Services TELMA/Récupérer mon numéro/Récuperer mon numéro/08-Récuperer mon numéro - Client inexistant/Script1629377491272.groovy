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
String numeroInexistant="${numeroInexistant}"

'En tant que client TELMA, je vais dans le menu pour Récupérer mon numéro en composant #130*4*9#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'#', numeroInitiateur)

'Je saisis le MSISDN à récupérer'
numeroInexistant=CustomKeywords.'ussd.Util.to034'(numeroInexistant)
CustomKeywords.'ussd.Send.response'(numeroInexistant)//

'Je saisis un numéro de pièce d\'identité valide'
CustomKeywords.'ussd.Send.response'('123456789012')

'Je saisis un Pin valide'
actualMenu=CustomKeywords.'ussd.Send.response'('0000')

'Je saisis à nouveau le même PIN pour confirmation et valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('0000')

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Votre demande n a pas abouti\\. Client Invalid, SIM Inexistant\\.')

WS.verifyMatch(actualMenu, menu, true)

