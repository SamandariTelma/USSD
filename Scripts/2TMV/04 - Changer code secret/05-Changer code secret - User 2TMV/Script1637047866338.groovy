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
String pinActuel="${pinActuel}"
String nouveauPin="${nouveauPin}"

'En tant que MSISDN grossiste, je compose le *130*2#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'#', numeroInitiateur)

'Je saisis 6 (Changer code secret) et je valide'
CustomKeywords.'ussd.Send.response'('6')

'Je saisis mon code secret actuel et je valide '
CustomKeywords.'ussd.Send.response'(pinActuel)

'Je saisis un nouveau pin'
CustomKeywords.'ussd.Send.response'(nouveauPin)

'Je confirme mon nouveau Pin'
String actualMenu=CustomKeywords.'ussd.Send.response'(nouveauPin)

'Vérifier la conformité du message ussd'
String menu=CustomKeywords.'ussd.Expected.menu'('Votre demande est en cours de traitement','Tontosa ny fanovana kaody miafina')

WS.verifyMatch(actualMenu, menu, true)