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
String dateExpiration=CustomKeywords.'outStream.XML.getDateBundle'("yelow 200")
String heureExpiration=CustomKeywords.'outStream.XML.getTimeBundle'("yelow 200")


'En tant que GP, je consulte mon offre YELOW 200 :  *655*63#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodeDirect+'*63#', numeroInitiateur)

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Bonus YELOW 200 restants: 50 SMS Telma et/ou 50 Mo utilisable a toute heure jusqu au '+dateExpiration+' a '+heureExpiration,
	'Bonus YELOW 200: 50 SMS Telma sy/na 50 Mo azo ampiasaina @ ora rehetra hatramin ny '+dateExpiration+' @ '+heureExpiration)

WS.verifyMatch(actualMenu, menu, true)