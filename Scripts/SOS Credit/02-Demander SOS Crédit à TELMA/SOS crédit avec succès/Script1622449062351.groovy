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

String menuMontant="${menuMontant}"
String montant="${montant}"
GlobalVariable.montantARembourser=montant
String numeroInitiateur="${numeroInitiateur}"
'En tant que client TELMA je me rends sur le menu SOS Credit à TELMA en composant le short code #111# > 3 > 2'
String actualMenu= CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*2#', numeroInitiateur)

String menu=CustomKeywords.'ussd.Expected.menu'('^Selectionner le montant du credit:\n1 200\n2 500\n3 1000\n4 2000\n5 5000\n6 10000$')

'Vérifier la conformité du menu'
WS.verifyMatch(actualMenu, menu, true)

'Choisi un montant'
actualMenu=CustomKeywords.'ussd.Send.response'(menuMontant)

menu=CustomKeywords.'ussd.Expected.menu'('^Pour confirmer votre demande de SOS credit a TELMA '+montant+' Ar tapez 1$', 
	'^Raha hanamafy ny fangatahana SOS fahana any amin\'ny TELMA '+montant+' Ar tsindrio 1$')

'Vérifier la conformité du prompt'
WS.verifyMatch(actualMenu, menu, true)

'Je saisi 1 et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

menu=CustomKeywords.'ussd.Expected.menu'('(^Votre demande de SOS crédit est en cours\\. Vous allez recevoir un SMS\\. Sinon veuillez appeler le service client au 800$)|(^Merci d\'avoir utilise le service Telma\\.$)', 
	'^Misaotra anao nampiasa ny tolotra Telma\\.$')

'Vérifier la conformité du message'
WS.verifyMatch(actualMenu, menu, true)
