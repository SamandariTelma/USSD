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

String numeroInitiateur = "${numeroInitiateur}"

'En tant que client TELMA, je vais dans le menu ussd telma en composant *130#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeTELMA, numeroInitiateur)

'Je saisis 4 (Service TELMA)'
String actualMenu=CustomKeywords.'ussd.Send.response'('4')

'Vérifier la présence du menu Recharge'
String menu= CustomKeywords.'ussd.Expected.menu'('^.*2 Recharge.*$','^.*2 Hamahana.*$')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 2 (Recharge) et valide'
actualMenu=CustomKeywords.'ussd.Send.response'('2')

'Vérifier la conformité du menu'
menu= CustomKeywords.'ussd.Expected.menu'('recharge\n1 Recharger mon numero\n2 Recharger un autre numero\n3 Recharger avec MVola\n4 Envoyer code recharge',
	'Hamahana\n1 Hamahana ny kaontiko\n2 Hamahana kaonty hafa\n3 Recharger avec MVola\n4 Hamahana code recharge')

WS.verifyMatch(actualMenu, menu, true)