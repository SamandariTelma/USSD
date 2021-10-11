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

String numeroInitiateur = "${numeroInitiateur}"

String nomInitiateur= "${nomInitiateur}"

'En tant que client TELMA, je vais dans le menu pour Mon identité en composant #111 > 8 > 1 et valide'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*1#', numeroInitiateur)

'Je saisis mon nom et valide'
String actualMenu=CustomKeywords.'ussd.Send.response'(nomInitiateur)

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Merci de renseigner votre Prenom \\(saisir 0 si vide\\) :','Ampidiro ny Fanampin anaranao, \\(tsindrio ny 0 raha toa ka tsy misy\\) :')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un prénom avec plus de 30 caractères et valide'
actualMenu=CustomKeywords.'ussd.Send.response'('RAVELOMANANTSOASamandariSandySamandariSandy')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Veuillez verifier le prenom \\(1 a 30 caracteres ou 0 si vide\\)', 'Hamarino ny fanampin\'anarananao \\(tarehintsoratra 1 hatramin ny 30 na 0 raha tsy misy\\)')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis à nouveau un prénom non conforme'
actualMenu=CustomKeywords.'ussd.Send.response'('RAVELOMANANTSOASamandariSandySamandariSandy')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Veuillez verifier le prenom \\(1 a 30 caracteres ou 0 si vide\\)', 'Hamarino ny fanampin\'anarananao \\(tarehintsoratra 1 hatramin ny 30 na 0 raha tsy misy\\)')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un prénom au format incorrect 3ème tentative'
actualMenu=CustomKeywords.'ussd.Send.response'('RAVELOMANANTSOASamandariSandySamandariSandy')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Veuillez verifier le prenom \\(1 a 30 caracteres ou 0 si vide\\)', 'Hamarino ny fanampin\'anarananao \\(tarehintsoratra 1 hatramin ny 30 na 0 raha tsy misy\\)')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un prénom au format incorrect 4ème tentative'
actualMenu=CustomKeywords.'ussd.Send.response'('RAVELOMANANTSOASamandariSandySamandariSandy')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Le nombre d\'essai maximum est atteint\\.','Mihoatra ny fanandramana azo ekena\\.')

WS.verifyMatch(actualMenu, menu, true)
