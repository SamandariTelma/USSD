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

String menuYelowAAcherter="${menuYelowAAcherter}"

'Je shortcode #111*4*6#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'#', numeroInitiateur)

'Je saisis 3 (YELOW (SMS - INTERNET)) et valide'
CustomKeywords.'ussd.Send.response'('3')

'Je choisis un menu quelconque'
String actualMenu=CustomKeywords.'ussd.Send.response'(menuYelowAAcherter)

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Votre credit est insuffisant pour le changement d\'offre que vous demandez\\.', 'Tsy ampy ny fahana anananao raha hiova io tolotra nangatahanao io ianao\\.')

WS.verifyMatch(actualMenu, menu, true)