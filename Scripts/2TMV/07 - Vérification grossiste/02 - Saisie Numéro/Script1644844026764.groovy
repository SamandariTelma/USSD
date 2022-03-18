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
String pinInitateur="${pinInitateur}"

'Je shortcode *130*2*8# pour acceder au menu Vérification grossiste'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*8#', numeroInitiateur)

'Je saisi le code pin de mon numéro 2tmv'
String actualMenu=CustomKeywords.'ussd.Send.response'(pinInitateur)

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Entrer le numero du PDV:', 'Entrer le numero du PDV :')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un numéro non Telma'
actualMenu=CustomKeywords.'ussd.Send.response'('0325785400')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Veuillez verifier le numero Tel \\(034xxxxxxx ou 038xxxxxxx\\):', 'Hamarino ny laharan\'ny finday \\(034xxxxxxx na 038xxxxxxx\\):')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un numéro Telma au mauvais format'
actualMenu=CustomKeywords.'ussd.Send.response'('261346848017')

'Vérifier la conformité du prompt'
WS.verifyMatch(actualMenu, menu, true)

'Je saisis un numéro Telma avec un caractère spéciaux'
actualMenu=CustomKeywords.'ussd.Send.response'('034003081p')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Le nombre d essai maximum est atteint', 'Mihaotra ny fanandramana azo ekena\\.')

WS.verifyMatch(actualMenu, menu, true)
