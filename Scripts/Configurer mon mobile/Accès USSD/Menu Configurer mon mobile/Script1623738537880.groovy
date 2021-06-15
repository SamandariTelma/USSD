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

'Je shortcode *130*9#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeTELMA, numeroInitiateur)

'Vérifier l\'apperition du menu Configurer mon mobile'
String menu=CustomKeywords.'ussd.Expected.menu'('^.*Configurer mon mobile.*$')

WS.verifyMatch(actualMenu, menu, true)


'Je saisis 9 (Configurer mon mobile)'
actualMenu=CustomKeywords.'ussd.Send.response'('9')

'Vérifier la conformité du sous menu'
menu=CustomKeywords.'ussd.Expected.menu'('Configurer mon mobile\n1 Configurer service WAP\n2 Configurer service WEB\n3 Configurer tous les services \\(WAP,WEB\\)\n4 \\(Des\\-\\) Activer INTERNET sur compte principal\n0 Page suivante',
	'Configurer mon mobile\n1 Configurer service WAP\n2 Configurer service WEB\n3 Configurer tous les services \\(WAP,WEB\\)\n4 \\(Des\\-\\) Activer INTERNET sur compte principal\n0 Pejy manaraka')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 0 pour voir la page suuivante'
actualMenu=CustomKeywords.'ussd.Send.response'('0')

'Vérifier la conformité du sous menu'
menu=CustomKeywords.'ussd.Expected.menu'('5 Generer le code OTP pour mon application\n00 Page precedente',
	'5 Generer le code OTP pour mon application\n00 Pejy aloha')

WS.verifyMatch(actualMenu, menu, true)