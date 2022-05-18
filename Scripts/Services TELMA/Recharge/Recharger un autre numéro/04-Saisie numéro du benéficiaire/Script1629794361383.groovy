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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String numeroInitiateur="${numeroInitiateur}"


'En tant que client TELMA, je vais dans le menu pour Recharge en composant #130*4# > 2'
CustomKeywords.'ussd.Send.code'(GlobalVariable.ShortCode+'#', numeroInitiateur)


'Je saisis 2 (Recharger un autre numéro)'
String actualMenu=CustomKeywords.'ussd.Send.response'('2')

'Vérifier la conformité du prompt'
String menu=CustomKeywords.'ussd.Expected.menu'('Entrer numero de tel\\. Destinataire :', 'Nomerao tel\\. andefasana :')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un numéro de téléphone au mauvais format(Alphanumérique)'
actualMenu=CustomKeywords.'ussd.Send.response'('034350@o78')

'Vérifer la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Verifiez le numero de tel\\. destinataire SVP \\(03 & 8 chiffres\\)','Hamarino ny nomerao azafady \\(03 & tarehimarika 8\\)')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un numéro de téléphone non telma'
actualMenu=CustomKeywords.'ussd.Send.response'('0323500078')

'Vérifer la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Verifiez le numero de tel\\. destinataire SVP \\(03 & 8 chiffres\\)','Hamarino ny nomerao azafady \\(03 & tarehimarika 8\\)')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un numéro de téléphone au mauvais format(inférieur à 9 chiffres)'
actualMenu=CustomKeywords.'ussd.Send.response'('034350007')

'Vérifer la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Verifiez le numero de tel\\. destinataire SVP \\(03 & 8 chiffres\\)','Hamarino ny nomerao azafady \\(03 & tarehimarika 8\\)')

WS.verifyMatch(actualMenu, menu, true)

'Je saisis un numéro de téléphone au mauvais format(supérieur à 9 chiffres)'
actualMenu=CustomKeywords.'ussd.Send.response'('03435000780')

'Vérifer la conformité du prompt'
menu=CustomKeywords.'ussd.Expected.menu'('Le nombre d\'essai maximum a ete atteint\\.','Mihaotra ny fanandramana azo ekena\\.')

WS.verifyMatch(actualMenu, menu, true)
