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

String numeroGrossiste="${numeroGrossiste}"
String numeroRevendeur="${numeroRevendeur}"
String numeroANotifier="${numeroANotifier}"
String pinGrossiste="${pinGrossiste}"

'En tant que MSISDN grossiste [0346849414], je compose le *130*129*5#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode, numeroGrossiste)

'Je compose le 2 et je valide'
CustomKeywords.'ussd.Send.response'('2')

'Je clique sur 1 Envoyer du stock et je valide'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis 1 (Autre montant) et je valide'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis un montant entre 100 à 1 000 000 Ar et je valide'
CustomKeywords.'ussd.Send.response'('18000')

'Je saisis correctement le numero du Destinataire [0346847989] qui est revendeur et je valide'
numeroRevendeur=CustomKeywords.'ussd.Util.to034'(numeroRevendeur)
CustomKeywords.'ussd.Send.response'(numeroRevendeur)

'Je saisis 1 (Oui) et je valide '
String actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('', '')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis correctement mon PIN (0000) et je valide'
CustomKeywords.'ussd.Send.response'(pinGrossiste)

'Je saisis 0 (Non) et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('0')

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('Votre demande de transfert est en cours de traitement\\.','Tontosa ny fividiana fahana ho n\'ny laharako\\.')

WS.verifyMatch(actualMenu, menu, true)