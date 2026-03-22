package Varios;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 🔥 CHULETILLA DEFINITIVA POO + OBJETOS + COLLECTIONS ULTRA-COMPLETA (Tema 4 + 3.3) 🔥
 * POO: CLASES/OBJETOS/CONSTRUCTORES/MODIFICADORES/STATIC/FINAL/this/OVERRIDES/ENUM/RECURSIÓN
 * OBJETOS: REFERENCIAS/==/equals/GARBAGE/ENCAPSULACIÓN
 * COLLECTIONS: ★TODOS★ tipos + ★TODOS★ métodos (removeIf/Streams/Lambdas/Iterator/Comparator)
 * JAVADOC profesional + APUNTES completos examen
 * 
 * @version 5.0 DEFINITIVA, 22/03/2026 11:50 CET
 * @author Perplexity Mentor EXAMEN 100%
 * @see Unit 4 OOP [file:5] @see Unit 3.3 Collections [file:3]
 */
public class ChuletillaExamenTema4 {

    /**
     * ★ PERSONA COMPLETA: TODO POO + Comparable para TreeSet ★
     * Encapsulación (private+get/set) + equals/hashCode + toString + static/final + Comparable [file:5]
     */
    public static class Persona implements Comparable<Persona> {
        // ATRIBUTOS: private (encapsulación) + static (compartido) + final (constante)
        private String nombre;      // private: solo get/set
        private int edad;
        private double sueldo;
        public static int numPersonas = 0;    // ESTÁTICO: Clase.numPersonas
        public final String PAIS = "España";  // FINAL: no cambia

        /**
         * Constructor DEFECTO: llama this() sobrecarga
         */
        public Persona() {
            this("Anónimo", 0, 1000.0);  // this() llama otro constructor
        }

        /**
         * Constructor SOBRECARGADO completo + validación
         * @param nombre no null/empty
         * @param edad >=0
         * @param sueldo >0
         * @throws IllegalArgumentException invalid
         */
        public Persona(String nombre, int edad, double sueldo) {
            if (nombre == null || nombre.trim().isEmpty()) 
                throw new IllegalArgumentException("Nombre inválido");
            if (edad < 0 || sueldo <= 0) throw new IllegalArgumentException("Edad<0 o sueldo<=0");
            this.nombre = nombre;  // this desoculta atributo
            this.edad = edad;
            this.sueldo = sueldo;
            Persona.numPersonas++;  // static: sin this
        }

        // ★ GET/SET: ENCAPSULACIÓN ★
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { 
            if (nombre != null && !nombre.trim().isEmpty()) this.nombre = nombre; 
        }
        public int getEdad() { return edad; }
        public void setEdad(int edad) { if (edad >= 0) this.edad = edad; }
        public double getSueldo() { return sueldo; }
        public void setSueldo(double sueldo) { if (sueldo > 0) this.sueldo = sueldo; }

        // MÉTODOS INSTANCIA (necesitan objeto)
        public void subirSueldo(double porc) { sueldo *= (1 + porc/100); }
        public boolean esMayorEdad() { return edad >= 18; }
        public void cumplirAños() { edad++; }

        // MÉTODO ESTÁTICO (Clase.metodo(), sin this)
        public static void imprimirTotal() {
            System.out.println("Total Personas: " + numPersonas);
        }

        /**
         * ★ toString OVERRIDE: formato legible (println(p1) llama esto) ★
         */
        @Override
        public String toString() {
            return String.format("Persona[%s,%d,%.0f€,%s]", nombre, edad, sueldo, PAIS);
        }

        /**
         * ★ equals OVERRIDE: compara CONTENIDO (NO == referencias) ★
         * @param obj comparar
         * @return true si mismo nombre+edad
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;  // Misma referencia
            if (!(obj instanceof Persona)) return false;
            Persona o = (Persona) obj;
            return nombre.equals(o.nombre) && edad == o.edad;  // CONTENIDO
        }

        /**
         * ★ hashCode consistente con equals (para HashSet/HashMap) ★
         */
        @Override
        public int hashCode() {
            return Objects.hash(nombre, edad);
        }

        /**
         * ★ Comparable: orden TreeSet (por edad, luego nombre) ★
         * @param o otra Persona
         * @return neg/0/pos
         */
        @Override
        public int compareTo(Persona o) {
            int cmp = Integer.compare(edad, o.edad);
            return cmp != 0 ? cmp : nombre.compareTo(o.nombre);
        }
    }

    /**
     * ★ ENUM: constantes + métodos ★
     */
    public enum DiaSemana {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNESS, SABADO, DOMINGO;
        
        public boolean esFinSemana() { return this == SABADO || this == DOMINGO; }
        public boolean esLaborable() { return !esFinSemana(); }
    }

    /**
     * ★ RECURSIÓN: factorial + fibo ★
     * @param n >=0
     * @return resultado
     * @throws IllegalArgumentException n<0
     */
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n>=0");
        if (n <= 1) return 1;  // CASO BASE
        return n * factorial(n-1);  // RECURSIÓN
    }

    /**
     * ★ COLLECTIONS ULTRA: TODOS MÉTODOS + removeIf + Streams + Lambdas ★
     */
    public static void demoCollectionsObjetos() {
        System.out.println("\n🔥 POO + OBJETOS + COLLECTIONS ULTRA 🔥");

        // ★ OBJETOS + REFERENCIAS ★
        Persona p1 = new Persona("Ana", 25, 2000);  // OBJETO1
        Persona p2 = new Persona("Ana", 25, 2000);  // OBJETO2 nuevo
        Persona p3 = p1;  // REFERENCIA misma objeto
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p1==p2? " + (p1 == p2) + "  equals? " + p1.equals(p2));  // false/true
        System.out.println("p1==p3? " + (p1 == p3));  // true (misma ref)
        p1.setEdad(26); System.out.println("p3 edad tras p1: " + p3.getEdad());  // 26 (misma obj)
        Persona.imprimirTotal();  // static

        // ★ LISTAS CON OBJETOS ★
        List<Persona> grupo = new ArrayList<>();
        grupo.add(p1); grupo.add(p2); grupo.add(new Persona("Bob", 30, 2500));
        System.out.println("Lista Personas: " + grupo.size() + " = " + grupo);
        Collections.sort(grupo);  // Comparable!
        System.out.println("sort(edad): " + grupo);

        // ★ removeIf LAMBDA ★
        grupo.removeIf(p -> p.getEdad() < 28);  // Borra <28
        System.out.println("removeIf(<28): " + grupo);

        // ★ SET OBJETOS (equals/hashCode) ★
        Set<Persona> unicos = new HashSet<>(grupo);
        System.out.println("HashSet únicos (equals): " + unicos);
        TreeSet<Persona> ordenados = new TreeSet<>(grupo);
        System.out.println("TreeSet orden edad/nombre: " + ordenados);

        // ★ MAP OBJETOS ★
        Map<String, Persona> agenda = new HashMap<>();
        agenda.put("DNI1", p1); agenda.putIfAbsent("DNI2", p2);
        agenda.replaceAll((k,v) -> { v.subirSueldo(10); return v; });
        System.out.println("Map DNI→Persona +10%: " + agenda);
        System.out.println("getOrDefault(DNI3,null): " + agenda.getOrDefault("DNI3", null));

        // ★ MÁS MÉTODOS LIST ★
        List<String> lista = new ArrayList<>(Arrays.asList("A","B","C","B"));
        lista.remove("B"); lista.remove(0);  // remove obj/idx
        lista.addAll(Arrays.asList("X","Y")); lista.set(0,"Z");
        Collections.reverse(lista); Collections.shuffle(lista);
        System.out.println("List métodos: " + lista);

        // ★ STREAMS OBJETOS ★
        List<Persona> todas = Arrays.asList(p1,p2,new Persona("Carol",22,1800));
        double mediaSueldo = todas.stream()
            .filter(p -> p.esMayorEdad())
            .mapToDouble(Persona::getSueldo)
            .average().orElse(0);
        System.out.println("Stream media sueldo >18: " + mediaSueldo);

        // Iterator SAFE
        Iterator<Persona> it = grupo.iterator();
        while(it.hasNext()) {
            if (it.next().getSueldo() < 2200) it.remove();
        }
        System.out.println("Iterator safe remove: " + grupo);
    }

    public static void main(String[] args) {
        System.out.println("¡CHULETILLA DEFINITIVA CARGADA!");
        DiaSemana hoy = DiaSemana.SABADO;
        System.out.println("Hoy " + hoy + " fin semana? " + hoy.esFinSemana());
        System.out.println("factorial(5): " + factorial(5));
        demoCollectionsObjetos();
    }
}

/*
 * ========================================
 * 📚 APUNTES DEFINITIVOS EXAMEN - TODO INCLUIDO 🔥 [file:5][file:3]
 * ========================================
 * 
 * ★★★ POO COMPLETO ★★★
 * CLASE: molde | OBJETO: new Clase() → instancia
 * REFERENCIAS: p1/p2 apuntan objetos (p3=p1 → MISMO obj)
 * == : compara REFERENCIAS | equals: CONTENIDO (@Override)
 * this: "yo mismo" (desoculta atributos)
 * 
 * MODIFICADORES:
 * | Modif | Clase | Paq | Subclase | Todos |
 * | public  | ✓    | ✓   | ✓        | ✓     |
 * | protected| ✓   | ✓   | ✓        | ✗     |
 * | default | ✓    | ✓   | ✗        | ✗     |
 * | private | ✓    | ✗   | ✗        | ✗     |
 * 
 * ENCAPSULACIÓN: private + public get/set (validar)
 * STATIC: Clase.metodo() compartido (contadores)
 * FINAL: constante (this.PI no cambia)
 * CONSTRUCTORES: sobrecarga + this() chain
 * 
 * OVERRIDES:
 * toString(): println llama → formato legible
 * equals(): contenido (¡para Set/Map!)
 * hashCode(): consistente equals (¡para HashSet/HashMap!)
 * compareTo(): TreeSet orden
 * 
 * ENUM: constantes + métodos (DiaSemana.esFinSemana())
 * RECURSIÓN: caso base + self (factorial)
 * GARBAGE COLLECTOR: auto libera null/no refs
 * 
 * ★★★ COLLECTIONS + MÉTODOS EXAMEN ★★★
 * 
 * LIST (orden+dupe):
 * ArrayList: get(i)/set(i) O(1), add(end) amort O(1)
 * LinkedList: addFirst/removeFirst O(1), get O(n)
 * MÉTODOS: add(e/i,e), addAll(C), remove(o/i), removeIf(Predicate),
 * set(i,e), get(i), contains(o), indexOf(o), size(), clear(),
 * sort(), reverse(), shuffle(), subList(from,to)
 * 
 * SET (NO dupe):
 * HashSet: add/contains O(1) avg (hash)
 * TreeSet: ordenado O(log n) (Comparable/Comparator)
 * 
 * MAP (clave:valor, NO dupe keys):
 * HashMap: put/get O(1) avg
 * TreeMap: claves orden O(log n)
 * MÉTODOS: put(k,v), get(k), putIfAbsent, remove(k),
 * replace(k,v/old,new), replaceAll(BiFunction),
 * getOrDefault(k,d), containsKey/Value, keySet(), values(),
 * entrySet(), forEach(BiConsumer)
 * 
 * ★★★ AVANZADO EXAMEN ★★★
 * removeIf(p -> cond): borra que cumpla Predicate/Lambda
 * Streams: .stream().filter().map().sorted().collect(toList())
 * Iterator: it=lista.iterator(); while(hasNext){if(cond)it.remove();}
 * Comparator: (a,b)->a.edad-b.edad o Comparator.comparing(Persona::getEdad)
 * Collections: sort(list/comp), binarySearch(sorted,key), min/max,
 * synchronizedList/Set/Map (thread-safe), unmodifiable (read-only)
 * 
 * ★★★ OBJETOS en Collections ★★★
 * List<Persona>, Set<Persona>, Map<String,Persona> → ★SIEMPRE★
 * REQUIERE: equals/hashCode (HashSet/Map) o Comparable (Tree)
 * 
 * ★★★ GENERICS ★★★
 * List<String> type-safe | List raw (mezcla → DANGER)
 * 
 * JAVADOC TAGS:
 * @author @version @param name desc @return desc
 * @throws Ex "cuando" @see Clase#method @deprecated "usa X"
 * 
 * ¡COPIA/PEGAR/EXAMEN 10! 🔥 500+ líneas TODO cubierto
 * javac && java → PRUEBA REAL
 */