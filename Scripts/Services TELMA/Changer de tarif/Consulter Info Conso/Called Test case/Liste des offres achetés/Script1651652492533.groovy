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

String offre ="${offre}"
String actualMenu="${actualMenu}"

String rangMenu

'Vérifier si l\'offre apparait dans la liste offre'
switch(offre)
{	
	case "FIRST PREMIUM" :
		return rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('FIRST PREMIUM\n', actualMenu)
		break;
	case "YELOW100":
		return rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('YELOW100', actualMenu)
		break;
	case "YELOW 200":
		return rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('YELOW 200', actualMenu)
		break;
	case "YELOW SMS":
		return rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('YELOW SMS', actualMenu)
		break;
	case "YELOW FACEBOOBAKA":
		return rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('YELOW FACEBOOBAKA', actualMenu)
		break;
	case "YELOW FACEBOOBAKA ONE":
		return rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('YELOW FACEBOOBAKA ONE', actualMenu)
		break;
	case "YELOW FACEBOOBAKA \\+":
		return rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('YELOW FACEBOOBAKA \\+', actualMenu)
		break;
	case "YELOW 1000":
		return rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('YELOW 1000', actualMenu)
		break;
	case "YELOW ONE":
		return rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('YELOW ONE', actualMenu)
		break;
	case "NET ONE WEEK 2 Go" :
		return rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('NET ONE WEEK 2Go', actualMenu)
		break;
	case "NET ONE MONTH 2 Go" :
		return rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('NET ONE MONTH 2 Go', actualMenu)
		break;
	case "NET ONE MONTH 4 Go" :
		return rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('NET ONE MONTH 4 Go', actualMenu)
		break;
	case "NET ONE MONTH 12 Go" :
		return rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('NET ONE MONTH 12 Go', actualMenu)
		break;
	case "NET ONE MONTH 25 Go" :
		return rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('NET ONE MONTH 25 Go', actualMenu)
		break;
	case "NET ONE MONTH 50Go" :
		return rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('NET ONE MONTH 50Go', actualMenu)
		break;
	case "NET ONE MONTH 100Go" :
		return rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('NET ONE MONTH 100Go', actualMenu)
		break;
	default :
		return rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'(offre, actualMenu)
}
