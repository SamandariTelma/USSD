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

'En tant que GP, j\'effectue mon offre NET One Month 2,5Go :  *611*80#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeDirectAchat+'*80#', numeroInitiateur)

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Votre achat de NET ONE MONTH 2,5 Go est reussi\\. Vous avez 2,5 Go de DATA utilisable a toute heure\\. Achetez via Mvola et gagnez 20% de bonus \\(#111\\*1#\\)\\.',
	'Tafiditra ny tolotra NET ONE MONTH 2,5 Go novidianao\\. Manana 2,5 Go azo ampiasaina @ ora rehetra ianao\\. Vidio @Mvola ny tolotra ary mahazoa bonus 20%\\. \\(#111\\*1#\\)\\.')

WS.verifyMatch(actualMenu, menu, true)
