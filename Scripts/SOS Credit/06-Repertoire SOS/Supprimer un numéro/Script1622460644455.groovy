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
'En tant que client TELMA, je vais dans le menu repertoire SOS en composant le #111# > 3 > 4 >3'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*4*3#', numeroInitiateur)

'Je saisis 2 et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('2')

String menu=CustomKeywords.'ussd.Expected.menu'('^Selectionner le contact SOS à supprimer: (\n[1-5] 034\\d{1,7}){1,5}$',
	'^Safidio ny laharana SOS hofafana: (\n[1-5] 034\\d{1,7}){1,5}$')

'Vérifier la conformité du repertoire'
WS.verifyMatch(actualMenu, menu, true)

//Extraction du rang du msisdn à supprimer
String menuNumASupprimer=actualMenu.substring(actualMenu.lastIndexOf(numeroASupprimer)-2,actualMenu.lastIndexOf(numeroASupprimer)-1)

println "Numero à supprimer: "+menuNumASupprimer

'Je saisi un numéro du msisdn à supprimer'

actualMenu=CustomKeywords.'ussd.Send.response'(menuNumASupprimer)

menu=CustomKeywords.'ussd.Expected.menu'('INDEFINI', 'INDEFINI')

WS.verifyMatch(actualMenu, menu, true)

'Consulte le repertoire'

actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*4*3*3#', numeroInitiateur)

//REGEX qui exclu le numéro supprimé
String numeroSupprime='^((?!'+numeroASupprimer+').)*$'

'Vérifier que le numéro ne figure plus dans le répertoire'
WS.verifyMatch(actualMenu, numeroSupprime, true)
