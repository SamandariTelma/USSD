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

WebUI.callTestCase(findTestCase('SOS Credit/03-Demander SOS Crédit à un ami/SOS crédit à un ami avec succès'), [('montant'):'300'], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('SOS Credit/03-Demander SOS Crédit à un ami/SOS crédit à un ami avec succès'), [('montant'):'400'], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('SOS Credit/03-Demander SOS Crédit à un ami/SOS crédit à un ami avec succès'), [('montant'):'500'], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('SOS Credit/03-Demander SOS Crédit à un ami/SOS crédit à un ami avec succès'), [('montant'):'600'], FailureHandling.CONTINUE_ON_FAILURE)

'J\'effectue un SOS crédit pour la 6 ème fois'

String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*1#', GlobalVariable.msisdnInitiateur)

String menu=CustomKeywords.'ussd.Expected.menu'('^Entrer numero de tel\\. Destinataire :$', '^nomerao tel\\. andefasana :$')

'Vérifier la conformité du message'
WS.verifyMatch(actualMenu, menu, true)

'J\'entre le numéro de l\'ami auquel je demande un SOS crédit et je valide'

actualMenu=CustomKeywords.'ussd.Send.response'(GlobalVariable.msisdnRecepteur)

menu=CustomKeywords.'ussd.Expected.menu'('^Montant demande:$')

WS.verifyMatch(actualMenu, menu, true)

'Je saisi un montant valide ex: 300 Ar'

actualMenu=CustomKeywords.'ussd.Send.response'('300')

'Vérifier la conformité du message'

menu=CustomKeywords.'ussd.Expected.menu'('^Desole, vous avez utilise toutes vos demandes pour aujourd\'hui\\. Vous pourrez envoyer 5 demandes demain\\.$', '^Tapitra ny fahafahanao mampiasa io servisy io androany\\.Rahampitso  indray  mandefa hafatra 5\\.$')

'Vérifier la conformité du message'
WS.verifyMatch(actualMenu, menu, true)