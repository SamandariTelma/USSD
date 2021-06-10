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


'En tant que client TELMA je me rends sur le menu SOS Credit à TELMA en composant le short code #111# > 3 > 2'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*2#', GlobalVariable.msisdnInitiateur)

'Choisi un montant en dehors de 1 à 6'
String actualMenu=CustomKeywords.'ussd.Send.response'('10')

String menu=CustomKeywords.'ussd.Expected.menu'('^Repondez par 1 svp ou Annulez$')

'Vérifier la conformité du prompt'
WS.verifyMatch(actualMenu, menu, true)

'Saisir encore un chiffre en dehors de "1-6" 3fois succéssive'
CustomKeywords.'ussd.Send.response'('10')

CustomKeywords.'ussd.Send.response'('10')

actualMenu=CustomKeywords.'ussd.Send.response'('10')

menu=CustomKeywords.'ussd.Expected.menu'('^Le nombre d\'essai maximum est atteint\\.$', '^Mihaotra ny fanandramana azo ekena\\.$')

'Vérifier la conformité du prompt'
WS.verifyMatch(actualMenu, menu, true)