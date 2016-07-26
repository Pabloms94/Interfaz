JFLAGS = -g -d build/ -cp "lib/*"
JC = javac

SOURCEDIR = src
BUILDDIR = build
LIBDIR = lib

CLASSPATH = $(LIBDIR)/jcommon-1.0.23.jar gson-2.6.2.jar jfreechart-1.0.19.jar

.SUFFIXES: .java .class

CLASSES = $(SOURCEDIR)/Controlador.java $(SOURCEDIR)/Interfaz.java $(SOURCEDIR)/Main.java $(SOURCEDIR)/Modelo.java $(SOURCEDIR)/Vista.java 

.java.class:
	$(JC) $(JFLAGS) $(SOURCEDIR)/*.java

#MAIN = Main
	
default: classes

classes: $(CLASSES:.java=.class)

run: classes
	java -cp build Main

clean: $(RM) build/*.class