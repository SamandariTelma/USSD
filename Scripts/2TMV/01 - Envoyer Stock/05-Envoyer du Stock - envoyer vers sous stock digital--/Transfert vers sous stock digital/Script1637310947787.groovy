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
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode, numeroGrossiste)

'Je compose le 2 et je valide'
CustomKeywords.'ussd.Send.response'('2')

'Je clique sur 1 Envoyer du stock et je valide'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis 8 (Transfert vers sous stock digital ) et je valide'
CustomKeywords.'ussd.Send.response'('8')

'Je saisis un montant correct (10000) à transferer vers sous stock digital et je valide'
CustomKeywords.'ussd.Send.response'('10000')

'Je saisis correctement mon code secret 2TMV et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'(pinGrossiste)

'Vérifier la conformité du message ussd'
String menu=CustomKeywords.'ussd.Expected.menu'('Votre transaction a reussi. Vous allez recevoir un sms de confirmation')

WS.verifyMatch(actualMenu, menu, true)