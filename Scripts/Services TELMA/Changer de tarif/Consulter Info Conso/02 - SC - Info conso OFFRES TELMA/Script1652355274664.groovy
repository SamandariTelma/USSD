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

String numeroInitiateur = "${numeroInitiateur}"
String groupeOffre ="${groupeOffre}"
String offre ="${offre}"
String tarifCode= "${tarifCode}"

'Après achat Offre avec succès , je consulte mon solde en saisissant #359*tarifCode#'
String actualMenu = CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode359 +"*"+ tarifCode+'#', numeroInitiateur)

'Vérifier la conformité du message'
String menu = WebUI.callTestCase(findTestCase('Services TELMA/Changer de tarif/00 - Prompt et Message achat offre/Message info conso offre'),
	[('offre') : offre, ('groupeOffre') : groupeOffre,], FailureHandling.CONTINUE_ON_FAILURE)

WS.verifyMatch(actualMenu, menu, true)
