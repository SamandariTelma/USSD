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

'Je shortcode #111*4*6#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 3 (YELOW (SMS - INTERNET)) et valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('3')

'Vérifier la conformité du sous menu'
String menu=CustomKeywords.'ussd.Expected.menu'('YELOW \\(SMS \\- INTERNET\\)\n1 YELOW100 \\(100 Ar\\)\n2 YELOW SMS \\(200 Ar\\)\n3 YELOW FACEBOBAKA \\(500 Ar\\)\n4 YELOW 1000 \\(1 000 Ar\\)\n5 YELOW 200 \\(200 Ar\\)\n6 YELOW FACEBOOBAKA \\+ \\(2 000 Ar\\)')

WS.verifyMatch(actualMenu, menu, true)