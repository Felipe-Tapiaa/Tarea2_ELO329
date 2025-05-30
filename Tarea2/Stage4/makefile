JFLAGS = -g --module-path $(PATH_TO_FX) --add-modules javafx.controls,javafx.media -encoding ISO8859_1  # -encoding in case latin characters are used
JC = javac
JVM= java  # Added by Agust�n Gonz�lez
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = Broker.java CarFollower.java Component.java  /
Follower.java GPSCarPublisher.java GPSPosition.java /
Monitor.java Publisher.java Recorder.java Stage4.java /
Subscriber.java Topic.java VideoFollower.java VideoPublisher.java
Broker.java Topic.java T1Stage4.java

MAIN = Stage4

default: classes

classes: $(CLASSES:.java=.class)

run: 
	$(JVM) $(MAIN) config.txt

clean:
	$(RM) *.class

