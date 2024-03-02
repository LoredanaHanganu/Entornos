package cribaJavaDoc;

import java.util.Scanner;

public class CribaRefactorizadaJavaDoc {

    /**
     * Genera un array de números primos desde 2 hasta el número máximo especificado.
     * Si el número máximo es menor que 2, devuelve un array vacío.
     *
     * @param max El número máximo hasta el cual se generarán los números primos.
     * @return Un array de números primos hasta el número máximo especificado.
     */
    public static int[] generarPrimos(int max) {
        if (max < 2) {
            // Si max es menor que 2, devolvemos un arreglo vacío
            return new int[0];
        }

        int dim = max + 1; // Tamaño del array
        boolean[] esPrimo = new boolean[dim]; // Array para marcar si un número es primo o no

        return rellenarArrayNumPrimos(dim, esPrimo);
    }

    /**
     * Rellena un array con los números primos encontrados.
     *
     * @param dim La dimensión del array.
     * @param esPrimo Un array booleano que indica si cada número es primo o no.
     * @return Un array con los números primos encontrados.
     */
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

    /**
     * Obtiene la cantidad de números primos encontrados.
     *
     * @param dim La dimensión del array.
     * @param esPrimo Un array booleano que indica si cada número es primo o no.
     * @return La cantidad de números primos encontrados.
     */
    private static int getCuentaPrimos(int dim, boolean[] esPrimo) {
        int cuenta = 0;
        for (int i = 0; i < dim; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }

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

    /**
     * Imprime en la consola el array de números primos.
     *
     * @param vector El array de números primos.
     */
    private static void printArrayPrimos(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println(); // Salto de línea cada 10 elementos
            System.out.print(vector[i] + "\t"); // Imprimir el número primo seguido de un tabulador
        }
    }

    /**
     * Imprime en la consola el array inicial desde 1 hasta el tamaño del array.
     *
     * @param vector El array inicial.
     */
    private static void printArrayInicial(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println(); // Salto de línea cada 10 elementos
            System.out.print(i + 1 + "\t"); // Imprimir el índice del número seguido de un tabulador
        }
    }
}