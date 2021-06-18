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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

String numeroInitiateur="${numeroInitiateur}"

String nomInitiateur="${nomInitiateur}"

String prenomInitiateur="${prenomInitiateur}"

'En tant que client TELMA, je vais dans le menu pour Mon identité en composant #111 > 8 > 1 et valide'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*1#', numeroInitiateur)

'Je saisis mon nom et valide'
CustomKeywords.'ussd.Send.response'(nomInitiateur)

'Je saisis mon prénom et valide'
CustomKeywords.'ussd.Send.response'(prenomInitiateur)

'Je saisis un CIN avec plus de 30 caractères'
String actualMenu=CustomKeywords.'ussd.Send.response'('1234567890123456789012345678901')

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Veuillez verifier le numero de la piece d identite \\(1 a 30 caracteres\\)', 
	'Hamarino ny laharan ny karapanondronao  \\(Tarehimarika 1 hatramin ny 30\\)')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un cin au format incorrect 2ème tentative'
String actualMenu=CustomKeywords.'ussd.Send.response'('1234567890123456789012345678901')

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Veuillez verifier le numero de la piece d identite \\(1 a 30 caracteres\\)',
	'Hamarino ny laharan ny karapanondronao  \\(Tarehimarika 1 hatramin ny 30\\)')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un cin au format incorrect 3ème tentative'
String actualMenu=CustomKeywords.'ussd.Send.response'('1234567890123456789012345678901')

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Veuillez verifier le numero de la piece d identite \\(1 a 30 caracteres\\)',
	'Hamarino ny laharan ny karapanondronao  \\(Tarehimarika 1 hatramin ny 30\\)')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un cin au format incorrect 4ème tentative'
String actualMenu=CustomKeywords.'ussd.Send.response'('1234567890123456789012345678901')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Le nombre d\'essai maximum est atteint\\.','Mihaotra ny fanandramana azo ekena\\.')

WS.verifyMatch(actualMenu, menu, true)
