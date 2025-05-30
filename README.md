
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

Para compilar todos los archivos `.java`, utiliza el Makefile:

```
make
```

Esto generará todos los archivos `.class` necesarios para ejecutar el programa.

---

## Cómo ejecutar

Cada etapa se ejecuta de la siguiente manera:

### Stage 
```
make run
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
