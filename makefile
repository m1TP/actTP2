


compile: 
	javac -cp . src/util/*.java src/main/*.java src/implementation/*.java
	
game:
	java -cp . src/main/Game
	
do:
	java -cp . src/main/Main