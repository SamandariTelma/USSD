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
String numeroRecepteur="${numeroRecepteur}"
String pinEnvoyeur="${pinEnvoyeur}"

'Je shortcode #130*4*4#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode + '#', numeroInitiateur)

'Je saisis 3 (Partager du Mega) et je valide '
CustomKeywords.'ussd.Send.response'('3')

'Je saisi 1 (NET ONE MONTH)'
CustomKeywords.'ussd.Send.response'('1')

'Je sélectionne un numero parmi la liste et je valide'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis le numero MSISDN du bénéficiaire et je valide'
numeroRecepteur=CustomKeywords.'ussd.Util.to034'(numeroRecepteur)

CustomKeywords.'ussd.Send.response'(numeroRecepteur)

'Je saisis un PIN Mvola plus de 4 chiffres et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('00000')

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Le code secret doit comporter 4 chiffres\\.', 'Hamarino ny kaody miafina \\(tarehimarika 4\\)\\.')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un PIN Mvola moins de 4 chiffres et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('000')

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('Le code secret doit comporter 4 chiffres\\.', 'Hamarino ny kaody miafina \\(tarehimarika 4\\)\\.')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un mauvais PIN et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('9235')

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('Votre demande n a pas abouti\\. Vous avez recu un SMS avec les details de votre transaction\\. Si besoin, contactez le Service Clientele au 807\\.',
	'Tsy tafita ny fangatahanao\\. Naharay SMS manazava ny antony ianao\\. Raha ilaina, antsoy ny Service Clientele amin ny 807\\.')

WS.verifyMatch(actualMenu, menu, true)

