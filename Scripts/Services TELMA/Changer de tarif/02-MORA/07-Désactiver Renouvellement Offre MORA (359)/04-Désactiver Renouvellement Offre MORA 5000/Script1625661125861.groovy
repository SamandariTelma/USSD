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

String dateExpiration=CustomKeywords.'ussd.Util.getLastDayOfMonth'()


'Après desactivation Offre FIRST ROYAL, je short code #359#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode359+'#', numeroInitiateur)

'Je saisis 1 (Mes offres) et valide'
String actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier si l\'offre apparait dans la liste offre'
String rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('MORA+ 5000', actualMenu)

'Je saisis le rang du menu MORA+ 5000 et valide'
CustomKeywords.'ussd.Send.response'(rangMenu)

'Je saisis 2 (Renouvellement automatique)et valide'
CustomKeywords.'ussd.Send.response'('2')

'Je saisis 1 pour desactiver le renouvellement automatique et valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('Vous avez desactive avec succes le renouvellement automatique de l offre MORA\\+ 5000\\. Pour le reactiver, tapez #359\\*35\\*1#')

WS.verifyMatch(actualMenu, menu, true)