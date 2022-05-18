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

String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(14,'dd/MM/yyy')

String heureExpiration=CustomKeywords.'ussd.Util.nextDate'(14,'HH:mm')

'En tant que GP, j\'effectue mon offre YELOW faceboobaka + :  *611*68#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeDirectAchat+'*68#', numeroInitiateur)

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('YELOW FACEBOOBAKA\\+ : vous avez 2 Go pour acceder a vos videos et photos sur Instagram et Facebook pendant 7 jours pour 2000 Ar\\. En profiter\\? 1\\-OUI; 0\\-NON',
	'YELOW FACEBOOBAKA \\+: Manana 2 Go ianao ahafahana mampiasa Instagram sy Facebook, manan\\-kery 7 andro @ sarany 2000 Ar\\. Hanararaotra\\? 1\\-ENY ; 0\\-TSIA')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 1 (OUI)'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('L achat du YelowFacebobaka\\+ est reussi\\.Bonus restants:#359#\\.Achats et consultation bonus SIMPLE& RAPIDE via l app Telma&Moi\\.\\+Bonus Kadoa 20% si achat via MVola',
	'Tafiditra ny YelowFacebobaka\\+\\. Bonus-nao:#359#\\.Haingana sy tsotra ny mividy tolotra sy mijery bonus @alalan ny app Telma&Moi\\.\\+Bonus Kadoa 20% raha vidiana @MVola')

WS.verifyMatch(actualMenu, menu, true)

CustomKeywords.'outStream.XML.setDateBundle'("yelow faceboobaka", dateExpiration, heureExpiration)