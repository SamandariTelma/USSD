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
String numeroChefDeZone="${numeroChefDeZone}"
String numeroANotifier="${numeroANotifier}"
String pinEnvoyeur="${pinEnvoyeur}"

'En tant que MSISDN grossiste, je compose le *130*2#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'#', numeroGrossiste)

'Je saisis un menu qui n\'existe pas'
String actualMenu=CustomKeywords.'ussd.Send.response'('12')

'Vérifier que je reviens sur les menus 2tmv'
String menu=CustomKeywords.'ussd.Expected.menu'('1 Recharger client\n2 Changer tarif client\n3 Envoyer du stock\n4 Consultation du solde\n5 Ventes d\'hier\n6 Changer code secret\n7 Changement de langue\n0 Page suivante\n00 Page precedente',
	'1 Mamahana mpanjifa\n2 Manova ny tolotry ny mpanjifa\n3 Andefa tahiry\n4 Mijery fahana sisa tavela\n5 Varotra omaly\n6 Manova kaody miafina\n7 Hisafidy fiteny\n0 Pejy manaraka\n00 Pejy aloha')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 3 Envoyer du stock et je valide'
CustomKeywords.'ussd.Send.response'('3')

'Je saisis un numero en dehors du menu stock proposé et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('10')

'Vérifier que je reviens sur la liste des stock'
menu=CustomKeywords.'ussd.Expected.menu'('1 Autre montant\n2 Envoyer 10 000 Ar\n3 Envoyer 20 000 Ar\n4 Envoyer 50 000 Ar\n5 Envoyer 100 000 Ar\n6 Envoyer 500 000 Ar\n7 Envoyer 1 000 000 Ar\n00 Page precedente',
	'1 Sandam\\-bola hafa\n2 Andefa 10 000 Ar\n3 Andefa 20 000 Ar\n4 Andefa 50 000 Ar\n5 Andefa 100 000 Ar\n6 Andefa 500 000 Ar\n7 Andefa 1 000 000 Ar\n00 Pejy aloha\n\\*\\* main')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 4 (Envoyer 50 000 Ar) et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('4')

'Je saisis correctement le numero du Destinataire qui est revendeur et je valide'
numeroChefDeZone=CustomKeywords.'ussd.Util.to034'(numeroChefDeZone)
actualMenu=CustomKeywords.'ussd.Send.response'(numeroChefDeZone)

'Je saisis correctement mon PIN et je valide'
CustomKeywords.'ussd.Send.response'(pinEnvoyeur)

'Je saisis un numero différent de 1 et 0 et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('2')

'Vérifier que je reviens sur le prompt de confirmation'
menu=CustomKeywords.'ussd.Expected.menu'('Envoyer 50000 Ar au '+numeroChefDeZone+' \\? \\(1\\-Oui ; 0\\-Non\\)', 
	'Andefa 50000 Ar ny '+numeroChefDeZone+' \\? \\(1\\-Eny; 0\\-Tsia\\)')

WS.verifyMatch(actualMenu, menu, true)