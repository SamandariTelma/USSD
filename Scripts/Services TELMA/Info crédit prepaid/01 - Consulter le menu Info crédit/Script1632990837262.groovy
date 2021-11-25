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

'En tant que client TELMA, je vais dans le menu pour Info crédit en composant #130*4#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeTELMA+'4#', numeroInitiateur)

'Vérifier la présence du menu Info crédit'
String menu = CustomKeywords.'ussd.Expected.menu'('^.*Info credit.*$','^.*Hamantatra fahana.*$')

WS.verifyMatch(actualMenu, menu, true)
'Je saisi 1 pour Info credit'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du menu'
menu=CustomKeywords.'ussd.Expected.menu'('1 Info credit prepaye\n2 Info Conso Internet', '1 Fahana prepaye sisa\n2 Fahana internet sisa')

WS.verifyMatch(actualMenu, menu, true)