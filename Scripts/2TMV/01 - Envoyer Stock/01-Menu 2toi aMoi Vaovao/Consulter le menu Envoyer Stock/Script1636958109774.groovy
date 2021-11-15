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

'En tant que MSISDN grossiste [0346849414], je compose le *130*129*5#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode, numeroGrossiste)

'Je vérifie la présence du menu 2tmv'
String menu=CustomKeywords.'ussd.Expected.menu'('^.*De Toi a Moi vaovao.*$')

WS.verifyMatch(actualMenu, menu, true)

'Je compose le 2 et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('2')

'Vérifier l\'affichage du sous-menu'
menu=CustomKeywords.'ussd.Expected.menu'('2Toi a Moi vaovao\n1 Envoyer du stock\n2 Consultation du solde\n3 Consultation du bonus\n4 Ventes d\'hier\n5 Changer code secret\n6 Hisafidy fiteny')

WS.verifyMatch(actualMenu, menu, true)

'Je clique sur 1 Envoyer du stock et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du prompt montant'
menu=CustomKeywords.'ussd.Expected.menu'('Stock\n1 Autre montant\n2 Envoyer 10 000 Ar\n3 Envoyer 20 000 Ar\n4 Envoyer 50 000 Ar\n5 Envoyer 100 000 Ar\n6 Envoyer 500 000 Ar\n7 Envoyer 1 000 000 Ar\n0 Page suivante')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 0'
actualMenu=CustomKeywords.'ussd.Send.response'('0')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('8 Transfert vers sous stock digital\n00 Page precedente')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 00 et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('00')

'Vérifier que je retourne sur le prompt montant'
menu=CustomKeywords.'ussd.Expected.menu'('Stock\n1 Autre montant\n2 Envoyer 10 000 Ar\n3 Envoyer 20 000 Ar\n4 Envoyer 50 000 Ar\n5 Envoyer 100 000 Ar\n6 Envoyer 500 000 Ar\n7 Envoyer 1 000 000 Ar\n0 Page suivante')

WS.verifyMatch(actualMenu, menu, true)
