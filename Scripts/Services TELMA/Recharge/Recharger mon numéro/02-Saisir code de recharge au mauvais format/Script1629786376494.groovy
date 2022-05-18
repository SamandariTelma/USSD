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

String numeroInitiateur= "${numeroInitiateur}"

'En tant que client TELMA, je vais dans le menu pour Recharger mon numéro en composant #130*4*2#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'#', numeroInitiateur)

'Je saisis 1 (Recharger mon compte)'
String actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du prompt'
String menu= CustomKeywords.'ussd.Expected.menu'('Entrer code recharge :','Kaodin ny fahana :')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un code de recharge au mauvais format (Alphanumérique)'
actualMenu=CustomKeywords.'ussd.Send.response'('abcd123')

'Vérifer la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Verifier le code de la recharge :', 'Hamarino ny laharan\'ny fahana azafady:')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un code de recharge au mauvais format (Avec caractère speciaux)'
actualMenu=CustomKeywords.'ussd.Send.response'('@-/152')

'Vérifer la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Verifier le code de la recharge :', 'Hamarino ny laharan\'ny fahana azafady:')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un code de recharge au mauvais format  inférieur à 8 chiffres'
actualMenu=CustomKeywords.'ussd.Send.response'('123456')

'Vérifer la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Verifier le code de la recharge :', 'Hamarino ny laharan\'ny fahana azafady:')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un code de recharge au mauvais format  supérieur à 20 chiffres'
actualMenu=CustomKeywords.'ussd.Send.response'('12345678989465456465464668')

'Vérifer la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Le nombre d\'essai maximum a ete atteint\\.','Mihaotra ny fanandramana azo ekena\\.')

WS.verifyMatch(actualMenu, menu, true)