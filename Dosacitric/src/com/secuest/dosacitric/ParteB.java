package com.secuest.dosacitric;



public class ParteB {

	/**** B ****/
	private float VolumenApp;
	private float AnchoTrabajo;
	private float VelocidadAvance;
	private float CaudalLiquidoTotal;
	private float CaudalLiquidoSector;
	private int NumeroTotalBoquillas;
	private int[] NumeroBoquillasCerradas; // Z.Alta y Z.Baja
	private int[] NumeroBoquillasAbiertas; // Z.Alta Z.Media y Z.Baja
	private float[] PorcentajeVegetacion; // Z.Alta Z.Media y Z.Baja
	private float[] IntervaloCaudalAdmisible; // Z.Alta Z.Media y Z.Baja
	private float VariacionCaudalAdmisible;
	private float AlturaMeseta; //PARTE A
	private int NumeroBoquillasSector;
	private int NumeroTotalBoquillasAbiertas;
	private float [] CaudalLiquidoZona;
	private float [] CaudalLiquidoBoquilla;
	
	public ParteB() {
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
		this.NumeroBoquillasAbiertas = NumeroBoquillasAbiertas; // Z.Alta
																// Z.Media y
									 							// Z.Baja
		this.PorcentajeVegetacion = PorcentajeVegetacion; // Z.Alta Z.Media y
															// Z.Baja
		this.IntervaloCaudalAdmisible = IntervaloCaudalAdmisible; // Z.Alta
						  		 									// Z.Media y
																	// Z.Baja
		this.VariacionCaudalAdmisible = VariacionCaudalAdmisible;
		//hhh
	}

	public void calcularParteB() {
		
		CaudalLiquidoTotal = VolumenApp*AnchoTrabajo*VelocidadAvance / 600;  //600 HARCODEADO---------
		CaudalLiquidoSector = CaudalLiquidoTotal / 2; // SectorIzquierdo y Sector Derecho
		NumeroBoquillasSector = NumeroTotalBoquillas/2;
		NumeroTotalBoquillasAbiertas = NumeroTotalBoquillas - NumeroBoquillasCerradas[0] - NumeroBoquillasCerradas[1];
		CaudalLiquidoZona[0] = CaudalLiquidoTotal * PorcentajeVegetacion[0] / 100;
		CaudalLiquidoZona[1] = CaudalLiquidoTotal * PorcentajeVegetacion[1] / 100;
		CaudalLiquidoZona[2] = CaudalLiquidoTotal * PorcentajeVegetacion[2] / 100;
		CaudalLiquidoBoquilla[0] = CaudalLiquidoZona[0] / NumeroBoquillasAbiertas[0];
		CaudalLiquidoBoquilla[1] = CaudalLiquidoZona[1] / NumeroBoquillasAbiertas[1];
		CaudalLiquidoBoquilla[2] = CaudalLiquidoZona[2] / NumeroBoquillasAbiertas[2];
		VariacionCaudalAdmisible = VariacionCaudalAdmisible / 100;
		IntervaloCaudalAdmisible[0] = CaudalLiquidoBoquilla[0] * (1-VariacionCaudalAdmisible);
		IntervaloCaudalAdmisible[1] = CaudalLiquidoBoquilla[0] * (1+VariacionCaudalAdmisible);
		IntervaloCaudalAdmisible[2] = CaudalLiquidoBoquilla[1] * (1-VariacionCaudalAdmisible);
		IntervaloCaudalAdmisible[3] = CaudalLiquidoBoquilla[1] * (1+VariacionCaudalAdmisible);
		IntervaloCaudalAdmisible[4] = CaudalLiquidoBoquilla[2] * (1-VariacionCaudalAdmisible);
		IntervaloCaudalAdmisible[5] = CaudalLiquidoBoquilla[2] * (1+VariacionCaudalAdmisible);
		
		
		
	}

}
