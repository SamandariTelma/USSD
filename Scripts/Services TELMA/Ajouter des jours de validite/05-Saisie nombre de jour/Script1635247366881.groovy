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

'Je shortcode #130*4*5#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+"#", numeroInitiateur)

'Je saisis 1 (Acheter des jours de validite) et valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Entrez nombre de jours a acheter', 'Isan\'ny andro hovidiana')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 0 et valide'
actualMenu=CustomKeywords.'ussd.Send.response'('0')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Saisie incorrecte, veuiller entrer un nombre entre 1 et 100', 'diso ny tarehimarika, ampidiro ny isa eo anelanelan\'ny  1 sy  100')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 101 et valide'
actualMenu=CustomKeywords.'ussd.Send.response'('101')

'Vérifier la conformité du prompt'
WS.verifyMatch(actualMenu, menu, true)

'Je saisis un nombre différent de 1 à 100 (3ème tentative)'
actualMenu=CustomKeywords.'ussd.Send.response'('200')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Nombre d\'essai maximum atteint\\. Veuillez réessayer plus tard\\.', 'Mihaotra ny fanandramana azo ekena\\.')

WS.verifyMatch(actualMenu, menu, true)
