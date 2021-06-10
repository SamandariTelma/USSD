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

String msisdnRecepteur=GlobalVariable.msisdnRecepteur
'En tant que client TELMA, je vais dans le menu pour SOS Crédit en composant le #111# > 3, puis je sasis 4 et je valide'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*4#', GlobalVariable.msisdnInitiateur)

String menu=CustomKeywords.'ussd.Expected.menu'('^SOS Crédit\n1 Demander le remboursement à un ami\n2 Rembourser le SOS Crédit d\'un ami avec MVola\n3 Répertoire SOS$',
	'^SOS Crédit\n1 Mangataka namana hamerina ny SOS credit\n2 Hamerina SOS credit nataon ny namana @ alalan ny Mvola\n3 Répertoire SOS$')

'Vérifier la conformité des sous menus'
WS.verifyMatch(actualMenu, menu, true)

'Je sasis 1 et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

menu=CustomKeywords.'ussd.Expected.menu'('^Entrer le numéro de la personne autorisée à rembourser mes SOS :$', '^Laharan ny olona afaka mamerina ny fangatahana SOS nataoko :$')

'Vérifier la conformité du prompt'
WS.verifyMatch(actualMenu, menu, true)

'Je saisis le numéro d\'un ami et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'(msisdnRecepteur)

menu=CustomKeywords.'ussd.Expected.menu'('^Un SMS sera envoyé au '+msisdnRecepteur+' \\(.{1,50}\\) pour lui demander de rembourser votre SOS en cours\\. Tapez 1 pour confirmer\\.$', 
	'^Nisy SMS fangatahana famerenana ny SOS nataonao lasa tany @ laharana '+msisdnRecepteur+' \\(.{1,50}\\)\\. Tsindrio ny 1 raha hanamarina:$')

'Vérifier la conformité du prompt'
WS.verifyMatch(actualMenu, menu, true)

'Je saisis 1 et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

menu=CustomKeywords.'ussd.Expected.menu'('^Votre demande a bien été envoyée\\..*$', '^.*Tontosa ny fandefasana ny fangatahanao\\.$')

'Vérifier la conformité du prompt'
WS.verifyMatch(actualMenu, menu, true)
