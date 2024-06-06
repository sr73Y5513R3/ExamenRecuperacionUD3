package ejercicios;

/**
 * Ejercicio Practico 1 - Incidencias
 * ¡OJO! Este código TIENE ERRORES que deben ser subsanados a través
 * de la depuración del código.
 * Este programa es capaz imprimir la tabla de frecuencias
 * de elementos de un array.
 */

public class Ejercicio1 {
	
	public static void main(String[] args) {

		int[] array1 = new int[] { 1, 1, 2, 2, 3, 4, 5, 5, 6, 6, 7, 7, 7, 8, 9, 9, 10 };

		imprimeTablaFrecuencias(array1);

	}

	/**
	 * Método que imprime, para cada uno de los elementos del array su frecuencia,
	 * es decir, el número de ocurrencias.
	 * 
	 * @param array
	 */
	public static void imprimeTablaFrecuencias(int[] array) {

		int[] sinRepetidos = limpiarRepetidos(array);

		for (int i = 0; i < sinRepetidos.length; i++) {
			int frecuencia = ocurrences(sinRepetidos[i], array);
			System.out.println("Número: " + sinRepetidos[i] + ", frecuencia: " + frecuencia + 1);
		}

	}

	/**
	 * Este método toma como entrada un array que puede tener números repetidos y
	 * nos devuelve otro array con los elementos sin repetir.
	 * 
	 * @param arr Array que puede tener repetidos
	 * @return Array con elementos diferentes
	 */
	public static int[] limpiarRepetidos(int[] arr) {
		// El array resultante puede tener como tamaño,
		// como mucho, el tamaño del array original, si
		// no tiene repetidos.
		int[] result = new int[arr.length];
		// Lo usamos como índice para añadir elementos al
		// array resultante, así como tamaño definitivo
		// del array de elementos sin repetidos.
		int resultSize = 0;

		// Para cada elemento....
		for (int i = 0; i < arr.length; i++) {
			// Si no está contenido en el array de resultado
			if (!contains(arr[i], result)) {
				// Se añade
				result[resultSize] = arr[i];
				resultSize++;
			}
		}

		// Reducimos el array al número real de elementos
		return pack(result, resultSize);

	}

	/**
	 * Este método comprueba sin un array contiene un número
	 * 
	 * @param n   El número a buscar
	 * @param arr El array donde buscar
	 * @return true si lo encuentra, false en otro caso
	 */
	public static boolean contains(int n, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == n)
				return true;
		}
		return false;
	}

	/**
	 * Este método devuelve el número de ocurrencias de un número en un array
	 * 
	 * @param n   El número a buscar
	 * @param arr El array donde buscar
	 * @return El número de veces que el número está presente en el array
	 */
	public static int ocurrences(int n, int[] arr) {
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == n)
				result++;
		}
		return result;
	}

	/**
	 * Reduce un array al número de elementos proporcionados
	 * 
	 * @param arr Array reducir. Debe ser de tamaño mayor o igual a n
	 * @param n   Tamaño del array resultante
	 * @return Array reducido
	 */
	public static int[] pack(int[] arr, int n) {
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = arr[i];
		}
		return result;
	}
}
