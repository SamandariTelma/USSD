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

String numeroARembourser=GlobalVariable.msisdnRecepteur

String montantARembourser=GlobalVariable.montantARembourser

String moitieARembourser=((montantARembourser.toInteger())/2).toString()

GlobalVariable.montantARembourser=moitieARembourser

'En tant que client TELMA, je vais dans le menu pour SOS Crédit en composant le #111# > 3, puis je sasis 4 et je valide'

CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*4#', GlobalVariable.msisdnInitiateur)

'Je saisis 2 et je valide'

String actualMenu=CustomKeywords.'ussd.Send.response'('2')

String menu=CustomKeywords.'ussd.Expected.menu'('Entrer le numéro du tiers :', 'Ampidiro ny laharan ny nomerao :')

'Vérifier la conformité du prompt'

WS.verifyMatch(actualMenu, menu, true)

'Je saisis le numéro auquel je rembourse du SOS crédit via MVola et je valide'

actualMenu=CustomKeywords.'ussd.Send.response'(numeroARembourser)
String regexDate='(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}'
menu=CustomKeywords.'ussd.Expected.menu'('Le numéro '+numeroARembourser+' doit rembourser '+montantARembourser+' Ar avant le '+regexDate+'\\. Entrer le montant du SOS à rembourser :', 
	'Ny laharana '+numeroARembourser+' dia tokony hamerina '+montantARembourser+' Ar alohan ny '+regexDate+'\\. Ampidiro ny saran ny SOS averina : ')

'Vérifier la conformité du prompt'

WS.verifyMatch(actualMenu, menu, true)

'Je saisis la moitié du montant à rembourser'

actualMenu=CustomKeywords.'ussd.Send.response'(moitieARembourser)

menu=CustomKeywords.'ussd.Expected.menu'('Pour confirmer le transfert immediat de '+moitieARembourser+' Ar pour rembourser une partie de son SOS, entrer code secret MVola :', 
	'Raha hanamarina ny fandefasana '+moitieARembourser+' Ar ho famerenana ny ampahan ny SOS, ampidiro ny code secret Mvola')

WS.verifyMatch(actualMenu, menu, true)

'Saisir le code secret MVola puis valide'

actualMenu=CustomKeywords.'ussd.Send.response'(GlobalVariable.pinMsisdnInitiateur)

menu=CustomKeywords.'ussd.Expected.menu'('Vous avez transferé '+moitieARembourser+' Ar pour rembourser une partie du SOS du '+numeroARembourser+'\\.', 'Namindra '+moitieARembourser+' Ar ho famerenana ny ampahan ny SOS ho an ny laharana '+numeroARembourser+' ianao\\.')

WS.verifyMatch(actualMenu, menu, true)






