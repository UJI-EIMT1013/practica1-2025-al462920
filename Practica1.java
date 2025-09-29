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
    public static<T> Collection<Set<T>> divideInSets (Iterator<T> it) {
        //TODO
        return null;
    }

    //EJERCICIO 4
    public static<T> Collection<Set<T>> coverageSet2 (Set<T> u,ArrayList<Set<T>> col) {
        //TODO
        return null;
    }



}
