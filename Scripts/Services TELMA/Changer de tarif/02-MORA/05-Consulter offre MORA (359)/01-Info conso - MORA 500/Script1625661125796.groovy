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


'Après achat Offre MORA 500 avec succès , je consulte mon solde en saisissant #359#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode359+'#', numeroInitiateur)

'Je saisis 1 (Mes offres) et valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier si l\'offre apparait dans la liste offre'
String rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('MORA 500', actualMenu)

'Je saisis le rang du menu MORA 500 et valide'
actualMenu=CustomKeywords.'ussd.Send.response'(rangMenu)

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('MORA 500\n1 Info conso\n2 Etat du renouvellement automatique\n00 Page precedente\n\\*\\* Menu principal',
	'MORA 500\n1 Info conso\n2 Etat du renouvellement automatique\n00 Pejy aloha\n\\*\\* main')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 1 (Info conso) à nouveau et valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('Bonus MORA 500 restants : 500 Ar appels \\+ 10 SMS Telma et/ou 10 Mo valables a toute heure ET BONUS 10\\.0 SMS Telma et/ou 10\\.0 Mo valable la nuit',
	'Bonus MORA 500 : 500 Ar antso \\+ 10 SMS Telma sy/na 10 Mo manankery @ ora rehetra ARY BONUS 10\\.0 SMS Telma sy/na 10\\.0 Mo manankery @alina\\.')

WS.verifyMatch(actualMenu, menu, true)

/*
String actualMenu='Mes offres\n1 MORA ONE\n0 Pejy manaraka'


String rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('MORA 500', actualMenu)

println 'RANG MENU:'+rangMenu

WS.verifyMatch('test', 'test', true)
*/
