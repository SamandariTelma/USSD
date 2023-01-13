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
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode + '*1#', numeroInitiateur)

numeroInitiateur=CustomKeywords.'ussd.Util.to034'(numeroInitiateur)

String actualMenu=CustomKeywords.'ussd.Send.response'(numeroInitiateur)

String menu=CustomKeywords.'ussd.Expected.menu'('^Vous ne pouvez pas envoyer une demande a vous-meme\\.$', '^Tsy afaka mandefa fangatahana any amin\'ny tenanao ianao\\.$')

'Vérifier la conformité du message'
WS.verifyMatch(actualMenu, menu, true)

