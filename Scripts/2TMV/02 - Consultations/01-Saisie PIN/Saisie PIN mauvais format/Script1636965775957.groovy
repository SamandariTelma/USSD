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

'En tant que MSISDN grossiste, je compose le *130*129*5#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode, numeroInitiateur)

'Je compose le 2 ( De toi a moi vaovao) et je valide '
CustomKeywords.'ussd.Send.response'('2')

'Je saisis 2 (Consultation du solde) et je valide'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis un PIN plus de 4 chiffres'
String actualMenu=CustomKeywords.'ussd.Send.response'('25898')

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Le code secret doit comporter 4 chiffres')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un PIN moins de 4 chiffres'
actualMenu=CustomKeywords.'ussd.Send.response'('258')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Le code secret doit comporter 4 chiffres')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis PIN avec des lettres et des Chiffres'
actualMenu=CustomKeywords.'ussd.Send.response'('12ab')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Nombre d\'essai depasse\\. Merci de contacter le Service Clientele au 807\\.',
	'Maro loatra ny fampidirana kaody miafina diso\\. Mila miantso ny service client raha te hamerina amin\'ny laoniny\\.')

WS.verifyMatch(actualMenu, menu, true)