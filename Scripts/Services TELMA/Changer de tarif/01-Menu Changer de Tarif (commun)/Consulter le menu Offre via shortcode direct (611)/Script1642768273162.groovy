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

'J\'accède au menu Offre en shortcodant *611#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodeDirectAchat+'#', numeroInitiateur)

'Vérifier la conformité du menu'
String menu=CustomKeywords.'ussd.Expected.menu'('Votre offre tarifaire actuelle est (TOKANA|(\\w*))\n1 MORA \\(VOIX \\- SMS \\- INTERNET\\)\n2 FIRST \\(VOIX \\- SMS \\- INTERNET\\)\n3 YELOW \\(SMS \\- INTERNET\\)\n4 TELMA Net \\(INTERNET\\)',
	'Ny tolotra misy anao dia (TOKANA|(\\w*))\n1 MORA \\(VOIX \\- SMS \\- INTERNET\\)\n2 FIRST \\(VOIX \\- SMS \\- INTERNET\\)\n3 YELOW \\(SMS \\- INTERNET\\)\n4 TELMA Net \\(INTERNET\\)')

WS.verifyMatch(actualMenu, menu, true)