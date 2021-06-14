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

String numeroRecepteur="${numeroRecepteur}"

'En tant que client TELMA, me rends dans le menu SOS Crédit à un ami en composant le short code #111# >3>1'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*1#', numeroInitiateur)

String menu=CustomKeywords.'ussd.Expected.menu'('^Entrer numero de tel\\. Destinataire :$', '^nomerao tel\\. andefasana :$')

'Vérifier la conformité du message'
WS.verifyMatch(actualMenu, menu, true)

'J\'entre le numéro de l\'ami auquel je demande un SOS crédit et je valide'

actualMenu=CustomKeywords.'ussd.Send.response'(numeroRecepteur)

menu=CustomKeywords.'ussd.Expected.menu'('^Montant demande:$')

WS.verifyMatch(actualMenu, menu, true)

'Je saisi un montant valide ex: 300 Ar'

actualMenu=CustomKeywords.'ussd.Send.response'("${montant}")

'Vérifier la conformité du message'

String msisdnRecepteur=GlobalVariable.msisdnRecepteur

msisdnRecepteur=msisdnRecepteur.substring(1)

menu=CustomKeywords.'ussd.Expected.menu'('^Votre demande de recharge de (\\d+(,\\d{1,3})?)  Ar a ete envoyee a 261'+msisdnRecepteur+'\\.$',
	'^Voarain\'i 261'+msisdnRecepteur+'  ny fangatahana fahana (\\d+(,\\d{1,3})?) Ar nalefanao\\.$')

WS.verifyMatch(actualMenu, menu, true)