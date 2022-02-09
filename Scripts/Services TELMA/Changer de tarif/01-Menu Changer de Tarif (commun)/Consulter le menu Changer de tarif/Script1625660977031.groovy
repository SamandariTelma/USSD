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

'Je shortcode #111#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeTELMA, numeroInitiateur)

'Je saisis 4 (Service TELMA) et valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('4')

'Vérifier l\'apparition du menu Changer de tarif'
String menu=CustomKeywords.'ussd.Expected.menu'('^.*Acheter une offre.*$','^.*Hividy tolotra.*$')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 6 (Changer de tarif)'
actualMenu=CustomKeywords.'ussd.Send.response'('6')

'Vérifier la conformité du sous menu'
menu=CustomKeywords.'ussd.Expected.menu'('Votre offre tarifaire actuelle est (TOKANA|(\\w*))\n1 MORA \\(VOIX \\- SMS \\- INTERNET\\)\n2 FIRST \\(VOIX \\- SMS \\- INTERNET\\)\n3 YELOW \\(SMS \\- INTERNET\\)\n4 TELMA Net \\(INTERNET\\)',
	'Ny tolotra misy anao ankehitriny dia (TOKANA|(\\w*))\n1 MORA \\(VOIX \\- SMS \\- INTERNET\\)\n2 FIRST \\(VOIX \\- SMS \\- INTERNET\\)\n3 YELOW \\(SMS \\- INTERNET\\)\n4 TELMA Net \\(INTERNET\\)')

WS.verifyMatch(actualMenu, menu, true)