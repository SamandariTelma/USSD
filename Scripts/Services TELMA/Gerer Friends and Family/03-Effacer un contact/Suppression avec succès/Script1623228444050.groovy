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

String numeroAEfface = GlobalVariable.msisdnAAjouter1

'En tant que client TELMA, je vais dans le menu Gerer Friends and family en composant *130*4*3#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode + '#', GlobalVariable.msisdnInitiateur)

'Je saisis 2 (Effacer un contact) puis valide'
String actualMenu = CustomKeywords.'ussd.Send.response'('2')

'Vérifier la conformité du prompt'
String menu = CustomKeywords.'ussd.Expected.menu'('Entrer numero :', 'Ampidiro ny laharana :')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un numéro existant dans la liste FAF'
actualMenu = CustomKeywords.'ussd.Send.response'(numeroAEfface)

'Vérifier la conformité du messsage'
menu = CustomKeywords.'ussd.Expected.menu'(('Le numero ' + numeroAEfface) + ' a ete supprime avec succes\\.', ('Voafafa ny nomerao ' + 
    numeroAEfface) + ' nosafidianao\\.')

WS.verifyMatch(actualMenu, menu, true)

WebUI.callTestCase(findTestCase('Services TELMA/Gerer Friends and Family/03-Effacer un contact/00-Called test case/Vérification du numéro supprimé'), 
    [('numeroASupprimer') : numeroAEfface], FailureHandling.CONTINUE_ON_FAILURE)

