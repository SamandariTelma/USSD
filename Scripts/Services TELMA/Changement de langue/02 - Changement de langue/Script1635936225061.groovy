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

'En tant que client TELMA, je vais dans le menu pour Changement de langue en composant #130*4#'

CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeTELMA, numeroInitiateur)

CustomKeywords.'ussd.Send.response'('5')

'Je saisis 8 (Changement de Langue) et valide'
CustomKeywords.'ussd.Send.response'('8')

'Je saisis 1 pour choirsir la langue et valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('Tafita soa aman-tsara ny fanovana fiteny\\.', 'Votre langue a ete modifiee avec succes')

WS.verifyMatch(actualMenu, menu, true)

//Changer le paramètre langue
if(GlobalVariable.langue.equals('fr'))
	GlobalVariable.langue='mg'
else
	GlobalVariable.langue='fr'