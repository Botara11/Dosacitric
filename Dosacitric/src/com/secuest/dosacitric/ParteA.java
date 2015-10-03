package com.secuest.dosacitric;

import java.io.Serializable;
import java.util.ArrayList;


public class ParteA implements Serializable{

	private static final long serialVersionUID = -8034845210747968378L;

	public float IndiceDosificacion = (float) 0.085; // HARDCODEADO -> TIENE QUE ESTAR EN LA NUBE
	
	/**** A ****/
	public int day = 0;
	public int month = 0;
	public int year = 1000;
	public String idParcela = "";
	public String idTratamiento= "";
	public String Referencia= "";
	
	/**** A1 ****/
	public float DensidadFoliar;
	public float AnchoCalle;
	public float DistanciaArboles;
	public float LongitudArboles;
	public float AnchuraArboles;
	public float AlturaArboles;
	//public float AlturaMeseta;
	public float FormaArbol;
	public float FechaUltimaPoda;
	public float GradoPoda;
	public float VolumenArbol;
	public int	 IndiceFormaArbol;
	public int 	 IndiceGradoPoda;
	public int	 IndiceFechaUltimaPoda;
	public int	 IndiceDensidadFoliar;

	/**** A2 ****/
	public float ProductosAplicar;
	public float FormaActuacion;
	public float Mojantes;
	public float ZonaCriticaTratar;
	public int	 IndiceProductosAplicar;
	public int	 IndiceFormaActuacion;
	public int	 IndiceZonaCriticaTratar;
	public int	 IndiceMojantes;
	
	/**** A3 ****/
	public float Temperatura;
	public float Humedad;
	public float VelocidadViento;
	public int   VolumenAppLHA;
	public int   VolumenAppLHG;
	public int 	 IndiceTemperatura;
	public int 	 IndiceHumedad;
	
	
	/**** A4 ****/
	public float TipoPulverizador;
	
	
	public void rellenarA(int day, int month, int year, String idParcela,
			String idTratamiento, String Referencia) {

		this.day = day;
		this.month = month;
		this.year = year;
		this.idParcela = idParcela;
		this.idTratamiento = idTratamiento;
		this.Referencia = Referencia;

	}

	public void rellenarA1(float DensidadFoliar, float AnchoCalle,
			float DistanciaArboles, float LongitudArboles,
			float AnchuraArboles, float AlturaArboles, int IndiceDensidadFoliar,
			/*float AlturaMeseta,*/float FormaArbol, float FechaUltimaPoda, 
			float GradoPoda, int IndiceFormaArbol, int IndiceGradoPoda, 
			int IndiceFechaUltimaPoda) {

		this.DensidadFoliar = DensidadFoliar;
		this.AnchoCalle = AnchoCalle;
		this.DistanciaArboles = DistanciaArboles;
		this.LongitudArboles = LongitudArboles;
		this.AnchuraArboles = AnchuraArboles;
		this.AlturaArboles = AlturaArboles;
		this.IndiceDensidadFoliar = IndiceDensidadFoliar;
		//this.AlturaMeseta = AlturaMeseta;
		this.FormaArbol = FormaArbol;
		this.FechaUltimaPoda = FechaUltimaPoda;
		this.GradoPoda = GradoPoda;
		this.IndiceFormaArbol = IndiceFormaArbol;
		this.IndiceGradoPoda = IndiceGradoPoda;
		this.IndiceFechaUltimaPoda = IndiceFechaUltimaPoda;
				
	}

	public void rellenarA2345(float ProductosAplicar, float FormaActuacion,
			float Mojantes, float ZonaCriticaTratar, float Temperatura, float Humedad,
			float VelocidadViento, float TipoPulverizador, int IndiceProductosAplicar, int IndiceFormaActuacion, int IndiceZonaCriticaTratar, int IndiceMojantes,
			int IndiceTemperatura, int IndiceHumedad) {
		
		this.ProductosAplicar = ProductosAplicar;
		this.FormaActuacion = FormaActuacion;
		this.Mojantes = Mojantes;
		this.ZonaCriticaTratar = ZonaCriticaTratar;
		this.Temperatura = Temperatura;
		this.Humedad = Humedad;
		this.VelocidadViento = VelocidadViento;
		this.TipoPulverizador = TipoPulverizador;
		this.IndiceProductosAplicar = IndiceProductosAplicar;
		this.IndiceFormaActuacion = IndiceFormaActuacion;
		this.IndiceZonaCriticaTratar = IndiceZonaCriticaTratar;
		this.IndiceMojantes = IndiceMojantes;
		this.IndiceHumedad = IndiceHumedad;
		this.IndiceTemperatura = IndiceTemperatura;
		
	}


	// DEVUELVE A5 (VOLUMEN DE APLICACION) (L/HA L/HG)
	public ArrayList<Integer> calcularParteA() {
		ArrayList<Integer> Resultado = new ArrayList<Integer>();
		float NumeroArbolesPorHect, VolumenSetoAsigArbol, TRV;

		if (IndiceFormaArbol == 0){
			VolumenArbol = (float) (3.14159 * LongitudArboles * AnchuraArboles * AlturaArboles / 6);
		}else{
			VolumenArbol = LongitudArboles * AnchuraArboles * AlturaArboles;
		}
		
		NumeroArbolesPorHect = 10000 / (AnchoCalle * DistanciaArboles);
		
		//if (IndiceFormaArbol == 0){
			//VolumenSetoAsigArbol=VolumenArbol*2;
		//}else{
		VolumenSetoAsigArbol = VolumenArbol * DistanciaArboles
				/ LongitudArboles;
		//}
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

		VolumenAppLHA = ent1;
		VolumenAppLHG = ent1/12;
		Resultado.add(0, ent1);
		Resultado.add(1, ent1 / 12);

		return Resultado;

	}

}
