## Intrucciones de ejecución:

Dentro del directorio `../Agenda Electronica` ejecutar los siguientes comandos:

```shell
chmod +x build.sh
./build.sh
java -jar AgendaElectronica.jar
```
Y se podrá empezar a utilizar la Agenda Electrónica :)


> [!NOTE]
> En esta implementación se guardan archivos `.data` que quedan a manera de histórico, es decir, se eliminen o alteren de la agenda principal, estos objetos quedan guardados por si se necesita una recuperación de los datos alterados. Se encunetran en el directorio `../data/historico/` y se separan entre registros, citas y notas.
