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

String offre = "${offre}"

switch(offre)
{
	case "MORA\\+ 2000" :
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(1,'dd/MM/yyy')
		CustomKeywords.'outStream.XML.setDateBundle'("mora 2000", dateExpiration, "23:59")
	break;
	case "MORA\\+ 5000" :
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(6,'dd/MM/yyy')
		CustomKeywords.'outStream.XML.setDateBundle'("mora 5000", dateExpiration, "23:59")
	break;
	case "MORA NIGHT" :
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(1,'dd/MM/yyy')
		CustomKeywords.'outStream.XML.setDateBundle'("mora night", dateExpiration, "23:59")
	break;
	case 'MORA INTERNATIONAL':
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(1,'dd/MM/yyy')
		CustomKeywords.'outStream.XML.setDateBundle'("mora international", dateExpiration, "23:59")
	break;
	case 'FIRST PREMIUM':
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(29,'dd/MM/yyy')
		CustomKeywords.'outStream.XML.setDateBundle'("first premium", dateExpiration, "23:59")
	break
	case 'FIRST PREMIUM \\+':
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(29,'dd/MM/yyy')
		CustomKeywords.'outStream.XML.setDateBundle'("first premiumPlus", dateExpiration, "23:59")
	break
	case 'FIRST PRESTIGE':
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(29,'dd/MM/yyy')
		CustomKeywords.'outStream.XML.setDateBundle'("first prestige", dateExpiration, "23:59")
	break
	case 'FIRST ROYAL':
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(29,'dd/MM/yyy')
		CustomKeywords.'outStream.XML.setDateBundle'("first royal", dateExpiration, "23:59")
	break
	case "YELOW 200" :
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(1,'dd/MM/yyy') //La date d'expiration est d'une journée à partir de la date actuel
		String heureExpiration=CustomKeywords.'ussd.Util.nextDate'(1,'HH:mm') //L'heure d'expiration est l'heure actuel
		CustomKeywords.'outStream.XML.setDateBundle'("yelow 200", dateExpiration, heureExpiration) //Ecriture de la date et heure d'expiration dans un fichier XML
	break;
	case "YELOW SMS" : 
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(1,'dd/MM/yyy')
		String heureExpiration=CustomKeywords.'ussd.Util.nextDate'(1,'HH:mm')
		CustomKeywords.'outStream.XML.setDateBundle'("yelow sms", dateExpiration, heureExpiration)
	break;
	case "YELOW FACEBOBAKA" :
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(2,'dd/MM/yyy')
		String heureExpiration=CustomKeywords.'ussd.Util.nextDate'(2,'HH:mm')
		CustomKeywords.'outStream.XML.setDateBundle'("yelow facebobaka", dateExpiration, heureExpiration)
	break;
	case "YELOW FACEBOOBAKA ONE" :
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(7,'dd/MM/yyy')
		String heureExpiration=CustomKeywords.'ussd.Util.nextDate'(7,'HH:mm')
		CustomKeywords.'outStream.XML.setDateBundle'("yelow faceboobaka one", dateExpiration, heureExpiration)
	break;
	case "YELOW FACEBOOBAKA +" :
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(14,'dd/MM/yyy')
		String heureExpiration=CustomKeywords.'ussd.Util.nextDate'(14,'HH:mm')
		CustomKeywords.'outStream.XML.setDateBundle'("yelow faceboobaka", dateExpiration, heureExpiration)
	break;
	case "YELOW 1000" :
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(29,'dd/MM/yyy')
		CustomKeywords.'outStream.XML.setDateBundle'("yelow 1000", dateExpiration, "23:59")
	break;
	case "NET ONE WEEK 350 Mo" :
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(6,'dd/MM/yyy')
		CustomKeywords.'outStream.XML.setDateBundle'("net one week 350 Mo", dateExpiration, "23:59")
	break;
	case "NET ONE WEEK 800 Mo" :
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(6,'dd/MM/yyy')
		CustomKeywords.'outStream.XML.setDateBundle'("net one week 800 Mo", dateExpiration, "23:59")
	break;
	case "NET ONE WEEK 2 Go" :
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(6,'dd/MM/yyy')
		CustomKeywords.'outStream.XML.setDateBundle'("net one week 2 Go", dateExpiration, "23:59")
	break;
	case "NET ONE MONTH 2 Go" :
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(29,'dd/MM/yyy')
		CustomKeywords.'outStream.XML.setDateBundle'("net one month 2 Go", dateExpiration, "23:59")
	break;
	case "NET ONE MONTH 4 Go" :
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(29,'dd/MM/yyy')
		CustomKeywords.'outStream.XML.setDateBundle'("net one month 4 Go", dateExpiration, "23:59")
	break;
	case "NET ONE MONTH 12 Go" :
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(29,'dd/MM/yyy')
		CustomKeywords.'outStream.XML.setDateBundle'("net one month 12 Go", dateExpiration, "23:59")
	break;
	case "NET ONE MONTH 25 Go" :
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(29,'dd/MM/yyy')
		CustomKeywords.'outStream.XML.setDateBundle'("net one month 25 Go", dateExpiration, "23:59")
	break;
	case "NET ONE MONTH 50Go" :
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(29,'dd/MM/yyy')
		CustomKeywords.'outStream.XML.setDateBundle'("net one month 50 Go", dateExpiration, "23:59")
	break;
	case "NET ONE MONTH 100Go" :
		String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(29,'dd/MM/yyy')
		CustomKeywords.'outStream.XML.setDateBundle'("net one month 100 Go", dateExpiration, "23:59")
	break;
}