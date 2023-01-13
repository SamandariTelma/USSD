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

String pinMsisdnInitiateur="${pinMsisdnInitiateur}"

String numeroAAjouter="${numeroAAjouter}"

'En tant que client TELMA, je vais dans le menu pour SOS Crédit en composant le #111# > 3, puis je sasis 4 et je valide'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*4', numeroInitiateur)

String actualMenu=CustomKeywords.'ussd.Send.response'('3')

String menu=CustomKeywords.'ussd.Expected.menu'('^Répertoire SOS Crédit\n1 Ajouter un numéro\n2 Supprimer un numéro\n3 Consulter mon répertoire$', 
	'^Répertoire SOS Crédit\n1 Hanampy nomerao\n2 Hamafa nomerao\n3 Hijery ny lisitry ny nomerao$')

'Vérifier la conformité du sous menu'
WS.verifyMatch(actualMenu, menu, true)

'Je saisis 1 et je valide'

actualMenu=CustomKeywords.'ussd.Send.response'('1')

menu=CustomKeywords.'ussd.Expected.menu'('^.*Entrer le numéro de la personne autorisée à rembourser mes SOS :.*$',
	'^Ampidiro ny laharan ny nomerao afaka mamerina ny SOS offre ko :$')

'Vérifier la conformité du prompt'
WS.verifyMatch(actualMenu, menu, true)

'Je rentre un numéro invalide'
actualMenu=CustomKeywords.'ussd.Send.response'('03400')

menu=CustomKeywords.'ussd.Expected.menu'('^.*Entrer le numéro de la personne autorisée à rembourser mes SOS :.*$',
	'^Ampidiro ny laharan ny nomerao afaka mamerina ny SOS offre ko :$')

'Vérifier la conformité du prompt'
WS.verifyMatch(actualMenu, menu, true)

numeroAAjouter=CustomKeywords.'ussd.Util.to034'(numeroAAjouter)

'Je rentre le numéro que je veux ajouter et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'(numeroAAjouter)

menu=CustomKeywords.'ussd.Expected.menu'('^Pour ajouter le numéro '+numeroAAjouter+' \\(.{1,50}\\) parmi les personnes autorisées à rembourser vos SOS, entrer code secret MVola :$',
	'^Raha hampiditra ny laharana '+numeroAAjouter+' \\(.{1,50}\\) ho isan ny olona afaka mamerina ny SOS, tsindrio ny code secret Mvola :$')

'Vérifier la conformité du prompt'
WS.verifyMatch(actualMenu, menu, true)

'Je sais mon code secret MVola et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'(pinMsisdnInitiateur)

menu=CustomKeywords.'ussd.Expected.menu'('^Le numéro '+numeroAAjouter+' \\(.{1,50}\\) a été ajouté à la liste des personnes autorisées à rembourser votre SOS\\.$',
	'^Ny laharana  '+numeroAAjouter+' \\(.{1,50}\\) dia tafiditra ao anatin ny listr ireo olona afaka mamerina ny SOS nataonao$')

'Vérifier la conformité du prompt'
WS.verifyMatch(actualMenu, menu, true)