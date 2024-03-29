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

'Je saisis 4 (YELOW) et je valide'
CustomKeywords.'ussd.Send.response'('4')

'Je saisis un numero autre qu\'affichés sur le menu et je valide '
String actualMenu=CustomKeywords.'ussd.Send.response'('12')

'Vérifier que je reste sur le menu MORA'
String menu=CustomKeywords.'ussd.Expected.menu'('YELOW \\(SMS \\- INTERNET\\)\n1 YELOW100 \\(100 Ar\\)\n2 YELOW SMS \\(200 Ar\\)\n3 YELOW FACEBOOBAKA \\(500 Ar\\)\n4 YELOW 1000 \\(1000 Ar\\)\n0 Page suivante', 
	                                             'YELOW \\(SMS \\- INTERNET\\)\n1 YELOW100 \\(100 Ar\\)\n2 YELOW SMS \\(200 Ar\\)\n3 YELOW FACEBOOBAKA \\(500 Ar\\)\n4 YELOW 1000 \\(1000 Ar\\)\n0 Pejy manaraka')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 9  et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('9')

'Je saisis un numero autre qu\'affichés sur le menu et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('9')

WS.verifyMatch(actualMenu, menu, true)