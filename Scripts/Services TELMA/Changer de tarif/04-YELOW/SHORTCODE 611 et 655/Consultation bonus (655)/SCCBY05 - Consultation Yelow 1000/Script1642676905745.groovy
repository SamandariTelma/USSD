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

String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(29,'dd/MM/yyy')

'En tant que GP, je consulte mon offre YELOW 1000 : *655*66#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodeDirect+'*66#', numeroInitiateur)

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Bonus YELOW 1000 restants: 100 SMS vers tous les opérateurs et/ou 50\\.0 Mo utilisable à toute heure \\+ 50\\.0 Mo la nuit jusqu au '+dateExpiration+'\\.',
	'Bonus YELOW 1000 tavela: 100 SMS mankany @ tambazotra rehetra  \\+ 50\\.0 Mo ny alina hatramin ny '+dateExpiration+'\\.')
WS.verifyMatch(actualMenu, menu, true)