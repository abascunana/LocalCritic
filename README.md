# LocalCritic
### (1º DAM 2021-2022)
*Bascuñana Sánchez, Antoni Xavier 
Borrás Mercant, Xavier
Marcos Nazco, Miguel*





### ¿Qué es LocalCritic?
LocalCritic es una página web (**local**) orientada la crítica/opinión y valoración de obras del mundo del entretenimiento como películas, videojuegos, libros o canciones. Dentro de la página se encuentran diferentes obras (de los cuatro tipos previamente mencionados) las cuales cuentan con una valoración media que se adquiere mediante las críticas de los usuarios, los cuales al hacer la crítica deben escribir una valoración personal y el texto de su crítica.

Hay que indicar que existen dos tipos de usuario, el usuario **básico** y el usuario **administrador**, que como bien dice su nombre, es el encargado de gestionar la web y posee privilegios específicos para ello.


### Estructura de la Página
Se divide en:

* **Página inicial** (`index.html`): En está página se muestran las portadas y el título de las obras destacadas; también existe la posibilidad de pueden buscar obras mediante un *search-box*. Esta página inicial, al igual que el resto, disponen de una barra de navegación para desplazarse a los distintos puntos de interés de la web (*los veremos más tarde*) y a su vez, un *footer* donde hay una breve definición sobre la web, el logo y un enlace al repositorio de *GitHub*.


* **Perfil de usuario** (`perfilUsuario.html`): Se muestra un contenedor donde se encuentra la información del usuario (*nombre, media valoraciones, karma (puntuación basada en upvotes y downvotes), numero de críticas del usuario*) y por debajo de este se despliegan todas las críticas creadas por el usuario (*donde se muestra el nombre del usuario, el tipo de usuario, la valoración del usuario hacia la obra, el numero de Upvotes y Downvotes y sus botones correspondientes*). Para obtener un perfil de usuario es necesario haber registrado el usuario y haber iniciado sesión, si no, no aparecerá la opción acceder al perfil.

* **Insertar obras** (`InsertarObra.html`): Esta página únicamente está disponible como administrador y consiste en una sección con cuatro opciones (`RegistroPelicula.html`, `RegistroJuegos.html`, `RegistroLibro.html` y `RegistroCancion.html`, las cuales también están habilitadas únicamente para administradores al clicar encima de alguna de las opciones se redirige a una página para insertar nuevas obras del tipo de obra que hayas escogido antes en las cuatro opciones. 
Estas últimas cuatro páginas consisten en un formulario con diferentes campos, *dependiendo del tipo de obra escogido*, y un botón *submit* que permite que se conecte con el servidor Tomcat y se inserte dentro de la base de datos en la tabla del tipo de obra correspondiente y en la tabla de obras general, donde disponen de una id diferente para evitar la duplicación de id entre diferentes tipos de obras.

* **Resultados de la Búsqueda** (`resultadosBusqueda.html`): Al buscar una obra en la *search-box* en cualquier sección de la página se redirige a esta, donde se muestran unos resultados u otros dependiendo de qué se haya buscado:
Si se ha buscado un nombre similar de la obra, *pero no completo*, aparecerá la ficha técnica (donde se incluye la información correspondiente de cada tipo de obra) de todas las obras que tengan un nombre similar.
En cambio, si se ha buscado el nombre exacto de la obra aparecerá también la ficha técnica y todas sus críticas,* si dispone de ellos*.


### Elementos relevantes

* **Barra de navegación** (*Usuario básico*): La barra de navegación como usuario **básico** se muestra en la parte superior de la web ocupando toda la anchura del *viewport*. Dentro de la barra de navegación encontramos una lista que contiene los "*botones*" interactivos que redirigen a donde corresponda según el que se pulse; los "*botones*" que aparecen son: el logo de LocalCritic (redirige al index), Registrarse o iniciar sesión (en el caso en el que no se tenga usuario o no estes *logueado*), Cerrar sesión (si ya se ha iniciado sesión y es accionado cierra la sesión del usuario), Perfil (solamente aparece si se ha iniciado sesión y te redirige a tu perfil de usuario).

* **Barra de navegación** (*Usuario administrador*): La barra de navegación de administrador muestra todo lo que muestra la de usuario básico además de opciones exclusivas. Para acceder a estas, evidentemente debes estar dado de alta como administrador e iniciar sesión; las opciones exclusivas de admin están comprimidas en la página que hemos mencionado previamente como `InsertarObra.html` la cual te redirige a una pagina con cuatro opciones de insertar obra distintas (para mostrar)


	
