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

String numeroInitiateur = "${numeroInitiateur}"
String numeroARecuperer = "${numeroARecuperer}"

'Je shortcode #130*4*9#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis le numéro à recupérer'
String actualMenu=CustomKeywords.'ussd.Send.response'(numeroARecuperer)

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Entrer votre numéro de pièce d\'identité choisi pour Mvola:')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un numero de pièce d\'identité contenant contenant un alphabet'
actualMenu=CustomKeywords.'ussd.Send.response'('123456s85412')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Veuillez verifier le numero de la piece d identite SVP ', 'Hamarino ny laharan ny karatra azafady')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un numéro inférieur à 12 chiffres'
actualMenu=CustomKeywords.'ussd.Send.response'('12')

'Vérifier que je reste sur le prompt précédent'
menu=CustomKeywords.'ussd.Expected.menu'('Veuillez verifier le numero de la piece d identite SVP ', 'Hamarino ny laharan ny karatra azafady')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un numéro cin avec caractère spéciaux '
actualMenu=CustomKeywords.'ussd.Send.response'('12345678903@')

'Vérifier que je reste sur le prompt précédent'
menu=CustomKeywords.'ussd.Expected.menu'('Veuillez verifier le numero de la piece d identite SVP ', 'Hamarino ny laharan ny karatra azafady')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un troisième tentative de numero au mauvais format'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('Nombre d\'essai maximum atteint\\.','Mihaotra ny fanandramana azo ekena')
