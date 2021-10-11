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
String actualMenu=CustomKeywords.'ussd.Send.response'(prenomInitiateur)

'Je vérifie la conformité du prompt'
String menu = CustomKeywords.'ussd.Expected.menu'('Merci de renseigner le numero de votre piece d\'identite :', 'Ampidiro ny laharan ny karapanondronao :')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un CIN avec plus de 30 caractères'
actualMenu=CustomKeywords.'ussd.Send.response'('1234567890123456789012345678901')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Verifier le  numero d\'identification svp ', 
	'Hamarino ny laharan\'ny fanamarinana azafady ')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un cin au format incorrect 2ème tentative'
actualMenu=CustomKeywords.'ussd.Send.response'('1234567890123456789012345678901')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Verifier le  numero d\'identification svp ',
	'Hamarino ny laharan\'ny fanamarinana azafady ')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un cin au format incorrect 3ème tentative'
actualMenu=CustomKeywords.'ussd.Send.response'('1234567890123456789012345678901')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Verifier le  numero d\'identification svp ',
	'Hamarino ny laharan\'ny fanamarinana azafady ')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un cin au format incorrect 4ème tentative'
actualMenu=CustomKeywords.'ussd.Send.response'('1234567890123456789012345678901')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Le nombre d\'essai maximum est atteint\\.','Mihoatra ny fanandramana azo ekena\\.')

WS.verifyMatch(actualMenu, menu, true)
