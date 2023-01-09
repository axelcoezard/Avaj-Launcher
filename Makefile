all:
	@find * -name "*.java" > sources.txt
	@javac -sourcepath ./src/ -d bin @sources.txt
	@cd ./bin && java com.acoezard.avaj_launcher.Main
