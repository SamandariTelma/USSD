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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String numeroInitiateur = "${numeroInitiateur}"

'Je shortcode #130*4*9#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Vérifier la conformité du prompt'
String menu= CustomKeywords.'ussd.Expected.menu'('Entrer le Numero à recuperer :')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un numero aux caractères: alphabetique'
actualMenu=CustomKeywords.'ussd.Send.response'('03435007a')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Veuillez verifier le numero Tel\\. à recuperer SVP\\(034xxxxxxx ou 038xxxxxxx\\):')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un numero autre que telma : '
actualMenu=CustomKeywords.'ussd.Send.response'('0325631456')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Veuillez verifier le numero Tel\\. à recuperer SVP\\(034xxxxxxx ou 038xxxxxxx\\):')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un troisième tentative de numero au mauvais format'
actualMenu=CustomKeywords.'ussd.Send.response'('03435000788')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Le nombre d\'essai maximum a été atteint\\.','Mihaotra ny fanandramana azo ekena\\.')

WS.verifyMatch(actualMenu, menu, true)

