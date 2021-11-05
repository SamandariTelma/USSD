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

'Je consulte mon solde crédit en saisissant le code ussd #111*4*1*1#'
String actualMenu=CustomKeywords.'ussd.Send.code'('*130*4*1*1#', numeroInitiateur)

GlobalVariable.soldeCredit=getBalance(actualMenu)

println('Votre crédit est de: '+GlobalVariable.soldeCredit)

//Methode de récupération du solde
int getBalance(String actualMenu)
{
	String solde
	int soldeCredit
	if(GlobalVariable.langue.equals('fr'))
	{
		solde=actualMenu.substring(actualMenu.lastIndexOf('credit est de')+14,actualMenu.lastIndexOf('Ar,'))
		soldeCredit=solde.replaceAll("\\s","").toInteger()
	}
	else if(GlobalVariable.langue.equals('mg'))
	{
		solde=actualMenu.substring(actualMenu.lastIndexOf('anananao dia')+13,actualMenu.lastIndexOf('Ar,'))
		soldeCredit=solde.replaceAll("\\s","").toInteger()
	}
	return soldeCredit
}