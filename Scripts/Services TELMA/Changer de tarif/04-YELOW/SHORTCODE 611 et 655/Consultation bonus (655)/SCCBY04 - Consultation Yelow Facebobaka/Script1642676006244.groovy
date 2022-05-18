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

String dateExpiration=CustomKeywords.'outStream.XML.getDateBundle'("yelow facebobaka")//String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(3,'dd/MM/yyy HH:mm')
String heureExpiration=CustomKeywords.'outStream.XML.getTimeBundle'("yelow facebobaka")

'En tant que GP, je consulte mon offre YELOW Facebobaka :  *655*65#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeDirect+'*65#', numeroInitiateur)

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Vos bonus YELOW FACEBOBAKA restant : 250\\.0 Mo utilisable toute la journee valable jusqu au '+dateExpiration+' a '+heureExpiration+' inclus',
	'Ny bonus YELOW FACEBOBAKA- nao: 250\\.0 Mo ny tontolo andro ampiasaina  hatramin ny '+dateExpiration+' @ '+heureExpiration+'\\.')

WS.verifyMatch(actualMenu, menu, true)