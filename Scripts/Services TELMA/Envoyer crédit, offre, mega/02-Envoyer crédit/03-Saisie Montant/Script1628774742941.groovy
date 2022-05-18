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

'Je shortcode #130*4*4#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'#', numeroInitiateur)

'Je saisis 1 (Envoyer du credit) et valide'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis un montant < 500 ar et je valide = 499'
String actualMenu=CustomKeywords.'ussd.Send.response'('499')

'Vérifier la conformité du prompt'
String menu= CustomKeywords.'ussd.Expected.menu'('Montant incorrect\\. Veuillez entrer un montant entre 500 Ar et 200 000 Ar', 
	'Diso ny sandam\\-bola\\. Ampidiro ny sanda eo anelanelan ny 500 Ar sy 200 000 Ar')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un montant > 200 000 Ar et je valide = 200 001'
actualMenu=CustomKeywords.'ussd.Send.response'('200 001')

'Vérifier la conformité du prompt'
menu= CustomKeywords.'ussd.Expected.menu'('Montant incorrect\\. Veuillez entrer un montant entre 500 Ar et 200 000 Ar',
	'Diso ny sandam\\-bola\\. Ampidiro ny sanda eo anelanelan ny 500 Ar sy 200 000 Ar')

WS.verifyMatch(actualMenu, menu, true)
