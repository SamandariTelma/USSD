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
String pinInitiateur="${pinInitiateur}"

'En tant que MSISDN grossiste , je compose le *130*2#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'#', numeroInitiateur)

'Je saisis 4 (Consultation du solde) et je valide'
CustomKeywords.'ussd.Send.response'('4')

'Je saisis un PIN valide'
String actualMenu=CustomKeywords.'ussd.Send.response'(pinInitiateur)

String solde
if(GlobalVariable.langue=='fr')
	solde=actualMenu.substring(actualMenu.lastIndexOf('solde est de')+12, actualMenu.lastIndexOf('Ar')-1)
else if (GlobalVariable.langue=='mg')
	solde=actualMenu.substring(actualMenu.lastIndexOf('sisa dia')+9, actualMenu.lastIndexOf('Ar')-1)
	
GlobalVariable.solde2tmv=(solde.replaceAll("\\s","")).toInteger()

println("Solde 2tmv :"+GlobalVariable.solde2tmv)