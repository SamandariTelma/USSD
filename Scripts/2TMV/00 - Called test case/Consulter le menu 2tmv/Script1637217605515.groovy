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

String numeroRevendeur = "$numeroGrossiste"

'En tant que MSISDN grossiste, je compose le *130*2#'
String actualMenu = CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeTELMA + '#', numeroGrossiste)

'Je vérifie la présence du menu 2tmv'
String menu = CustomKeywords.'ussd.Expected.menu'('^.*De Toi a Moi Vaovao.*$')

WS.verifyMatch(actualMenu, menu, true)

'Je compose le 2 et je valide'
actualMenu = CustomKeywords.'ussd.Send.response'('2')

'Vérifier l\'affichage du sous-menu'
menu = CustomKeywords.'ussd.Expected.menu'('2 TOI A MOI VAOVAO\n2 Changer tarif client\n3 Envoyer du stock\n4 Consultation du solde\n5 Ventes d\'hier\n6 Changer code secret\n7 Changement de langue\n0 Page suivante\n00 Page precedente', 
    '1 Mamahana mpanjifa\n2 Manova ny tolotry ny mpanjifa\n3 Andefa tahiry\n4 Mijery fahana sisa tavela\n5 Varotra omaly\n6 Manova kaody miafina\n7 Hisafidy fiteny\n0 Pejy manaraka\n00 Pejy aloha')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 0 (Page suivante)'
actualMenu = CustomKeywords.'ussd.Send.response'('0')

'Vérifier la conformité du menu'
menu = CustomKeywords.'ussd.Expected.menu'('8 Verification du grossiste\n00 Page precedente\n\\*\\* Menu principal', '8 Verification du grossiste\n00 Pejy aloha\n\\*\\* main')

WS.verifyMatch(actualMenu, menu, true)

