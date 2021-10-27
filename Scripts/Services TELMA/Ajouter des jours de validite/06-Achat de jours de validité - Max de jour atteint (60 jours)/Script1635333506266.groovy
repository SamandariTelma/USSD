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

String numeroPlus60JoursValidite = "$numeroPlus60JoursValidite"
String nombreJourAchete="${nombreJourAchete}"

'Je vérifie préalablement la date de validité de mon crédit'

WebUI.callTestCase(findTestCase('Services TELMA/Ajouter des jours de validite/00-Called Test Case/Visualiser la date de validité'), 
    [('numeroInitiateur') : numeroPlus60JoursValidite], FailureHandling.CONTINUE_ON_FAILURE)

String dateAvantAchatJour=GlobalVariable.dateValidite


//Implémentation de la vérification info crédit avant achat j de validité
'Je Shortcode *130*4*5#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode + '#', numeroPlus60JoursValidite)

'Je saisis 1 (Acheter des jours de validite) et valide'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis un chiffre de 1 à 100'
String actualMenu = CustomKeywords.'ussd.Send.response'(nombreJourAchete)

'Vérifier la conformité du message'
String menu = CustomKeywords.'ussd.Expected.menu'('Vous avez atteint le maximum de jours de validite, impossible  d\' acheter des jours en plus\\.', 
    'Efa tratra ny fetr\'andro be indrindra azonao ampiasaina\\. Koa tsy afaka manampy intsony ianao\\.')

WS.verifyMatch(actualMenu, menu, true)

'Je vérifie que la date de validité n\'a pas bougé en composant #130*4*1*1#'

WebUI.callTestCase(findTestCase('Services TELMA/Ajouter des jours de validite/00-Called Test Case/Visualiser la date de validité'), 
    [('numeroInitiateur') : numeroPlus60JoursValidite], FailureHandling.CONTINUE_ON_FAILURE)

String dateApresAchatJour=GlobalVariable.dateValidite
													
WS.verifyMatch(dateAvantAchatJour, dateApresAchatJour, false)
