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

'En tant que client TELMA, je vais dans le menu pour Récupérer mon numéro en composant #130*4#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeTELMA, numeroInitiateur)
String actualMenu=CustomKeywords.'ussd.Send.response'('4')

'Vérifier la présence du menu Récupérer mon numéro'
String menu= CustomKeywords.'ussd.Expected.menu'('Services TELMA\n1 Info credit\n2 Recharge\n3 Gerer Friends and Family\n4 Envoyer Credit/Offre/Mega\n5 Ajouter des jours de validite\n0 Page suivante', '^.*0 Pejy manaraka*.$')

WS.verifyMatch(actualMenu, menu, true)

         