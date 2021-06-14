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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

String numeroInitiateur="${numeroInitiateur}"
'En tant que client TELMA, je vais dans mon USSD en composant le short code *130#'
String actualMenu = CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCodeTELMA,numeroInitiateur)

'Vérifier l\'affichage du menu SOS Credit parmi les menus affichés'

String menu=CustomKeywords.'ussd.Expected.menu'('^.*3 SOS Credit.*$', '^.*3 SOS Fahana.*$')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis 3 et je valide'

actualMenu = CustomKeywords.'ussd.Send.response'('3')

'Vérifier l\'affichage des sous menus'

menu=CustomKeywords.'ussd.Expected.menu'('^SOS Crédit\n1 SOS credit a un ami\n2 SOS Credit a TELMA\n3 SOS offre a TELMA\n4 Rembourser SOS\n5 Aide$', '^SOS Crédit\n1 SOS fahana any amin\'ny namana\n2 SOS fahana any amin\'ny TELMA\n3 SOS offre a TELMA\n4 Hamerina SOS credit\n5 Fanampiana$')

WS.verifyMatch(actualMenu, menu, true)
