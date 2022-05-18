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
String pinInitateur="${pinInitateur}"
String numeroAVerifier="${numeroAVerifier}"
String nonBranche = "${nonBranche}"

String numeroAVerifierTo034 = CustomKeywords.'ussd.Util.to034'(numeroAVerifier)

'Je shortcode *130*2*8# pour acceder au menu Vérification grossiste'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'*8#', numeroInitiateur)

'Je saisi le code pin de mon numéro 2tmv'
CustomKeywords.'ussd.Send.response'(pinInitateur)

'Je saisis un numéro qui n\'est pas de type PDV'
String actualMenu=CustomKeywords.'ussd.Send.response'(numeroAVerifierTo034)

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Le nom du grossiste auquel il est rattache est '+nonBranche+'\\.')

WS.verifyMatch(actualMenu, menu, true)


