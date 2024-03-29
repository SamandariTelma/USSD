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

String montantFirstPrenium = "${montantFirstPrenium}"

'Consulter mon solde avant d\' effectuer un FIRST'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeAvant = GlobalVariable.soldeCredit

'Je shortcode *130*5# et je valide'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 3(FIRST)'
CustomKeywords.'ussd.Send.response'('3')

'Je saisis  1 (First Premium) et je valide'
CustomKeywords.'ussd.Send.response'('1')

'Je confirme l\'achat en saisissant 1 (OUI)'
String actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du menu'
String menu=CustomKeywords.'ussd.Expected.menu'('BRAVO\\! Grace a l achat de l offre FIRST PREMIUM, TELMA vous offre un bonus NET ONE WEEK 2,5 Go \\. Consultez vos bonus sur #359#\\. TELMA N1 des KADOA\\.',
	'Tafiditra ny First Premium\\. Bonus\\-nao:#359#\\. Haingana sy tsotra ny mividy tolotra sy mijery bonus @alalan ny app Telma&Moi ')

WS.verifyMatch(actualMenu, menu, true)

'Je vérifie que mon solde est déduit du montant de FIRST'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur],
	FailureHandling.CONTINUE_ON_FAILURE)

int soldeApresFirst10000 = GlobalVariable.soldeCredit

int soldeExcepted=soldeAvant - Integer.valueOf(montantFirstPrenium)
WS.verifyEqual(soldeApresFirst10000, soldeExcepted)
