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

'En tant que client TELMA, je vais dans le menu pour Mon identité en composant #111 > 8 > 1 et valide'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*1#', numeroInitiateur)

'Vérifier la conformité du prompt'
String menu = CustomKeywords.'ussd.Expected.menu'('Afin de vous identifier, merci de renseigner votre NOM :', 'Mba ahafahana manamarina ny laharanao, ampidiro ny ANARANAO :')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un nom avec plus de 30 caractères et valide'
actualMenu=CustomKeywords.'ussd.Send.response'('RAVELOMANANTSOASamandariSandySamandariSandy')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Veuillez verifier le nom \\(1 a 30 caracteres\\)', 'Hamarino ny anarananao \\(tarehintsoratra 1 hatramin ny 30\\)\\.')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un nom comportant un espace'
actualMenu=CustomKeywords.'ussd.Send.response'('RAVELOMANANTSOA Samandari')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Veuillez verifier le nom \\(1 a 30 caracteres\\)','Hamarino ny anarananao \\(tarehintsoratra 1 hatramin ny 30\\)\\.')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un nom au format incorrect 3ème tentative'
actualMenu=CustomKeywords.'ussd.Send.response'('RAVELOMANANTSOA Samandari')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Veuillez verifier le nom \\(1 a 30 caracteres\\)','Hamarino ny anarananao \\(tarehintsoratra 1 hatramin ny 30\\)\\.')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un nom au format incorrect 4ème tentative'
actualMenu=CustomKeywords.'ussd.Send.response'('RAVELOMANANTSOA Samandari')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Le nombre d\'essai maximum est atteint\\.','Mihoatra ny fanandramana azo ekena\\.')

WS.verifyMatch(actualMenu, menu, true)

