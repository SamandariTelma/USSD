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

'En tant que client TELMA, je vais dans mon USSD en composant le short code #111#'

String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeTELMA, numeroInitiateur)

'Vérifier l\'apparition du menu \'Mon identité\''

String menu=CustomKeywords.'ussd.Expected.menu'('^.*Mon identite.*$')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 8 (Mon identite) et je valide'

actualMenu=CustomKeywords.'ussd.Send.response'('8')

'Vérifier la conformité des menus Mon identité'

menu=CustomKeywords.'ussd.Expected.menu'('1 Renseigner mon identite\n2 Mon identite enregistre')

WS.verifyMatch(actualMenu, menu, true)