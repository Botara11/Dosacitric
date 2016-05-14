package com.secuest.dosacitric;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ParteC implements Serializable{

	private static final long serialVersionUID = 9017987621798917121L;
	/**** C ****/
	public float AnchoCalle;
	public int[] NumeroBoquillasZona; // Z.Alta Z.Media y Z.Baja
	public float VelocidadAvance;
	public int NumeroTotalBoquillas;
	public float[] CaudalZona = {0,0,0}; // Z.Alta Z.Media y Z.Baja
	public float CaudalZonaTotal;
	public float CaudalSector;
	public float CaudalTotal;
	public int VolumenCaldoAplicado;
	public int VolumenCaldoAplicadoHanegada;
	public String PresionSeleccionada;
	public String MarcaSeleccionada;
	public ArrayList<String> ModeloZonaAltaSeleccionado;
	public ArrayList<String> ModeloZonaMediaSeleccionado;
	public ArrayList<String> ModeloZonaBajaSeleccionado;
	public Resultados3 resultados3;
	
	public ParteC() {
	}

	public int getNumTotBoq() {
		return NumeroTotalBoquillas;
	}

	public void rellenarC1(float AnchoCalle,
			int[] NumeroBoquillasZona, // Z.Alta Z.Media y Z.Baja
			float VelocidadAvance) {

		this.AnchoCalle = AnchoCalle;
		this.NumeroBoquillasZona = NumeroBoquillasZona; // Z.Alta// Z.Media y
		// Z.Baja
		this.VelocidadAvance = VelocidadAvance;
	}
	
	public void rellenarC2(String item) {
		PresionSeleccionada = item;
	}
	
	public void rellenarC3(String item) {
		MarcaSeleccionada = item;
	}
	
	public void rellenarC4(ArrayList<String> item) {
		ModeloZonaAltaSeleccionado = item;
	}
	public void rellenarC5(ArrayList<String> item) {
		ModeloZonaMediaSeleccionado = item;
	}
	public void rellenarC6(ArrayList<String> item) {
		ModeloZonaBajaSeleccionado = item;
	}
	
	public void calcularParteC(Float ValorZonaAlta, Float ValorZonaMedia, Float ValorZonaBaja) {
		
		
		
		CaudalZona[0] = ValorZonaAlta * NumeroBoquillasZona[0];
		CaudalZona[1] = ValorZonaMedia * NumeroBoquillasZona[1];
		CaudalZona[2] = ValorZonaBaja * NumeroBoquillasZona[2];
		
		//Suma de los caudales por zona//
		CaudalZonaTotal = CaudalZona[0] + CaudalZona[1] + CaudalZona[2];
		
		System.out.print(CaudalZonaTotal);
		
		CaudalSector = CaudalZonaTotal / 2;
		CaudalTotal = CaudalSector * 2;
		DecimalFormat df = new DecimalFormat("#");
		VolumenCaldoAplicado = (int) Float.parseFloat(df.format(( CaudalTotal * (float)600 / (AnchoCalle * VelocidadAvance))));
		VolumenCaldoAplicadoHanegada = VolumenCaldoAplicado / 12;
		
	}
}

