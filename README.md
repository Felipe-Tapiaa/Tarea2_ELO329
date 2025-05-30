
# README - Tarea 1 ELO329 - Felipe Tapia - Rol:202130023-6

## Archivos del proyecto 

- T1Stage4.java
- Broker.java
- Topic.java
- Component.java
- Publisher.java
- Subscriber.java
- Follower.java
- Recorder.java
- Monitor.java
- Counter.java
- config.txt
- Makefile

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

### Stage 1
```
make run
```
- No requiere archivo de configuración externo.
- Ingresar los mensajes:
  ```
  Hola a todos
  Bienvenidos a la transmisión
  Hoy aprenderemos Java
  ```
- Finalizar entrada con `Ctrl + Z` + `Enter`.

---

### Stage 2
```
make run
```
- Ingresar coordenadas:
  ```
  100 200
  300 400
  500 600
  ```
- Finalizar entrada con `Ctrl + Z` + `Enter`.

---

### Stage 3
```
make run
```
- Ingresar mensajes en formato `NombrePublicador mensaje`:
  ```
  Streamer1 Hola a todos
  Streamer1 Hoy aprenderemos Java
  Streamer1 No se lo pierdan
  ```
- Finalizar entrada con `Ctrl + Z` + `Enter`.

---

### Stage 4
```
make run
```
- Ingresar mensajes:
  ```
  Streamer1 Bienvenidos a todos
  Streamer1 Hoy aprenderemos Java
  GPS1 100 200
  GPS1 700 700
  GPS1 20 20
  StreamerX Esto no debería funcionar
  ```
- Finalizar entrada con `Ctrl + Z` + `Enter`.

---

## Notas adicionales

- El programa detecta publicadores desconocidos e imprime `"Unknown Publisher"`.
- Los mensajes y coordenadas son guardados en diferentes archivos según el suscriptor.
- Los `Counter` imprimen un resumen final de mensajes recibidos.
- Los comando "$ tail -f seguidor.txt" y "$ tail -f trayectoria.txt" sirven para saber si el codigo funciona o abrir el archivo con un editor de texto como por ejemplo nano.
- Como buena practica se ejecuta el comando "make clean " para limpiar la carpeta de archivos no deseados

---

## Bonificación Extra

Tambien se ejecuta con el comando "make run" y los mensajes a ingresar son los mismos que en el Stage 4.

Se implementó la funcionalidad de **Contadores (`Counter`)** para optar a la bonificación extra.

---
