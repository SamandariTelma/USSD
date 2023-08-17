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

'Ajourter un 2ème numéro dans ma liste FAF'
WebUI.callTestCase(findTestCase('Services TELMA/Gerer Friends and Family/02-Ajouter un contact/Ajouter contact avec succès'), 
    [('numeroInitiateur') : numeroInitiateur, ('numeroAAjouter') : GlobalVariable.msisdn1AAjouter2], FailureHandling.CONTINUE_ON_FAILURE)

'Ajouter un 3ème numéro dans ma liste FAF'
WebUI.callTestCase(findTestCase('Services TELMA/Gerer Friends and Family/02-Ajouter un contact/Ajouter contact avec succès'), 
    [('numeroInitiateur') :numeroInitiateur, ('numeroAAjouter') : GlobalVariable.msisdn1AAjouter3], FailureHandling.CONTINUE_ON_FAILURE)

'Essayer d\' ajouter un 4ème numéro dans ma liste FAF'
String actualMenu = CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodde + '*1*0340030816#', numeroInitiateur)

'Vérifier la conformité du messsage'
String menu = CustomKeywords.'ussd.Expected.menu'('Vous avez atteint le nombre maximum de numeros Friends and Familly autorises\\. Vous devez supprimer un avant d\'en rajouter\\.', 
    'Efa feno ny lisitra Friends and Family nao\\. Mamafa nomerao 1 raha hampiditra vaovao ianao\\.')

WS.verifyMatch(actualMenu, menu, true)