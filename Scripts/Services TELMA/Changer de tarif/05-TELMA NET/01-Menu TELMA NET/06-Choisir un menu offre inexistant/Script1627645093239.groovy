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
String actualMenu=CustomKeywords.'ussd.Send.response'('4')

'Je saisi un numéro qui n\'existe pas dans le menu'
CustomKeywords.'ussd.Send.response'('12')

'Vérifier la conformité du menu'
String menu=CustomKeywords.'ussd.Expected.menu'('TELMA Net \\(INTERNET\\)\n1 NET JOURNALIER\n2 NET HEBDOMADAIRE\n3 NET MENSUEL\n4 NET PAYER MENSUALITES EN AVANCE')

WS.verifyMatch(actualMenu, menu, true)

'Je saisi un numéro qui n\'existe pas dans le menu'
actualMenu=CustomKeywords.'ussd.Send.response'('9')

'Vérifier la conformité du menu'

WS.verifyMatch(actualMenu, menu, true)
