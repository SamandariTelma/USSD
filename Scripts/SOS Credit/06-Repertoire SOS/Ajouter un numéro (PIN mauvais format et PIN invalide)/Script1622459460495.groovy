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

String numeroAAjouter=GlobalVariable.numeroAAjouter

'En tant que client TELMA, je vais dans le menu repertoire SOS en composant le #111# > 3 > 4 >3'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodde+'*4*3#', numeroInitiateur)

'Je saisis 1 et je valide'
CustomKeywords.'ussd.Send.response'('1')

'Je rentre le numéro qui existe déjà dans le repertoire et je valide'
CustomKeywords.'ussd.Send.response'(numeroAAjouter)

'Je saisis un code secret au mauvais format  c-a-d avec des alphabet'
String actualMenu= CustomKeywords.'ussd.Send.response'('abcd')

String menu=CustomKeywords.'ussd.Expected.menu'('^Pour ajouter le numéro '+numeroAAjouter+' \\(.{1,50}\\) parmi les personnes autorisées à rembourser vos SOS, entrer code secret MVola :$',
	'^Raha hampiditra ny laharana '+numeroAAjouter+' \\(.{1,50}\\) ho isan ny olona afaka mamerina ny SOS, tsindrio ny code secret Mvola :$')

'Vérifier la conformité du prompt'
WS.verifyMatch(actualMenu, menu, true)
'Je saisis un code secret invalide ex 9632 et je valide'
actualMenu= CustomKeywords.'ussd.Send.response'('9632')

menu=CustomKeywords.'ussd.Expected.menu'('^Votre demande n a pas abouti\\. Vous avez recu un SMS avec les details de votre transaction\\. Si besoin, contactez le Service Clientele au 807\\.$', 
	'^Tsy tafita ny fangatahanao\\. Naharay SMS manazava ny antony ianao\\. Raha ilaina, antsoy ny Service Clientele amin ny 807\\.$')

'Vérifier la conformité du message'
WS.verifyMatch(actualMenu, menu, true)

