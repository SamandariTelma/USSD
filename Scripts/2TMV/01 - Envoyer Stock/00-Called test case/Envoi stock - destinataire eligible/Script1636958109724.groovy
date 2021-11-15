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
String pinEnvoyeur="${pinEnvoyeur}"
String montantStock="${montantStock}"

'En tant que MSISDN envoyeur [0346849414], je compose le *130*129*5#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode, numeroEnvoyeur)

'Je compose le 2 et je valide'
CustomKeywords.'ussd.Send.response'('2')

'Je clique sur 1 Envoyer du stock et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Je saisis le rang du stock a envoyer'
String rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('Envoyer '+montantStock+' Ar', actualMenu)
actualMenu=CustomKeywords.'ussd.Send.response'(rangMenu)

'Je saisis correctement le numero du Destinataire [0346847989] qui est revendeur et je valide'
numeroRecepteur=CustomKeywords.'ussd.Util.to034'(numeroRecepteur)
CustomKeywords.'ussd.Send.response'(numeroRecepteur)

'Je saisis 1 Oui pour saisir le numéro de confirmation'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis correctement le numero (0346848239) pour passer le SMS de confirmation et je valide'
numeroANotifier=CustomKeywords.'ussd.Util.to034'(numeroANotifier)
CustomKeywords.'ussd.Send.response'(numeroANotifier)

'Je saisis correctement mon PIN (0000) et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'(pinEnvoyeur)

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Envoyer '+montantStock+' Ar au '+numeroRecepteur+' \\? No pour SMS de confirmation '+numeroANotifier+'\n1 \\- Oui\n0 \\- Non',
	'Andefa '+montantStock+' Ar amin\'ny '+numeroRecepteur+' \\?  No pour SMS de confirmation '+numeroANotifier+'\n1 \\- Eny \n0 \\- Tsia')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 1 (Oui) pour confirmation et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('Votre demande de transfert est en cours de traitement\\.','Tontosa ny fividiana fahana ho n\'ny laharako\\.')

WS.verifyMatch(actualMenu, menu, true)