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

'En tant que client TELMA je me rends sur le menu SOS Offre à TELMA en composant le short code #111# > 3 > 3'
String actualMenu= CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*3#', numeroInitiateur)

'Vérifier la conformité du menu'
String menu= CustomKeywords.'ussd.Expected.menu'("Sos Offre\n1 MORA \\(VOIX \\- SMS \\- INTERNET\\)\n2 FIRST \\(VOIX \\- SMS \\- INTERNET\\)\n3 YELOW \\(SMS \\- INTERNET\\)\n4 TELMA Net \\(INTERNET\\)")

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 1 pour l\'offre MORA'
actualMenu= CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du menu'
menu = CustomKeywords.'ussd.Expected.menu'('MORA \\(VOIX \\- SMS \\- INTERNET\\)\n1 MORA NIGHT\n2 MORA TEAM\n3 MORA 500\n4 MORA\\+ 2000\n5 MORA\\+ 5000\n6 FIRST CLASSIQUE\n7 MORA ONE\n8 MORA INTERNATIONAL')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 3 (MORA 500)'
actualMenu= CustomKeywords.'ussd.Send.response'('3')

'Vérifier la conformité du prompt'
menu = CustomKeywords.'ussd.Expected.menu'(actualMenu, 'Raha hanamarina ny fangatahana SOS @ TELMA, ny tolotra MORA 500, tsindrio ny 1')

