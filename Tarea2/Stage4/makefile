JFLAGS = -g -encoding ISO8859_1  # -encoding in case latin characters are used
JC = javac
JVM= java  # Added by Agust�n Gonz�lez
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = Component.java Publisher.java Subscriber.java \
Follower.java Recorder.java Monitor.java  \
Broker.java Topic.java T1Stage4.java

MAIN = T1Stage4

default: classes

classes: $(CLASSES:.java=.class)

run: 
	$(JVM) $(MAIN) config.txt

clean:
	$(RM) *.class