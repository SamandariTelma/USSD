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
		montant = CustomKeywords.'ussd.Util.separateThousand'(montant.toInteger(), ".")
		return CustomKeywords.'ussd.Expected.menu'('YELOW ONE ! Beneficiez de '+volumeData+' de DATA utilisable a toute heure pour '+montant+' Ar/ jour\\. En profiter\\? 1\\-OUI; 0 \\- NON',
			'YELOW ONE! Mahazoa '+volumeData+' DATA azo ampiasaina @ ora rehetra @ sarany '+montant+' Ar monja\\. Hanararoatra\\? 1\\-ENY ; 0\\-TSIA')
		//YELOW ONE ! Beneficiez de 200 Mo de DATA utilisable a toute heure pour 1000 Ar/ jour. En profiter? 1-OUI; 0 - NON
		//YELOW ONE! Mahazoa 200 Mo DATA azo ampiasaina @ ora rehetra @ sarany 1.000 Ar monja. Hanararoatra? 1-ENY ; 0-TSIA
	break;
	case "YELOW FACEBOBAKA":
		return CustomKeywords.'ussd.Expected.menu'('YELOW FACEBOBAKA : vous avez '+volumeData+' pour acceder a vos videos et photos sur Instagram et Facebook pendant '+validite+'j pour '+montant+' Ar\\. En profiter\\? 1\\-OUI; 0\\-NON',
			'YELOW FACEBOBAKA: Manana '+volumeData+' ianao ahafahana mampiasa Instagram sy Facebook, manan\\-kery '+validite+' andro @ sarany '+montant+' Ar\\. Hanararaotra\\? 1\\-ENY ; 0\\-TSIA')
		//YELOW FACEBOOBAKA : vous avez 250 Mo pour acceder a vos videos et photos sur Instagram et Facebook pendant 2j pour 500 Ar. En profiter? 1-OUI; 0-NON
	break;
	case "YELOW FACEBOOBAKA \\+": 
		return CustomKeywords.'ussd.Expected.menu'('YELOW FACEBOOBAKA\\+ : vous avez '+volumeData+' pour acceder a vos videos et photos sur Facebook, Instagram et WhatsApp pendant '+validite+'j pour '+montant+' Ar\\. En profiter\\? 1\\-OUI; 0\\-NON', 
			'YELOW FACEBOOBAKA \\+: Manana '+volumeData+' ianao ahafahana mampiasa Instagram sy Facebook, manan\\-kery '+validite+' andro @ sarany '+montant+' Ar\\. Hanararaotra\\? 1\\-ENY ; 0\\-TSIA')
	//'YELOW FACEBOOBAKA+ : vous avez 1,5Go pour acceder a vos videos et photos sur Facebook, Instagram et WhatsApp pendant 7j pour 2000 Ar. En profiter? 1-OUI; 0-NON
    //YELOW FACEBOOBAKA +: Manana 1,5 Go ianao ahafahana mampiasa Instagram sy Facebook, manan-kery 7 andro @ sarany 2000 Ar. Hanararaotra? 1-ENY ; 0-TSIA
	break;
	case "YELOW FACEBOOBAKA ONE":
		return CustomKeywords.'ussd.Expected.menu'('YELOW FACEBOOBAKA ONE : vous avez '+volumeData+' pour acceder a vos videos et photos sur Instagram et Facebook pendant '+validite+'j pour '+montant+' Ar\\. En profiter\\? 1-OUI; 0-NON',
			'YELOW FACEBOOBAKA ONE: Manana '+volumeData+' ianao ahafahana mampiasa Instagram sy Facebook, manan\\-kery '+validite+' andro @ sarany '+montant+' Ar\\. Hanararoatra\\? 1\\-ENY ; 0; TSIA')
	 //YELOW FACEBOOBAKA ONE : vous avez 700 Mo pour acceder a vos videos et photos sur Instagram et Facebook pendant 7j pour 1000 Ar
	break;
	
	case "NET ONE WEEK 350 Mo":
		montant = CustomKeywords.'ussd.Util.separateThousand'(montant.toInteger(), ".")
		return CustomKeywords.'ussd.Expected.menu'(offre+'! Beneficiez de '+volumeData+' de DATA utilisable a toute heure pendant '+validite+' jours pour seulement '+montant+' Ar\\. En profiter\\? 1\\-OUI; 0 \\- NON',
			offre+'! Mahazoa '+volumeData+'  DATA azo ampiasaina @ ora rehetra @ sarany '+montant+'Ar monja mandritry ny '+validite+' andro\\. Hanararoatra\\? 1\\-ENY ; 0\\-TSIA')
	//NET ONE WEEK 350 Mo! Beneficiez de 350 Mo de DATA utilisable a toute heure pendant 7 jours pour seulement 3.000 Ar. En profiter? 1-OUI; 0 - NON
	//NET ONE WEEK 350 Mo! Mahazoa 350 Mo DATA azo ampiasaina @ ora rehetra @ sarany 3.000Ar monja mandritry ny 7 andro. Hanararoatra? 1-ENY ; 0-TSIA	
	break;
	case "NET ONE WEEK 800 Mo":
		montant = CustomKeywords.'ussd.Util.separateThousand'(montant.toInteger(), ".")
		return CustomKeywords.'ussd.Expected.menu'(offre+'! Beneficiez de '+volumeData+' de DATA utilisable a toute heure pendant '+validite+' jours pour seulement '+montant+' Ar\\. En profiter\\? 1\\-OUI; 0 \\- NON',
			offre+'! Mahazoa '+volumeData+'  DATA azo ampiasaina @ ora rehetra @ sarany '+montant+'Ar monja mandritry ny '+validite+' andro\\. Hanararoatra\\? 1\\-ENY ; 0\\-TSIA')
	//NET ONE WEEK 800 Mo! Beneficiez de 800 Mo de DATA utilisable a toute heure pendant 7 jours pour seulement 5.000 Ar. En profiter? 1-OUI; 0 - NON
	break;
	
	case "NET ONE WEEK 2 Go":
		montant = CustomKeywords.'ussd.Util.separateThousand'(montant.toInteger(), ".")
		return CustomKeywords.'ussd.Expected.menu'(offre+'! Beneficiez de '+volumeData+' de DATA utilisable a toute heure pendant '+validite+' jours pour seulement '+montant+' Ar\\. En profiter\\? 1\\-OUI; 0 \\- NON',
			offre+'! Mahazoa '+volumeData+'  DATA azo ampiasaina @ ora rehetra @ sarany '+montant+'Ar monja mandritry ny '+validite+' andro\\. Hanararoatra\\? 1\\-ENY ; 0\\-TSIA')
		//NET ONE WEEK 2 Go! Beneficiez de 2 Go de DATA utilisable a toute heure pendant 7 jours pour seulement 10.000 Ar. En profiter? 1-OUI; 0 - NON
	break;
	case "NET ONE MONTH 2 Go":
		montant = CustomKeywords.'ussd.Util.separateThousand'(montant.toInteger(), ".")
		return CustomKeywords.'ussd.Expected.menu'(offre+'! Beneficiez de '+volumeData+' de DATA utilisable a toute heure pendant '+validite+' jours pour seulement '+montant+' Ar\\. En profiter\\? 1\\-OUI; 0 \\- NON',
			offre+'! Mahazoa '+volumeData+' DATA azo ampiasaina @ ora rehetra @ sarany '+montant+' Ar monja mandritry ny '+validite+' andro\\. Hanararoatra\\? 1\\-ENY ; 0\\-TSIA')
		//NET ONE MONTH 2 Go! Mahazoa 2 Go DATA azo ampiasaina @ ora rehetra @ sarany 15.000 Ar monja mandritry ny 30 andro. Hanararoatra? 1-ENY ; 0-TSIA
	break;
	case "NET ONE MONTH 4 Go":
		montant = CustomKeywords.'ussd.Util.separateThousand'(montant.toInteger(), ".")
		return CustomKeywords.'ussd.Expected.menu'(offre+'! Beneficiez de '+volumeData+' de DATA utilisable a toute heure pendant '+validite+' jours pour seulement '+montant+' Ar\\. En profiter\\? 1\\-OUI; 0 \\- NON',
			offre+'! Mahazoa '+volumeData+' DATA azo ampiasaina @ ora rehetra @ sarany '+montant+' Ar monja mandritry ny '+validite+' andro\\. Hanararoatra\\? 1\\-ENY ; 0\\-TSIA')
		//NET ONE MONTH 4 Go! Beneficiez de 4 Go de DATA utilisable a toute heure pendant 30 jours pour seulement 25.000 Ar. En profiter? 1-OUI; 0 - NON
	break;
	case "NET ONE MONTH 12 Go":
		montant = CustomKeywords.'ussd.Util.separateThousand'(montant.toInteger(), ".")
		return CustomKeywords.'ussd.Expected.menu'(offre+'! Beneficiez de '+volumeData+' de DATA utilisable a toute heure pendant '+validite+' jours pour seulement '+montant+' Ar\\. En profiter\\? 1\\-OUI; 0 \\- NON',
			offre+'! Mahazoa '+volumeData+' DATA azo ampiasaina @ ora rehetra @ sarany '+montant+' Ar monja mandritry ny '+validite+' andro\\. Hanararoatra\\? 1\\-ENY ; 0\\-TSIA')
		//NET ONE MONTH 12 Go! Mahazoa 12 Go DATA azo ampiasaina @ ora rehetra @ sarany 75.000 Ar monja mandritry ny 30 andro. Hanararoatra? 1-ENY ; 0-TSIA
		//NET ONE MONTH 12 Go! Beneficiez de 12 Go de DATA utilisable a toute heure pendant 30 jours pour seulement 75.000 Ar. En profiter? 1-OUI; 0 - NON
	break;
	case "NET ONE MONTH 25 Go":
		montant = CustomKeywords.'ussd.Util.separateThousand'(montant.toInteger(), ".")
		return CustomKeywords.'ussd.Expected.menu'(offre+'! Beneficiez de '+volumeData+' de DATA utilisable a toute heure pendant '+validite+' jours pour seulement '+montant+' Ar\\. En profiter\\? 1\\-OUI; 0 \\- NON',
			offre+'! Mahazoa '+volumeData+' DATA azo ampiasaina @ ora rehetra @ sarany '+montant+' Ar monja mandritry ny '+validite+' andro\\. Hanararoatra\\? 1\\-ENY ; 0\\-TSIA')
		//NET ONE MONTH 25 Go! Beneficiez de 25 Go de DATA utilisable a toute heure pendant 30 jours pour seulement 125.000 Ar. En profiter? 1-OUI; 0 - NON
		//NET ONE MONTH 25 Go! Mahazoa 25 Go DATA azo ampiasaina @ ora rehetra @ sarany 125.000 Ar monja mandritry ny 30 andro. Hanararoatra? 1-ENY ; 0-TSIA
	break;
	default:
		montant = CustomKeywords.'ussd.Util.separateThousand'(montant.toInteger(), ".")
		return CustomKeywords.'ussd.Expected.menu'(offre+'! Beneficiez de '+volumeData+' de DATA utilisable a toute heure pendant '+validite+' jours pour seulement '+montant+' Ar\\. En profiter\\? 1\\-OUI; 0 \\- NON',
			offre+'! Mahazoa '+volumeData+' DATA azo ampiasaina @ ora rehetra @ sarany '+montant+'Ar monja mandritry ny '+validite+' andro\\. Hanararoatra\\? 1\\-ENY ; 0\\-TSIA')
	break;
	
	case "NET ONE MONTH 100 Go":
		montant = CustomKeywords.'ussd.Util.separateThousand'(montant.toInteger(), ".")
		return CustomKeywords.'ussd.Expected.menu'(offre+'! Beneficiez de '+volumeData+' de DATA utilisable a toute heure pendant '+validite+' jours pour seulement '+montant+' Ar\\. En profiter\\? 1\\-OUI; 0 \\- NON',
			offre+'! Mahazoa '+volumeData+'  DATA azo ampiasaina @ ora rehetra @ sarany '+montant+'Ar monja mandritry ny '+validite+' andro\\. Hanararoatra\\? 1\\-ENY ; 0\\-TSIA')
	break;
}