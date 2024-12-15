/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestionmonedas;

/**
 *
 * @author 2024-2025 DAM-1
 */
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que representa cada moneda y sus atributos correspondientes.
 */
class Moneda {
    private String pais;
    private String denominacion;
    private int anoEmision;

    /**
     * Constructor para crear una nueva moneda.
     * @param pais El país de origen de la moneda.
     * @param denominacion La denominación o valor de la moneda.
     * @param anoEmision El año en que se emitió la moneda.
     */
    public Moneda(String pais, String denominacion, int anoEmision) {
        this.pais = pais;
        this.denominacion = denominacion;
        this.anoEmision = anoEmision;
    }

    /**
     * Obtiene el país de origen de la moneda.
     * @return Devuelve ese valor.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Obtiene la denominación de la moneda.
     * @return Devuelve ese valor.
     */
    public String getDenominacion() {
        return denominacion;
    }

    /**
     * Obtiene el año de emisión de la moneda.
     * @return Devuelve ese valor.
     */
    public int getAnoEmision() {
        return anoEmision;
    }

    /**
     * @return Devuelve toda la información relevante de la moneda.
     */
    @Override
    public String toString() {
        return "País: " + pais + ", Denominación: " + denominacion + ", Año de emisión: " + anoEmision;
    }
}

/**
 * Clase principal que gestiona una colección de monedas.
 */
public class GestionMonedas {
    public ArrayList<Moneda> monedas;

    /**
     * Constructor que inicializa la lista de monedas.
     */
    public GestionMonedas() {
        monedas = new ArrayList<>();
    }

    /**
     * Agrega una nueva moneda a la colección.
     * @param pais El país de la moneda.
     * @param denominacion La denominación de la moneda.
     * @param anoEmision El año de emisión de la moneda.
     */
    public void agregarMoneda(String pais, String denominacion, int anoEmision) {
        Moneda nuevaMoneda = new Moneda(pais, denominacion, anoEmision);
        monedas.add(nuevaMoneda);
        System.out.println("Moneda agregada: " + nuevaMoneda);
    }
    
    /**
    * Formatea y capitaliza el nombre de un país.
    * 
    * @param pais El nombre del país a formatear.
    * @return El nombre del país con la primera letra en mayúscula y el resto en minúsculas.
    * @throws UnsupportedOperationException Si ocurre un error durante el proceso de formateo.
    */
    public String agregarPais(String pais) throws UnsupportedOperationException{
        pais = pais.trim().substring(0, 1).toUpperCase() + pais.trim().substring(1).toLowerCase();
        return pais;
    }

    /**
    * Formatea y capitaliza el nombre de la denominacion.
    * 
    * @param denominacion 
    * @return El nombre del país con la primera letra en mayúscula y el resto en minúsculas.
    * @throws UnsupportedOperationException Si ocurre un error durante el proceso de formateo.
    */
    public String agregarDenominacion(String denominacion) throws UnsupportedOperationException {
       denominacion = denominacion.trim();
       if (denominacion.matches("\\d+.*")) {
           return denominacion.toLowerCase();
       }
       return denominacion.substring(0, 1).toUpperCase() + denominacion.substring(1).toLowerCase();
   }

    
    /**
     * Muestra todas las monedas añadidas hasta ese momento.
     */
    public void mostrarMonedas() {
        if (monedas.isEmpty()) {
            System.out.println("La lista de monedas está vacía.");
        } else {
            System.out.println("Lista de monedas:");
            for (Moneda moneda : monedas) {
                System.out.println(moneda);
            }
        }
    }

    /**
     * Elimina una moneda de la colección basándose en el país.
     * @param pais El país de la moneda a eliminar.
     */
    public void eliminarMoneda(String pais) {
        boolean encontrado = false;
        for (Moneda moneda : monedas) {
            if (moneda.getPais().equalsIgnoreCase(pais)) {
                monedas.remove(moneda);
                System.out.println("Moneda eliminada: " + moneda);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Moneda no encontrada.");
        }
    }

    /**
     * Método principal que lleva a cabo la ejecución del programa además de la interfaz de usuario.
     */
    public static void main(String[] args) {
        GestionMonedas gestionMonedas = new GestionMonedas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar moneda");
            System.out.println("2. Mostrar monedas");
            System.out.println("3. Eliminar moneda");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                System.out.print("Ingrese el país de la moneda: ");
                String pais = scanner.nextLine();
                System.out.print("Ingrese la denominación de la moneda: ");
                String denominacion = scanner.nextLine();
                int ano = 0;
                boolean entradaValida = false;

                int anoActual = java.time.Year.now().getValue();

                while (!entradaValida) {
                    System.out.print("Ingrese el año de emisión de la moneda (entre 1000 y " + anoActual + "): ");
                    try {
                        ano = Integer.parseInt(scanner.nextLine());

                        if (ano >= 1000 && ano <= anoActual) {
                            entradaValida = true; // Año válido
                        } else {
                            System.out.println("Error: El año debe estar entre 1000 y " + anoActual + ".");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Por favor, ingrese un número entero válido para el año.");
                    }
                }

                gestionMonedas.agregarMoneda(pais, denominacion, ano);
                break;


                case "2":
                    gestionMonedas.mostrarMonedas();
                    break;
                case "3":
                    System.out.print("Ingrese el país de la moneda a eliminar: ");
                    String paisEliminar = scanner.nextLine();
                    gestionMonedas.eliminarMoneda(paisEliminar);
                    break;
                case "4":
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
