package Varios;

import java.util.*;  // ← IMPORTANTE: Importa Arrays, List, Set, Map, etc.

public class ChuletillaTema3_SUPER_FACIL {
    public static void main(String[] args) {
        // ========================================
        // ★ ARRAYS (TABLAS) - LO MÁS BÁSICO ★
        // ========================================
        System.out.println("🔥 ARRAYS - Recuerda: índices desde 0 hasta length-1");
        
        // 1. CREAR ARRAY
        int[] edad = new int[5];  // ← Crea 5 ceros: [0,0,0,0,0]
        int[] numeros = {10, 20, 30};  // ← Solo al declarar, longitud 3
        
        // 2. USAR (acceder/modificar)
        edad[0] = 18;  // ← Primera posición (índice 0)
        edad[2] = 25;  // ← Tercera posición
        System.out.println("edad[2] = " + edad[2]);  // SALE: 25
        
        // 3. LONGITUD: SIEMPRE .length
        System.out.println("Longitud edad: " + edad.length);  // SALE: 5
        
        // 4. RECORRER - FOR CLÁSICO (para modificar)
        int suma = 0;
        for (int i = 0; i < edad.length; i++) {  // i=0,1,2,3,4
            edad[i] = i * 10;  // Modifica: [0,10,20,30,40]
            suma += edad[i];
        }
        System.out.println("Suma for clásico: " + suma);  // SALE: 100
        
        // FOR-EACH (solo LEER, no modifica array)
        suma = 0;
        for (int e : edad) {  // e copia cada valor
            suma += e;
        }
        System.out.println("Suma for-each: " + suma);  // SALE: 100
        
        // 5. CLASE ARRAYS - TRUCOS FÁCILES
        System.out.println("Mostrar array: " + Arrays.toString(edad));
        
        Arrays.sort(edad);  // ORDENA creciente
        System.out.println("Ordenado: " + Arrays.toString(edad));  // [0,10,20,30,40]
        
        int posicion = Arrays.binarySearch(edad, 20);  // BUSCA (¡array ORDENADO!)
        System.out.println("Posición de 20: " + posicion);  // SALE: 2
        
        // ========================================
        // ★ STRINGS - NO USES ==, USA .equals() ★
        // ========================================
        System.out.println("\n🔥 STRINGS - Inmutables: métodos devuelven NUEVA string");
        
        String hola = "Hola Mundo";
        System.out.println("Longitud: " + hola.length());  // 10 chars
        
        String mayus = "HOLA";
        System.out.println("equals: " + hola.equals(mayus));  // false (case-sensitive)
        System.out.println("equalsIgnoreCase: " + hola.equalsIgnoreCase(mayus));  // true
        
        // SUBCADENA: substring(inicio) o substring(inicio, fin)
        String mundo = hola.substring(5);  // Desde pos 5: "Mundo"
        System.out.println("Desde pos 5: " + mundo);
        
        // BÚSQUEDA
        int posM = hola.indexOf('M');  // Primera 'M': 5
        System.out.println("Primera 'M': " + posM);
        int ultimaO = hola.lastIndexOf('o');  // Última 'o': 9
        System.out.println("Última 'o': " + ultimaO);
        
        // CAMBIOS (devuelve NUEVA)
        String minus = hola.toLowerCase();  // "hola mundo"
        String cambio = minus.replace('o', '0');  // "h0la mund0"
        System.out.println("toLower + replace: " + cambio);
        
        // SPLIT y JOIN
        String[] palabras = hola.split(" ");  // ["Hola", "Mundo"]
        System.out.println("Split: " + Arrays.toString(palabras));
        String unida = String.join(" *** ", palabras);  // "Hola *** Mundo"
        System.out.println("Join: " + unida);
        
        String conEspacios = "  hola  ";
        System.out.println("Trim: '" + conEspacios.trim() + "'");  // "hola"
        
        // ========================================
        // ★ COLLECTIONS - GENÉRICOS <T> ★
        // ========================================
        System.out.println("\n🔥 COLLECTIONS - Elige: List (duplicados), Set (únicos), Map (clave-valor)");
        
        // LIST: Como array DINÁMICO, DUPLICADOS OK, con índices
        List<String> lista = new ArrayList<>();  // <> = genérico
        lista.add("gato");
        lista.add("perro");
        lista.add("gato");  // DUPLICADO OK
        lista.add(1, "INSERTAR");  // Inserta en pos 1
        System.out.println("Lista: " + lista);
        
        lista.remove("gato");  // Borra PRIMERA ocurrencia
        Collections.sort(lista);  // ORDENA (solo List)
        System.out.println("Ordenada: " + lista);
        
        // SET: ÚNICOS, sin orden (HashSet) o ordenado (TreeSet)
        Set<String> set = new TreeSet<>();  // TreeSet = ordenado
        set.add("banana");
        set.add("manzana");
        set.add("banana");  // IGNORADO!
        System.out.println("Set único/ordenado: " + set);
        
        // MAP: CLAVE única → VALOR (como diccionario)
        Map<String, String> diccionario = new HashMap<>();
        diccionario.put("gato", "miau");
        diccionario.put("perro", "guau");
        diccionario.put("gato", "¡MIAU!");  // SOBREESCRIBE
        System.out.println("Map: " + diccionario);
        System.out.println("Sonido gato: " + diccionario.get("gato"));
        
        // RECORRER MAP
        for (String clave : diccionario.keySet()) {
            System.out.println(clave + " → " + diccionario.get(clave));
        }
        
        // MATRIZ 2D RÁPIDA
        System.out.println("\nMatriz 2D:");
        int[][] tabla2D = {{1,2,3}, {4,5,6}};
        for (int i = 0; i < tabla2D.length; i++) {
            for (int j = 0; j < tabla2D[i].length; j++) {
                System.out.print(tabla2D[i][j] + " ");
            }
            System.out.println();
        }
        // SALE:
        // 1 2 3 
        // 4 5 6 
        
        System.out.println("\n✅ ¡CHULETILLA COMPLETA! Copia, compila y APROBARÁS FÁCIL.");
        System.out.println("Ejecuta: javac ChuletillaTema3_SUPER_FACIL.java && java ChuletillaTema3_SUPER_FACIL");
    }
}
