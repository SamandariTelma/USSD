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

String numeroInitiateur = "$numeroInitiateur"

String montantTelmaNet = "$montantTelmaNet"
/*
'Acheter TELMA net ONE NIGHT pour la 2ème fois'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/05-TELMA NET/02-Achat offre TELMA NET/01-TELMA NET Journalier/01-Achat offre pour soi - TELMA net ONE NIGHT'), 
    [('montantTelmaNet') : montantTelmaNet, ('numeroInitiateur') : numeroInitiateur], FailureHandling.CONTINUE_ON_FAILURE)

'Acheter TELMA net ONE NIGHT pour la 3ème fois'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/05-TELMA NET/02-Achat offre TELMA NET/01-TELMA NET Journalier/01-Achat offre pour soi - TELMA net ONE NIGHT'), 
    [('montantTelmaNet') : montantTelmaNet, ('numeroInitiateur') : numeroInitiateur], FailureHandling.CONTINUE_ON_FAILURE)

'Acheter TELMA net ONE NIGHT pour la 4ème fois'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/05-TELMA NET/02-Achat offre TELMA NET/01-TELMA NET Journalier/01-Achat offre pour soi - TELMA net ONE NIGHT'), 
    [('montantTelmaNet') : montantTelmaNet, ('numeroInitiateur') : numeroInitiateur], FailureHandling.CONTINUE_ON_FAILURE)

'Acheter TELMA net ONE NIGHT pour la 5ème fois'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/05-TELMA NET/02-Achat offre TELMA NET/01-TELMA NET Journalier/01-Achat offre pour soi - TELMA net ONE NIGHT'),
	[('montantTelmaNet') : montantTelmaNet, ('numeroInitiateur') : numeroInitiateur], FailureHandling.CONTINUE_ON_FAILURE)
*/
'Achat ONE NIGHT 6ème Tentative'
'Je vais dans le menu Changer de tarif en shortcodant #130*4*6# (Achat TELMA ONE NIGHT 5ème tentative)'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode + '#', numeroInitiateur)

'Je saisis 4 (TELMA Net (INTERNET)) et valide'
CustomKeywords.'ussd.Send.response'('4')

'Je saisi 1 (TELMA NET Journalier)'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis 1(NET ONE NIGHT)'
String actualMenu = CustomKeywords.'ussd.Send.response'('1')

'Je vérifie la conformité du message'
String menu = CustomKeywords.'ussd.Expected.menu'('Desole, vous avez utilise toutes vos demandes pour aujourd\'hui\\. Vous pourrez envoyer 5 demande\\(s\\) demain\\.', 
    'Tapitra ny fahafahanao mampiasa io tolotra io androany\\. Rahampitso indray ianao afaka mividy  5\\.')

WS.verifyMatch(actualMenu, menu, true)

