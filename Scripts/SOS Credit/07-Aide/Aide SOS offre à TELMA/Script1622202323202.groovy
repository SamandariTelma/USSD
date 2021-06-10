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

'En tant que client TELMA, je vais dans le menu pour SOS Crédit en composant le #111# > 3, puis je sasis 5 et je valide'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*5#', GlobalVariable.msisdnInitiateur)

'Je saisis 3 et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('3')

String menu=CustomKeywords.'ussd.Expected.menu'('^Bonjour, pour beneficier de cette offre, vous devez etre client TELMA prepaye depuis au moins 3 mois et utiliser regulierement les services\\. Tapez:\n1 Menu precedent\n2 Quitter$',
	 '^Mba ahafahanao mampiasa io tolotra io dia tokony ho efa mpanjifa Telma fara fahakeliny 3 volana mialoha ianao ary koa mpanjifa tsy tapaka ny tolotra TELMA\\. Tsindrio:\n0 Pejy manaraka$')

'Vérifier la conformité du sous menu'
WS.verifyMatch(actualMenu, menu, true)

'Pour la vérsion Malagasy uniquement, je tape 0 pou voir la page suivante'
if(GlobalVariable.langue.equals('mg'))
{
	actualMenu=CustomKeywords.'ussd.Send.response'('0')
	
	menu=CustomKeywords.'ussd.Expected.menu'('', '^1 Tolotra teo aloha\n2 Hiala\n00 Pejy aloha$')
	
	'Vérifier l\'affichage de la suite du menu'
	WS.verifyMatch(actualMenu, menu, true)
}
'Je saisis 1 et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

menu=CustomKeywords.'ussd.Expected.menu'('^Aide\n1 Demander SOS credit a un ami\n2 Demander SOS credit a TELMA\n3 Demander SOS offre a TELMA$',
	'^Fanampiana\n1 SOS fahana any amin\'ny namana\n2 SOS fahana any amin\'ny TELMA\n3 Demander SOS offre a TELMA$')

'Vérifier que Je reviens sur l\' affichage des sous menus aide'
WS.verifyMatch(actualMenu, menu, true)

'Je choisi de nouveau Demander SOS offre a TELMA et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('3')

menu=CustomKeywords.'ussd.Expected.menu'('^Bonjour, pour beneficier de cette offre, vous devez etre client TELMA prepaye depuis au moins 3 mois et utiliser regulierement les services\\. Tapez:\n1 Menu precedent\n2 Quitter$',
	 '^Mba ahafahanao mampiasa io tolotra io dia tokony ho efa mpanjifa Telma fara fahakeliny 3 volana mialoha ianao ary koa mpanjifa tsy tapaka ny tolotra TELMA\\. Tsindrio:\n0 Pejy manaraka$')

'Vérifier la conformité du sous menu'
WS.verifyMatch(actualMenu, menu, true)

'Je saisis 2 et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('2')

menu=CustomKeywords.'ussd.Expected.menu'('^Merci d\'avoir utilise le service Telma\\.$','^Misaotra anao nampiasa ny tolotra Telma\\.$')

'Vérifier la conformité du message'
WS.verifyMatch(actualMenu, menu, true)