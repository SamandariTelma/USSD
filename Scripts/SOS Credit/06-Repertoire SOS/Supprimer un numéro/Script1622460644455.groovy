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
String numeroASupprimer="${numeroASupprimer}"
String pinMsisdnInitiateur="${pinMsisdnInitiateur}"

'En tant que client TELMA, je vais dans le menu repertoire SOS en composant le #111# > 3 > 4 >3'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'*4*3#', numeroInitiateur)

'Je saisis 2 et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('2')

String menu=CustomKeywords.'ussd.Expected.menu'('^.*Selectionner le contact SOS à supprimer:.*$',
	'^.*Safidio ny laharana SOS hofafana:.*$')

'Vérifier la conformité du repertoire'
WS.verifyMatch(actualMenu, menu, true)

//Extraction du rang du msisdn à supprimer
numeroASupprimer=CustomKeywords.'ussd.Util.to034'(numeroASupprimer)

String menuNumASupprimer=actualMenu.substring(actualMenu.lastIndexOf(numeroASupprimer)-2,actualMenu.lastIndexOf(numeroASupprimer)-1)

println "Numero à supprimer: "+menuNumASupprimer

'Je saisi un numéro du msisdn à supprimer'

actualMenu=CustomKeywords.'ussd.Send.response'(menuNumASupprimer)

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Pour supprimer le numéro '+numeroASupprimer+' \\(.{1,30}\\) parmi les personnes autorisées à rembourser vos SOS, entrer code secret MVola :', 
	'Raha hamafa ny laharana '+numeroASupprimer+' \\(.{1,30}\\) @ lisitr ireo afaka mamerina ny SOS nao, tsindrio ny code secret Mvola :')

WS.verifyMatch(actualMenu, menu, true)

'Je saisi mon code MVola'
actualMenu = CustomKeywords.'ussd.Send.response'(pinMsisdnInitiateur)

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Le numéro '+numeroASupprimer+' \\(.{1,30}\\) a été supprimé de la liste des personnes autorisées à rembourser votre SOS\\.',
	'Ny laharana  '+numeroASupprimer+' \\(.{1,30}\\) dia voafafa ao anatin ny lisitr ireo olona afaka mamerina ny SOS nataonao\\.')

WS.verifyMatch(actualMenu, menu, true)

'Consulte le repertoire'

actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'*4*3*3#', numeroInitiateur)

//REGEX qui exclu le numéro supprimé
String numeroSupprime='^((?!'+numeroASupprimer+').)*$'

'Vérifier que le numéro ne figure plus dans le répertoire'
WS.verifyMatch(actualMenu, numeroSupprime, true)
