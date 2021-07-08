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

String regexDate='(((0[1-9]|[12][0-9]|30)[-\\/]?(0[13-9]|1[012])|31[-\\/]?(0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-\\/]?02)[-\\/]?[0-9]{4}|29[-\\/]?02[-\\/]?([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))'
String regexSolde='\\d+( \\d{3})*(\\.\\d+)?'
String menuYelow100


'Après achat Offre Yelow 100 avec succès , je consulte mon solde en saisissant #359#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode359+'#', numeroInitiateur)

'Vérifier la conformité du menu'
String menu=CustomKeywords.'ussd.Expected.menu'('Votre crédit est de '+regexSolde+' Ar valable jusqu au '+regexDate+'\\.\n1 Mes offres.*$',
	'Ny credit\\-nao dia '+regexSolde+' Ar azonao ampiasaina h@ '+regexDate+'\n1 Mes offres.*$')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 1 (Mes offres) et valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du menu'
menu=CustomKeywords.'ussd.Expected.menu'('^.*Mes offres:\n1.*$')

WS.verifyMatch(actualMenu, menu, true)

menu=CustomKeywords.'ussd.Expected.menu'('^.*YELOW100.*$')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis le rang du menu YELOW100 et valide'
menuYelow100=actualMenu.substring(actualMenu.lastIndexOf('YELOW100')-2,actualMenu.lastIndexOf('YELOW100')-1)
println("tets: "+menuYelow100)
actualMenu=CustomKeywords.'ussd.Send.response'(menuYelow100)

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('YELOW100\n1 Info conso\n00 Page precedente',
	'YELOW100\n1 Info conso\n00 Pejy aloha')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 1 (Info conso) à nouveau et valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('YELOW 100, il vous reste \\d{1,3}\\.\\d SMS et/ou \\d{1,3}\\.\\d Mo utilisable a toute heure\\.',
	'YELOW 100, \\d{1,3}\\.\\d  SMS sy/na \\d{1,3}\\.\\d  Mo sisa ny bonus\\-nao azo ampiasaina @ ora rehetra\\.')

WS.verifyMatch(actualMenu, menu, true)

