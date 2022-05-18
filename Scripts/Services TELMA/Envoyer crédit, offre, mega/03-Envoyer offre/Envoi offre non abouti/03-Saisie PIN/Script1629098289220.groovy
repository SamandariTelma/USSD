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

'Je shortcode #130*4*4#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'#', numeroInitiateur)

'Je saisis 2 (Envoyer du offre) et valide'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis le numéro du beneficiarie'
numeroRecepteur=CustomKeywords.'ussd.Util.to034'(numeroRecepteur)
CustomKeywords.'ussd.Send.response'(numeroRecepteur)

'Je selectionne 1 MORA et je valide '
CustomKeywords.'ussd.Send.response'('1')

'Je choisi un offre'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis un PIN au format incorrect (alhanumerique) et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('000@')

'Vérifier la conformité du prompt'
String menu = CustomKeywords.'ussd.Expected.menu'(('Pour accepter d\'acheter l\'offre MORA 500 au tarrif de 500 Ar pour le numero ' + numeroRecepteur) + ', Entrer le code secret:', 
('Raha manaiky ny handefa ny tolotra MORA 500 amin\'ny sarany 500 Ar ho an\'ny laharana ' + numeroRecepteur) + ', Ampidiro ny kaody miafina:')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un PIN au format incorrect (moins de 4 chiffres) et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('000')

'Vérifier la conformité du prompt'
WS.verifyMatch(actualMenu, menu, true)

'Je saisis un mauvais pin (au bon format)'
actualMenu=CustomKeywords.'ussd.Send.response'('8624')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Votre demande n a pas abouti\\. Vous avez recu un SMS avec les details de votre transaction\\. Si besoin, contactez le Service Clientele au 807\\.',
	'Tsy tafita ny fangatahanao\\. Naharay SMS manazava ny antony ianao\\. Raha ilaina, antsoy ny Service Clientele amin ny 807\\.')

WS.verifyMatch(actualMenu, menu, true)
