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

String montant = "${montant}"
String offre ="${offre}"
String volumeData = "${volumeData}"
String groupeOffre ="${groupeOffre}"

String numeroInitiateur="${numeroInitiateur}"
String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(6,'dd/MM/yyy')

offre = CustomKeywords.'ussd.Util.escapeCharRegex'(offre)

'Après achat Offre TELMA avec succès , je consulte mon solde en saisissant #359#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode359+'#', numeroInitiateur)

'Je saisis 1 (Mes offres) et valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

String rangMenu
'Vérifier si l\'offre apparait dans la liste offre'
switch(offre)
{
	case "NET ONE WEEK 2 Go" :
		rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('NET ONE WEEK 2Go', actualMenu)
		break;
	case "NET ONE WEEK 2 Go" :
		rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('NET ONE WEEK 2Go', actualMenu)
		break;
	case "NET ONE MONTH 2 Go" :
		rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('NET ONE MONTH 2Go', actualMenu)
		break;
	case "NET ONE MONTH 4 Go" :
		rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('NET ONE MONTH 4Go', actualMenu)
		break;
	case "NET ONE MONTH 12 Go" :
		rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('NET ONE MONTH 12Go', actualMenu)
		break;
	case "NET ONE MONTH 25 Go" :
		rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('NET ONE MONTH 25Go', actualMenu)
		break;
	case "NET ONE MONTH 50 Go" :
		rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('NET ONE MONTH 50Go', actualMenu)
		break;
	case "NET ONE MONTH 100 Go" :
		rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('NET ONE MONTH 100Go', actualMenu)
		break;
	default :
		rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'(offre, actualMenu)
}

'Je saisis le rang du menu et valide'
actualMenu=CustomKeywords.'ussd.Send.response'(rangMenu)

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('NET ONE WEEK 1Go\n1 Info conso\n00 Page precedente',
	'NET ONE WEEK 1Go\n1 Info conso\n00 Pejy aloha')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 1 (Info conso) à nouveau et valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du message'
menu=CustomKeywords.'ussd.Expected.menu'('NET ONE WEEK 1 Go, il vous reste 1024\\.0 Mo utilisable a toute heure jusqu au '+dateExpiration+' inclus\\.',
	'NET ONE WEEK 1 Go, 1024\\.0  Mo sisa ny bonus\\-nao azo ampiasaina @ ora rehetra hatramin ny '+dateExpiration+'\\.')

WS.verifyMatch(actualMenu, menu, true)