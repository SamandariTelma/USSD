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

'En tant que client TELMA, je vais dans mon USSD en composant le short code *130*2#'

CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', GlobalVariable.msisdn1Initiateur)

'Je saisis 2 (Aide) et je valide'

String actualMenu=CustomKeywords.'ussd.Send.response'('2')

String menu=CustomKeywords.'ussd.Expected.menu'('Bienvenue\\. Pour le Rappelle\\-moi composez #555\\*Numero TELMA MOBILE#\\. Pour SOS credit composez #555\\*1\\*Numero TELMA Mobile\\*somme a demander#','Rappelle\\-moi, tsindrio ny #555\\*Numerao TELMA#\\. Ho an\'ny SOS Fahana, tsindrio #555\\*1\\*Numerao TELMA\\*sandan ny Fahana#')

'Vérifier la conformité du message'

WS.verifyMatch(actualMenu, menu, true)