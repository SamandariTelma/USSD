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

'Je compose le short code *130*4*8*1# pour le changement de langage'
GlobalVariable.message = '*130*4*8*1#'

GlobalVariable.msisdn1 = GlobalVariable.msisdn1Grossiste

GlobalVariable.sessionId = CustomKeywords.'ussd.Util.randomizeNumber'()

def response = WS.sendRequest(findTestObject('AdaptIT first menu request'))

message = WS.getElementPropertyValue(response, 'message').toString()

if (message.equals('Le changement de langue a ete pris en compte.'))
{
	GlobalVariable.langue='fr'
}
else if(message.equals('Tanteraka ny fanovana fiteny izay nataonao.'))
{
	GlobalVariable.langue='mg'
}