import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

String numeroInitiateur = "$numeroInitiateur"

String numeroRecepteur = "$numeroRecepteur"

String montant = "$montant"

String offre = "$offre"

String tarifCode = "$tarifCode"

numeroRecepteur = CustomKeywords.'ussd.Util.to034'(numeroRecepteur)
'En tant que GP, j\'effectue un achat offre MORA via Mvola:  *611*tarifCodeMora*1#'
String actualMenu = CustomKeywords.'ussd.Send.code'(((GlobalVariable.shortCodeDirectAchat + '*') + tarifCode) + '*1#', numeroInitiateur)

'Vérifier la conformité du message'
String menu = WebUI.callTestCase(findTestCase('null'), 
    [('montant') : montant, ('offre') : offre], FailureHandling.CONTINUE_ON_FAILURE)

WS.verifyMatch(actualMenu, menu, true)

//RunConfiguration.getExecutionSource().toString().substring(RunConfiguration.getExecutionSource().toString().lastIndexOf("\\")+1)


