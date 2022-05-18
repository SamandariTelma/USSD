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

String numeroExistant = "$numeroExistant"

'En tant que GP, je shortCode  *644*1*MSISDN# pour ajouter le numero *644*1*034xxx#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeDirect + '*1*'+numeroExistant+'#', numeroInitiateur)

'Vérifier la conformité du messsage'/*
String menu=CustomKeywords.'ussd.Expected.menu'('Le nombre maximum de numero FAF autre que TELMA est deja atteint\\.',
	'Feno ny isan\'ny FAF tsy TELMA anananao\\.')*/

String menu=CustomKeywords.'ussd.Expected.menu'('Le '+numeroExistant+' fait deja partie de vos numeros Friends and Family\\.',
	'Efa ao anaty lisitra Friends and Family ny '+numeroExistant+'\\.')

WS.verifyMatch(actualMenu, menu, true)