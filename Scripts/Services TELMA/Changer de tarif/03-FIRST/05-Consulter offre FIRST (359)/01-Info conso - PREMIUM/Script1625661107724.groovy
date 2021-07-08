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
String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(2,'dd/MM/yyy')

'Après achat Offre FIRST PREMIUM avec succès , je consulte mon solde en saisissant #359#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode359+'#', numeroInitiateur)

'Je saisis 1 (Mes offres) et valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier si l\'offre apparait dans la liste offre'
String rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('FIRST PREMIUM\n', actualMenu)

'Je saisis le rang du menu PREMIUM et valide'
actualMenu=CustomKeywords.'ussd.Send.response'(rangMenu)

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('FIRST PREMIUM \\+\n1 Info conso\n2 Etat du renouvellement automatique\n00 Page precedente',
	'PREMIUM \\+\n1 Info conso\n2 Etat du renouvellement automatique\n00 Pejy aloha')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 1 (Info conso) à nouveau et valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('Bonus FIRST PREMIUM: \\d{1,6} Ar appel national \\+ \\d{1,4} SMS Telma \\+ \\d{1,5}\\.\\d Mo la journee \\+ \\d{1,5}\\.\\d Mo la nuit jusqu au '+dateExpiration+' inclus',
	'Bonus FIRST PREMIUM: \\d{1,6} Ar antso eto M/kara \\+ \\d{1,4} SMS Telma \\+ \\d{1,5}\\.\\d Mo ny tontolo andro \\+ \\d{1,5}\\.\\d Mo ny alina, h@ '+dateExpiration)

WS.verifyMatch(actualMenu, menu, true)
