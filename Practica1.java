package practica1;

import java.util.*;

public class Practica1 {

    //EJERCICIO 1
    public static Set<Integer> multiplos (Iterator<Integer> it) {

        // Set que devolvera al final con los numeros que son multiplos
        Set<Integer> set_final = new HashSet<>();

        // Crear la lista interna
        List<Integer> numeros = new ArrayList<>();


        // Guardamos todos los elementos del iterador en una nueva lista
        while (it.hasNext()) {
            
            //Guardamos numero en la lista
            numeros.add(it.next());

        }

        // Dos bucles Para comparar cada numero y ver si es multiple de los otros
        for (int i = 0; i < numeros.size(); i++) {
            for (int j = 0; j < numeros.size(); j++) {

                // No comparamos un elemento consigo mismo
                if (i == j) {
                    continue;
                }

                // Obtenemos los números usando los índices
                Integer potencialMultiplo = numeros.get(i);
                Integer divisor = numeros.get(j);

                // Aseguramos no coger 0
                if (divisor != 0 && potencialMultiplo != 0) {

                    // Comprobamos si es multiplo
                    if (potencialMultiplo % divisor == 0) {
                        
                        // Es multiplo asi que lo añadimos al Set_final
                        set_final.add(potencialMultiplo);

                        // Pasamos al siguiente numero
                        break;
                    }
                }
            }
        }

        // Devolvemos el set_final
        return set_final;
    }

    //EJERCICIO2
    public static void separate (Set<Integer> cuadrados, Set<Integer> noCuadrados)  {
        
        // Creamos Set auxiliar que sera la UNION de los 2, para asi poder recorrerlo
        HashSet<Integer> set_auxiliar = new HashSet<>(cuadrados);

        // Hacemos la union
        set_auxiliar.addAll(noCuadrados);

        // Guardamos si el 1 estaba en los dos sets originales, CASO RARO PORQUE EN VERDAD EL CUADRADO DE 1 ES 1
        boolean unoEnAmbos = cuadrados.contains(1) && noCuadrados.contains(1);
        boolean unoPresente = set_auxiliar.contains(1);

        // Borramos los Set para dejarlos vacios
        cuadrados.clear();
        noCuadrados.clear();

        // Bucle que para cada numero calcula su cuadrado y pregunta si esta en el set_auxiliar
        for (Integer n: set_auxiliar) {

            // Evitamos números negativos y el cero
            if (n <= 0) continue;

            int raiz = (int) Math.sqrt(n);

            // comprobamos si es un cuadrado perfecto y su raíz está en el set
            if (raiz * raiz == n && set_auxiliar.contains(raiz)) {
                cuadrados.add(n);   // metemos el número (el cuadrado)
            } else {
                noCuadrados.add(n);
            }



            // Calculamos el cuadrado
            //int cuadrado = potencial_cuadrado * potencial_cuadrado;

            // Miramos si esta en el set_auxiliar
            //if (set_auxiliar.contains(cuadrado)) {

                // Esta en set_auxiliar, por tanto metemos el cuadrado a el set cuadrado
                //cuadrados.add(cuadrado);
                
            //}
            //else {

                // No esta en set_auxiliar por lo tanto lo metemos a noCuadrados
                //noCuadrados.add(potencial_cuadrado);

            //}
        }

        // Tratamiento especial del 1
        if (unoPresente) {
            if (unoEnAmbos) {
                // Lo pasamos a cuadrados
                cuadrados.add(1);
                noCuadrados.remove(1);
            }  
            else {
            // Lo pasamos a noCuadrados
            cuadrados.remove(1);
            noCuadrados.add(1);
            }
        }
        
    }

    //EJERCICIO 3
    // ESTA PERFECTO
    public static<T> Collection<Set<T>> divideInSets (Iterator<T> it) {
        
        // Collection de sets final
        Collection<Set<T>> Col_final = new ArrayList<>();

        // Iniciamos el recorrido con el iterador
        while (it.hasNext()) {

            // Cogemos el siguiente elemento
            T elemento = it.next();

            // Flag para comprobrar si el numero ha podido ser añadido
            boolean añadido = false;

            // Intentamos meter el elemento en algun subconjunto del Col_final
            for (Set<T> subconjunto : Col_final) {

                // Comprobamos si entra en algun subconjunto
                if (subconjunto.add(elemento)) {

                    // Marcamos el añadido como true
                    añadido = true;

                    // Como ha sido añadido hacemos que termine el bucle para que no se meta en mas Sets
                    break;
                }
            }

            // Si ha recorrido todos los subconjuntos y aun añadido es false creamos otro nuevo y lo metemos dentro
            if (añadido == false) {

                // Creamos el set nuevo
                HashSet<T> nuevo_Set = new HashSet<>();

                // Metemos el numero elemento dentro
                nuevo_Set.add(elemento);

                // Metemos el nuevo_Set en el set_final
                Col_final.add(nuevo_Set); 
            }
        }

        return Col_final;
    }

    //EJERCICIO 4
    public static<T> Collection<Set<T>> coverageSet2 (Set<T> u, ArrayList<Set<T>> col) {
        
        // Collection de sets final
        Collection<Set<T>> col_final = new HashSet<>();

        // Creamos un HashSet Auxiliar y Metemos todos los sets de la Lista col en el Auxiliar
        HashSet<Set<T>> setAux = new HashSet<>(col);

        // Ahora recorremos todos los subconjuntos
        for (Set<T> subconjunto : col) {

            // Para cada subconjunto Calculamos cual deberia ser su complemento para ser igual al Set<T>u
            HashSet<T> complemento = new HashSet<>(u);

            // Por tanto Restamos U - Subconjunto 
            complemento.removeAll(subconjunto);

            // Y ahora comprobamos si el Complemento necesario se encuentra en nuestro HashSet auxiliar
            if (setAux.contains(complemento)) {

                // Si encuentra añadimos a nuestro col_final los 2 metodos
                col_final.add(subconjunto);
                col_final.add(complemento);

                return col_final;
            }
        }

        // Si no encuentra nada devolvemos la coleccion vacia
        return col_final;

    }

}
