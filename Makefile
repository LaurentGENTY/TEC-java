TEC=tec/
SRC=src/
BLD=build/
TST=tst/
EXC=$(SRC)exceptions/


FLAGS=-d $(BLD) -cp $(BLD) #-Xlint:unchecked -Xlint:deprecation


.PHONY: all build tests clean

all: build

## Building java into .class

build:

	javac $(FLAGS) $(EXC)*.java
	javac $(FLAGS) $(SRC)*.java


tests:
	javac $(FLAGS) $(SRC)*.java $(TST)*.java
	java -ea -cp $(BLD) $(TEC)LancerTests `./recherche.sh`

clean:
	rm -rf $(SRC)*.class *~ \#*#
	rm -rf $(BLD)*

# simple_exception:
# 	javac $(FLAGS) $(SRC)*.java $(TST)*.java
# 	(cd $(BLD) && java -ea SimplePourException)
