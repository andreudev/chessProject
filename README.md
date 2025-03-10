# Proyecto de Ajedrez

Este proyecto es una simulación de un juego de ajedrez que permite generar piezas de ajedrez, ordenarlas utilizando diferentes algoritmos de ordenamiento y visualizar el tablero en diferentes vistas.

## Compilación

Para compilar el proyecto, asegúrate de tener instalado JDK 20. Luego, puedes compilar el proyecto utilizando el siguiente comando:

```sh
javac -d . -sourcepath src src/com/chess/Main.java
```

Esto compilará todos los archivos `.java` y colocará los archivos `.class` en el directorio `out`.

## Ejecución

Para ejecutar el proyecto, utiliza el siguiente comando:

```sh
java -cp out com.chess.Main [parametros]
```

## Parámetros

El programa acepta los siguientes parámetros:

- `a`: Algoritmo de ordenamiento (`m` para Merge Sort, `q` para Quick Sort, `i` para Insertion Sort, `b` para Bubble Sort).
- `t`: Tipo de datos (`c` para Caracter, `n` para Numérico).
- `c`: Color del tablero (`b` para Blancas, `n` para Negras).
- `r`: Número de piezas (1, 2, 4, 6, 8, 10, 16).
- `s`: Intervalo en milisegundos entre cada operación de ordenamiento (de 100 a 1000).

### Ejemplo de Uso

```sh
java -cp . com.chess.Main a=i t=c c=b r=16 s=100
```

Este comando ejecutará el programa con los siguientes parámetros:

- Algoritmo de ordenamiento: Insertion Sort
- Tipo de datos: Caracter
- Color del tablero: Negras
- Número de piezas: 4
- Intervalo: 100 milisegundos

## Descripción de Clases Principales

- `Main.java`: Punto de entrada del programa.
- `ChessGame.java`: Representa un juego de ajedrez con varias configuraciones.
- `ChessBoard.java`: Representa un tablero de ajedrez con piezas y una vista.
- `Piece.java`: Clase abstracta que representa una pieza de ajedrez.
- `PieceGenerator.java`: Genera piezas de ajedrez aleatorias.
- `YArgs.java`: Utilidad para dividir los argumentos de la línea de comandos.
- `WhiteBoardView.java` y `BlackBoardView.java`: Implementaciones de la interfaz `BoardView` para mostrar el tablero.

## Algoritmos de Ordenamiento

- `BubbleSort.java`: Implementa el algoritmo de ordenamiento Bubble Sort.
- `InsertionSort.java`: Implementa el algoritmo de ordenamiento Insertion Sort.
- `QuickSort.java`: Implementa el algoritmo de ordenamiento Quick Sort.

## Excepciones

- `AlgorithmTypeError.java`: Excepción lanzada cuando se especifica un algoritmo inválido.
- `ColorTypeError.java`: Excepción lanzada cuando se especifica un color inválido.
- `DataTypeError.java`: Excepción lanzada cuando se especifica un tipo de datos inválido.
- `NumbersTypesErrors.java`: Excepción lanzada cuando se especifica un número inválido.

## Interfaces

- `BoardView.java`: Interfaz para mostrar el tablero de ajedrez.
- `PieceFactory.java`: Interfaz para crear piezas de ajedrez.
- `SortingStrategy.java`: Interfaz para implementar diferentes estrategias de ordenamiento.

## Diagrama de Clases

![Diagrama de Clases](Diagrama%20UML.svg)