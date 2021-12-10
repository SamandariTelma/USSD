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

String numeroInitiateur = "$numeroInitiateur"

String numeroRecepteur = "$numeroRecepteur"

String montantAEnvoyer = "$montantAEnvoyer"

String pinNumeroInitiateur = "$pinNumeroInitiateur"

String frais = "$frais"

'J\'envoie du crédit à un numéro invalide'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodeDirect+'*'+montantAEnvoyer+'*'+numeroInitiateur+'*1939#', numeroInitiateur)

'Vérifier la conformité du message'
String menu= CustomKeywords.'ussd.Expected.menu'('Votre code secret est incorrect\\. Ref : \\d{1,10}',
	'Diso ny kaodinao\\. Ref : \\d{1,10}')

WS.verifyMatch(actualMenu, menu, true)

'J\'envoie du crédit à un numéro en laissant vide le PIN'
actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodeDirect+'*'+montantAEnvoyer+'*261346848017*#', numeroInitiateur)

'Vérifier la confromité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Pour transferer du credit composez #311\\*montant\\*numero TELMA MOBILE\\*code secret#',
	'Raha handefa fahana dia tsindrio ny #311\\*Sandan\'ny fahana\\*laharana TELMA\\*Kaody miafina#')

WS.verifyMatch(actualMenu, menu, true)



