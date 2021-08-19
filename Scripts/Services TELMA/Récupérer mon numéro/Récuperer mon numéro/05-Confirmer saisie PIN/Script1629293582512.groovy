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
String cinNumARecuperer = "${cinNumARecuperer}"
String pinNumARecuperer = "${pinNumARecuperer}"

'Je shortcode #130*4*9#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis le numéro à recupérer'
CustomKeywords.'ussd.Send.response'(numeroARecuperer)

'Je saisis un numero de pièce d\'identité contenant contenant un alphabet'
CustomKeywords.'ussd.Send.response'(cinNumARecuperer)

'Je saisis un PIN valide'
actualMenu=CustomKeywords.'ussd.Send.response'(pinNumARecuperer)

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Pour confirmer la recuperation du numero '+numeroARecuperer+' a partir de cette SIM, entrer le code secret Mvola '+numeroARecuperer+':')
WS.verifyMatch(actualMenu, menu, true)

'Je saisis un pin au mauvais format (alhanumerique)'
actualMenu=CustomKeywords.'ussd.Send.response'('000a')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Le code secret doit comporter 4 chiffres\\.', 'Hamarino ny kaody miafina \\(tarehimarika 4\\)\\.')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis à nouveau un pin au mauvais format (moins de 4 chiffres)'
String actualMenu=CustomKeywords.'ussd.Send.response'('000')

'Vérifier que je reste sur le même prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Le code secret doit comporter 4 chiffres\\.', 'Hamarino ny kaody miafina \\(tarehimarika 4\\)\\.')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis à nouveau un pin au mauvais format (plus de 4 chiffres)'
String actualMenu=CustomKeywords.'ussd.Send.response'('00000')

'Vérifier que je reste sur le même prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Le code secret doit comporter 4 chiffres\\.', 'Hamarino ny kaody miafina \\(tarehimarika 4\\)\\.')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis à nouveau un pin au mauvais format (dernier tentative)'
String actualMenu=CustomKeywords.'ussd.Send.response'('00000')

'Vérifier que je reste sur le même prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Le nombre d\'essai maximum a été atteint\\.', 'Mihaotra ny fanandramana azo ekena')

WS.verifyMatch(actualMenu, menu, true)