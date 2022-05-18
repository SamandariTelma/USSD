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

'En tant que GP, je consulte mon offre Mora Night :  *655*25#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeDirect+'*25#', numeroInitiateur)

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Bonus MORA NIGHT: 3600 sec d appels et/ou 60 SMS vers Telma utilisable de 21h\\-5h59 jusqu au '+dateExpiration,
	'Bonus MORA NIGHT: antso 3600 sec sy/na 60 SMS mankany @numerao Telma azo ampiasaina @21h\\-5h59, ary manankery h@ '+dateExpiration)

WS.verifyMatch(actualMenu, menu, true)