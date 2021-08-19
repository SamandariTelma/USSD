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
String numeroARecuperer="${numeroARecuperer}"
String pinNumARecuperer="${pinNumARecuperer}"
String cinMsisdnARecuperer="${cinMsisdnARecuperer}"


'En tant que client TELMA, je vais dans le menu pour Récupérer mon numéro en composant #130*4*9#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis le MSISDN à récupérer'
CustomKeywords.'ussd.Send.response'(numeroARecuperer)

'Je saisis la pièce d\'identité correspondant au numéro à récupérer'
CustomKeywords.'ussd.Send.response'(cinMsisdnARecuperer)

'Je saisis un Pin valide'
actualMenu=CustomKeywords.'ussd.Send.response'(pinNumARecuperer)

'Je saisis à nouveau le même PIN pour confirmation et valide'
String actualMenu=CustomKeywords.'ussd.Send.response'(pinNumARecuperer)

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Votre demande est en cours de traitement, vous allez recevoir un SMS de confirmation')

WS.verifyMatch(actualMenu, menu, true)

'Je vérifie que le SMS recu'
