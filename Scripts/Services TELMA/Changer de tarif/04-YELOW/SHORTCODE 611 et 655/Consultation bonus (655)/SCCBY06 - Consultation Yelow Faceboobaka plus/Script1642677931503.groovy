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

String dateExpiration=CustomKeywords.'outStream.XML.getDateBundle'("yelow faceboobaka")//CustomKeywords.'ussd.Util.nextDate'(14,'dd/MM/yyy HH:mm')
String heureExpiration=CustomKeywords.'outStream.XML.getTimeBundle'("yelow faceboobaka")

'En tant que GP, je consulte mon offre YELOW Faceboobaka + : *655*68#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodeDirect+'*68#', numeroInitiateur)

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Bonus YELOW FACEBOOBAKA \\+ : 1024\\.0 Mo utilisable toute la journee valable jusqu au '+dateExpiration+' a '+heureExpiration+' inclus\\.',
	'Bonus YELOW FACEBOOBAKA \\+ : 1024\\.0 Mo azo ampiasaina ny tontolo andro ampiasaina  hatramin ny '+dateExpiration+' @ '+heureExpiration+'\\.')

WS.verifyMatch(actualMenu, menu, true)