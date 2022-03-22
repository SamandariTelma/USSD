import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

String numeroInitiateur = "$numeroInitiateur"

String numeroRecepteur = "$numeroRecepteur"

String montant = "$montant"

String offre = "$offre"

String tarifCode = "$tarifCode"

numeroRecepteur = CustomKeywords.'ussd.Util.to034'(numeroRecepteur)

'En tant que GP, j\'effectue un achat offre MORA via Mvola:  *611*tarifCodeMora*1#'
String actualMenu = CustomKeywords.'ussd.Send.code'(((GlobalVariable.shortCodeDirectAchat + '*') + tarifCode) + '*1#', numeroInitiateur)

'Vérifier la conformité du message'
String menu = WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/00 - Prompt et Message achat offre/Message de confirmation achat via MVola'), 
    [('montant') : montant, ('offre') : offre], FailureHandling.CONTINUE_ON_FAILURE)

WS.verifyMatch(actualMenu, menu, true)

