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

String numeroNonMVola="${numeroNonMVola}"

'En tant que client TELMA, je vais dans le menu pour SOS Crédit en composant le #111# > 3, puis je sasis 4 et je valide'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'*4#', numeroInitiateur)

'Je sasis 1 et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Je saisis le numéro d\'un ami non souscrit MVola et je valide'

actualMenu=CustomKeywords.'ussd.Send.response'(numeroNonMVola)
numeroNonMVola=CustomKeywords.'ussd.Util.to034'(numeroNonMVola)
String menu=CustomKeywords.'ussd.Expected.menu'('^Le numéro saisi doit disposer d\'un compte MVola certifié pour payer votre dette\\.$', '^Ny nomerao ampidirina dia tsy maintsy manana kaonty Mvola certifié ahafahany mamerina ny trosanao\\.$')

'Vérifier la conformité du message'
WS.verifyMatch(actualMenu, menu, true)