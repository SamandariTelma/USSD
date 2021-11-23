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
String codeRecharge="${codeRecharge}"
String montantRecharge="${montantRecharge}"

'En tant que client TELMA, je vais dans le menu pour Recharge en composant #130*4# > 2'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 2 (Recharger un autre numéro)'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis correctement un numéro MSISDN valide et je valide'
String numeroBeneficiarie=CustomKeywords.'ussd.Util.to034'(numeroRecepteur)
CustomKeywords.'ussd.Send.response'(numeroBeneficiarie)

'Je saisis correctement le code de recharge et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'(codeRecharge)

'Vérifier la conformtité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Vous avez depasse le nombre de transactions gratuites de la journee\\. Votre demande sera maintenant facturee\\.  Continuer\\?\n0 Non\n1 Oui',
	'Nihoatra ny isa tsy andoavambola ny fijerena ny abin ny volanao\\. Misy sarany ity fangatahana ity manomboka izao\\. Tohizana\\?\n0 Tsia\n1 Eny')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 0 pour annuler'
actualMenu=CustomKeywords.'ussd.Send.response'('0')

'Vérifier la conformité du prompt'
WS.verifyMatch(actualMenu, 'null', false)


