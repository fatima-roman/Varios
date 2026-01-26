package ejrciciosrepaso;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class EJ02 {
	//No lo entendí muy bien
	/*
	 * He hecho como si fuera una clase con distintos alumnos 
	 * y en el segundo array coge la nota más alta por alumno
	 */
	
	public static Scanner sc = new Scanner(System.in);
	public static final int notaMinima = 5; //La nota del aprobado

	public static void main(String[] args) {
		Random rand = new Random();
		
		double[][] notas; 
		
		System.out.println("Cuantos alumnos quieres intoducir?");
		int a = sc.nextInt();
		System.out.println("Cuantas notas quieres introduciir?");
		notas = new double[a][sc.nextInt()];
		System.out.println("Las notas se rellenaran aleatoriamente ");
		
		for (int i = 0; i < notas.length; i++) {
			for (int j = 0; j < notas[i].length; j++) {
				notas[i][j] = Math.round(rand.nextDouble(1,11) * 100.0) / 100.0;
			}
		}
		
		System.out.println("Cuanto quieres incrementar las notas?");
		double incre = sc.nextDouble();
		
		//Esta separado por si son varios alumnos
		
		System.out.println("Nota media por alumno: ");
		for ( int i = 0; i< notas.length; i++) {
			System.out.print("Alumno "+ (i+1) + " : ");
			System.out.println(calcularMedia(notas[i]));
		}
		
		System.out.println("Nota alta por alumno: ");
		for ( int i = 0; i< notas.length; i++) {
			System.out.print("Alumno "+(i+1)+" : ");
			System.out.println(notaMaxima(notas[i]));
		}
		
		System.out.println("Suspensos por alumno: ");
		for ( int i = 0; i< notas.length; i++) {
			System.out.print("Alumno "+(i+1)+" : ");
			System.out.println(contarAprobados(notas[i]));
		}
		
		System.out.println("Notas incrementadas por alumno: ");
		for ( int i = 0; i< notas.length; i++) {
			System.out.print("Alumno "+(i+1)+" : ");
			subirNotas(notas[i], incre);
		}
		
	}
	
	static double calcularMedia(double[] notas) {
		double media =0; 
		int i =0;
		for (;i < notas.length; i++) {
			media += notas[i];
		}
		media/=i;
		
		return Math.round(media * 100.0) / 100.0; 
	}
	
	static double notaMaxima(double[] notas) {
		double notaAlta =0; 
		for (int i =0; i< notas.length; i++) {
			if (notas[i] > notaAlta) {
				notaAlta = notas[i];
			}
		}
		
		return notaAlta;
		
	}
	
	static int contarAprobados(double[] notas) {
		int cont = 0; 
		
		for (int i =0; i< notas.length; i++) {
			if (notas[i]>=notaMinima) {
				cont++;
			}
		}
		
		return cont;
		
	}
	
	static void subirNotas(double[] notas, double incremento) {
		for (int i =0; i < notas.length; i++) {
			notas[i] += incremento; 
		}
		
		System.out.println(Arrays.toString(notas));
	}
	

}
