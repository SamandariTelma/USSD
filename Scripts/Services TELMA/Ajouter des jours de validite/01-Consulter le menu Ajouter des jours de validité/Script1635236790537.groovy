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

'En tant que client TELMA, je vais dans le menu pour Ajouter des jours de validité en composant #130*4#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeTELMA,numeroInitiateur)
CustomKeywords.'ussd.Send.response'('4')

'Je saisis 5 (Ajouter des jours de validité) et valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('5')

'Vérifier la conformité du menu'
String menu=CustomKeywords.'ussd.Expected.menu'('Achat de jour de validite\n1 Acheter des jours de validite\n2 Aide', 'Hanampy Fetr\'andro\n1 Hividy fetr\'andro\n2 Fanampiana')

WS.verifyMatch(actualMenu, menu, true)