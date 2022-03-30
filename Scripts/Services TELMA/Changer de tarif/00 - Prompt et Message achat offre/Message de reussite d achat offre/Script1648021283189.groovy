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
	//------------------------------------------------*MORA*-------------------------------------------------- 
	case "MORA" :
		switch(offre)
		{
			case "MORA NIGHT":
				return  CustomKeywords.'ussd.Expected.menu'('Vous avez choisi MORA NIGHT, desormais valable 24 HEURES\\. Beneficiez de 60 Mn et/ou 60 SMS utlisables de 21h a 6h vers TELMA\\. Solde bonus : #359#\\.',
					'Nisafidy ny MORA NIGHT ianao, manankery 24 ORA manomboka izao\\. Antso 60 Mn sy/na SMS 60 azo ampiasaina @21h h@6h manakany @ nomerao Telma\\. Bonus tavela: #359#\\. ')
			break;
			default:
				return CustomKeywords.'ussd.Expected.menu'('L achat de votre '+offre+' est reussi\\. Bonus restants: #359#\\. Achetez via MVola et gagnez a chaque fois un bonus KADOA de 20%\\. Tapez vite le #111\\*1#\\.',
					'Tafiditra ny tolotra '+offre+' novidianao\\. Bonus\\-nao: #359#\\. Vidio @MVola ny tolotrao  ary mahazoa hatrany Bonus kadoa 20%\\. Tsindrio ny #111\\*1#\\.')
			break;
		}
	break;
	//------------------------------------------------*FIRST*--------------------------------------------------
	case "FIRST" :
		switch(offre)
		{
			case "FIRST PREMIUM":
				return CustomKeywords.'ussd.Expected.menu'('BRAVO! Grace a l achat de l offre '+offre+', TELMA vous offre un bonus NET ONE WEEK 1,5 Go\\. Consultez vos bonus sur #359#\\. TELMA N1 des KADOA\\.',
					'ARAHABAINA! Noho ny fividiananao ny tolotra '+offre+', TELMA dia manolotra anao bonus NET ONE WEEK 1,5Go\\. Araho ny bonus\\-nao @ #359#\\. TELMA N1 ny KADOA\\.')
			break;
			case "FIRST PREMIUM \\+":
				return CustomKeywords.'ussd.Expected.menu'('L achat de votre FIRST PREMIUM\\+ est reussi\\. Bonus restants: #359#\\. Achetez via MVola et gagnez a chaque fois un bonus kadoa de 20%\\.Tapez vite le #111\\*1#\\.',
					'Tafiditra ny tolotra FIRST PREMIUM\\+ novidianao\\. Bonus\\-nao: #359#\\. Vidio @MVola ny tolotrao ary mahazoa hatrany Bonus kadoa 20%\\. Tsindrio ny #111\\*1#\\.')
			break;
			default:
				return CustomKeywords.'ussd.Expected.menu'('L achat de votre '+offre+' est reussi\\. Bonus restants: #359#\\. Achetez via MVola et gagnez a chaque fois un bonus kadoa de 20%\\.Tapez vite le #111\\*1#\\.',
					'Tafiditra ny tolotra '+offre+' novidianao\\. Bonus\\-nao: #359#\\. Vidio @MVola ny tolotrao  ary mahazoa hatrany Bonus kadoa 20%\\. Tsindrio ny #111\\*1#\\.')
			break;
		}
	//------------------------------------------------*YELOW*--------------------------------------------------
	case "YELOW" :
		switch(offre)
		{
			case "YELOW100":
				return CustomKeywords.'ussd.Expected.menu'('L achat de votre YELOW 100 est reussi\\. Vous avez 20 SMS et/ou 20Mo utilisable a toute heure\\. Achetez via Mvola et gagnez 20% de bonus\\. #111\\*1#\\.', 
						'Tafiditra ny tolotra YELOW100 novidianao\\. Manana 20 SMS sy/na 20 Mo azo ampiasaina @ora rehetra ianao\\. Vidio @Mvola ny tolotra ary mahazoa bonus 20%\\. \\(#111\\*1#\\)\\.')
			break;
			case "YELOW FACEBOBAKA":
				return CustomKeywords.'ussd.Expected.menu'('L achat de votre YELOW FACEBOBAKA est reussi\\. Bonus restants: #359#\\. Achetez via MVola et gagnez a chaque fois un bonus kadoa de 20%\\. Tapez vite le #111\\*1#\\.', 
						'Tafiditra ny tolotra YELOW FACEBOBAKA novidianao\\. Bonus\\-nao: #359#\\. Vidio @MVola ny tolotrao  ary mahazoa hatrany Bonus kadoa 20%\\. Tsindrio ny #111\\*1#\\.')
			break;
			break;
			default :
				return CustomKeywords.'ussd.Expected.menu'('L achat de votre '+offre+' est reussi\\. Bonus restants: #359#\\. Achetez via MVola et gagnez a chaque fois un bonus kadoa de 20%\\. Tapez vite le #111\\*1#\\.',
					'Tafiditra ny tolotra '+offre+' novidianao\\. Bonus\\-nao: #359#\\. Vidio @MVola ny tolotrao  ary mahazoa hatrany Bonus kadoa 20%\\. Tsindrio ny #111\\*1#\\.')
			break;
		}
		break;
	//------------------------------------------------*TELMA NET*--------------------------------------------------
	case "TELMA NET" : 
		switch(offre)
		{
			case "NET ONE NIGHT" : 
				return CustomKeywords.'ussd.Expected.menu'('L achat de votre '+offre+' est reussi\\. Vous avez '+volumeData+' utilisable de 0h a 6h et de 21h a 00h\\. Achetez via Mvola et gagnez 20% de bonus\\. #111\\*1#\\.',
					'Tafiditra ny tolotra '+offre+' novidianao\\. Manana '+volumeData+' ianao azo ampiasaina @ 0h\\-6h sy 21h\\-0h\\. Vidio @Mvola ny tolotra ary mahazoa bonus 20%\\. \\(#111\\*1#\\)\\.')
			break;
			case "NET ONE MONTH 2 Go" :
				return CustomKeywords.'ussd.Expected.menu'('Votre achat de '+offre+' est reussi\\. Vous avez '+volumeData+' de DATA utilisable a toute heure\\. Achetez via Mvola et gagnez 20% de bonus \\(#111\\*1#\\)\\.',
					'Tafiditra ny tolotra '+offre+' novidianao\\. Manana '+volumeData+' azo ampiasaina @ ora rehetra ianao\\. Vidio @Mvola ny tolotra ary mahazoa bonus 20%\\. \\(#111\\*1#\\)\\.')
			break;
			case "NET ONE MONTH 25 Go" :
				return CustomKeywords.'ussd.Expected.menu'('Votre achat de '+offre+' est reussi\\. Vous avez '+volumeData+' de DATA utilisable a toute heure\\. Achetez via Mvola et gagnez 20% de bonus \\(#111\\*1#\\)\\.',
					'Tafiditra ny tolotra '+offre+' novidianao\\. Manana '+volumeData+' azo ampiasaina @ ora rehetra ianao\\. Vidio @Mvola ny tolotra ary mahazoa bonus 20%\\. \\(#111\\*1#\\)\\.')
			break;
			default : 
				return CustomKeywords.'ussd.Expected.menu'('L achat de votre '+offre+' est reussi\\. Vous avez '+volumeData+' de DATA utilisable a toute heure\\. Achetez via Mvola et gagnez 20% de bonus\\. \\(#111\\*1#\\)\\.',
					'Tafiditra ny tolotra '+offre+' novidianao\\. Manana '+volumeData+' azo ampiasaina @ ora rehetra ianao\\. Vidio @Mvola ny tolotra ary mahazoa bonus 20%\\. \\(#111\\*1#\\)\\.')

		}
}