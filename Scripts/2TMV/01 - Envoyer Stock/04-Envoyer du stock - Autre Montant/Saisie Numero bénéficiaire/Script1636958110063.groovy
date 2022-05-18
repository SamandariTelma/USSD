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

String numeroEnvoyeur="${numeroEnvoyeur}"
String pinEnvoyeur="${pinEnvoyeur}"

'En tant que MSISDN grossiste, je compose le *130*2#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'#', numeroEnvoyeur)

'Je clique sur 3 Envoyer du stock et je valide'
CustomKeywords.'ussd.Send.response'('3')

'Je saisis 1 (Autre montant) et je valide'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis un montant entre 10 000 à 10 000 000 Ar et je valide :'
String actualMenu=CustomKeywords.'ussd.Send.response'('18000')

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Envoyer au No :','Alefa amin\'ny No :')

WS.verifyMatch(actualMenu, menu, true)


'Je saisis un numero invalide autre que Telma'
actualMenu=CustomKeywords.'ussd.Send.response'('0330000000')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Verifier le numero de telephone SVP', 'Nomerao tsy manankery')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un numero non Telma'
actualMenu=CustomKeywords.'ussd.Send.response'('0326848017')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Verifier le numero de telephone SVP', 'Nomerao tsy manankery')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis pour la 3è fois un numero invalide'
actualMenu=CustomKeywords.'ussd.Send.response'('0326848017')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Le nombre d essai maximum est atteint','Mihaotra ny fanandramana azo ekena\\.')

WS.verifyMatch(actualMenu, menu, true)

