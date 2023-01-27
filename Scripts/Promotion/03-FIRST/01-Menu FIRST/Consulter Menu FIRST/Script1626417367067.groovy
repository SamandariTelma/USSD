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

'Je short code *111*5*3# pour consulter le menu FIRST et valide'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*3#', numeroInitiateur)

'Je vérifie la conformité du menu'
String menu=CustomKeywords.'ussd.Expected.menu'('FIRST \\(VOIX \\- SMS \\- INTERNET\\)\n1 FIRST PREMIUM \\(10000 Ar\\)\n2 FIRST PREMIUM \\+ \\(15000 Ar\\)\n3 FIRST PRESTIGE \\(30000 Ar\\)\n4 FIRST ROYAL \\(50000 Ar\\)')

WS.verifyMatch(actualMenu, menu, true)