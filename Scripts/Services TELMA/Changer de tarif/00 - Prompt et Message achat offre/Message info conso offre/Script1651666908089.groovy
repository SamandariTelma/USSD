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
String groupeOffre ="${groupeOffre}"

offre = CustomKeywords.'ussd.Util.escapeCharRegex'(offre)

switch(groupeOffre) 
{       
	//------------------------------------------------*MORA*-------------------------------------------------- 
	case "MORA" :
		switch(offre)
		{
			case "MORA 500":
				return CustomKeywords.'ussd.Expected.menu'('L achat du Mora500 est reussi\\. Bonus restants:#359#\\. Achats et consultation bonus SIMPLE\\&RAPIDE via l app Telma\\&Moi\\. Kadoa 20% si achat via MVola',
					'Tafiditra ny Mora500\\. Bonus-nao:#359#\\. Haingana sy tsotra ny mividy tolotra sy mijery bonus @alalan ny app Telma\\&Moi\\. Kadoa 20% raha vidiana @Mvola')
				break;
			case "MORA ONE":
				return CustomKeywords.'ussd.Expected.menu'('L achat du Mora One est reussi\\. Bonus restants:#359#\\. Achats et consultation bonus SIMPLE\\&RAPIDE via l app Telma\\&Moi\\. Kadoa 20% si achat via MVola',
					'Tafiditra ny Mora One\\. Bonus-nao:#359#\\. Haingana sy tsotra ny mividy tolotra sy mijery bonus @alalan ny app Telma\\&Moi\\. Kadoa 20% raha vidiana @Mvola')
				break;
			case "MORA\\+ 2000":
				return CustomKeywords.'ussd.Expected.menu'('L achat du Mora\\+2000 est reussi\\. Bonus restants:#359#\\. Achats et consultation bonus SIMPLE\\&RAPIDE via l app Telma\\&Moi\\. Kadoa 20% si achat via MVola',
					'Tafiditra ny Mora\\+2000\\. Bonus-nao:#359#\\. Haingana sy tsotra ny mividy tolotra sy mijery bonus @alalan ny app Telma\\&Moi\\. Kadoa 20% raha vidiana @Mvola')
				break;
			case "MORA\\+ 5000":
				return CustomKeywords.'ussd.Expected.menu'('L achat du Mora\\+5000 est reussi\\. Bonus restants:#359#\\. Achats et consultation bonus SIMPLE\\&RAPIDE via l app Telma\\&Moi\\. Kadoa 20% si achat via MVola',
					'Tafiditra ny Mora\\+5000\\. Bonus-nao:#359#\\. Haingana sy tsotra ny mividy tolotra sy mijery bonus @alalan ny app Telma\\&Moi\\. Kadoa 20% raha vidiana @Mvola')
				break;
			case "MORA NIGHT":
				return CustomKeywords.'ussd.Expected.menu'('L achat du Mora Night est reussi\\. Bonus restants:#359#\\. Achats et consultation bonus SIMPLE\\&RAPIDE via l app Telma\\&Moi\\. Kadoa 20% si achat via MVola',
					'Tafiditra ny Mora Night\\. Bonus-nao:#359#\\. Haingana sy tsotra ny mividy tolotra sy mijery bonus @alalan ny app Telma\\&Moi\\. Kadoa 20% raha vidiana @Mvola')
				break;
			case "MORA TEAM":
				return CustomKeywords.'ussd.Expected.menu'('L achat du Mora Team est reussi\\. Bonus restants:#359#\\. Achats et consultation bonus SIMPLE\\&RAPIDE via l app Telma\\&Moi\\. Kadoa 20% si achat via MVola',
					'Tafiditra ny Mora Team\\. Bonus-nao:#359#\\. Haingana sy tsotra ny mividy tolotra sy mijery bonus @alalan ny app Telma\\&Moi\\. Kadoa 20% raha vidiana @Mvola')
				break;
			case "MORA INTERNATIONAL":
				return CustomKeywords.'ussd.Expected.menu'('L achat du Mora International est reussi\\. Bonus restants:#359#\\. Achats et consultation bonus SIMPLE\\&RAPIDE via l app Telma\\&Moi\\. Kadoa20% si achat via MVola',
					'Tafiditra ny Mora International\\. Bonus-nao:#359#\\. Haingana sy tsotra ny mividy tolotra sy mijery bonus @alalan ny app Telma\\&Moi\\. Kadoa20% raha vidiana @Mvola')
				break;
		}
	break;
	//------------------------------------------------*FIRST*--------------------------------------------------
	case "FIRST" :
		switch(offre)
		{
			case "FIRST PREMIUM":
				return CustomKeywords.'ussd.Expected.menu'('L achat du First Premium est reussi\\. Bonus restants:#359#\\. Achats et consultation bonus SIMPLE\\&RAPIDE via l app Telma\\&Moi\\. Kadoa 20% si achat via MVola',
					'Tafiditra ny First Premium\\. Bonus-nao:#359#\\. Haingana sy tsotra ny mividy tolotra sy mijery bonus @alalan ny app Telma\\&Moi\\. Kadoa 20% raha vidiana @Mvola')
				break;
			case "FIRST PREMIUM \\+":
				return CustomKeywords.'ussd.Expected.menu'('L achat du First Premium\\+ est reussi\\. Bonus restants:#359#\\. Achats et consultation bonus SIMPLE\\&RAPIDE via l app Telma\\&Moi\\. Kadoa 20% si achat via MVola',
					'Tafiditra ny First Premium\\+\\. Bonus-nao:#359#\\. Haingana sy tsotra ny mividy tolotra sy mijery bonus @alalan ny app Telma\\&Moi\\. Kadoa 20% raha vidiana @Mvola')
				break;
			case "FIRST PRESTIGE":
			return CustomKeywords.'ussd.Expected.menu'('L achat du First Prestige est reussi\\. Bonus restants:#359#\\. Achats et consultation bonus SIMPLE\\&RAPIDE via l app Telma\\&Moi\\. Kadoa 20% si achat via MVola',
				'Tafiditra ny First Prestige. Bonus-nao:#359#\\. Haingana sy tsotra ny mividy tolotra sy mijery bonus @alalan ny app Telma\\&Moi\\. Kadoa 20% raha vidiana @Mvola')
				break;
			case "FIRST ROYAL":
				return CustomKeywords.'ussd.Expected.menu'('L achat du First Royal est reussi\\. Bonus restants:#359#\\. Achats et consultation bonus SIMPLE\\&RAPIDE via l app Telma\\&Moi\\. Kadoa 20% si achat via MVola',
				'Tafiditra ny First Royal. Bonus-nao:#359#\\. Haingana sy tsotra ny mividy tolotra sy mijery bonus @alalan ny app Telma\\&Moi\\. Kadoa 20% raha vidiana @Mvola')
				break;
		}
	//------------------------------------------------*YELOW*--------------------------------------------------
	case "YELOW" :
		switch(offre)
		{
			case "YELOW100":
				return CustomKeywords.'ussd.Expected.menu'('L achat du Yelow 100 est reussi\\. Bonus restants:#359#\\. Achats et consultation bonus SIMPLE\\&RAPIDE via l app Telma\\&Moi\\. Kadoa 20% si achat via MVola',
					'Tafiditra ny Yelow 100\\. Bonus-nao:#359#\\. Haingana sy tsotra ny mividy tolotra sy mijery bonus @alalan ny app Telma\\&Moi\\. Kadoa 20% raha vidiana @Mvola')
				break;
			case "YELOW 200":
				return CustomKeywords.'ussd.Expected.menu'('L achat du Yelow 200 est reussi\\. Bonus restants:#359#\\. Achats et consultation bonus SIMPLE\\&RAPIDE via l app Telma\\&Moi\\. Kadoa 20% si achat via MVola',
					'Tafiditra ny Yelow 200\\. Bonus-nao:#359#\\. Haingana sy tsotra ny mividy tolotra sy mijery bonus @alalan ny app Telma\\&Moi\\. Kadoa 20% raha vidiana @Mvola')
				break;
			case "YELOW SMS":
				return CustomKeywords.'ussd.Expected.menu'('L achat du Yelow SMS est reussi\\. Bonus restants:#359#\\. Achats et consultation bonus SIMPLE\\&RAPIDE via l app Telma\\&Moi\\. Kadoa 20% si achat via MVola',
					'Tafiditra ny Yelow SMS\\. Bonus-nao:#359#\\. Haingana sy tsotra ny mividy tolotra sy mijery bonus @alalan ny app Telma\\&Moi\\. Kadoa 20% raha vidiana @Mvola')
				break;
			case "YELOW FACEBOBAKA":
				return CustomKeywords.'ussd.Expected.menu'('L achat du Yelow Facebobaka est reussi\\. Bonus restants:#359#\\. Achats et consultation bonus SIMPLE\\&RAPIDE via l app Telma\\&Moi\\. Kadoa 20% si achat via MVola',
					'Tafiditra ny Yelow Facebobaka\\. Bonus-nao:#359#\\. Haingana sy tsotra ny mividy tolotra sy mijery bonus @alalan ny app Telma\\&Moi\\. Kadoa20% raha vidiana @MVola')
				break;
			case "YELOW FACEBOOBAKA ONE":
				return CustomKeywords.'ussd.Expected.menu'('L achat de votre YELOW FACEBOOBAKA ONE est reussi\\. Bonus restants:#359#\\. Achetez via MVola et gagnez a chaque fois un bonus kadoa de 20%\\. Tapez vite le #111\\*1#\\.',
					'Tafiditra ny tolotra YELOW FACEBOOBAKA ONE novidianao\\. Bonus\\-nao: #359#\\. Vidio @MVola ny tolotrao  ary mahazoa hatrany Bonus kadoa 20%\\. Tsindrio ny #111\\*1#\\. ')
				break;
			case "YELOW FACEBOOBAKA \\+":
				return CustomKeywords.'ussd.Expected.menu'('L achat du Yelow Facebobaka\\+ est reussi\\. Bonus restants:#359#\\. Achats et consultation bonus SIMPLE\\&RAPIDE via l app Telma\\&Moi\\. Kadoa 20% si achat via MVola',
					'Tafiditra ny Yelow Facebobaka\\+\\. Bonus-nao:#359#\\. Haingana sy tsotra ny mividy tolotra sy mijery bonus @alalan ny app Telma\\&Moi\\. Kadoa 20% raha vidiana @Mvola')
				break;
			case "YELOW 1000":
				return CustomKeywords.'ussd.Expected.menu'('L achat du Yelow 1000 est reussi\\. Bonus restants:#359#\\. Achats et consultation bonus SIMPLE\\&RAPIDE via l app Telma\\&Moi\\. Kadoa 20% si achat via MVola',
					'Tafiditra ny Yelow 1000\\. Bonus-nao:#359#\\. Haingana sy tsotra ny mividy tolotra sy mijery bonus @alalan ny app Telma\\&Moi\\. Kadoa 20% raha vidiana @Mvola')
			case "YELOW ONE":
				return CustomKeywords.'ussd.Expected.menu'('L achat du Yelow One est reussi\\. Bonus restants:#359#\\. Achats et consultation bonus SIMPLE\\&RAPIDE via l app Telma\\&Moi\\. Kadoa 20% si achat via MVola',
					'Tafiditra ny Yelow One\\. Bonus-nao:#359#\\. Haingana sy tsotra ny mividy tolotra sy mijery bonus @alalan ny app Telma\\&Moi\\. Kadoa 20% raha vidiana @Mvola')
		}
		break;
	//------------------------------------------------*TELMA NET*--------------------------------------------------
	case "TELMA NET" : 
		switch(offre)
		{
			case "NET ONE WEEK 2 Go" :
				String dateExpiration = CustomKeywords.'outStream.XML.getDateBundle'("net one week 2 Go")
				return CustomKeywords.'ussd.Expected.menu'('NET ONE WEEK 2 Go, il vous reste 4096\\.0 Mo utilisable a toute heure jusqu au '+dateExpiration+' inclus\\.',
					'NET ONE WEEK 2 Go, 4096\\.0  Mo sisa ny bonus\\-nao azo ampiasaina @ ora rehetra hatramin ny '+dateExpiration+'\\.')
			break;
			case "NET ONE NIGHT" : 
				return CustomKeywords.'ussd.Expected.menu'('L achat de votre '+offre+' est reussi\\. Vous avez '+volumeData+' utilisable de 0h a 6h et de 21h a 00h\\. Achetez via Mvola et gagnez 20% de bonus\\. #111\\*1#\\.',
					'Tafiditra ny tolotra '+offre+' novidianao\\. Manana '+volumeData+' ianao azo ampiasaina @ 0h\\-6h sy 21h\\-0h\\. Vidio @Mvola ny tolotra ary mahazoa bonus 20%\\. \\(#111\\*1#\\)\\.')
			break;
			case "NET ONE MONTH 2 Go" :
				return CustomKeywords.'ussd.Expected.menu'('L achat de votre '+offre+' est reussi\\. Vous avez '+volumeData+' de DATA utilisable a toute heure\\. Achetez via Mvola et gagnez 20% de bonus \\(#111\\*1#\\)\\.',
					'Tafiditra ny tolotra '+offre+' novidianao\\. Manana '+volumeData+' azo ampiasaina @ora rehetra ianao\\. Vidio @Mvola ny tolotra ary mahazoa bonus 20%\\. \\(#111\\*1#\\)\\.')
			break;
			case "NET ONE MONTH 25 Go" :
				return CustomKeywords.'ussd.Expected.menu'('L achat de votre '+offre+' est reussi\\. Vous avez '+volumeData+' de DATA utilisable a toute heure\\. Achetez via Mvola et gagnez 20% de bonus \\(#111\\*1#\\)\\.',
					'Tafiditra ny tolotra '+offre+' novidianao\\. Manana '+volumeData+' azo ampiasaina @ ora rehetra ianao\\. Vidio @Mvola ny tolotra ary mahazoa bonus 20%\\. \\(#111\\*1#\\)\\.')
			break;
			case "NET ONE MONTH 50Go" :
			return CustomKeywords.'ussd.Expected.menu'('L achat de votre NET ONE MONTH 50 Go est reussi\\. Vous avez '+volumeData+' de DATA utilisable a toute heure\\. Achetez via Mvola et gagnez 20% de bonus \\(#111\\*1#\\)\\.',
				'Tafiditra ny tolotra NET ONE MONTH 50 Go novidianao\\. Manana '+volumeData+' azo ampiasaina @ ora rehetra ianao\\. Vidio @Mvola ny tolotra ary mahazoa bonus 20%\\. \\(#111\\*1#\\)\\.')
			break;
			case "NET ONE MONTH 100Go" :
			return CustomKeywords.'ussd.Expected.menu'('L achat de votre NET ONE MONTH 100 Go est reussi\\. Vous avez '+volumeData+' de DATA utilisable a toute heure\\. Achetez via Mvola et gagnez 20% de bonus \\(#111\\*1#\\)\\.',
				'Tafiditra ny tolotra NET ONE MONTH 100Go novidianao\\. Manana '+volumeData+' azo ampiasaina @ ora rehetra ianao\\. Vidio @Mvola ny tolotra ary mahazoa bonus 20%\\. \\(#111\\*1#\\)\\.')
			break;
			default : 
				return CustomKeywords.'ussd.Expected.menu'('L achat de votre '+offre+' est reussi\\. Vous avez '+volumeData+' de DATA utilisable a toute heure\\. Achetez via Mvola et gagnez 20% de bonus\\. \\(#111\\*1#\\)\\.',
					'Tafiditra ny tolotra '+offre+' novidianao\\. Manana '+volumeData+' azo ampiasaina @ ora rehetra ianao\\. Vidio @Mvola ny tolotra ary mahazoa bonus 20%\\. \\(#111\\*1#\\)\\.')
		
		}
}