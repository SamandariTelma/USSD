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

'Je shortcode #111*5#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 3 (FIRST) et je valide'
CustomKeywords.'ussd.Send.response'('3')

'Je saisis un numero autre qu\'affichés sur le menu et je valide '
String actualMenu=CustomKeywords.'ussd.Send.response'('12')

'Vérifier que je reste sur le menu FIRST'
String menu=CustomKeywords.'ussd.Expected.menu'('FIRST \\(VOIX \\- SMS \\- INTERNET\\)\n1 FIRST PREMIUM \\(10 000 Ar\\)\n2 FIRST PREMIUM \\+ \\(15 000 Ar\\)\n3 FIRST PRESTIGE \\(30 000 Ar\\)\n4 FIRST ROYAL \\(50 000 Ar\\)\n5 FIRST CLASSIQUE \\(9 000 Ar\\)')

WS.verifyMatch(actualMenu, menu, true)