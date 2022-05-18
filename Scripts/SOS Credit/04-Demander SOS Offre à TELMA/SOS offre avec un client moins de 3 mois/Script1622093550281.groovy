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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

String numeroNonEligible="${numeroNonEligible}"

'En tant que client TELMA, je vais dans le menu pour SOS Crédit en composant #111 > 3, puis je Je saisis 2 et je valide'
String actualMenu = CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'*3#', numeroNonEligible)

'Vérifier la conformité du message'
String menu = CustomKeywords.'ussd.Expected.menu'('^Cher abonne, pour beneficier de ce service, merci d\'utiliser davantage les services TELMA\\.$',
    '^Ry mpanjifa, mba ahafahanao manjifa ity tolotra ity, mampiasa matetika kokoa ny tolotra TELMA\\.$')

WS.verifyMatch(actualMenu, menu, true)