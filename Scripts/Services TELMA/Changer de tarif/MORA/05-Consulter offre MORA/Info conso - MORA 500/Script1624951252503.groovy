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

String []menuPage=['Mes offres\n1 MORA 500 (500 Ar)\n2 MORA ONE (1 000 Ar)\n3 MORA+ 2000 (2 000 Ar)\n4 MORA+ 5000 (5 000 Ar)\n5 MORA NIGHT (500 Ar)\n0 Pejy manaraka',
'6 MORA TEAM (1 000 Ar)\n00 Pejy manaraka',
'7 MORA INTERNATIONAL (5 000 Ar)\n00 Pejy aloha']

boolean menuTrouve=false
int i=0


while(menuTrouve==false)
{
	println 'itération '+i
	if(menuPage[i].contains('MORA'))
	{
		println 'menu trouvé dans la page'+i
		menuTrouve=true
	}
	else if(menuTrouve==false && (menuPage[i].contains('Page suivante')||menuPage[i].contains('Pejy manaraka')))
	{
		//Passer au menu suivante
		i++
		menuTrouve=false
	}
}
