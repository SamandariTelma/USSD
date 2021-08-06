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

String numeroInitiateur="${numeroInitiateur}"

'En tant que client TELMA, je vais dans mon USSD en composant le short code #130*4*6#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 4 (TELMA Net (INTERNET)) et valide'
CustomKeywords.'ussd.Send.response'('4')

'Je saisis 4 NET PAYER MENSUALITES EN AVANCE'
String actualMenu=CustomKeywords.'ussd.Send.response'('4')

'Je vérifie la conformité du menu'
String menu=CustomKeywords.'ussd.Expected.menu'('NET PAYER MENSUALITES EN AVANCE\n1 NET 3 MOIS \\(30 000 Ar\\)\n2 NET 6 MOIS \\(60 000 Ar\\)\n3 NET 9 MOIS \\(90 000 Ar\\)\n4 NET 12 MOIS \\(110 000 Ar\\)')

WS.verifyMatch(actualMenu, menu, true)
