mvn -e -q clean
mvn -e -q compile

mvn -e -q exec:java -Dexec.mainClass="cs1302.hw09.TTTSolver"
