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

String numeroInitiateur = "${numeroInitiateur}"

String montantYelowFacebobaka = "${montantYelowFacebobaka}"

String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(14,'dd/MM/yyy')

String heureExpiration=CustomKeywords.'ussd.Util.nextDate'(14,'HH:mm')

'Consulter mon solde avant d\' effectuer un Yelow facebobaka +'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur], 
    FailureHandling.CONTINUE_ON_FAILURE)

int soldeAvant = GlobalVariable.soldeCredit

'Je shortcode #111*4*6#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode + '#', numeroInitiateur)

'Je saisis 3 (YELOW (SMS - INTERNET)) et valide'
CustomKeywords.'ussd.Send.response'('3')

'Je saisis 6(YELOW FACEBOBAKA +) et je valide'
String actualMenu = CustomKeywords.'ussd.Send.response'('6')

'Je choisis 1 Oui'
actualMenu = CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du message'
String menu = CustomKeywords.'ussd.Expected.menu'('L achat de votre YELOW FACEBOOBAKA \\+ est reussi\\. Bonus restants: #359#\\. Achetez via MVola et gagnez a chaque fois un bonus kadoa de 20%\\. Tapez vite le #111\\*1#\\.', 
    'Tafiditra ny tolotra YELOW FACEBOOBAKA \\+ novidianao\\. Bonus\\-nao: #359#\\. Vidio @MVola ny tolotrao  ary mahazoa hatrany Bonus kadoa 20%\\. Tsindrio ny #111\\*1#\\.')

WS.verifyMatch(actualMenu, menu, true)

CustomKeywords.'outStream.XML.setDateBundle'("yelow faceboobaka", dateExpiration, heureExpiration)

'Je vérifie que mon solde est déduit du montant de Yelow facebobaka +'
WebUI.callTestCase(findTestCase('00-Called Test Case/Consulter le solde crédit'), [('numeroInitiateur') : numeroInitiateur], 
    FailureHandling.CONTINUE_ON_FAILURE)

int soldeApresYelow100 = GlobalVariable.soldeCredit

int soldeExcepted=soldeAvant - Integer.valueOf(montantYelowFacebobaka)
WS.verifyEqual(soldeApresYelow100, soldeExcepted)

