# X-pectra
Programa en lenguaje Java que complementa al programa en C y que representa modelos de fuentes de rayos X, concretamente con ánodos de tungsteno.

##Preparación
* Necesitaremos descargar el directorio src, el cual contiene todos los ficheros fuente.
* La carpeta lib, que contiene las librerías externas utilizadas.
* La imagen icon.png es la que se usará como logo, por lo que habrá que descargarla para que la aplicación la pueda mostrar.
* Y el makefile, archivo con el cual compilaremos nuestro programa.

##Requisitos del sistema
No es necesario ningún requisito especial.

##Instalación
* Crearemos una carpeta que podemos llamar X-pectra, si no lo hemos hecho ya, por ejemplo. Aquí reuniremos todo lo necesario para el funcionamiento completo de la aplicación. El nombre no es importante.
  1. En ella tendremos que crear 2 carpetas: 
    * Una para la parte de C. La llamaremos XpectraC.
    * La otra para la parte de Java, en la que estamos. La llamaremos XpectraJ.
    1. En la carpeta llamada XpectraJ colocaremos todo el contenido nombrado anteriormente en la sección de preparación.
    1. En la carteta XpectraC introduciremos toda la parte de los cálculos en C, situada en el repositorio "TFG".

![Screenshot](/Images/1.png)

- - - -
 
![Screenshot](/Images/2.png)

* Hecho ésto, podemos ejecutar el comando make desde nuestra terminal situada en el directorio ../X-pectra/XpectraJ. De esta manera se nos creará automáticamente una carpeta llamada build que contendrá todos los objetos creados de tipo class. El mismo makefile ejecuta la aplicación.

* Se abrirá la ventana principal de la aplicación y nos pedirá los 5 argumentos necesarios para su funcionamiento (podemos dejar los que vienen por defecto):
  1. E0: referente al valor máximo sobre el cual calcularemos nuestro espectro.
  2. Theta: ángulo en grados.
  3. Phi: ángulo en grados.
  4. Ey: valor mínimo del intervalo donde calcularemos el espectro.
  5. Intervalo: unidades que separarán un valor de X del siguiente.
  Si lo hacemos correctamente, cambiará automáticamente de pestaña y nos mostrará los resultados calculados gráficamente.

![Screenshot](/Images/3.png)

- - - - 

![Screenshot](/Images/4.png)

* Si buscamos cambiar dichos resultados con una cierta atenuación, podemos hacerlo gracias al menú desplegable y el textField. Con ellos elegimos el material que deseamos atravesar y la distancia o ancho del mismo (en cm).

![Screenshot](/Images/6.png)

* El programa es capaz de exportar los resultados actuales a un fichero .csv, para trabajar con ellos en Excel, por ejemplo.

![Screenshot](/Images/2.png)

* La aplicación cuenta también con ayuda, donde se explican los parámetros y funcionalidad.

##Herramientas usadas
Se ha trabajado con el IDE de Eclipse, y los frameworks:
  * gson-2.6.2 para el tratamiento de ficheros JSON
  * jcommmon-1.0.23 y jfreechart-1.0.19 para la generación de gráficas

##Autor
Pablo Martín Sánchez

##Tutores
Guillermo Hernández

María Belén Pérez Lancho

##License
[LICENSE](https://raw.githubusercontent.com/Pabloms94/Interfaz/master/LICENSE.txt)
