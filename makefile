JFLAGS = -g -d $(BUILDDIR) -cp "$(LIBDIR)/*" -encoding ISO-8859-1
JC = javac

SOURCEDIR = src
BUILDDIR = build
LIBDIR = lib

CLASSPATH = $(LIBDIR)/jcommon-1.0.23.jar gson-2.6.2.jar jfreechart-1.0.19.jar

.SUFFIXES: .java .class

CLASSES = $(SOURCEDIR)/Controlador.java $(SOURCEDIR)/Interfaz.java $(SOURCEDIR)/Main.java $(SOURCEDIR)/Modelo.java $(SOURCEDIR)/Vista.java 

.java.class: 
	$(JC) $(JFLAGS) $(SOURCEDIR)/*.java
	
default: classes

classes: dir mf $(CLASSES:.java=.class) jar

dir:
	mkdir -p $(BUILDDIR)
	
mf:
	cp -r manifest.mf $(BUILDDIR)
	cp -r lib $(BUILDDIR)
	
jar: classes
	cd $(BUILDDIR) && jar -cvfm Xpectra.jar manifest.mf *.class

clean: 
	$(RM) build/*.class

.PHONY: 
	jar dir mf