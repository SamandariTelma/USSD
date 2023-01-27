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

String numeroInitiateur = "$numeroInitiateur"

String numeroAEfface = "$numeroAEfface"

'En tant que GP, je shortCode  *644*2*numeroASupprimer# pour supprimer un numero FAF'
String actualMenu = CustomKeywords.'ussd.Send.code'(((GlobalVariable.shortCoddeDirect + '*2*') + numeroAEfface) + '#', numeroInitiateur)

'Vérifier la conformité du prompt'
String menu = CustomKeywords.'ussd.Expected.menu'(('Le numero ' + numeroAEfface) + ' a ete supprime avec succes\\.', ('Voafafa ny nomerao ' + 
    numeroAEfface) + ' nosafidianao\\.')

WS.verifyMatch(actualMenu, menu, true)

'Vérifier que le numéro effacé n\'est plus présent dans le repertoire'

WebUI.callTestCase(findTestCase('Services TELMA/Gerer Friends and Family/03-Effacer un contact/00-Called test case/Vérification du numéro supprimé'), 
    [('numeroInitiateur') : numeroInitiateur, ('numeroASupprimer') : numeroAEfface], FailureHandling.CONTINUE_ON_FAILURE)

