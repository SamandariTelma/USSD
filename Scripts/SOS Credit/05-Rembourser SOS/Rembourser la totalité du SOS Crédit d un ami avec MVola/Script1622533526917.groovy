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

String pinMsisdnInitiateur="${pinMsisdnInitiateur}"

String numeroARembourser="${numeroARembourser}"

String montantARembourser="${montantARembourser}"

'En tant que client TELMA, je vais dans le menu pour SOS Crédit en composant le #111# > 3, puis je sasis 4 et je valide'

CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'*4#', numeroInitiateur)

'Je saisis 2 et je valide'

CustomKeywords.'ussd.Send.response'('2')

'Je saisis le numéro auquel je rembourse du SOS crédit via MVola et je valide'

String actualMenu=CustomKeywords.'ussd.Send.response'(numeroARembourser)
String regexDate='(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}'
String menu=CustomKeywords.'ussd.Expected.menu'('Le numéro '+numeroARembourser+' doit rembourser '+montantARembourser+' Ar avant le '+regexDate+'\\. Entrer le montant du SOS à rembourser :', 
	'Ny laharana '+numeroARembourser+' dia tokony hamerina '+montantARembourser+' Ar alohan ny '+regexDate+'\\. Ampidiro ny saran ny SOS averina : ')

'Vérifier la conformité du prompt'

WS.verifyMatch(actualMenu, menu, true)

'Je saisis le montant à rembourser'

actualMenu=CustomKeywords.'ussd.Send.response'(montantARembourser)

menu=CustomKeywords.'ussd.Expected.menu'('Pour confirmer le transfert immediat de '+montantARembourser+' Ar pour rembourser la totalité de son SOS, entrer code secret MVola :', 
	'Raha hanamarina ny fandefasana '+montantARembourser+' Ar ho famerenana ny SOS offre, ampidiro ny code secret Mvola')

WS.verifyMatch(actualMenu, menu, true)

'Saisir le code secret MVola puis valide'

actualMenu=CustomKeywords.'ussd.Send.response'(pinMsisdnInitiateur)

menu=CustomKeywords.'ussd.Expected.menu'('Vous avez transferé '+montantARembourser+' Ar pour rembourser la totalité du SOS du '+numeroARembourser+'\\.', 'Namindra '+montantARembourser+' Ar ho famerenana ny sandan ny SOS ho an ny laharana '+numeroARembourser+' ianao.')

WS.verifyMatch(actualMenu, menu, true)