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

String offre = "$offre"

String groupeOffre = "$groupeOffre"

offre = CustomKeywords.'ussd.Util.escapeCharRegex'(offre)

switch (groupeOffre) {
    //------------------------------------------------*MORA*-------------------------------------------------- 
    case 'MORA':
        switch (offre) {
            case 'MORA 500':
                return CustomKeywords.'ussd.Expected.menu'('Bonus MORA 500 restants : 500 Ar appels \\+ 10 SMS Telma et/ou 10 Mo valables a toute heure ET BONUS 10\\.0 SMS Telma et/ou 10\\.0 Mo valable la nuit',
					'Bonus MORA 500 : 500 Ar antso \\+ 10 SMS Telma sy/na 10 Mo manankery @ ora rehetra ARY BONUS 10\\.0 SMS Telma sy/na 10\\.0 Mo manankery @alina\\.')
                break
            case 'MORA ONE':
                return CustomKeywords.'ussd.Expected.menu'('Bonus MORA ONE restants : 1000 Ar appel national \\+ 20 SMS Telma \\+ 20\\.0 Mo utilisables jusqu a minuit\\. ',
					'Bonus MORA ONE : 1000 Ar antso mankany @tambazotra rehetra \\+ 20 SMS Telma \\+ 20\\.0 Mo manankery hatramin ny sasakalina\\.')
                break
            case 'MORA\\+ 2000':
                return CustomKeywords.'ussd.Expected.menu'('Bonus MORA \\+ 2000 restants: 2000 Ar appels \\+ 50 SMS Telma \\+ 50\\.0 Mo valable jusqu au '+dateExpiration,
					'Bonus MORA\\+ 2000 : 2000 Ar antso mankany @tambazotra rehetra \\+ 50 SMS Telma \\+ 50\\.0 Mo ampiasaina h@ '+dateExpiration)
                break
            case 'MORA\\+ 5000':
                return CustomKeywords.'ussd.Expected.menu'('Bonus MORA\\+ 5000 restants: 5000 Ar appels \\+ 100 SMS Telma \\+ 100\\.0 Mo la journee et 50\\.0 Mo la nuit valable jusqu au '+dateExpiration,
					'Bonus MORA\\+ 5000 : 5000 Ar antso eto an toerana \\+ 100 SMS Telma \\+ 100\\.0 Mo ny tontolo andro sy 50\\.0 Mo ny alina azo ampiasaina h@ '+dateExpiration)
                break
            case 'MORA NIGHT':
                return CustomKeywords.'ussd.Expected.menu'('Bonus MORA NIGHT: 3600 sec d appels et/ou 60 SMS vers Telma utilisable de 21h\\-5h59 jusqu au '+dateExpiration,
					'Bonus MORA NIGHT: antso 3600 sec sy/na 60 SMS mankany @numerao Telma azo ampiasaina @21h\\-5h59, ary manankery h@ '+dateExpiration)
                break
            case 'MORA TEAM':
                return CustomKeywords.'ussd.Expected.menu'('Bonus MORA TEAM: 3600 sec d appels et/ou 60 SMS vers Num FAF et/ou 60\\.0 Mo valable jusqu a minuit\\. Tapez #344\\*1\\*Num pour rajouter Num FAF\\. Telma N1 a M/car',
					'Bonus MORA TEAM: antso 3600 sec sy/na 60 SMS mankany @ Num FAF sy/na 60\\.0 Mo h@ sasak alina\\. Antsoy ny #344\\*1\\*Num# raha hanampy Num FAF\\. Telma N1 eto M/kara')
                break
            case 'MORA INTERNATIONAL':
                return CustomKeywords.'ussd.Expected.menu'('Bonus MORA INTERNATIONAL restants: 900 sec d appels vers l international utilisable jusqu au '+dateExpiration,
					'Bonus MORA INTERNATIONAL tavela: 900 sec antso mankany ivelany azo ampiasaina hatramin ny '+dateExpiration)
                break
        }
        
        break //------------------------------------------------*FIRST*--------------------------------------------------
    case 'FIRST':
        switch (offre) {
            case 'FIRST PREMIUM':
                return CustomKeywords.'ussd.Expected.menu'('Bonus FIRST PREMIUM: 20000 Ar appel national \\+ 200 SMS Telma \\+ 200\\.0  Mo la journee \\+ 100\\.0 Mo la nuit jusqu au '+dateExpiration+' inclus',
					'Bonus FIRST PREMIUM: 20000 Ar antso eto M/kara \\+ 200 SMS Telma 200\\.0 Mo ny tontolo andro \\+ 100\\.0 Mo ny alina, h@ '+dateExpiration)
                break
            case 'FIRST PREMIUM \\+':
                return CustomKeywords.'ussd.Expected.menu'(('Bonus FIRST PREMIUM \\+ : 30000 Ar appel national \\+ 300 SMS Telma \\+ 400\\.0 Mo la journee \\+ 400\\.0 Mo la nuit \\+ Bonus 600 sec vers international jusqu au ' + 
					dateExpiration) + '.', 'Bonus FIRST PREMIUM \\+ : 30000 Ar antso eto M/kara \\+ 300 SMS Telma \\+ 400\\.0 Mo ny tontolo andro \\+ 400\\.0 Mo ny alina \\+Bonus 600 s makany ivelany, h@ ' + dateExpiration)
                break
            case 'FIRST PRESTIGE':
                return CustomKeywords.'ussd.Expected.menu'('Bonus FIRST PRESTIGE: 60000 Ar appel national \\+ 1000 SMS Telma \\+ 1000\\.0 Mo la journee \\+ 1000\\.0 Mo la nuit \\+ Bonus 1200 sec vers international jusqu au '+dateExpiration,
					'Bonus FIRST PRESTIGE: 60000 Ar antso eto M/kara \\+ 1000 SMS Telma \\+ 1000\\.0 Mo ny tontolo andro  \\+ 1000\\.0 Mo  ny alina \\+Bonus 1200 sec  makany ivelany, h@ '+dateExpiration)
                break
            case 'FIRST ROYAL':
                return CustomKeywords.'ussd.Expected.menu'('Bonus FIRST ROYAL: 100000 Ar appel national \\+ 2000 SMS Telma \\+ 2048\\.0 Mo la journee \\+ 2048\\.0 Mo la nuit \\+ Bonus 1800 sec vers international jusqu au '+dateExpiration,
					'Bonus FIRST ROYAL: 100000 Ar antso eto M/kara \\+ 2000 SMS Telma \\+ 2048\\.0 Mo ny tontolo andro  \\+ 2048\\.0 Mo ny alina \\+ Bonus 1800  s  makany ivelany, h@ '+dateExpiration)              
                break
        } //------------------------------------------------*YELOW*--------------------------------------------------
    case 'YELOW':
        switch (offre) {
            case 'YELOW100':
                return CustomKeywords.'ussd.Expected.menu'('YELOW 100, il vous reste 20\\.0 SMS et/ou 20\\.0 Mo utilisable a toute heure\\.', 
                    'YELOW 100, 20\\.0 SMS sy/na 20\\.0 Mo sisa ny bonus-nao azo ampiasaina @ ora rehetra\\.')
                
                break
            case 'YELOW 200':
                String dateExpiration = CustomKeywords.'outStream.XML.getDateBundle'('yelow 200')

                String heureExpiration = CustomKeywords.'outStream.XML.getTimeBundle'('yelow 200')

                return CustomKeywords.'ussd.Expected.menu'((('Bonus YELOW 200 restants: 50 SMS Telma et/ou 50 Mo utilisable a toute heure jusqu au ' + 
                    dateExpiration) + ' a ') + heureExpiration, (('Bonus YELOW 200: 50 SMS Telma sy/na 50 Mo azo ampiasaina @ ora rehetra hatramin ny ' + 
                    dateExpiration) + ' @ ') + heureExpiration)
                
                break
            case 'YELOW SMS':
                String dateExpiration = CustomKeywords.'outStream.XML.getDateBundle'('yelow sms')

                String heureExpiration = CustomKeywords.'outStream.XML.getTimeBundle'('yelow sms')

                return CustomKeywords.'ussd.Expected.menu'(((('Bonus YELOW SMS restants: 100 SMS Telma et 25 SMS autres opérateurs jusqu au ' + 
                    dateExpiration) + ' a ') + heureExpiration) + '\\.', ((('Bonus YELOW SMS : 100 SMS Telma  \\+ 25 SMS mankany @ tambazotra hafa azo ampiasaina hatramin ny ' + 
                    dateExpiration) + ' @ ') + heureExpiration) + '\\.')
                
                break
            case 'YELOW FACEBOBAKA':
                String dateExpiration = CustomKeywords.'outStream.XML.getDateBundle'('yelow facebobaka')

                return CustomKeywords.'ussd.Expected.menu'(('Vos bonus YELOW FACEBOOBAKA restant: 250\\.0 Mo utilisable toute la journee valable jusqu au ' + 
                    dateExpiration) + ' inclus\\.', ('Ny bonus YELOW FACEBOOBAKA-nao: 250\\.0 Mo azo ampiasaina ny tontolo andro ampiasaina  hatramin ny ' + 
                    dateExpiration) + '\\.')
                
                break
            case 'YELOW FACEBOOBAKA ONE':
                String dateExpiration = CustomKeywords.'outStream.XML.getDateBundle'('yelow faceboobaka one')

                return CustomKeywords.'ussd.Expected.menu'(('Vos bonus YELOW FACEBOOBAKA restant: 700\\.0 Mo utilisable toute la journee valable jusqu au ' + 
                    dateExpiration) + ' inclus\\.', ('Ny bonus YELOW FACEBOOBAKA-nao: 700\\.0 Mo azo ampiasaina ny tontolo andro ampiasaina  hatramin ny ' + 
                    dateExpiration) + '\\.')
                
                break
            case 'YELOW FACEBOOBAKA \\+':
                String dateExpiration = CustomKeywords.'outStream.XML.getDateBundle'('yelow faceboobaka')

                return CustomKeywords.'ussd.Expected.menu'(('Bonus YELOW FACEBOOBAKA \\+ : 1536\\.0 Mo utilisable toute la journee valable jusqu au ' + 
                    dateExpiration) + ' inclus\\.', ('Bonus YELOW FACEBOOBAKA \\+ : 1536\\.0 Mo azo ampiasaina ny tontolo andro ampiasaina  hatramin ny ' + 
                    dateExpiration) + '\\.')
                
                break
            case 'YELOW 1000':
                String dateExpiration = CustomKeywords.'outStream.XML.getDateBundle'('yelow 1000')

                return CustomKeywords.'ussd.Expected.menu'(('Bonus YELOW 1000 restants: 100 SMS vers tous les opérateurs et/ou 50\\.0 Mo utilisable à toute heure \\+ 50\\.0 Mo la nuit jusqu au ' + 
                    dateExpiration) + '\\.', ('Bonus YELOW 1000 tavela: 100 SMS mankany @ tambazotra rehetra  \\+ 50\\.0 Mo ny alina hatramin ny ' + 
                    dateExpiration) + '\\.')
                
                break
            case 'YELOW ONE':
                return CustomKeywords.'ussd.Expected.menu'('YELOW ONE, il vous reste 250\\.0 Mo utilisable a toute heure\\.', 
                    'YELOW ONE, 250\\.0 Mo sisa ny bonus\\-nao azo ampiasaina @ ora rehetra\\.')
                
                break
        }
        
        break //------------------------------------------------*TELMA NET*--------------------------------------------------
    case 'TELMA NET':
        switch (offre) {
            case 'NET ONE NIGHT':
                return CustomKeywords.'ussd.Expected.menu'('NET ONE NIGHT, il vous reste  40\\.0 Mo utlisable de 0H\\-6H et de 21H\\-0H', 
                    'NET ONE NIGHT, 40.0 Mo sisa ny bonus-nao azo ampiasaina @ 0H-6H sy 21H-0H')
                
                break
            case 'NET ONE WEEK 350 Mo':
                String dateExpiration = CustomKeywords.'outStream.XML.getDateBundle'('net one week 350 Mo')

                return CustomKeywords.'ussd.Expected.menu'(('NET ONE WEEK 350 Mo, il vous reste 350\\.0 Mo utilisable a toute heure jusqu au ' + 
                    dateExpiration) + ' inclus\\.', ('NET ONE WEEK 350 Mo, 350\\.0  Mo sisa ny bonus\\-nao azo ampiasaina @ ora rehetra hatramin ny ' + 
                    dateExpiration) + '\\.')
                
                break
            case 'NET ONE WEEK 800 Mo':
                String dateExpiration = CustomKeywords.'outStream.XML.getDateBundle'('net one week 800 Mo')

                return CustomKeywords.'ussd.Expected.menu'(('NET ONE WEEK 800 Mo, il vous reste 800\\.0 Mo utilisable a toute heure jusqu au ' + 
                    dateExpiration) + ' inclus\\.', ('NET ONE WEEK 800 Mo, 800\\.0  Mo sisa ny bonus\\-nao azo ampiasaina @ ora rehetra hatramin ny ' + 
                    dateExpiration) + '\\.')
                
                break
            case 'NET ONE WEEK 2 Go':
                String dateExpiration = CustomKeywords.'outStream.XML.getDateBundle'('net one week 2 Go')

                return CustomKeywords.'ussd.Expected.menu'(('NET ONE WEEK 2 Go, il vous reste 2048\\.0 Mo utilisable a toute heure jusqu au ' + 
                    dateExpiration) + ' inclus\\.', ('NET ONE WEEK 2 Go, 2048\\.0  Mo sisa ny bonus\\-nao azo ampiasaina @ ora rehetra hatramin ny ' + 
                    dateExpiration) + '\\.')
                
                break
            case 'NET ONE MONTH 2 Go':
                String dateExpiration = CustomKeywords.'outStream.XML.getDateBundle'('net one month 2 Go')

                return CustomKeywords.'ussd.Expected.menu'(('NET ONE MONTH 2 Go, il vous reste 2048\\.0 Mo utilisable a toute heure jusqu au ' + 
                    dateExpiration) + ' inclus\\.', ('NET ONE MONTH 2 Go, 2048\\.0  Mo sisa ny bonus-nao azo ampiasaina @ ora rehetra hatramin ny ' + 
                    dateExpiration) + '\\.')
                
                break
            case 'NET ONE MONTH 4 Go':
                String dateExpiration = CustomKeywords.'outStream.XML.getDateBundle'('net one month 4 Go')

                return CustomKeywords.'ussd.Expected.menu'(('NET ONE MONTH 4 Go, il vous reste 4096\\.0 Mo utilisable a toute heure jusqu au ' + 
                    dateExpiration) + ' inclus\\.', ('NET ONE MONTH 4 Go, 4096\\.0  Mo sisa ny bonus-nao azo ampiasaina @ ora rehetra hatramin ny ' + 
                    dateExpiration) + '\\.')
                
                break
            case 'NET ONE MONTH 12 Go':
                String dateExpiration = CustomKeywords.'outStream.XML.getDateBundle'('net one month 12 Go')

                return CustomKeywords.'ussd.Expected.menu'(('NET ONE MONTH 12 Go, il vous reste 12288\\.0 Mo utilisable a toute heure jusqu au ' + 
                    dateExpiration) + ' inclus\\.', ('NET ONE MONTH 12 Go, 12288\\.0  Mo sisa ny bonus-nao azo ampiasaina @ ora rehetra hatramin ny ' + 
                    dateExpiration) + '\\.')
                
                break
            case 'NET ONE MONTH 25 Go':
                String dateExpiration = CustomKeywords.'outStream.XML.getDateBundle'('net one month 25 Go')

                return CustomKeywords.'ussd.Expected.menu'(('NET ONE MONTH 25 Go, il vous reste 25600\\.0 Mo utilisable a toute heure jusqu au ' + 
                    dateExpiration) + ' inclus\\.', ('NET ONE MONTH 25 Go, 25600\\.0  Mo sisa ny bonus-nao azo ampiasaina @ ora rehetra hatramin ny ' + 
                    dateExpiration) + '\\.')
                
                break
            case 'NET ONE MONTH 50Go':
                String dateExpiration = CustomKeywords.'outStream.XML.getDateBundle'('net one month 50 Go')

                return CustomKeywords.'ussd.Expected.menu'(('NET ONE MONTH 50 Go, il vous reste 51200\\.0 Mo utilisable a toute heure jusqu au ' + 
                    dateExpiration) + ' inclus\\.', ('NET ONE MONTH 50 Go, 51200\\.0  Mo sisa ny bonus-nao azo ampiasaina @ ora rehetra hatramin ny ' + 
                    dateExpiration) + '\\.')
                
                break
            case 'NET ONE MONTH 100Go':
                String dateExpiration = CustomKeywords.'outStream.XML.getDateBundle'('net one month 100 Go')

                return CustomKeywords.'ussd.Expected.menu'(('NET ONE MONTH 100 Go, il vous reste 102400\\.0 Mo utilisable a toute heure jusqu au ' + 
                    dateExpiration) + ' inclus\\.', ('NET ONE MONTH 100 Go, 102400\\.0  Mo sisa ny bonus-nao azo ampiasaina @ ora rehetra hatramin ny ' + 
                    dateExpiration) + '\\.')
                
                break
            default:
                return CustomKeywords.'ussd.Expected.menu'(('L achat de votre ' + offre) + ' est reussi\\. Vous avez de DATA utilisable a toute heure\\. Achetez via Mvola et gagnez 20% de bonus\\. \\(#111\\*1#\\)\\.', 
                    ('Tafiditra ny tolotra ' + offre) + ' novidianao\\. Manana  azo ampiasaina @ ora rehetra ianao\\. Vidio @Mvola ny tolotra ary mahazoa bonus 20%\\. \\(#111\\*1#\\)\\.')
        }
}

