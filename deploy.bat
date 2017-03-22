@echo off
@cd c:%~p1
@for %%a in (.) do set currentfolder=%%~na
@set wildFly=C:\Program Files\wildfly-10.0.0.Final\standalone\deployments
@set archive=C:\Program Files\wildfly-10.0.0.Final\
@FOR /f "tokens=1-8 delims=:./ " %%G IN ("%date%_%time%") DO (SET datetime=%%G%%H%%I_%%J_%%K)
@echo %datetime%
@copy  "%wildFly%\%currentfolder%.war" "%archive%\%datetime% - %currentfolder%.war"
@del "%wildfly%\%currentfolder%.war"
@call mvn clean install -DskipTests
@del "%wildfly%\%currentfolder%*"
@copy /y target\*.war "%wildfly%"\
