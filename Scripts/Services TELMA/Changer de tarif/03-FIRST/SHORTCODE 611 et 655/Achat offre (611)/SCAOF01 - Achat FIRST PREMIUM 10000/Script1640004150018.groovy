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

'En tant que GP, j\'effectue mon offre FIRST PREMIUM :  *611*91#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodeDirectAchat+'*91#', numeroInitiateur)

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('BRAVO! Grace a l achat de l offre FIRST PREMIUM, TELMA vous offre un bonus NET ONE WEEK 1,5 Go\\. Consultez vos bonus sur #359#\\. TELMA N1 des KADOA\\.',
	'ARAHABAINA! Noho ny fividiananao ny tolotra FIRST PREMIUM, TELMA dia manolotra anao bonus NET ONE WEEK 1,5Go\\. Araho ny bonus\\-nao @ #359#\\. TELMA N1 ny KADOA\\.')

WS.verifyMatch(actualMenu, menu, true)