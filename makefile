Jflags = -g
JCC = javac

AsciiAnim:AsciiAnim.class AsciiCanvas.class node.class

AsciiAnim.class: node.class AsciiCanvas.class AsciiAnim.java
	$(JCC) $(Jflags) AsciiAnim.java
AsciiCanvas.class: node.class AsciiCanvas.java
	$(JCC) $(Jflags) AsciiCanvas.java
node.class: node.java
	$(JCC) $(Jflags)  node.java

clean:
	rm *.class AsciiAnimation
run: AsciiAnim.class
	java AsciiAnim
