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

String numeroAjoute1="${numeroAjoute1}"
String numeroAjoute2="${numeroAjoute2}"
String numeroAjoute3="${numeroAjoute3}"
'En tant que client TELMA, je vais dans le menu Gerer Friends and family en composant *130*4*3#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 3 (Liste Friends & Family) et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('3')

'Vérifier l\'affichage du menu'
String menu=CustomKeywords.'ussd.Expected.menu'('Liste Friends & Familly\\.\n1 '+numeroAjoute1+'\n2 '+numeroAjoute2+'\n3 '+numeroAjoute3, 
	'Lisitra Namana & fianakaviana\\.\n1'+numeroAjoute1+'\n2 '+numeroAjoute2+'\n3 '+numeroAjoute3)

WS.verifyMatch(actualMenu, menu, true)