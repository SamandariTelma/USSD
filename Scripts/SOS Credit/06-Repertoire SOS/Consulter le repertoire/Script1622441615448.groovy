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

String numeroAjoute="${numeroAjoute}"

'En tant que client TELMA, je vais dans le menu repertoire SOS en composant le #111# > 3 > 4 >3'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodde+'*4*3#', numeroInitiateur)

'Je saisis 3 et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('3')

String menu=CustomKeywords.'ussd.Expected.menu'('^.*Les numéros autorisés à rembourser mes SOS :.*$', 
	'^.*Ny lisitr ireo laharana afaka mamerina ny SOS nao :.*$')

'Vérifier la conformité du repertoire'
WS.verifyMatch(actualMenu, menu, true)

numeroAjoute=CustomKeywords.'ussd.Util.to034'(numeroAjoute)
'Vérifier que les numéros que je viens d\'ajouter exite dans la liste'
WS.verifyMatch(actualMenu, '^.*'+numeroAjoute+'.*$', true)