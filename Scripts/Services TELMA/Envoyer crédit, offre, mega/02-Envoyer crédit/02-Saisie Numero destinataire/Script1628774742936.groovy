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
String montantAEnvoyer="${montantAEnvoyer}"

'Je shortcode #130*4*4#'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'#', numeroInitiateur)

'Je saisis 1 (Envoyer du credit) et valide'
CustomKeywords.'ussd.Send.response'('1')

'Je saisis un montant correct et je valide'
CustomKeywords.'ussd.Send.response'(montantAEnvoyer)

'Je saisis un numéro au mauvais format (alphabenumerique) : '
String actualMenu=CustomKeywords.'ussd.Send.response'('034350078@a')

'Vérifier que je reste sur le prompt de saisie numero de tel'
String menu=CustomKeywords.'ussd.Expected.menu'('Entrer numero de tel\\. Destinataire :', 'nomerao tel\\. andefasana :')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un numéro non valide'
actualMenu=CustomKeywords.'ussd.Send.response'('4214569875')

'Vérifier que je reste sur le prompt de saisie numero de tel'
menu=CustomKeywords.'ussd.Expected.menu'('Entrer numero de tel\\. Destinataire :', 'nomerao tel\\. andefasana :')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un numéro non telma'
actualMenu=CustomKeywords.'ussd.Send.response'('03245632154')

'Vérifier que je reste sur le prompt de saisie numero de tel'
menu=CustomKeywords.'ussd.Expected.menu'('Entrer numero de tel\\. Destinataire :', 'nomerao tel\\. andefasana :')

WS.verifyMatch(actualMenu, menu, true)

'Je ne sasis rien et je valide'
actualMenu=CustomKeywords.'ussd.Send.response'('')

'Vérifier que je reste sur le prompt de saisie numero de tel'
menu=CustomKeywords.'ussd.Expected.menu'('null')

WS.verifyMatch(actualMenu, menu, true)
