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

'En tant que MSISDN grossiste, je compose le *130*2*1*# pour aller dans le menu Recharger client'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'*1#', numeroInitiateur)

'Vérifier la conformité du menu'
String menu= CustomKeywords.'ussd.Expected.menu'('1 Autre Montant \n2 Envoyer 1 000 Ar\n3 Envoyer 2 000 Ar\n4 Envoyer 5 000 Ar\n5 Envoyer 15 000 Ar\n6 Envoyer 25 000 Ar\n0 Page suivante\n00 Page precedente', 
	'1 Sandam\\-bola hafa \n2 Andefa 1 000 Ar\n3 Andefa 2 000 Ar\n4 Andefa 5 000 Ar\n5 Andefa 15 000 Ar\n6 Andefa 25 000 Ar\n7 Andefa 50 000 Ar\n8 Andefa 100 000 Ar\n00 Pejy aloha\n\\*\\* main')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 0 pour page suivante'
actualMenu=CustomKeywords.'ussd.Send.response'('0')

'Vérifier la conformité du menu'
menu= CustomKeywords.'ussd.Expected.menu'('7 Envoyer 50 000 Ar\n8 Envoyer 100 000 Ar\n00 Page precedente\n\\*\\* Menu principal',
	'1 Sandam\\-bola hafa \n2 Andefa 1 000 Ar\n3 Andefa 2 000 Ar\n4 Andefa 5 000 Ar\n5 Andefa 15 000 Ar\n6 Andefa 25 000 Ar\n7 Andefa 50 000 Ar\n8 Andefa 100 000 Ar\n00 Pejy aloha\n\\*\\* main')

WS.verifyMatch(actualMenu, menu, true)
