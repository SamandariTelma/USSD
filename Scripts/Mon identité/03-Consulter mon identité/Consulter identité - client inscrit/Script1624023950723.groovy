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

String cinDejaInscrit="${cinDejaInscrit}"

String troisDernierChiffreCIN=cinDejaInscrit.substring(cinDejaInscrit.length()-3)

'En tant que client TELMA, je vais dans le menu pour Mon identité en composant #111 > 8 > 2, et je valide'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*2#', numeroInitiateur)

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Votre compte est Identifie et Certifie MVola\\. Type et numéro de pièce enregistrés : CIN \\*\\*\\*'+troisDernierChiffreCIN+'\\. MVola vous remercie de votre confiance\\.')
//ou L'identification de votre compte est en cours de traitement. Pour plus d'information, contactez le 807.
WS.verifyMatch(actualMenu, menu, true)