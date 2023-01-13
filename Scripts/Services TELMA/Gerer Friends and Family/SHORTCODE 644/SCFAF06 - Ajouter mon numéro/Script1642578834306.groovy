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

String numeroInitiateur = "$numeroInitiateur"
String numeroAAjouter=CustomKeywords.'ussd.Util.to034'(numeroInitiateur)

'En tant que GP, je shortCode  *644*1*MSISDN# pour ajouter mon numéro *644*1*monNumero#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodeDirect + '*1*'+numeroAAjouter+'#', numeroInitiateur)

'Vérifier la conformité du messsage'
String menu=CustomKeywords.'ussd.Expected.menu'('Impossible de vous ajouter vous meme dans votre propre liste Friends & Familly', 
	'Tsy azonao ampidirina anaty lisitra Friends & Family ny nomeraonao')

WS.verifyMatch(actualMenu, menu, true)

