package ussd

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Send {
	@Keyword
	String code(String code, String msisdn) {

		def Util=new Util()

		GlobalVariable.message = code

		GlobalVariable.msisdn = msisdn

		GlobalVariable.sessionId = Util.randomizeNumber()

		def response=WS.sendRequest(findTestObject('AdaptIT first menu request'))

		println 'MESSAGE: \n'+ WS.getElementPropertyValue(response, 'message').toString()

		return WS.getElementPropertyValue(response, 'message').toString()
	}
	@Keyword
	String response(String response) {
		GlobalVariable.message = response

		def resp = WS.sendRequest(findTestObject('AdaptIT response menu request'))

		println 'MESSAGE: \n'+WS.getElementPropertyValue(resp, 'message').toString()

		return WS.getElementPropertyValue(resp, 'message').toString()
	}
}
