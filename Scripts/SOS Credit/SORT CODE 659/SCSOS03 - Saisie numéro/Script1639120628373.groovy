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

'En tant que GP, je shortCode le SOS Credit  en composant *659*1*0325785400*1000#  qui est un numero autre opérateur'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeDirect+'*0325785400*1000#', numeroInitiateur)

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Verifiez le numero svp\\.', 'Hamarino ny nomerao azafady\\.')

WS.verifyMatch(actualMenu, menu, true)

'En tant que GP, je shortCode le SOS Credit  en composant *659*1*261346848017*1000#  qui est un numero autre opérateur'
actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeDirect+'*261346848017*1000#', numeroInitiateur)

'Vérifier la conformité du prompt'

WS.verifyMatch(actualMenu, menu, true)

'Je reshortCode le SOS Credit  en composant *659*1*12536544*1000#  en saisissant des chiffres invalides'
actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeDirect+'*12345*1000#', numeroInitiateur)

'Vérifier la conformité du prompt'
WS.verifyMatch(actualMenu, menu, true)
