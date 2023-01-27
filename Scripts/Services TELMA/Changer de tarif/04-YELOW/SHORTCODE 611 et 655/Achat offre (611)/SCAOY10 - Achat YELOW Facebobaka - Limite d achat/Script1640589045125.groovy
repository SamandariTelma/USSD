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

String numeroInitiateur = "$numeroInitiateur"

String nextDate=CustomKeywords.'ussd.Util.nextDate'(3)

'2eme tentative d achat yelow facebobaka'
WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/04-YELOW/SHORTCODE 611 et 655/Achat offre (611)/SCAOY03 - Achat YELOW Facebobaka'), 
    [('numeroInitiateur') : numeroInitiateur], FailureHandling.CONTINUE_ON_FAILURE)

'Je tente d ahcheter un offre YELOW Facebobaka pour la 3ème fois :  *611*65#'
String actualMenu = CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCoddeDirectAchat + '*65#', numeroInitiateur)

'Vérifier la conformité du message'
String menu = CustomKeywords.'ussd.Expected.menu'(('Desole, vous avez utilise toutes vos demandes\\. Vous pourrez envoyer 2 demandes a partir du ' + 
    nextDate) + '\\.', ('Tapitra ny fahafahanao mampiasa io tolotra io\\. Amin ny ' + nextDate) + ' indray ianao afaka mividy 2\\.')

WS.verifyMatch(actualMenu, menu, true)

