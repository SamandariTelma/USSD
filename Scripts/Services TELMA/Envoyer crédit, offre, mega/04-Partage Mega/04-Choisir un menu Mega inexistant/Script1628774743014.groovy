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
String numeroRecepteur="${numeroRecepteur}"

'Je shortcode #130*4*4#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode + '#', numeroInitiateur)

'Je saisis 3 (Partager du Mega) et je valide '
CustomKeywords.'ussd.Send.response'('3')

'Je saisis un menu offre inexistant'
String actualMenu=CustomKeywords.'ussd.Send.response'('22')

'Vérifier que je reste sur la même page'
String menu=CustomKeywords.'ussd.Expected.menu'('^.*BONUS Mega partageable :\n1 NET ONE MONTH 2\\,5Go.*$', '^.*BONUS Mega afaka zaraina :\n1 NET ONE MONTH 2\\,5Go.*$')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 1 (NET ON MONTH 2,5Go)'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis un menu Mega qu n\'existe pas'
actualMenu=CustomKeywords.'ussd.Send.response'('12')

'Vérifier que je reste sur la page liste Mega'
menu=CustomKeywords.'ussd.Expected.menu'('Mega a partager \nIl vous reste \\d{1,5}\\.\\d{1,3} Mo sur votre NET ONE MONTH 2,5Go :\n1 100 Mo\n2 500 Mo\n3 1024 Mo',
	'Mega zaraina \\d{1,5}\\.\\d{1,3} sisa no ao @ tolotra NET ONE MONTH 2\\,5Go anao\n1 100 Mo\n2 500 Mo\n3 1024 Mo')

WS.verifyMatch(actualMenu, menu, true)

'Je sélectionne un numero parmi la liste et je valide'
CustomKeywords.'ussd.Send.response'('1')

