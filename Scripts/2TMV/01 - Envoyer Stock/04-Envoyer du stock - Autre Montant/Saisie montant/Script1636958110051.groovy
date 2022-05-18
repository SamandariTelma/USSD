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

String numeroGrossiste="${numeroGrossiste}"

'En tant que MSISDN grossiste [0346849414], je compose le *130*2#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'#', numeroGrossiste)

'Je clique sur 1 Envoyer du stock et je valide'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis 1 (Autre montant) et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Montant TTC en Ariary','Sandam-bola Ar TTC')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un montant inférieur à 100 et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('99')

'Vérifier la conformité du prompt'
WS.verifyMatch(actualMenu, menu, true)

'Je saisis un montant supérieur à 10 000 000 Ar et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('10000001')

'Vérifier la conformité du prompt'
WS.verifyMatch(actualMenu, menu, true)

'Je saisis un montant avec caractères spéciaux'
actualMenu=CustomKeywords.'ussd.Send.response'('10,000')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Le nombre d essai maximum est atteint','Mihaotra ny fanandramana azo ekena\\.')

WS.verifyMatch(actualMenu, menu, true)






