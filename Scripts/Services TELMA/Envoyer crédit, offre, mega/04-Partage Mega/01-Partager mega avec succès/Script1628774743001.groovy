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
String numeroRecepteur="${numeroRecepteur}"
String pinEnvoyeur="${pinEnvoyeur}"
//String dateExpiration="${dateExpiration}"
String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(29,'dd/MM/yyy')
'Je shortcode #130*4*4#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode + '#', numeroInitiateur)

'Je saisis 3 (Partager du Mega) et je valide '
String actualMenu=CustomKeywords.'ussd.Send.response'('3')

'Vérifier la conformité du menu'
String menu=CustomKeywords.'ussd.Expected.menu'('^.*BONUS Mega partageable :\n1 NET ONE MONTH 2\\,5Go.*$', '^.*BONUS Mega afaka zaraina :\n1 NET ONE MONTH 2\\,5Go.*$')

WS.verifyMatch(actualMenu, menu, true)
'Je saisis 1 (NET ONE MONTH 2,5Go)'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformtité du menu'
menu=CustomKeywords.'ussd.Expected.menu'('Mega a partager \nIl vous reste \\d{1,5}\\.\\d{1,3} Mo sur votre NET ONE MONTH 2,5Go :\n1 100 Mo\n2 500 Mo\n3 1024 Mo', 
	'Mega zaraina \\d{1,5}\\.\\d{1,3} sisa no ao @ tolotra NET ONE MONTH 2\\,5Go anao\n1 100 Mo\n2 500 Mo\n3 1024 Mo')

WS.verifyMatch(actualMenu, menu, true)

'Je sélectionne un numero parmi la liste et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Entrer numero tel: \\(Saisir 9 pour afficher votre repertoire OU 0 pour choisir l\'un des 3 derniers numeros\\):', 
	'Ampidiro ny numero: \\(Tsindrio ny 9 raha hifidy laharana ao @ reperetoire Mvola anao NA 0 raha hisafidy ny iray @ laharana 3 farany nampiasainao:')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis le numero MSISDN du bénéficiaire et je valide'
numeroRecepteur=CustomKeywords.'ussd.Util.to034'(numeroRecepteur)

actualMenu=CustomKeywords.'ussd.Send.response'(numeroRecepteur)

'Vérifier la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Pour accepter le partage de 100 Mo \\(valable jusqu au '+dateExpiration+'\\) vers  \\('+numeroRecepteur+'\\)\\. Frais: 10 Mo\\. Entrer code secret MVola :', 
	'Hanantontosana ny fandefasana ny 100 Mo \\(azo ampiasaina hatramin ny '+dateExpiration+'\\) any @ \\('+numeroRecepteur+'\\)\\. Frais: 10 Mo\\. Ampidiro ny kaody miafina MVola anao :')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis correctement mon code PIN Mvola et je valide '
actualMenu=CustomKeywords.'ussd.Send.response'(pinEnvoyeur)

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('Votre transaction a reussi, pour enregistrer '+numeroRecepteur+' dans votre repertoire MVola, Entrer le nom correspondant ou ignorer :', 
	'Tontosa ny fandefasanao mega, raha hampiditra ny '+numeroRecepteur+' ao @ repertoire MVola anao ianao dia ampidiro ny anarany :')

'Je saisis un nom pour enregistrer et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('Test1')
