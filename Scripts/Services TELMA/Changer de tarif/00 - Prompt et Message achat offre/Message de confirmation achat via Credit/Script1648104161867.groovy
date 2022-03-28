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
String validite = "${validite}"
//separateur de millier eng (.)
offre = CustomKeywords.'ussd.Util.escapeCharRegex'(offre)
println("OFFRE -------------------"+offre+"-----------------")
switch(offre) 
{            
	case "YELOW ONE":
		return CustomKeywords.'ussd.Expected.menu'('YELOW ONE ! Beneficiez de '+volumeData+' de DATA utilisable a toute heure pour '+montant+' Ar/ jour\\. En profiter\\? 1\\-OUI; 0 \\- NON',
			'YELOW ONE! Mahazoa '+volumeData+' DATA azo ampiasaina @ ora rehetra @ sarany '+montant+' Ar monja\\. Hanararoatra\\? 1\\-ENY ; 0\\-TSIA ')
	break;
	case "YELOW FACEBOBAKA":
		return CustomKeywords.'ussd.Expected.menu'('YELOW FACEBOOBAKA : vous avez '+volumeData+' pour acceder a vos videos et photos sur Instagram et Facebook pendant '+validite+'j pour '+montant+' Ar\\. En profiter\\? 1\\-OUI; 0\\-NON',
			'YELOW FACEBOOBAKA: Manana '+volumeData+' ianao ahafahana mampiasa Instagram sy Facebook, manan\\-kery '+validite+' andro @ sarany '+montant+' Ar\\. Hanararaotra\\? 1\\-ENY ; 0\\-TSIA')
	break;
	case "YELOW FACEBOOBAKA \\+": 
		return CustomKeywords.'ussd.Expected.menu'('YELOW FACEBOOBAKA\\+ : vous avez '+volumeData+' pour acceder a vos videos et photos sur Instagram et Facebook pendant '+validite+' jours pour '+montant+' Ar\\. En profiter\\? 1\\-OUI; 0\\-NON', 
			'YELOW FACEBOOBAKA \\+: Manana '+volumeData+' ianao ahafahana mampiasa Instagram sy Facebook, manan\\-kery '+validite+' andro @ sarany '+montant+' Ar\\. Hanararaotra\\? 1\\-ENY ; 0\\-TSIA')
	break;
	default:
		montant = CustomKeywords.'ussd.Util.separateThousand'(montant.toInteger(), ".")
		return CustomKeywords.'ussd.Expected.menu'(offre+'! Beneficiez de '+volumeData+' de DATA utilisable a toute heure pendant '+validite+' jours pour seulement '+montant+' Ar\\. En profiter\\? 1\\-OUI; 0 \\- NON',
			offre+'! Mahazoa '+volumeData+' DATA azo ampiasaina @ ora rehetra @ sarany '+montant+'Ar monja mandritry ny '+validite+' andro\\. Hanararoatra\\? 1\\-ENY ; 0\\-TSIA')
	break;
}