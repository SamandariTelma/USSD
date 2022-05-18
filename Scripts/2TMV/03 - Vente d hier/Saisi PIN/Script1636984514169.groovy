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

'En tant que MSISDN grossiste, je compose le *130*2#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'#', numeroInitiateur)

'Je saisis 5 (Ventes d\'hier) et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('5')

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Entrer code secret :','Kaody miafina :')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un PIN moins de 4 chiffres'
actualMenu=CustomKeywords.'ussd.Send.response'('258')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Le code secret doit comporter 4 chiffres','Kaody miafina tsy manankery')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un PIN qui ne m\'appartient pas'
actualMenu=CustomKeywords.'ussd.Send.response'('5852')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Le code secret saisi est incorrect\\. Ref: \\d{1,10}','Diso ny kaodinao\\. Ref: \\d{1,10}')

WS.verifyMatch(actualMenu, menu, true)
