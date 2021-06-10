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

'En tant que client TELMA je me rends sur le menu SOS Credit à TELMA en composant le short code #111# > 3 > 2'
String actualMenu = CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode + '*3*2#', GlobalVariable.msisdnInitiateur)

String menuFr = '^Votre demande n\'a pas abouti\\. Vous devez rembourser le precedent SOS bundle a TELMA\\. Il vous reste (\\d+(,\\d{1,3})?) Ar a rembourser\\.$'

String menuMg = '^Tsy tontosa ny fangatahanao\\. Tokony halohanao aloha ny fangatahana SOS bundle tam TELMA\\. (\\d+(,\\d{1,3})?) Ar sisa no tokony halohanao\\.$'

String menu = CustomKeywords.'ussd.Expected.menu'(menuFr, menuMg)

WS.verifyMatch(actualMenu, menu, true)
