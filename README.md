
# README - Tarea 2 ELO329 - Felipe Tapia - Rol:202130023-6

## Archivos del proyecto 

- `Stage4.java`: Interfaz gráfica con menú de opciones
- `VideoPublisher.java`, `VideoFollower.java`: Publicador y suscriptor de video
- `GPSCarPublisher.java`, `CarFollower.java`: Publicador de posiciones GPS y su seguidor
- `Broker.java`, `Topic.java`: Gestión de tópicos y suscripciones
- `Component.java`, `Publisher.java`, `Subscriber.java`: Estructura base
- Makefile
- posiciones.txt

---

## Cómo compilar

Para compilar esta tarea ya que ocupa JAVAFX se tiene que tener las librerias correspondientes y tener el path dependiendo del sistema operativo
Se puede compilar con el makefile con GitBash ya que el cmd de windows en mi caso no tiene instalado los comandos make, para compilar en GitBash se ocupa el siguiente comando 

Para compilar todos los archivos `.java`, utiliza el Makefile:

```
export PATH_TO_FX="/c/Users/felip/Documents/U/ELO329/javafx-sdk-24.0.1/lib"
make run

```
Reemplazando con su respectiva ruta
la otra opcion es compilar y ejecutar en algun editor de texto como IntelliJ o VS y ocupar los siguientes comandos
---

### Stage 4
```
javac --module-path "C:\Users\felip\Documents\U\ELO329\javafx-sdk-24.0.1\lib" --add-modules javafx.controls,javafx.media *.java
java --module-path "C:\Users\felip\Documents\U\ELO329\javafx-sdk-24.0.1\lib" --add-modules javafx.controls Stage4
```

- Finalizar entrada con `Ctrl + Z` + `Enter`.
- O cerrando la ventana 

---

## Notas adicionales

- No hay necesidad de tener el archivo posiciones.txt en la misma carpeta pero es lo recomendable
- Como buena practica se ejecuta el comando "make clean " para limpiar la carpeta de archivos no deseados
- Los seguidores de GPS abren una ventana por separado para cada instancia.
- El botón de video permite reproducir videos desde URL.
- Se debe usar archivos de texto `.txt` con formato `<tiempo> <x> <y>` para las posiciones GPS.

---
