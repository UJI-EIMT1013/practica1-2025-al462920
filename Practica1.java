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
        //TODO

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
