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
String numeroRecepteur="${numeroRecepteur}"

'En tant que client TELMA, je vais dans le menu pour Recharge en composant #130*4# > 2'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'#', numeroInitiateur)

'Je saisis 2 (Recharger un autre numéro)'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis correctement un numéro MSISDN valide et je valide'
numeroRecepteur=CustomKeywords.'ussd.Util.to034'(numeroRecepteur)
CustomKeywords.'ussd.Send.response'(numeroRecepteur)

'Je saisis un code de recharge qui n\'existe pas'
actualMenu=CustomKeywords.'ussd.Send.response'('12365478965478')

'Vérifer la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Votre code de recharge est invalide','Tsy manankery ny kaodin\'ny fahana nampidirinao')

WS.verifyMatch(actualMenu, menu, true)