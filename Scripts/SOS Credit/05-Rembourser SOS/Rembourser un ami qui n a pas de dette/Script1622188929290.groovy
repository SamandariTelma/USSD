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

String numeroSansDette="${numeroSansDette}"

'En tant que client TELMA, je vais dans le menu pour SOS Crédit en composant le #111# > 3, puis je sasis 4 et je valide'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*4#', numeroInitiateur)

'Je sasis 2 et je valide'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis le numéro auquel je rembourse du SOS crédit via MVola et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'(numeroSansDette)

String menu=CustomKeywords.'ussd.Expected.menu'('^Le numéro '+numeroSansDette+' n\'a pas de dette a rembourser\\.$', '^Ny laharana '+numeroSansDette+' dia tsy manana trosa tokony averina\\.$')

'Vérifier la conformité du message'
WS.verifyMatch(actualMenu, menu, true)