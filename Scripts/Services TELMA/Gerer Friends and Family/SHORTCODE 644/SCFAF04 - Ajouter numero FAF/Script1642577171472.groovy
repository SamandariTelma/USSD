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

String numeroInitiateur = "$numeroInitiateur"

String numeroAAjouter = "$numeroAAjouter"

'En tant que GP, je shortCode  *644*1*MSISDN# pour ajouter le numero *644*1*034xxx#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCoddeDirect + '*1*'+numeroAAjouter+'#', numeroInitiateur)

'Vérifier la conformité du messsage'
String menu = CustomKeywords.'ussd.Expected.menu'(('Le numero ' + numeroAAjouter) + ' a ete rajoute avec succes\\.', ('Voaray ny nomerao ' + 
    numeroAAjouter) + ' nampidirinao\\.')

WS.verifyMatch(actualMenu, menu, true)

println(numeroAAjouter)

'Vérifier que le numéro est ajouté dans le repertoire'

WebUI.callTestCase(findTestCase('Services TELMA/Gerer Friends and Family/02-Ajouter un contact/00-Called test case/Vérification du numéro ajouté'), 
    [('numeroInitiateur') : numeroInitiateur, ('numeroAjoute') : numeroAAjouter], FailureHandling.CONTINUE_ON_FAILURE)
