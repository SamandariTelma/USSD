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
String montantAEnvoyer="${montantAEnvoyer}"

'Je shortcode #130*4*4#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 1 (Envoyer du credit) et valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Montant a transferer :', 'Sandan\'ny Fahana hafindra:')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un montant correct et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'(montantAEnvoyer)

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Entrer numero de tel\\. Destinataire :', 'nomerao tel\\. andefasana :')

WS.verifyMatch(actualMenu, menu, true)

numeroRecepteur=CustomKeywords.'ussd.Util.to034'(numeroRecepteur)
println numeroRecepteur

'Je saisis correctement un MSISDN du destinataire et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'(numeroRecepteur)

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Entrer votre code secret MVola:', 'Kaody miafina MVola: ')

WS.verifyMatch(actualMenu, menu, true)



