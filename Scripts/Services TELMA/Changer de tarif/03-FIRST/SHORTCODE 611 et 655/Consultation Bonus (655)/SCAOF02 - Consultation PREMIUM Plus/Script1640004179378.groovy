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

'En tant que GP, je consulte mon offre First Premium Plus :  *655*92#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeDirect+'*92#', numeroInitiateur)

'Vérifier la conformité du message'
String menu= CustomKeywords.'ussd.Expected.menu'(('Bonus FIRST PREMIUM \\+ : 15000 Ar appel national \\+ 150 SMS Telma \\+ 200\\.0 Mo la journee \\+ 200\\.0 Mo la nuit \\+ Bonus 300 sec vers international jusqu au ' + 
    dateExpiration) + '.', 'Bonus FIRST PREMIUM \\+ : 15000 Ar antso eto M/kara \\+ 150 SMS Telma \\+ 200\\.0 Mo ny tontolo andro \\+ 200\\.0 Mo ny alina \\+Bonus 300 s makany ivelany, h@ ' + 
    dateExpiration)

WS.verifyMatch(actualMenu, menu, true)