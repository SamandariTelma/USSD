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

'En tant que client TELMA je me rends sur le menu SOS Offre à TELMA en composant le short code #111# > 3 > 3'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'*3#', numeroInitiateur)


'Je saisis 1 pour l\'offre MORA'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis 3 (MORA 500)'
CustomKeywords.'ussd.Send.response'('3')

'Confirmer le SOS offre pour MORA 500 en saisissant 1'
String actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformtité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Votre demande est en cours de traitement, vous allez recevoir un sms', 'Eo ampanatontosaina ny fangatahanao izahay, hahavoaray sms ianao\\.')

WS.verifyMatch(actualMenu, menu, true)