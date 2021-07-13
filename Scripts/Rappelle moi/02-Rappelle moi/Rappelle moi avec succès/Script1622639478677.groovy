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

String msisdnInitiateur="${msisdnInitiateur}"

String msisdnRecepteur="${msisdnRecepteur}"

msisdnRecepteur=CustomKeywords.'ussd.Util.to034'(msisdnRecepteur)
println msisdnRecepteur

'En tant que client TELMA, je vais dans mon USSD Rappelle moi en composant le short code *130*2#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', msisdnInitiateur)

'Je saisis 1 (Envoyer un rappelle moi) et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('1')

String menu=CustomKeywords.'ussd.Expected.menu'('Entrer numero de tel\\. Destinataire :','nomerao tel\\. andefasana :')

'Vérifier la conformité du prompt'
WS.verifyMatch(actualMenu, menu, true)

'Je saisis un numéro valide et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'(msisdnRecepteur)

menu=CustomKeywords.'ussd.Expected.menu'('Votre demande de Rappelle-moi a ete envoyee','Lasa soa aman-tsara ny SMS nangatahinao\\.')

WS.verifyMatch(actualMenu, menu, true)