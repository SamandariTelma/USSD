package outStream

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

import groovy.xml.StreamingMarkupBuilder
import groovy.xml.XmlUtil


import internal.GlobalVariable

public class XML {
	
	String filePath="D:\\Utilisateurs\\samandari\\QA\\PROJET AUTOMATISATION\\USSD\\USSD TELMA\\Include\\DateAchatBundle.xml"
	String bundleName
	def xmlFile = filePath
	def xml = new XmlSlurper().parse(xmlFile)
	
	@Keyword
	public setDateBundle(String bundle, String date, String time) {

		bundleName=bundle

		switch (bundleName) {
			case "yelow sms":
				xml.BundleYsms.date = date;
				xml.BundleYsms.heure = time;
				break;

			case "yelow 200":
				xml.BundleY200.date = date;
				xml.BundleY200.heure = time;
				break;

			case "yelow facebobaka":
				xml.BundleYfacebobaka.date = date;
				xml.BundleYfacebobaka.heure = time;
				break;

			case "yelow faceboobaka":
				xml.BundleYfaceboobaka.date = date;
				xml.BundleYfaceboobaka.heure = time;
				break;
		}

		def writer = new FileWriter(filePath)

		XmlUtil.serialize(xml, writer)
	}
	
	@Keyword
	public String getDateBundle(String bundle) {

		bundleName=bundle

		switch (bundleName) {
			case "yelow sms":
				return xml.BundleYsms.date;
				break;

			case "yelow 200":
				return xml.BundleY200.date;
				break;

			case "yelow facebobaka":
				return xml.BundleYfacebobaka.date;
				break;

			case "yelow faceboobaka":
				return xml.BundleYfaceboobaka.date;
				break;
		}
	}
	
	@Keyword
	public String getTimeBundle(String bundle) {

		bundleName=bundle

		switch (bundleName) {
			case "yelow sms":
				return xml.BundleYsms.heure;
				break;

			case "yelow 200":
				return xml.BundleY200.heure;
				break;

			case "yelow facebobaka":
				return xml.BundleYfacebobaka.heure;
				break;

			case "yelow faceboobaka":
				return xml.BundleYfaceboobaka.heure;
				break;
		}
	}
}
