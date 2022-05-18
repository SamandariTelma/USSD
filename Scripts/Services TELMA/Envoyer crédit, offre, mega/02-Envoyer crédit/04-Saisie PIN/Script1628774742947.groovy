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
String montantAEnvoyer="${montantAEnvoyer}"
String numeroRecepteur="${numeroRecepteur}"

'Je shortcode #130*4*4#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'#', numeroInitiateur)

'Je saisis 1 (Envoyer du credit) et valide'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis un montant correct et je valide'
CustomKeywords.'ussd.Send.response'(montantAEnvoyer)

numeroRecepteur=CustomKeywords.'ussd.Util.to034'(numeroRecepteur)
'Je saisis le numéro du benéficiaire'
CustomKeywords.'ussd.Send.response'(numeroRecepteur)

'Je saisis un PIN au format incorrect (alphanumerique) et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('000o')

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Le code secret doit comporter 4 chiffres\\.', 
	'Hamarino ny kaody miafina \\(tarehimarika 4\\)\\.')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un PIN au format incorrect (moins de 4 chiffres) et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('000')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Le code secret doit comporter 4 chiffres\\.',
	'Hamarino ny kaody miafina \\(tarehimarika 4\\)\\.')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un mauvais pin (au bon format)'
actualMenu=CustomKeywords.'ussd.Send.response'('8624')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Le code secret saisi est incorrect. Ref: \\d{1,9}',
	'Diso ny kaodinao. Ref: \\d{1,9}')

WS.verifyMatch(actualMenu, menu, true)

