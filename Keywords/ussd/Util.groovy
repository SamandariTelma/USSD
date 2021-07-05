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

public class Util {
	@Keyword
	def randomizeNumber() {
		int i=Math.random() * (5000 - 1)
		return i
	}
	@Keyword
	String nextDate(int dateIteration) {
		def today = new java.util.Date()
		def wantedDate = today + dateIteration
		return wantedDate.format("dd/MM/yyy")
	}
	@Keyword
	String nextDate(int dateIteration,String format) {
		def today = new java.util.Date()
		def wantedDate = today + dateIteration
		return wantedDate.format(format)
	}
	@Keyword
	String rechercheMenu(String menu, String actualMenu) {
		boolean menuFound=false
		boolean menuNotFound=false
		int i=0

		String rangMenu

		String actualMenuOffre=actualMenu

		while(menuFound==false && menuNotFound==false) {
			println 'itération '+i
			if(actualMenuOffre.contains(menu)) {
				println 'menu trouvé dans la page'+i
				menuFound=true
				//Recuperer le rang du menu consulté
				rangMenu=actualMenuOffre.substring(actualMenuOffre.lastIndexOf(menu)-2,actualMenuOffre.lastIndexOf(menu)-1)
				println("rang menu:"+rangMenu)
			}
			else if(menuFound==false && (actualMenuOffre.contains('Page suivante')||actualMenuOffre.contains('Pejy manaraka'))) {
				//Passer au menu suivante
				i++
				menuFound=false
				actualMenuOffre='\n2 MORA 500\n3 MORA 500+'
				//actualMenuOffre=CustomKeywords.'ussd.Send.response'('0')
			}
			else if(menuFound==false && !(actualMenuOffre.contains('Page suivante')||actualMenuOffre.contains('Pejy manaraka'))) {
				menuNotFound=true
				println 'menu non trouvé'
			}
		}
		WS.verifyEqual(menuFound, true)
		return rangMenu
	}
}