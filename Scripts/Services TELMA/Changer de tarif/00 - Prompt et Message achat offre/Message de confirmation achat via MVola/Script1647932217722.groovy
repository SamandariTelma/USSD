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
offre = CustomKeywords.'ussd.Util.escapeCharRegex'(offre)

switch(offre) 
{            
	case "YELOW FACEBOBAKA":
		return CustomKeywords.'ussd.Expected.menu'('Pour confirmer le paiement de l offre '+offre+' a '+montant+' Ar via MVola pour acceder a 400 Mo de forfait Instagram et Facebook , entrer code secret :',
			'Nividy '+offre+' misy 400 Mo Facebook sy Instagram @ vidiny '+montant+' Ar avy @ kaonty MVola nao ianao, ampidiro ny kaody miafinao hanamarina izany :')
	break;
	case "YELOW FACEBOOBAKA \\+":
		return CustomKeywords.'ussd.Expected.menu'('Pour confirmer le paiement de l offre '+offre+' a '+montant+' Ar via MVola pour acceder a 2 Go de forfait Instagram et Facebook , entrer code secret :',
			'Nividy '+offre+' misy 2 Go Facebook sy Instagram @ vidiny '+montant+' Ar avy @ kaonty MVola nao ianao, ampidiro ny kaody miafinao hanamarina izany :')
	break;
	default:
		return CustomKeywords.'ussd.Expected.menu'('Pour confirmer le paiement de l\'offre '+offre+' via MVola d\'un montant de '+montant+' Ar, Entrer code secret :',
			'Raha manaiky ny hividy ny tolotra '+offre+' amin\'ny sarany '+montant+' Ar, avy amin ny kaonty MVola ianao dia, Ampidiro ny kaody miafina :')
	break;
}