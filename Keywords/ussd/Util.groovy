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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import internal.GlobalVariable
import java.text.NumberFormat

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
	String getLastDayOfMonth() {

		Date today = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);

		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);

		Date lastDayOfMonth = calendar.getTime();

		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(lastDayOfMonth)
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
				try{
					rangMenu=actualMenuOffre.substring(actualMenuOffre.lastIndexOf(menu)-4,actualMenuOffre.lastIndexOf(menu)-3)
				}catch(Exception e)
				{
					print 'err '+Exception
					rangMenu='null'
				}
				if (rangMenu!='\n' && rangMenu!='null')
					rangMenu=actualMenuOffre.substring(actualMenuOffre.lastIndexOf(menu)-2,actualMenuOffre.lastIndexOf(menu)-1)
				else
					rangMenu=actualMenuOffre.substring(actualMenuOffre.lastIndexOf(menu)-3,actualMenuOffre.lastIndexOf(menu)-1)
				println("rang menu:"+rangMenu)
			}
			else if(menuFound==false && (actualMenuOffre.contains('Page suivante')||actualMenuOffre.contains('Pejy manaraka'))) {
				//Passer au menu suivante
				i++
				menuFound=false
				def send= new Send()
				actualMenuOffre=send.response('0')
				//actualMenuOffre='\n2 MORA 500\n3 MORA 500+'
			}
			else if(menuFound==false && !(actualMenuOffre.contains('Page suivante')||actualMenuOffre.contains('Pejy manaraka'))) {
				menuNotFound=true
				println 'menu non trouvé'
			}
		}
		WS.verifyEqual(menuFound, true)
		return rangMenu
	}
	//261 to 0
	@Keyword
	String to034(String msisdn034)
	{
		msisdn034='0'+msisdn034.substring(3)
		return msisdn034
	}

	//0 to 261
	@Keyword
	String to261(String msisdn261)
	{
		msisdn261='261'+msisdn261.substring(1)
		return msisdn261
	}
	//Separateur de millier
	@Keyword
	String separateThousand(int number)
	{
		NumberFormat formatter = NumberFormat.getInstance(new Locale("en_US"))
		String nombre=formatter.format(number)
		return nombre.replace(",", " ")
	}
}