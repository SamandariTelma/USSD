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

String dateExpiration=CustomKeywords.'outStream.XML.getDateBundle'("yelow sms")
String heureExpiration=CustomKeywords.'outStream.XML.getTimeBundle'("yelow sms")

'En tant que GP, je consulte mon offre YELOW SMS :  *655*62#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCoddeDirect+'*62#', numeroInitiateur)

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Bonus YELOW SMS restants: 100 SMS Telma et 25 SMS autres operateurs jusqu au '+dateExpiration+' a '+heureExpiration+'\\.',
	'Bonus YELOW SMS : 100 SMS Telma  \\+ 25 SMS mankany @ tambazotra hafa azo ampiasaina hatramin ny '+dateExpiration+' @ '+heureExpiration+'\\.')

WS.verifyMatch(actualMenu, menu, true)