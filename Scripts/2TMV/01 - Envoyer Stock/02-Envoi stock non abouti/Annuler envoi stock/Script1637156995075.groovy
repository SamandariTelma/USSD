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

String numeroEnvoyeur="${numeroEnvoyeur}"
String numeroRecepteur="${numeroRecepteur}"
String numeroANotifier="${numeroANotifier}"
String pinGrossiste="${pinGrossiste}"

'En tant que MSISDN Envoyeur , je compose le *130*2#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'#', numeroEnvoyeur)

'Je clique sur 3 Envoyer du stock et je valide'
CustomKeywords.'ussd.Send.response'('3')

'Je saisis 3 (Envoyer 20 000 Ar) et je valide'
CustomKeywords.'ussd.Send.response'('3')

'Je saisis correctement le numero du Destinataire et je valide'
numeroRecepteur=CustomKeywords.'ussd.Util.to034'(numeroRecepteur)
actualMenu=CustomKeywords.'ussd.Send.response'(numeroRecepteur)

'Je saisis correctement mon PIN  et je valide'
CustomKeywords.'ussd.Send.response'(pinGrossiste)

'Je saisis 0 (Non) et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('0')

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Votre demande de transfert a bien ete annulee\\.','Tsy nekena ny fividiana fahana ho an\'ny laharako\\.')

WS.verifyMatch(actualMenu, menu, true)