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

String numeroDejaRepertorie="${numeroDejaRepertorie}"

'En tant que client TELMA, je vais dans le menu repertoire SOS en composant le #111# > 3 > 4 >3'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodde+'*4*3#', numeroInitiateur)

'Je saisis 1 et je valide'
CustomKeywords.'ussd.Send.response'('1')

numeroDejaRepertorie=CustomKeywords.'ussd.Util.to034'(numeroDejaRepertorie)
'Je rentre le numéro qui existe déjà dans le repertoire et je valide'
CustomKeywords.'ussd.Send.response'(numeroDejaRepertorie)

'Je saisis mon code secret MVola et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'(pinMsisdnInitiateur)


String menu=CustomKeywords.'ussd.Expected.menu'('^Le numero '+numeroDejaRepertorie+' \\(.{1,50}\\) a deja ete enregistre dans votre repertoire SOS\\.$', 
	'^Ny laharana  '+numeroDejaRepertorie+' \\(.{1,50}\\) dia efa ao anatin ny listr ireo olona afaka mamerina ny SOS nataona\\.$')

'Vérifier la conformité du message'
WS.verifyMatch(actualMenu, menu, true)