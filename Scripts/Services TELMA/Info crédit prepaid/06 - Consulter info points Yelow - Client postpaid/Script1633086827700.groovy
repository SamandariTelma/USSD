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

String numeroPostpaid="${numeroPostpaid}"

'En tant que client TELMA, je vais dans le menu pour Info crédit en composant #130*4*1#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode, numeroPostpaid)

'Je saisis 3 (Info Conso points Yelow) et valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('3')

'Vérifier la conformité du menu'
String menu=CustomKeywords.'ussd.Expected.menu'('Tu totalises \\d{1,4} pt Yelow a ce jour\\. Pour gagner un Smartphone, cumul un max de points en composant le #322\\*77# et profites de tes bonus\\. Telma N1 des bonus\\!')

WS.verifyMatch(actualMenu, menu, true)

