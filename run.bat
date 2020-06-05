@echo off
chcp 65001
cls
if not exist target\escalade-0.0.1-SNAPSHOT.jar (
	echo **************************************************************************************
	echo * L'application n'est pas installée !                                                *
	echo * Exécuter la commande 'install' en mode console ou double-cliquer sur 'install.bat' *
	echo * pour installer l'application                                                       *
	echo **************************************************************************************
) else (
	java -jar target\escalade-0.0.1-SNAPSHOT.jar
)