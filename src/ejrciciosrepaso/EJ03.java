package ejrciciosrepaso;

public class EJ03 {
	
	public static void main(String[] args) {
		final String TEXTO_LARGO = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, adarga antigua, rocín flaco y galgo corredor. Una olla de algo más vaca que carnero, salpicón las más noches, duelos y quebrantos los sábados, lantejas los viernes, algún palomino de añadidura los domingos, consumían las tres partes de su hacienda. ";
		String[] palabrasClave = {"Mancha", "lugar", "nose", "Hola", "Que", "tiempo"};

        String[] encontradas = palabrasEncontradas(TEXTO_LARGO, palabrasClave);

        mostrarResultado(encontradas);
    }

    static boolean contienePalabra(String texto, String palabra) {
        return texto.toLowerCase().contains(palabra.toLowerCase());
    }

    static String[] palabrasEncontradas(String texto, String[] claves) {

        int contador = 0;

        for (String clave : claves) {
            if (contienePalabra(texto, clave)) {
                contador++;
            }
        }

        String[] resultado = new String[contador];
        int indice = 0;

        for (String clave : claves) {
            if (contienePalabra(texto, clave)) {
                resultado[indice] = clave;
                indice++;
            }
        }

        return resultado;
    }

    static void mostrarResultado(String[] encontradas) {
        if (encontradas.length > 0) {
            System.out.println("Palabras encontradas: " + String.join(", ", encontradas));
        } else {
            System.out.println("No se ha encontrado ninguna palabra clave.");
        }
    }

}
