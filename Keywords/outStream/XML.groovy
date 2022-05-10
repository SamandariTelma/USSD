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
			case "yelow faceboobaka one":
				xml.BundleYfaceboobakaOne.date = date;
				xml.BundleYfaceboobakaOne.heure = time;
				break;
			case "yelow 1000":
				xml.BundleY1000.date = date;
				xml.BundleY1000.heure = time;
				break;
			case "yelow faceboobaka":
				xml.BundleYfaceboobaka.date = date;
				xml.BundleYfaceboobaka.heure = time;
				break;
			case "net one week 350 Mo":
				xml.BundleNetOneWeek350.date = date;
				xml.BundleNetOneWeek350.heure = time;
				break;
			case "net one week 800 Mo":
				xml.BundleNetOneWeek800.date = date;
				xml.BundleNetOneWeek800.heure = time;
				break;
			case "net one week 2 Go":
				xml.BundleNetOneWeek2.date = date;
				xml.BundleNetOneWeek2.heure = time;
				break;
			case "net one month 2 Go":
				xml.BundleNetOneMonth2.date = date;
				xml.BundleNetOneMonth2.heure = time;
				break;
			case "net one month 4 Go":
				xml.BundleNetOneMonth4.date = date;
				xml.BundleNetOneMonth4.heure = time;
				break;
			case "net one month 12 Go":
				xml.BundleNetOneMonth12.date = date;
				xml.BundleNetOneMonth12.heure = time;
				break;
			case "net one month 25 Go":
				xml.BundleNetOneMonth25.date = date;
				xml.BundleNetOneMonth25.heure = time;
				break;
			case "net one month 50 Go":
				xml.BundleNetOneMonth50.date = date;
				xml.BundleNetOneMonth50.heure = time;
				break;
			case "net one month 100 Go":
				xml.BundleNetOneMonth100.date = date;
				xml.BundleNetOneMonth100.heure = time;
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
			case "yelow faceboobaka one":
				return xml.BundleYfaceboobakaOne.date;
				break;
			case "yelow faceboobaka":
				return xml.BundleYfaceboobaka.date;
				break;
			case "yelow 1000":
				return xml.BundleY1000.date;
				break;
			case "net one week 350 Mo":
				return xml.BundleNetOneWeek350.date;
				break;
			case "net one week 800 Mo":
				return xml.BundleNetOneWeek800.date;
				break;
			case "net one week 2 Go":
				return xml.BundleNetOneWeek2.date;
				break;
			case "net one month 2 Go":
				return xml.BundleNetOneMonth2.date;
				break;
			case "net one month 4 Go":
				return xml.BundleNetOneMonth4.date;
				break;
			case "net one month 12 Go":
				return xml.BundleNetOneMonth12.date;
				break;
			case "net one month 25 Go":
				return xml.BundleNetOneMonth25.date;
				break;
			case "net one month 50 Go":
				return xml.BundleNetOneMonth50.date;
				break;
			case "net one month 100 Go":
				return xml.BundleNetOneMonth100.date;
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

			case "yelow faceboobaka one":
				return xml.BundleYfaceboobakaOne.heure;
				break;

			case "yelow faceboobaka":
				return xml.BundleYfaceboobaka.heure;
				break;
			case "yelow 1000":
				return xml.BundleY1000.heure;
				break;
			case "net one week 350 Mo":
				return xml.BundleNetOneWeek350.heure;
				break;
			case "net one week 800 Mo":
				return xml.BundleNetOneWeek800.heure;
				break;
			case "net one week 2 Go":
				return xml.BundleNetOneWeek2.heure;
				break;
			case "net one month 2 Go":
				return xml.BundleNetOneMonth2.heure;
				break;
			case "net one month 4 Go":
				return xml.BundleNetOneMonth4.heure;
				break;
			case "net one month 12 Go":
				return xml.BundleNetOneMonth12.heure;
				break;
			case "net one month 25 Go":
				return xml.BundleNetOneMonth25.heure;
				break;
			case "net one month 50 Go":
				return xml.BundleNetOneMonth50.heure;
				break;
			case "net one month 100 Go":
				return xml.BundleNetOneMonth100.heure;
				break;
		}
	}
}

