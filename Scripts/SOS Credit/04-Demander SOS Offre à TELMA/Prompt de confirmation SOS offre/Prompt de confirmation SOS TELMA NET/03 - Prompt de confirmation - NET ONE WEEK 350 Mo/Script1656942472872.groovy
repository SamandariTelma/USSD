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
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodde+'*3#', numeroInitiateur)

'Je saisis 4 pour l\'offre TELMA NET'
CustomKeywords.'ussd.Send.response'('4')

'Je saisis 2 pour (NET HEBDOMADAIRE)'
CustomKeywords.'ussd.Send.response'('2')

'Je saisi 1 (NET ONE WEEK 350 Mo)'
String actualMenu = CustomKeywords.'ussd.Send.response'('1')

'Je vérifie la conformité du prompt'
String menu = CustomKeywords.'ussd.Expected.menu'('Pour confirmer votre demande de SOS a TELMA, ONE WEEK 350 Mo, Taper 1', 'Raha hanamarina ny fangatahana SOS @ TELMA, ny tolotra ONE WEEK 350 Mo, tsindrio ny 1')

WS.verifyMatch(actualMenu, menu, true)