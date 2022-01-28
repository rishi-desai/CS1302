rm -rf bin
mkdir bin

javac -d bin -cp phase2.jar src/cs1302/p2/BaseStringList.java
javac -d bin -cp phase2.jar:bin src/cs1302/p2/ArrayStringList.java
javac -d bin -cp phase2.jar:bin src/cs1302/p2/LinkedStringList.java
javac -d bin -cp phase2.jar:bin driver/Driver.java

java -cp phase2.jar:bin Driver
