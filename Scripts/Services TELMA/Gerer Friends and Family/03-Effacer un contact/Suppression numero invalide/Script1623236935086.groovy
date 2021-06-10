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

'En tant que client TELMA, je vais dans le menu Effacer un contact en composant *130*4*3*2#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*2#', GlobalVariable.msisdnInitiateur)

'Je saisis un numéro au mauvais format'
String actualMenu=CustomKeywords.'ussd.Send.response'('034')

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Verifiez le numero de telephone SVP\\.', 'Hamarino ny nomerao azafady\\.')

WS.verifyMatch(actualMenu, menu, true)

'Je saisi pour la 2ème fois un numéro au mauvais format'
actualMenu=CustomKeywords.'ussd.Send.response'('034blabla')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Verifiez le numero de telephone SVP\\.', 'Hamarino ny nomerao azafady\\.')

WS.verifyMatch(actualMenu, menu, true)

'Je saisi pour la 3ème fois un numéro au mauvais format'
actualMenu=CustomKeywords.'ussd.Send.response'('03400308166')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Verifiez le numero de telephone SVP\\.', 'Hamarino ny nomerao azafady\\.')

WS.verifyMatch(actualMenu, menu, true)

'Je saisi pour la 4ème fois un numéro au mauvais format'
actualMenu=CustomKeywords.'ussd.Send.response'('034003081')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Le nombre d\'essai maximum est atteint\\.', 'Mihaotra ny fanandramana azo ekena\\.')

WS.verifyMatch(actualMenu, menu, true)