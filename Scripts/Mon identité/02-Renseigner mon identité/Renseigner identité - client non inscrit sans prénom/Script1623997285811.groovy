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

String numeroInitiateur='261343063891'//"${numeroInitiateur}"

String nomInitiateur="${nomInitiateur}"

String cin="${cin}"

String numeroInitiateurFormate='0'+numeroInitiateur.substring(3)

'En tant que client TELMA, je vais dans le menu pour Mon identité en composant #111 > 8 et je valide'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodde+'#', numeroInitiateur)

'Je saisis 1 (Renseigner mon identite) et je valide'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis mon nom et je valide'
CustomKeywords.'ussd.Send.response'(nomInitiateur)

'Je saisis 0 et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('0')

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Merci de renseigner le numero de votre piece d\'identite :', 'Ampidiro ny laharan ny karapanondronao :')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis le numéro de mon pièce d\'identité et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'(cin)

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Pour confirmer l\'enregistrement du numero '+numeroInitiateurFormate+' au nom de '+nomInitiateur+'   '+cin+' merci de taper 1, sinon ignorez', 
	'Mba ahafahanao manamafy hanamarinanao ny fanamarinana fisoratan ny laharana '+numeroInitiateurFormate+' amin ny anaran ny i '+nomInitiateur+'   '+cin+' tsindrio ny 1, raha tsy izay, dingano')

WS.verifyMatch(actualMenu, menu, true)
/*
'Je saisis 1 et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('Votre identification s\'est deroulee avec succès\\. Afin de beneficier des services Mvola veuillez\\-vous rendre auprès d\'un revendeur Telma\\.', 
	'Voamarina soamantsara ny laharanao\\. Raha mila fanazavana fanampiny momba ny MVola dia manatona mpaninjara Telma\\.')

WS.verifyMatch(actualMenu, menu, true)
*/
println('fin')