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

String numeroEnvoyeur="${numeroEnvoyeur}"
String numeroRecepteur="${numeroRecepteur}"
String pinEnvoyeur="${pinEnvoyeur}"
String montantStock="${montantStock}"

'En tant que MSISDN envoyeur, je compose le *130*2#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroEnvoyeur)

'Je clique sur 3 Envoyer du stock et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('3')

'Je saisis le rang du stock a envoyer'
String rangMenu
if(GlobalVariable.langue=='fr')
	rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('Envoyer '+montantStock+' Ar', actualMenu)
else if (GlobalVariable.langue=='mg')
	rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('Andefa '+montantStock+' Ar', actualMenu)

actualMenu=CustomKeywords.'ussd.Send.response'(rangMenu)

'Je saisis correctement le numero du Destinataire et je valide'
numeroRecepteur=CustomKeywords.'ussd.Util.to034'(numeroRecepteur)
CustomKeywords.'ussd.Send.response'(numeroRecepteur)

'Je saisis 1 Oui pour saisir le numéro de confirmation'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis correctement mon PIN (0000) et je valide'
CustomKeywords.'ussd.Send.response'(pinEnvoyeur)

'Je saisis 1 (Oui) pour confirmation et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('Votre demande n\'a pas abouti\\. Vous n\'avez pas acces a cette fonction\\. Si besoin, contactez le Service Clientele au 801\\. Ref: \\d{1,10}',
	'Tsy tontosa ny fangatahanao\\. Tsy afaka manatontosa ity fifanakalozana ity ianao\\. Raha mila fanazavana fanampiny, antsoy ny 801\\. Ref: \\d{1,10}')

WS.verifyMatch(actualMenu, menu, true)