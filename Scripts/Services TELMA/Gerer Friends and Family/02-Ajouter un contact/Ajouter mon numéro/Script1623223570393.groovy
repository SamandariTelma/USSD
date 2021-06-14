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

String monNumero="${monNumero}"

'En tant que client TELMA, je vais dans le menu Gerer Friends and family'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 1 (Ajouter un contact)'
CustomKeywords.'ussd.Send.response'('1')

'J\'ajoute mon numéro en tant que numero Friends and family'
String actualMenu=CustomKeywords.'ussd.Send.response'(monNumero)

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Impossible de vous ajouter vous meme dans votre propre liste Friends & Familly', 
	'Tsy azonao ampidirina anaty lisitra Friends & Family ny nomeraonao')

WS.verifyMatch(actualMenu, menu, true)