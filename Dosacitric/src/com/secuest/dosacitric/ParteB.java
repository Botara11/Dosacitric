package com.secuest.dosacitric;

import java.io.Serializable;

public class ParteB implements Serializable {

	/**** B ****/
	public float VolumenApp;
	public float AnchoTrabajo;
	public float VelocidadAvance;
	public float CaudalLiquidoTotal;
	public float CaudalLiquidoSector;
	public int NumeroTotalBoquillas;
	public int[] NumeroBoquillasCerradas; // Z.Alta y Z.Baja
	public int[] NumeroBoquillasAbiertas; // Z.Alta Z.Media y Z.Baja
	public float[] PorcentajeVegetacion; // Z.Alta Z.Media y Z.Baja
	public float[] IntervaloCaudalAdmisible ={0,0,0,0,0,0}; // Z.Alta Z.Media y Z.Baja
	public float VariacionCaudalAdmisible;
	public float AlturaMeseta; // PARTE A
	public int NumeroBoquillasSector;
	public int NumeroTotalBoquillasAbiertas;
	public float[] CaudalLiquidoZona  ={0,0,0};
	public float[] CaudalLiquidoBoquilla  ={0,0,0};

	public ParteB() {
	}

	public int getNumTotBoq() {
		return NumeroTotalBoquillas;
	}

	public void rellenarB1(float VolumenApp, float AnchoTrabajo,
			float VelocidadAvance, float CaudalLiquidoTotal,
			float CaudalLiquidoSector, int NumeroTotalBoquillas) {

		this.VolumenApp = VolumenApp;
		this.AnchoTrabajo = AnchoTrabajo;
		this.VelocidadAvance = VelocidadAvance;
		this.CaudalLiquidoTotal = CaudalLiquidoTotal;
		this.CaudalLiquidoSector = CaudalLiquidoSector;
		this.NumeroTotalBoquillas = NumeroTotalBoquillas;

	}

	public void rellenarB2(int[] NumeroBoquillasCerradas, // Z.Alta y Z.Baja
			int[] NumeroBoquillasAbiertas, // Z.Alta Z.Media y Z.Baja
			float[] PorcentajeVegetacion, // Z.Alta Z.Media y Z.Baja
			float VariacionCaudalAdmisible) {
		this.NumeroBoquillasCerradas = NumeroBoquillasCerradas; // Z.Alta y
		// Z.Baja
		this.NumeroBoquillasAbiertas = NumeroBoquillasAbiertas; // Z.Alta
		// Z.Media y
		// Z.Baja
		this.PorcentajeVegetacion = PorcentajeVegetacion; // Z.Alta Z.Media y
		// Z.Baja
		this.VariacionCaudalAdmisible = VariacionCaudalAdmisible;
		// hhh

	}

	public void rellenarB(float VolumenApp, float AnchoTrabajo,
			float VelocidadAvance, float CaudalLiquidoTotal,
			float CaudalLiquidoSector, int NumeroTotalBoquillas,
			int[] NumeroBoquillasCerradas, // Z.Alta y Z.Baja
			int[] NumeroBoquillasAbiertas, // Z.Alta Z.Media y Z.Baja
			float[] PorcentajeVegetacion, // Z.Alta Z.Media y Z.Baja
			float[] IntervaloCaudalAdmisible, // Z.Alta Z.Media y Z.Baja
			float VariacionCaudalAdmisible) {

		this.VolumenApp = VolumenApp;
		this.AnchoTrabajo = AnchoTrabajo;
		this.VelocidadAvance = VelocidadAvance;
		this.CaudalLiquidoTotal = CaudalLiquidoTotal;
		this.CaudalLiquidoSector = CaudalLiquidoSector;
		this.NumeroTotalBoquillas = NumeroTotalBoquillas;
		this.NumeroBoquillasCerradas = NumeroBoquillasCerradas; // Z.Alta y
																// Z.Baja
		this.NumeroBoquillasAbiertas = NumeroBoquillasAbiertas; // Z.Alta// Z.Media y
														// Z.Baja
		this.PorcentajeVegetacion = PorcentajeVegetacion; // Z.Alta Z.Media y
															// Z.Baja
		this.IntervaloCaudalAdmisible = IntervaloCaudalAdmisible; // Z.Alta
																	// Z.Media y
																	// Z.Baja
		this.VariacionCaudalAdmisible = VariacionCaudalAdmisible;
		// hhh
	}

	public void calcularParteB() {

		CaudalLiquidoTotal = VolumenApp * AnchoTrabajo * VelocidadAvance / 600; // 600
																				// HARCODEADO---------
		CaudalLiquidoSector = CaudalLiquidoTotal / 2; // SectorIzquierdo y
														// Sector Derecho
		NumeroBoquillasSector = NumeroTotalBoquillas / 2;
		NumeroTotalBoquillasAbiertas = NumeroTotalBoquillas
				- NumeroBoquillasCerradas[0] - NumeroBoquillasCerradas[1];
		
		System.out.println("  "+PorcentajeVegetacion[0]+" " +CaudalLiquidoTotal);
		
		CaudalLiquidoZona[0] = CaudalLiquidoTotal * PorcentajeVegetacion[0] / 100;
		CaudalLiquidoZona[1] = CaudalLiquidoTotal * PorcentajeVegetacion[1]
				/ 100;
		CaudalLiquidoZona[2] = CaudalLiquidoTotal * PorcentajeVegetacion[2]
				/ 100;
		CaudalLiquidoBoquilla[0] = CaudalLiquidoZona[0]
				/ NumeroBoquillasAbiertas[0];
		CaudalLiquidoBoquilla[1] = CaudalLiquidoZona[1]
				/ NumeroBoquillasAbiertas[1];
		CaudalLiquidoBoquilla[2] = CaudalLiquidoZona[2]
				/ NumeroBoquillasAbiertas[2];
		VariacionCaudalAdmisible = VariacionCaudalAdmisible / 100;
		IntervaloCaudalAdmisible[0] = CaudalLiquidoBoquilla[0]
				* (1 - VariacionCaudalAdmisible);
		IntervaloCaudalAdmisible[1] = CaudalLiquidoBoquilla[0]
				* (1 + VariacionCaudalAdmisible);
		IntervaloCaudalAdmisible[2] = CaudalLiquidoBoquilla[1]
				* (1 - VariacionCaudalAdmisible);
		IntervaloCaudalAdmisible[3] = CaudalLiquidoBoquilla[1]
				* (1 + VariacionCaudalAdmisible);
		IntervaloCaudalAdmisible[4] = CaudalLiquidoBoquilla[2]
				* (1 - VariacionCaudalAdmisible);
		IntervaloCaudalAdmisible[5] = CaudalLiquidoBoquilla[2]
				* (1 + VariacionCaudalAdmisible);

	}

}
