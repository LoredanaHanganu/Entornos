package cribaRefactor;

import java.util.Scanner;

public class CribaRefactorizada {
    // Método para generar números primos de 1 a max
    public static int[] generarPrimos(int max) {
        if (max < 2) {
            // Si max es menor que 2, devolvemos un arreglo vacío
            return new int[0];
        }

        // Asignar tamaño del array
        int dim = max + 1; // Tamaño del array
        boolean[] esPrimo = new boolean[dim]; // Array para marcar si un número es primo o no

        // Llamar al método para rellenar el array de primos
        return rellenarArrayNumPrimos(dim, esPrimo);
    }

    // Método para rellenar el array de números primos
    private static int[] rellenarArrayNumPrimos(int dim, boolean[] esPrimo) {
        // Obtener la cantidad de números primos
        int cuenta = getCuentaPrimos(dim, esPrimo);
        int[] primos = new int[cuenta]; // Array para almacenar los números primos

        int j = 0;
        // Rellenar el vector de números primos con los índices de los números primos encontrados
        for (int i = 0; i < dim; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos; // Devolver el array con los números primos
    }

    // Método para contar la cantidad de números primos encontrados
    private static int getCuentaPrimos(int dim, boolean[] esPrimo) {
        int cuenta = 0;
        for (int i = 0; i < dim; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }

    // Método main - ejecución del programa
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Eratóstenes:");
        int dato = teclado.nextInt();
        int vector[] = new int[dato];
        System.out.println("\nVector inicial hasta :" + dato);

        // Imprimir el vector inicial hasta el número dado por el usuario
        printArrayInicial(vector);

        // Generar los números primos hasta el número dado por el usuario
        vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta:" + dato);

        // Imprimir el vector de números primos
        printArrayPrimos(vector);
    }

    // Método para imprimir el vector de números primos
    private static void printArrayPrimos(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println(); // Salto de línea cada 10 elementos
            System.out.print(vector[i] + "\t"); // Imprimir el número primo seguido de un tabulador
        }
    }

    // Método para imprimir el vector inicial
    private static void printArrayInicial(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println(); // Salto de línea cada 10 elementos
            System.out.print(i + 1 + "\t"); // Imprimir el índice del número seguido de un tabulador
        }
    }
}