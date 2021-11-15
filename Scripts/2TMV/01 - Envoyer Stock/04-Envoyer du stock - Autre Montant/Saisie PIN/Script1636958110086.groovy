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
String actualMenu=CustomKeywords.'ussd.Send.response'(numeroRevendeur)

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Entrer code secret :', 'Entrer code secret :')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un PIN au format invalide'
actualMenu=CustomKeywords.'ussd.Send.response'('abc12')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Le code secret saisi n\'est pas le bon\\.', 'Nanoratra kaody miafina diso ilay olona\\.')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un PIN comportant 4 chiffres mais qui ne m\'appartient pas et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('8624')

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('Votre demande n a pas abouti\\. Vous avez recu un SMS avec les details de votre transaction\\. Si besoin, contactez le Service Clientele au 807\\.',
	'Tsy tafita ny fangatahanao\\. Naharay SMS manazava ny antony ianao\\. Raha ilaina, antsoy ny Service Clientele amin ny 807\\.')

WS.verifyMatch(actualMenu, menu, true)


