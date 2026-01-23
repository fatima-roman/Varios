package ejrciciosrepaso;

import java.util.Arrays;
import java.util.Scanner;

public class EJ01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		final int LONGITUD_MINIMA = 5; 
		
		System.out.println("Introduce una frase: ");
		String frase = sc.nextLine();
		
		String[] palabrasFrase = obtenerPalabras(frase); 
		
		System.out.println("Palabras de una frase: ");
		System.out.print(Arrays.toString(palabrasFrase));
		
		System.out.println("\nPalabras que superen la longitud mínima: ");
		System.out.print(contarPalabrasLargas(palabrasFrase, LONGITUD_MINIMA));
		
		System.out.println("\nPalabra más larga: ");
		System.out.print(palabraMasLarga(palabrasFrase));
		
		sc.close();
	}
	
	static String[] obtenerPalabras(String frase) {
		String[] palabras; 
		frase = frase.trim();
		palabras = frase.split(" ");
		return palabras;
		
	}
	
	static int contarPalabrasLargas(String[] palabras, int longitudMinima) {
		int contador =0; 
		for (int i = 0; i < palabras.length; i++) {
			if (palabras[i].length() >= longitudMinima) {
				contador ++; 
			}
		}

		return contador;
	}
	
	static String palabraMasLarga(String[] palabras) {
		int longitud =0; 
		String masLarga = ""; 
		for (int i = 0; i < palabras.length; i++) {
			if (longitud > palabras[i].length()) {
				masLarga = palabras[i];
			}
		}
		
		return masLarga; 
	}
	

}
