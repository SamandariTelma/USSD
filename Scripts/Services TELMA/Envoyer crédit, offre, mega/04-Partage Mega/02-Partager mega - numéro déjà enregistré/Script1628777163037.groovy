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
String dateExpiration="${dateExpiration}"
String nomRecepteur="${nomRecepteur}"
'Je shortcode #130*4*4#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode + '#', numeroInitiateur)

'Je saisis 3 (Partager du Mega) et je valide '
CustomKeywords.'ussd.Send.response'('3')

'Je saisis 1 (NET ONE MONTH 1,5Go)'
CustomKeywords.'ussd.Send.response'('1')

'Je sélectionne un numero parmi la liste et je valide'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis 9 pour voir le repertoire je valide '
CustomKeywords.'ussd.Send.response'('9')

'Je saisis 1 pour choisir le numéro dans le repertoire'
String actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Pour accepter le partage de 100 Mo \\(valable jusqu au '+dateExpiration+'\\) vers '+nomRecepteur+' \\('+numeroRecepteur+'\\)\\. Frais: 10 Mo\\. Entrer code secret MVola :', 
	'Hanantontosana ny fandefasana ny 100 Mo \\(azo ampiasaina hatramin ny '+dateExpiration+'\\) any @ '+nomRecepteur+' \\('+numeroRecepteur+'\\)\\. Frais: 10 Mo\\. Ampidiro ny kaody miafina MVola anao :')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis correctement mon code PIN Mvola et je valide '
actualMenu=CustomKeywords.'ussd.Send.response'(pinEnvoyeur)

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('Votre transaction a reussi, pour enregistrer '+numeroRecepteur+' dans votre repertoire MVola, Entrer le nom correspondant ou ignorer :', 
	'Tontosa ny fandefasanao mega, raha hampiditra ny '+numeroRecepteur+' ao @ repertoire MVola anao ianao dia ampidiro ny anarany :')

'Je saisis un nom pour enregistrer et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('Test1')