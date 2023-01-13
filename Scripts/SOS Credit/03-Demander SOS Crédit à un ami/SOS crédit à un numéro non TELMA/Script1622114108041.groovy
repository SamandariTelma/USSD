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

'En tant que client TELMA, me rends dans le menu SOS Crédit à un ami en composant le short code #111# >3>1'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*1#', GlobalVariable.msisdnGrossiste)

String menu=CustomKeywords.'ussd.Expected.menu'('^Entrer numero de tel\\. Destinataire :$', '^nomerao tel\\. andefasana :$')

'Vérifier la conformité du message'
WS.verifyMatch(actualMenu, menu, true)

'J\'entre un numéro non Telma comme 0325785400 et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('0325785400')

menu=CustomKeywords.'ussd.Expected.menu'('^Verifiez le numero de telephone SVP\\.$', '^Hamarino ny nomerao azafady\\.$')

'Vérifier la conformité du message'
WS.verifyMatch(actualMenu, menu, true)

'J\'entre 2ème fois un numéro non Telma comme 0325785400 et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('0325785400')

menu=CustomKeywords.'ussd.Expected.menu'('^Verifiez le numero de telephone SVP\\.$', '^Hamarino ny nomerao azafady\\.$')

'Vérifier la conformité du message'
WS.verifyMatch(actualMenu, menu, true)

'J\'entre pour la 3ème fois un numéro non Telma comme 0325785400 et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('0325785400')

menu=CustomKeywords.'ussd.Expected.menu'('^Verifiez le numero de telephone SVP\\.$', '^Hamarino ny nomerao azafady\\.$')

'Vérifier la conformité du message'
WS.verifyMatch(actualMenu, menu, true)

'J\'entre pour la 4ème fois un numéro non Telma comme 0325785400 et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('0325785400')

menu=CustomKeywords.'ussd.Expected.menu'('^Le nombre d\'essai maximum est atteint\\.$', '^Diso io laharana io, avereno ny fangatahanao miaraka amin\'ny laharana marina\\.$')

'Vérifier la conformité du message'
WS.verifyMatch(actualMenu, menu, true)