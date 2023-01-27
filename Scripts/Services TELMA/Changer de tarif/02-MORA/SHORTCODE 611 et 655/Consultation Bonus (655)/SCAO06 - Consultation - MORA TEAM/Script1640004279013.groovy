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
String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(1,'dd/MM/yyy')

'En tant que GP, je consulte mon offre Mora Team :  *655*26#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCoddeDirect+'*26#', numeroInitiateur)

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Bonus MORA TEAM: 3600 sec d appels et/ou 60 SMS vers Num FAF et/ou 60\\.0 Mo valable jusqu a minuit\\. Tapez #344\\*1\\*Num pour rajouter Num FAF\\. Telma N1 a M/car',
	'Bonus MORA TEAM: antso 3600 sec sy/na 60 SMS mankany @ Num FAF sy/na 60\\.0 Mo h@ sasak alina\\. Antsoy ny #344\\*1\\*Num# raha hanampy Num FAF\\. Telma N1 eto M/kara')

WS.verifyMatch(actualMenu, menu, true)