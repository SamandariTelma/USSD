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

String numeroAEfface=GlobalVariable.msisdnAAjouter2
'Etand donné que j\'ai déjà supprimé auparavant un numéro FAF, je vais dans le menu Effacer un contact en composant *130*4*3*2#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode+'*2#', GlobalVariable.msisdnInitiateur)

'je supprime un numéro dans ma liste de contact Friends & Family'
String actualMenu=CustomKeywords.'ussd.Send.response'(numeroAEfface)

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Vous pouvez uniquement modifier un numero Friends & Familly par mois\\. Rendez vous au mois prochain !', 
	'Nomerao 1 isam-bolana ihany no azonao ovaina\\. Amin ny manaraka indray mihaona e!')

WS.verifyMatch(actualMenu, menu, true)