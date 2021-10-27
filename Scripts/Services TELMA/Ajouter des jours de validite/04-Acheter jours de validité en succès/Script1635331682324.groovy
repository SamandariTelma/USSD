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

String numeroInitiateur = "261346848017"//"$numeroInitiateur"

String montant1Jour = "$montant1Jour"

String nombreJourAchete = "$nombreJourAchete"

'Je visualise la date de validité de mon crédit en composant #130*4*1*1#'
WebUI.callTestCase(findTestCase('Services TELMA/Ajouter des jours de validite/00-Called Test Case/Visualiser la date de validité'), 
    [('numeroInitiateur') : numeroInitiateur], FailureHandling.CONTINUE_ON_FAILURE)

String dateAvantAchatJour=GlobalVariable.dateValidite

'Je shortcode #130*4*5#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode + '#', numeroInitiateur)

'Je saisis 1 (Acheter des jours de validite) et valide'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis un chiffre de 1 à 100'
String actualMenu = CustomKeywords.'ussd.Send.response'(nombreJourAchete)

int montantJourAchete = nombreJourAchete.toInteger() * montant1Jour.toInteger()

'Vérifier la conformité du message'
String menu = CustomKeywords.'ussd.Expected.menu'(((('Vous avez achete ' + nombreJourAchete) + ' jour\\(s\\) pour ') + montantJourAchete) + 
    ' Ar\\.', ((('Nividy ' + nombreJourAchete) + ' andro ianao, ') + montantJourAchete) + ' Ar ny sarany\\.')

WS.verifyMatch(actualMenu, menu, true)

'Je vérifie que ma date de validité augmente en fonction du nombre de jour acheté'
WebUI.callTestCase(findTestCase('Services TELMA/Ajouter des jours de validite/00-Called Test Case/Visualiser la date de validité'),
	[('numeroInitiateur') : numeroInitiateur], FailureHandling.CONTINUE_ON_FAILURE)

String dateApresAchatJour=GlobalVariable.dateValidite

String expectedDate=CustomKeywords.'ussd.Util.nextDate'(dateAvantAchatJour, nombreJourAchete.toInteger() , 'dd/MM/yyyy')

WS.verifyMatch(dateApresAchatJour, expectedDate, false)