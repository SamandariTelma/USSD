import internal.GlobalVariable

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

'En tant que MSISDN grossiste [0346849414], je compose le *130*2#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'#', numeroGrossiste)

'Je clique sur 3 Envoyer du stock et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('3')

'Vérifier la conformité du prompt montant'
String menu=CustomKeywords.'ussd.Expected.menu'('1 Autre montant\n2 Envoyer 10 000 Ar\n3 Envoyer 20 000 Ar\n4 Envoyer 50 000 Ar\n5 Envoyer 100 000 Ar\n6 Envoyer 500 000 Ar\n7 Envoyer 1 000 000 Ar\n0 Page suivante\n00 Page precedente',
	'1 Sandam\\-bola hafa\n2 Andefa 10 000 Ar\n3 Andefa 20 000 Ar\n4 Andefa 50 000 Ar\n5 Andefa 100 000 Ar\n6 Andefa 500 000 Ar\n7 Andefa 1 000 000 Ar\n0 Pejy manaraka\\n00 Pejy aloha')

WS.verifyMatch(actualMenu, menu, true)