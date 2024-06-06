package ejercicios;

import java.util.Arrays;

public class Ejercicio2 {
	public static void main(String[] args) {

        String msg = "El perro de San Roque no tiene rabo, porque Ramón Ramírez se lo ha cortado";

        System.out.println("La cadena es: " + msg);
        System.out.println("El resultado es: ");
        
		Resultado r = contadorLetras(msg);

		char[] caracteres = r.getLetras();
		int[] frecuencias = r.getFrecuencias();
		System.out.println("Caracteres: " + Arrays.toString(caracteres));
		for(int i = 0; i < caracteres.length; i++) {
			System.out.print("%s : %d veces".formatted(caracteres[i], frecuencias[i]));
			System.out.println();
		}


        
    }


    public static Resultado contadorLetras(String s) {
        // Convertimos la cadena en un array de char
        char[] cadena = s.toLowerCase().toCharArray();
        char[] caracteres = new char[cadena.length];
        int[] frecuencias = new int[cadena.length];
        int cantidadDiferenteLetras = 0;

        for(int i=0; i < cadena.length; i++) {
            // Si el carácter ya lo hemos incluido en
            // los caracteres resultantes
        	int pos;
            if ((pos = buscar(cadena[i], caracteres)) != -1) {
                // Incrementamos en 1 la frecuencia
                frecuencias[i]+=1;
            } else {
                // Lo agregamos por primera vez
                caracteres[cantidadDiferenteLetras] = cadena[i];
                frecuencias[cantidadDiferenteLetras] = 1; 
                cantidadDiferenteLetras++;
            }

        }

        return new Resultado(
            pack(caracteres, cantidadDiferenteLetras), 
            pack(frecuencias, cantidadDiferenteLetras));


    }

    /**
     * Método que busca un carácter en un array de caracteres
     * y devuelve su posición.
     * @param c Carácter a buscar
     * @param arr Array donde buscar
     * @return posición del carácter si lo encuentra, -1 en otro caso
     */
    public static int buscar(char c, char[] arr) {
        for(int i = 0; i < arr.length; i++) {
			if (arr[i]==c)
				return i;
		}
		return -1;
    }


    /**
	 * Este método comprueba sin un array contiene un carácter
	 * @param El carácter a buscar a buscar
	 * @param arr El array donde buscar
	 * @return true si lo encuentra, false en otro caso
	 */
	public static boolean contains(char c, char[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if (arr[i]==c)
				return true;
		}
		return false;
	}
	
	/**
	 * Este método devuelve el número de ocurrencias de 
	 * un carácter en un array
	 * @param c El carácter a buscar
	 * @param arr El array donde buscar
	 * @return El número de veces que el carácter está presente en el array
	 */
	public static int ocurrences(char c, char[] arr) {
		int result = 0;
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] == c)
				result++;
		}
		return result;
	}
	
	
	/**
	 * Reduce un array al número de elementos proporcionados
	 * @param arr Array reducir. Debe ser de tamaño mayor o igual a n
	 * @param n Tamaño del array resultante
	 * @return Array reducido
	 */
	public static int[] pack(int[] arr, int n) {
		int[] result = new int[n];
		for(int i = 0; i < n; i++) {
			result[i] = arr[i];
		}
		return result;
	}

    /**
	 * Versión del método anterior para caracteres
	 * @param arr Array reducir. Debe ser de tamaño mayor o igual a n
	 * @param n Tamaño del array resultante
	 * @return Array reducido
	 */
	public static char[] pack(char[] arr, int n) {
		char[] result = new char[n];
		for(int i = 0; i < n; i++) {
			result[i] = arr[i];
		}
		return result;
	}


    public static class Resultado {

        char[] letras;
        int[] frecuencias;

        public Resultado(char[] l, int[] f) {
            this.letras = l;
            this.frecuencias = f;
        }

        public char[] getLetras() {
            return this.letras;
        }

        public int[] getFrecuencias() {
            return this.frecuencias;
        }


    }
	
	
}
