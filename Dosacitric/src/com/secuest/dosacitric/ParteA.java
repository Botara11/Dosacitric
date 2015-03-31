package com.secuest.dosacitric;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;


public class ParteA implements Serializable{
	public float IndiceDosificacion = (float) 0.085; // HARDCODEADO -> TIENE QUE ESTAR EN LA NUBE
	/**** A1 ****/
	public float DensidadFoliar;
	public float AnchoCalle;
	public float DistanciaArboles;
	public float LongitudArboles;
	public float AnchuraArboles;
	public float AlturaArboles;
	public float AlturaMeseta;
	public float FormaArbol;
	public float FechaUltimaPoda;
	public float GradoPoda;

	/**** A2 ****/
	public float ProductosAplicar;
	public float FormaActuacion;
	public float Mojantes;
	public float ZonaCriticaTratar;

	/**** A3 ****/
	public float Temperatura;
	public float Humedad;
	public float VelocidadViento;

	/**** A4 ****/
	public float TipoPulverizador;
	

	public void rellenarA1(float DensidadFoliar, float AnchoCalle,
			float DistanciaArboles, float LongitudArboles,
			float AnchuraArboles, float AlturaArboles) {

		this.DensidadFoliar = DensidadFoliar;
		this.AnchoCalle = AnchoCalle;
		this.DistanciaArboles = DistanciaArboles;
		this.LongitudArboles = LongitudArboles;
		this.AnchuraArboles = AnchuraArboles;
		this.AlturaArboles = AlturaArboles;
		
	}
	
	public void rellenarA11(float AlturaMeseta,
			float FormaArbol, float FechaUltimaPoda, float GradoPoda){
		
		this.AlturaMeseta = AlturaMeseta;
		this.FormaArbol = FormaArbol;
		this.FechaUltimaPoda = FechaUltimaPoda;
		this.GradoPoda = GradoPoda;
		
	}

	public void rellenarA2345(float ProductosAplicar, float FormaActuacion,
			float Mojantes, float ZonaCriticaTratar, float Temperatura, float Humedad,
			float VelocidadViento, float TipoPulverizador) {
		this.ProductosAplicar = ProductosAplicar;
		this.FormaActuacion = FormaActuacion;
		this.FormaActuacion = FormaActuacion;
		this.ZonaCriticaTratar = ZonaCriticaTratar;
		this.Temperatura = Temperatura;
		this.Humedad = Humedad;
		this.VelocidadViento = VelocidadViento;
		this.TipoPulverizador = TipoPulverizador;
	}


	// DEVUELVE A5 (VOLUMEN DE APLICACION) (L/HA L/HG)
	public ArrayList<Integer> calcularParteA() {
		ArrayList<Integer> Resultado = new ArrayList<Integer>();
		float VolumenArbol, NumeroArbolesPorHect, VolumenSetoAsigArbol, TRV;

		VolumenArbol = LongitudArboles * AnchuraArboles * AlturaArboles / 6;
		NumeroArbolesPorHect = 10000 / (AnchoCalle * DistanciaArboles);
		VolumenSetoAsigArbol = VolumenArbol * DistanciaArboles
				/ LongitudArboles;
		TRV = NumeroArbolesPorHect * VolumenSetoAsigArbol;

		float FactorA1, FactorA2, FactorA3, FactorA4, FactorEficiencia;

		FactorA1 = DensidadFoliar * FormaArbol * FechaUltimaPoda * GradoPoda;
		FactorA2 = ProductosAplicar * FormaActuacion * Mojantes
				* ZonaCriticaTratar;
		FactorA3 = Temperatura * Humedad * VelocidadViento;
		FactorA4 = TipoPulverizador;

		FactorEficiencia = FactorA1 * FactorA2 * FactorA3 * FactorA4;

		int ent1;// VOLUMEN DE APLICACION
		float temp = TRV * IndiceDosificacion * FactorEficiencia;
		if (temp % 100 > 50)
			ent1 = (((int) (temp / 100)) + 1) * 100;
		else
			ent1 = ((int) (temp / 100)) * 100;

		Resultado.add(0, ent1);
		Resultado.add(1, ent1 / 12);

		return Resultado;

	}

}
