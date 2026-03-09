package Varios;

import java.util.*;  // ← Arrays, Collections, List/Set/Map/Queue
import java.util.stream.Collectors;  // ← Streams (nuevo!)

public class ChuletillaTema3_AMPLIADA {
    public static void main(String[] args) {
        // ========================================
        // ★ ARRAYS AVANZADO - Trucos pro del internet ★
        // ========================================
        System.out.println("🚀 ARRAYS AVANZADO - Copia parcial, jagged arrays, Streams");
        
        // Array irregular (jagged): filas de tamaños distintos [web:10][web:19]
        int[][] jagged = {{1,2}, {3,4,5}, {6}};  // Fila0:2 elems, Fila1:3, Fila2:1
        for (int[] fila : jagged) {
            System.out.print("Fila: ");
            for (int n : fila) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        // SALE: Fila: 1 2 
        //       Fila: 3 4 5 
        //       Fila: 6 
        
        // Copia parcial con System.arraycopy [web:1]
        int[] src = {10,20,30,40,50};
        int[] dest = new int[3];
        System.arraycopy(src, 1, dest, 0, 3);  // Copia src[1..3] a dest[0..]
        System.out.println("Copia parcial: " + Arrays.toString(dest));  // [20,30,40]
        
        // Búsqueda lineal manual (si NO ordenado)
        int[] desorden = {5,3,8,1};
        int buscar = 8;
        int idx = -1;
        for (int i = 0; i < desorden.length; i++) {
            if (desorden[i] == buscar) {
                idx = i;
                break;
            }
        }
        System.out.println("Búsq. lineal " + buscar + ": " + idx);  // 2
        
        // ========================================
        // ★ STRINGS AVANZADO - Regex, repeat, lines ★
        // ========================================
        System.out.println("\n🚀 STRINGS AVANZADO - Regex replace, repeat (Java 11+), lines");
        
        String texto = "Hola 123 Mundo 456!";
        
        // replaceAll con REGEX: borra números [web:14]
        String sinNums = texto.replaceAll("\\d+", "");  // \\d+ = uno+ dígitos
        System.out.println("Sin números (regex): " + sinNums);  // "Hola  Mundo !"
        
        // replaceFirst: solo PRIMERA ocurrencia regex
        String primera = texto.replaceFirst("\\d+", "X");
        System.out.println("Primera num → X: " + primera);  // "Hola X Mundo 456!"
        
        // repeat (Java 11+): repite string [web:14]
        String linea = "═".repeat(20);
        System.out.println(linea);  // ════════════════════
        
        // lines(): divide por \n (Java 11+) [web:14]
        String multi = "Línea1\nLínea2\nLínea3";
        multi.lines().forEach(System.out::println);
        // SALE:
        // Línea1
        // Línea2
        // Línea3
        
        // matches(regex): ¿coincide patrón? [web:14]
        System.out.println("Es email simple? " + "user@dom.com".matches(".*@.*\\..*"));  // true
        
        // ========================================
        // ★ COLLECTIONS AVANZADO - Streams, Queue, Immutable [web:15][web:18]
        // ========================================
        System.out.println("\n🚀 COLLECTIONS AVANZADO - Streams, Queue, unmodifiable");
        
        // List → Stream: filtra, mapea, reduce [web:15]
        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        int sumaStream = nums.stream()
                             .filter(n -> n % 2 == 0)  // Pares: 2,4
                             .map(n -> n * 2)          // 4,8
                             .reduce(0, Integer::sum); // 12
        System.out.println("Stream suma pares*2: " + sumaStream);
        
        // List → Map (agrupar) [web:18]
        List<String> frutas = Arrays.asList("manzana", "banana", "manzana", "kiwi");
        Map<Integer, List<String>> porLong = frutas.stream()
            .collect(Collectors.groupingBy(String::length));
        System.out.println("Agrupadas por longitud: " + porLong);
        // {6=[banana, kiwi], 7=[manzana, manzana]}
        
        // Queue: FIFO (primero entra, primero sale) [web:15]
        Queue<String> cola = new LinkedList<>();
        cola.add("primero");
        cola.add("segundo");
        System.out.println("Queue poll: " + cola.poll());  // "primero" (saca)
        System.out.println("Queue queda: " + cola);  // [segundo]
        
        // Inmutable: NO se puede modificar (thread-safe) [web:15]
        List<String> inmutable = List.of("a", "b", "c");  // Java 9+
        // inmutable.add("error");  // ¡ERROR en compile!
        System.out.println("Inmutable: " + inmutable);
        
        // TreeMap/TreeSet: AUTO-ORDENADO por clave/valor natural
        SortedMap<String, Integer> ordMapa = new TreeMap<>();
        ordMapa.put("C", 3);
        ordMapa.put("A", 1);
        ordMapa.put("B", 2);
        System.out.println("TreeMap ordenado: " + ordMapa);  // {A=1, B=2, C=3}
        
        // ========================================
        // ★ MEJORES PRÁCTICAS INTERNET [web:15]
        // ========================================
        System.out.println("\n💡 PRO-TIPS:");
        System.out.println("• Usa genéricos: List<String> NO List (type-safe)");
        System.out.println("• isEmpty() NO size()==0 (más rápido)");
        System.out.println("• ArrayList para lectura rápida, LinkedList para insert/delete");
        System.out.println("• Streams para procesar listas grandes (filter/map/reduce)");
        System.out.println("• Collections.unmodifiableList() para inmutables");
        
        System.out.println("\n✅ ¡AMPLIACIÓN COMPLETA! Tema 3 + avanzado. APROBARÁS CON 10.");
    }
    /*
     * ========================================
     * 📚 APUNTES TEÓRICOS COMPLETOS - CHULETA DEFINITIVA
     * ========================================
     * 
     * ★ ARRAYS (TABLAS) 
     * -----------------
     * - Variables ESCALARES: 1 valor (int x = 5;)
     * - ARRAY: Múltiples valores MISMOS tipo, índices 0 a length-1
     * - Declarar: int[] arr;  Crear: arr = new int[5];  // [0,0,0,0,0]
     * - Literal: int[] nums = {1,2,3};  // Solo declaración
     * - .length: longitud FIJA (no cambia)
     * - Recorrido:
     *   for(int i=0; i<arr.length; i++) { usa arr[i]; }  // Modifica OK
     *   for(int e : arr) { suma += e; }  // For-each: COPIA, NO modifica
     * - Inicializar: Arrays.fill(arr, 10);  // Todos 10
     * - Arrays.fill(arr, 2, 5, 99);  // arr[2..4] = 99
     * - Mostrar: System.out.println(Arrays.toString(arr));
     * - Ordenar: Arrays.sort(arr);  // Creciente
     * - Buscar:
     *   binarySearch(arr, valor);  // ORDENADO! → índice o negativo
     *   Secuencial: for manual hasta encontrar
     * - Copiar:
     *   Arrays.copyOf(arr, 10);  // Nueva, rellena 0s si >
     *   Arrays.copyOfRange(arr, 1, 4);  // arr[1..3]
     *   System.arraycopy(src, posSrc, dest, posDest, len);
     * - Matrices N-D:
     *   int[][] mat = new int[3][4];  // 3 filas x 4 cols
     *   Recorrer: for(i=0;i<mat.length;i++) for(j=0;j<mat[i].length;j++)
     *   Mostrar: Arrays.deepToString(mat);
     * - Jagged: int[][] jag = {{1,2},{3,4,5}};  // Filas tamaños distintos
     * - Funciones: Array por REFERENCIA (modifica original!)
     * 
     * ★ STRINGS 
     * ----------
     * - Inmutables: métodos devuelven NUEVA String
     * - Crear: String s = "texto";  o new String("texto")
     * - ==: compara REFERENCIA, NO contenido!
     * - equals(s2): true si MISMO contenido (case-sensitive)
     * - equalsIgnoreCase(): ignora mayús/minús
     * - compareTo(s2): <0 si this < s2 alfabético, 0 igual, >0 mayor
     * - .length(): chars
     * - charAt(i): char en posición i (¡no salgas de rango!)
     * - substring(inicio): desde inicio al final
     * - substring(inicio, fin): [inicio, fin-1]
     * - indexOf(char/str): PRIMERA posición o -1
     * - indexOf(char/str, desde): desde posición
     * - lastIndexOf(): ÚLTIMA
     * - contains(str): true si tiene subcadena
     * - startsWith(pref): true si empieza con
     * - endsWith(suf): true si acaba con
     * - toUpperCase()/toLowerCase()
     * - replace(char1, char2): TODAS ocurrencias
     * - replaceFirst/All(String regex, str): REGEX! \\d+ = dígitos
     * - split(" "): array de Strings por separador
     * - String.join(", ", array): une con sep
     * - trim(): quita espacios inicio/fin
     * - isEmpty(): longitud 0
     * - toCharArray(): char[]
     * - Java11+: repeat(n), lines() → Stream
     * - matches(regex): ¿coincide patrón?
     * 
     * ★ COLLECTIONS FRAMEWORK 
     * -----------------------
     * - Genéricos: List<String> NO List (type-safe, compile-check)
     * - Interfaces: List/Set/Map → implementaciones
     * 
     * LIST (duplicados OK, ordenados, índices):
     * - ArrayList: rápido acceso/get (array interno)
     * - LinkedList: rápido add/remove (nodos enlazados), implementa Queue/Deque
     * Métodos: add(e), add(idx,e), get(idx), set(idx,e), remove(e/idx),
     *          contains(e), size(), isEmpty(), clear(), indexOf(e)
     * 
     * SET (únicos, sin índices):
     * - HashSet: rápido, sin orden
     * - LinkedHashSet: orden inserción
     * - TreeSet: ordenado natural/compareTo
     * add(e): false si ya existe
     * 
     * MAP (clave única → valor):
     * - HashMap: rápido, sin orden
     * - LinkedHashMap: orden inserción
     * - TreeMap: ordenado por clave
     * put(key,val): sobreescribe si clave existe
     * get(key): null si no
     * keySet(), values(), entrySet()
     * 
     * QUEUE (FIFO): LinkedList.offer/add/poll/peek
     * 
     * Collections (utils):
     * - sort(List): ordena
     * - binarySearch(List ordenada, key)
     * - shuffle(List), reverse(List), unmodifiableList(List)
     * - frequency(col, e): cuántas veces
     * - max/min(col)
     * 
     * STREAMS (Java8+): lista.stream()
     * - filter(pred), map(fn), reduce(init, op), collect(toList/groupingBy)
     * Ej: lista.stream().filter(x->x>0).sum()
     * 
     * MEJORES PRÁCTICAS:
     * - Usa List.of("a","b") para inmutables (Java9+)
     * - isEmpty() > size()==0
     * - ArrayList 80% casos; LinkedList solo mucho insert/delete
     * - TreeSet/Map: lento O(log n), usa si necesitas orden
     * - Streams paralelos para BIG data: parallelStream()
     * - Evita null keys/values en Hash*
     * - Capacidad inicial: new ArrayList<>(100); evita realloc
     * 
     * ERRORES COMUNES:
     * - ArrayIndexOutOfBoundsException: i >= length
     * - UnsupportedOperationException: listas inmutables
     * - ClassCastException: genéricos mal
     * - ConcurrentModification: modifica mientras iteras → usa Iterator.remove()
     * 
     * EXAMEN TIPS:
     * - Dibuja diagramas: Array vs List (fija vs dinámica)
     * - Compara equals NO ==
     * - Ordena ANTES binarySearch
     * - Recuerda genéricos en todo
     * 
     * ¡MEMORIZA ESTO Y APROBARÁS CON 10/10! 📖
     * Fuentes: Docs Oracle, Baeldung, GeeksforGeeks
     */
}

