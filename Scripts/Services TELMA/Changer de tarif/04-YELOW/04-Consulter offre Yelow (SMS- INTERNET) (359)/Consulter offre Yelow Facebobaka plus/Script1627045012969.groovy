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

String dateExpiration=CustomKeywords.'outStream.XML.getDateBundle'("yelow faceboobaka")//CustomKeywords.'ussd.Util.nextDate'(14,'dd/MM/yyy HH:mm')
String heureExpiration=CustomKeywords.'outStream.XML.getTimeBundle'("yelow faceboobaka")

'Après achat Offre FACEBOOBAKA + avec succès , je consulte mon solde en saisissant #359#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCodde359+'#', numeroInitiateur)

'Je saisis 1 (Mes offres) et valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier si l\'offre apparait dans la liste offre'
String rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('YELOW FACEBOOBAKA +', actualMenu)

'Je saisis le rang du menu YELOW FACEBOBAKA + et valide'
actualMenu=CustomKeywords.'ussd.Send.response'(rangMenu)

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('YELOW FACEBOOBAKA \\+\n1 Info conso\n00 Page precedente',
	'YELOW FACEBOOBAKA \\+\n1 Info conso\n00 Pejy aloha')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 1 (Info conso) à nouveau et valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('Bonus YELOW FACEBOOBAKA \\+ : 2048\\.0 Mo utilisable toute la journee valable jusqu au '+dateExpiration+' a '+heureExpiration+' inclus\\.',
	'Bonus YELOW FACEBOOBAKA \\+ : 2048\\.0 Mo azo ampiasaina ny tontolo andro ampiasaina  hatramin ny '+dateExpiration+' @ '+heureExpiration+'\\.')

WS.verifyMatch(actualMenu, menu, true)

