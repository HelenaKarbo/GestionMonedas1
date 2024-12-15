/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.gestionmonedas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 2024-2025 DAM-1
 */
public class GestionMonedasIT {
    
    public GestionMonedasIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of agregarPais method, of class GestionMonedas1.
     */
    @Test
    public void testAgregarPais() {
        System.out.println("Pais");
        String[] pais = {"España"," España","España "," España ","españa","ESPAÑA","EsPaña"}; 
        
        GestionMonedas instance = new GestionMonedas();
        String expResult = "España";   
        
        
        assertAll(
            "Cabecera",
            ()->assertEquals(expResult, instance.agregarPais(pais[0])),
            ()->assertEquals(expResult, instance.agregarPais(pais[1])),
            ()->assertEquals(expResult, instance.agregarPais(pais[2])),
            ()->assertEquals(expResult, instance.agregarPais(pais[3])),
            ()->assertEquals(expResult, instance.agregarPais(pais[4])),
            ()->assertEquals(expResult, instance.agregarPais(pais[5])),
            ()->assertEquals(expResult, instance.agregarPais(pais[6]))
        );
    }
    
    @Test
    public void testAgregarDenominacion() {
        System.out.println("Denominacion");
        String[] denominacion = {"Euro", " euro", "EURO ", " EuRo ", "euro", "eUrO", "10 euros"};

        GestionMonedas instance = new GestionMonedas();
        String expResult = "Euro";  

        assertAll(
            "Denominacion",
            () -> assertEquals(expResult, instance.agregarDenominacion(denominacion[0])),
            () -> assertEquals(expResult, instance.agregarDenominacion(denominacion[1])),
            () -> assertEquals(expResult, instance.agregarDenominacion(denominacion[2])),
            () -> assertEquals(expResult, instance.agregarDenominacion(denominacion[3])),
            () -> assertEquals(expResult, instance.agregarDenominacion(denominacion[4])),
            () -> assertEquals(expResult, instance.agregarDenominacion(denominacion[5])),
            () -> assertEquals("10 euros", instance.agregarDenominacion(denominacion[6]))
        );
    }
}
