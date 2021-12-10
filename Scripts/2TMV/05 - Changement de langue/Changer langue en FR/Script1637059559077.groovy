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

String numeroInitiateur="${numeroInitiateur}"
String pinInitiateur="${pinInitiateur}"

'En tant que MSISDN grossiste, je compose le *130*2#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 7 (Changement de langue) et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('7')

'Vérifier la conformité du menu'
String menu=CustomKeywords.'ussd.Expected.menu'('1 Ho an\'ny teny Frantsay\n2 Ho an\'ny teny Malagasy')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 1 (Ho an\'ny teny Frantsay)'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('kaody miafina :')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un code pin au mauvais format'
actualMenu=CustomKeywords.'ussd.Send.response'('185')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Le code secret doit comporter 4 chiffres')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis correctement mon PIN et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'(pinInitiateur)

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Tontosa ny fanovana fiteny')

WS.verifyMatch(actualMenu, menu, true)

if (GlobalVariable.langue=='mg')
	GlobalVariable.langue='fr'
else if (GlobalVariable.langue=='fr')
	GlobalVariable.langue='mg'