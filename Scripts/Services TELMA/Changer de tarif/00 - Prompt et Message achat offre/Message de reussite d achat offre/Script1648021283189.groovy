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

offre = CustomKeywords.'ussd.Util.escapeCharRegex'(offre)

switch(groupeOffre) 
{            
	case "TELMA NET":
		return CustomKeywords.'ussd.Expected.menu'('L achat de votre '+offre+' est reussi\\. Vous avez '+volumeData+' de DATA utilisable a toute heure\\. Achetez via Mvola et gagnez 20% de bonus\\. \\(#111\\*1#\\)\\.',
			'Tafiditra ny tolotra '+offre+' novidianao\\. Manana '+volumeData+' azo ampiasaina @ ora rehetra ianao\\. Vidio @Mvola ny tolotra ary mahazoa bonus 20%\\. \\(#111\\*1#\\)\\.')
	break;

	default:
		return CustomKeywords.'ussd.Expected.menu'('L achat de votre '+offre+' est reussi\\. Bonus restants: #359#\\. Achetez via MVola et gagnez a chaque fois un bonus Kadoa de 20%\\. Tapez vite le #111\\*1#\\.',
			'Tafiditra ny tolotra '+offre+'\\. Bonus\\-nao: #359#\\. Vidio @MVola ny tolotrao ary mahazoa hatrany Bonus kadoa 20%\\. Tsindrio ny #111\\*1#\\.')
	break;
}