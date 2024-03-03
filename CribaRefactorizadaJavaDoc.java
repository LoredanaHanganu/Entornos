package cribaJavaDoc;

import java.util.Scanner;

/**
 * Clase que implementa la criba de Eratóstenes para generar números primos hasta un número máximo dado.
 */
public class CribaRefactorizadaJavaDoc {

    /**
     * Genera números primos hasta el número máximo especificado.
     *
     * @param max El número máximo hasta el cual se generarán los números primos.
     * @return Devuelve un array que contiene los números primos generados.
     */
    public static int[] generarPrimos(int max) {
         if ( max < 2 ){
             // Si max es menor que 2, devolvemos un array vacío
             return new int[0];
         }

         int dim = max + 1; // Tamaño del array
         boolean[] esPrimo = new boolean[dim];

         iniciarArray(dim, esPrimo);

         cribaNumerosPrimos(dim, esPrimo);

         int cuenta = getCuentaPrimos(dim, esPrimo);

         return rellenarArrayNumPrimos(cuenta, dim, esPrimo);

    }

    /**
     * Rellena un array con los números primos encontrados.
     *
     * @param cuenta  La cantidad de números primos encontrados.
     * @param dim     El tamaño del array.
     * @param esPrimo Un array que indica si un número es primo o no.
     * @return Devuelve un array que contiene los números primos encontrados.
     */
    private static int[] rellenarArrayNumPrimos(int cuenta, int dim, boolean[] esPrimo) {

        int[] primos = new int[cuenta];
        for (int i = 0, j = 0; i < dim; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }

    /**
     * Cuenta la cantidad de números primos encontrados.
     *
     * @param dim     El tamaño del array.
     * @param esPrimo Un array que indica si un número es primo o no.
     * @return Deveuleve la cantidad de números primos encontrados.
     */
    private static int getCuentaPrimos(int dim, boolean[] esPrimo) {

        int cuenta = 0;
        for (int i = 0; i < dim; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }

    /**
     * Aplica la criba de Eratóstenes para marcar los números compuestos como no primos.
     *
     * @param dim     El tamaño del array.
     * @param esPrimo Devuelve un array que indica si un número es primo o no.
     */
    private static void cribaNumerosPrimos(int dim, boolean[] esPrimo) {

        for (int i = 2; i < Math.sqrt(dim) + 1; i++) {
            if (esPrimo[i]) {
                for (int j = 2 * i; j < dim; j += i)
                    esPrimo[j] = false;
            }
        }
    }

    /**
     * Inicializa un array con valores predeterminados.
     *
     * @param dim     El tamaño del array.
     * @param esPrimo Un array que indica si un número es primo o no.
     */
    private static void iniciarArray(int dim, boolean[] esPrimo) {

        for (int i = 0; i < dim; i++)
            esPrimo[i] = true;

        esPrimo[0] = esPrimo[1] = false;
    }

    /**
     * Método principal para probar la generación de números primos.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
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
     * Imprime los números primos en el vector.
     *
     * @param vector El array que contiene los números primos.
     */
    private static void printArrayPrimos(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }

    /**
     * Imprime el array inicial hasta el número dado por el usuario.
     *
     * @param vector El array inicial.
     */
    private static void printArrayInicial(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(i + 1 + "\t");
        }
    }
}
