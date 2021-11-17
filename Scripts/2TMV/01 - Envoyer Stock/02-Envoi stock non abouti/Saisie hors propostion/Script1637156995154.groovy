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

String numeroGrossiste="${numeroGrossiste}"
String numeroRevendeur="${numeroRevendeur}"
String numeroANotifier="${numeroANotifier}"
String pinGrossiste="${pinGrossiste}"

'En tant que MSISDN grossiste [0346849414], je compose le *130*129*5#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode, numeroGrossiste)

'Je compose le 2 et je valide'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis un menu qui n\'existe pas'
String actualMenu=CustomKeywords.'ussd.Send.response'('12')

'Vérifier que je reviens sur les menus 2tmv'
String menu=CustomKeywords.'ussd.Expected.menu'('2Toi a Moi vaovao\n1 Envoyer du stock\n2 Consultation du solde\n3 Consultation du bonus\n4 Ventes d\'hier\n5 Changer code secret\n6 Hisafidy fiteny')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 1 Envoyer du stock et je valide'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis un numero en dehors du menu stock proposé et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('10')

'Vérifier que je reviens sur la liste des stock'
menu=CustomKeywords.'ussd.Expected.menu'('Stock\n1 Autre montant\n2 Envoyer 10 000 Ar\n3 Envoyer 20 000 Ar\n4 Envoyer 50 000 Ar\n5 Envoyer 100 000 Ar\n6 Envoyer 500 000 Ar\n7 Envoyer 1 000 000 Ar\n0 Page suivante')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 3 (Envoyer 50 000 Ar) et je valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('3')

'Je saisis correctement le numero du Destinataire [0346847989] qui est revendeur et je valide'
numeroRevendeur=CustomKeywords.'ussd.Util.to034'(numeroRevendeur)
actualMenu=CustomKeywords.'ussd.Send.response'(numeroRevendeur)

'Je saisis 1 (OUI) et valide'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis correctement le numero (0346848239) pour passer le SMS de confirmation et je valide'
numeroANotifier=CustomKeywords.'ussd.Util.to034'(numeroANotifier)
CustomKeywords.'ussd.Send.response'(numeroANotifier)

'Je saisis correctement mon PIN (0000) et je valide'
CustomKeywords.'ussd.Send.response'(pinGrossiste)

'Je saisis un numero différent de 1 et 0 et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('2')

'Vérifier que je reviens sur le prompt de confirmation'
menu=CustomKeywords.'ussd.Expected.menu'('Envoyer 10 000 Ar au '+numeroRevendeur+' \\? No pour SMS de confirmation '+numeroANotifier+'\n1 \\- Oui\n0 \\- Non', 
	'Andefa  10 000 Ar amin\'ny '+numeroRevendeur+' \\?  No pour SMS de confirmation '+numeroANotifier+'\n1 \\- Eny \n0 \\- Tsia')

WS.verifyMatch(actualMenu, menu, true)