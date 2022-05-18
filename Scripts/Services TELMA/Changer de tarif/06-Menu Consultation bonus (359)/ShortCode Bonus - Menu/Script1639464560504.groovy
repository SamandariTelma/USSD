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
String regexDate ='(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}'
String regexSolde='((\\d{1,3})|((\\d{1,3}(\\s\\d{3})+)))'

'En tant que GP , je shortCode  *655#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode359+'#', numeroInitiateur)

'Vérifier la conformité du menu'
String menu=CustomKeywords.'ussd.Expected.menu'('Votre credit est: '+regexSolde+',\\d{2} Ar valable jusqu au '+regexDate+'\\.\n1 Mes offres', 
	'Ny credit-nao dia '+regexSolde+',\\d{2} Ar azo ampiasaina h@ '+regexDate+'\\.\n1 Mes offres')

WS.verifyMatch(actualMenu, menu, true)