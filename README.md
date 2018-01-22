# Proyecto_notas_v0.1
Primera version de la aplicación en la cual podemos entrar con nuestro usuario y añadir las asignaturas y su nota correspondiente para tener un control sobre ellas.
Esta aplicación es un proyecto JSF con PrimeFaces.

# Instalación
Necesitaremos una base de datos redis, la cual la crearemos automáticamente con el fichero python, necesitaremos el interprete de python y por supuesto maven.

## 1. Redis
   Necesitaremos tener instalado la base de datos redis, a partir de aquí lo primero que tendremos que hacer es istalar el comando  pip con sudo apt-get install pip
    Ahora que lo tenemos instalado, tendremos que instalar pip-python con sudo apt-get install python-pip
Ya tenemos todo lo necesario para ejecutar nuestro script python que nos generará la base de datos con python datos_notas_redis.py 
y ya tendremos nuesta base de datos creada.

## 2. Ejecución
   Para iniciar nuestra aplicación nos colocaremos en la raiz del proyecto y ejecutaremos mvn clean install jetty:run
   y accederemos desde el navegador a localhost:9999
  
## 3. Funcionamiento
   En la página de inicio de sección, podremos acceder con 3 usuarios (delossantos, jerbi, alcon) y la contraseña son las 3 primeras letras de su nombre.
   Una vez iniciado sección podremos introducir, eliminar y modificar las asignaturas y notas a demas de cerrar hacer logout
   
## 4. Errores y proximas actualizaciones:
  Para las proximas versiones del programa añadiremos:
    - Crear nuevas cuentas de alumnos
    - Cuenta de profesor con total cotrol para modificar cualquier cuenta del alumno
    - Mejor interfaz
    - Solución de errores:
      - A la hora de eliminar, refrescar la página
      - Errores a la hora de modificar (a veces se debe introducir 2 veces el mismo dato para su modificación)
    - Mejora del código
      
   
