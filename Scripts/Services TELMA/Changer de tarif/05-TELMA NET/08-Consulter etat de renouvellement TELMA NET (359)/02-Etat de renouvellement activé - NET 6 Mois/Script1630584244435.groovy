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

String dateExpiration=CustomKeywords.'ussd.Util.nextDate'(179,'dd/MM/yyy')


'Après achat Offre NET 6 MOIS avec succès , je consulte mon solde en saisissant #359#'
String actualMenu=CustomKeywords.'ussd.Send.code'(GlobalVariable.shortCode359+'#', numeroInitiateur)

'Je saisis 1 (Mes offres) et valide'
actualMenu=CustomKeywords.'ussd.Send.response'('1')

'Vérifier si l\'offre apparait dans la liste offre'
String rangMenu=CustomKeywords.'ussd.Util.rechercheMenu'('NET 6 MOIS', actualMenu)

'Je saisis le rang du menu NET 6 MOIS et valide'
CustomKeywords.'ussd.Send.response'(rangMenu)

'Je saisis 2 (Renouvellement automatique)et valide'
actualMenu=CustomKeywords.'ussd.Send.response'('2')

'Vérifier la conformité du message'
String menu=CustomKeywords.'ussd.Expected.menu'('1 Votre offre NET 6 MOIS sera automatiquement renouvelee le '+dateExpiration+' a minuit\\. Pour desactiver le renouvellement tapez 1',
	'1 Ny tolotra NET 6 MOIS dia hohavaozina ny '+dateExpiration+' @ misasak\'alina\\. Raha hanafoana io fanavaozana io, tsindrio 1')

WS.verifyMatch(actualMenu, menu, true)