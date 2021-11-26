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


String numeroInitiateur="${numeroInitiateur}"
String pinInitiateur= "${pinInitiateur}"
String regexSolde='(([1-9]{1,3})|(([1-9]{1,3}(\\s\\d{3})+)))'

'En tant que MSISDN grossiste, je compose le *130*2#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 5 (Ventes d\'hier) et je valide'
CustomKeywords.'ussd.Send.response'('5')

'Je saisis correctement mon PIN  et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'(pinInitiateur)

'Vérifier la conformité du message ussd'
String menu=CustomKeywords.'ussd.Expected.menu'('Total montant envoye: '+regexSolde+' Ar\\.\nLe nombre de transactions est: [1-9]{1,4}\\. Ref: \\d{1,10}\\.',
	'Sandan ny vola voaray: '+regexSolde+' Ar\\. Ny isan ny fifanakalozana dia: [1-9]{1,4}\\. Ref: \\d{1,10}\\.')

WS.verifyMatch(actualMenu, menu, true)