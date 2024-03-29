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

String monMsisdn=CustomKeywords.'ussd.Util.to034'(GlobalVariable.msisdnInitiateur)
'En tant que client TELMA, je vais dans mon USSD en composant le short code *130*2*1#'

CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*1#', GlobalVariable.msisdnInitiateur)

'Je saisis mon numéro et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('0346848017')

String menu=CustomKeywords.'ussd.Expected.menu'('Vous ne pouvez pas envoyer une demande a vous-meme\\.', 'Tsy afaka mandefa fangatahana any amin\'ny tenanao ianao\\.')

'Vérifier la conformité du prompt'

WS.verifyMatch(actualMenu, menu, true)