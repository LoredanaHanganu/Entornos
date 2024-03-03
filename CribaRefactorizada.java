package cribaRefactor;

import java.util.Scanner;

public class CribaRefactorizada {
    // Método para generar números primos de 1 a max
    public static int[] generarPrimos(int max) {

        if (max >= 2) {
            // ASignar tamaño del array
            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[dim];

            iniciarArray(dim, esPrimo);

            cribaNumerosPrimos(dim, esPrimo);

            int cuenta = getCuentaPrimos(dim, esPrimo);

            return rellenarArrayNumPrimos(cuenta, dim, esPrimo);

        } else { // max < 2
            // Si max es menor que 2, devolvemos un arreglo vacío
            return new int[0];
        }
    }

    private static int[] rellenarArrayNumPrimos(int cuenta, int dim, boolean[] esPrimo) {

        // Rellenar el vector de números primos con los índices de los números primos encontrados
        int[] primos = new int[cuenta];
        for (int i = 0, j = 0; i < dim; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }

    private static int getCuentaPrimos(int dim, boolean[] esPrimo) {

        // Contar la cantidad de números primos encontrados
        int cuenta = 0;
        for (int i = 0; i < dim; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }

    private static void cribaNumerosPrimos(int dim, boolean[] esPrimo) {

        // Criba de Eratóstenes para marcar los números compuestos como no primos
        for (int i = 2; i < Math.sqrt(dim) + 1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (int j = 2 * i; j < dim; j += i)
                    esPrimo[j] = false;
            }
        }
    }

    private static void iniciarArray(int dim, boolean[] esPrimo) {

        // Inicializar el array con true (suponiendo que todos son primos)
        for (int i = 0; i < dim; i++)
            esPrimo[i] = true;

        // Eliminar el 0 y el 1, que no son primos
        esPrimo[0] = esPrimo[1] = false;
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

    private static void printArrayPrimos(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }

    private static void printArrayInicial(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(i + 1 + "\t");
        }
    }
}