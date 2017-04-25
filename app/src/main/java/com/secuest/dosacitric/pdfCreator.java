package com.secuest.dosacitric;

import java.io.File;
import java.io.FileOutputStream;

import com.secuest.dosacitric.apw.PDFWriter;
import com.secuest.dosacitric.apw.PaperSize;
import com.secuest.dosacitric.apw.StandardFonts;
import com.secuest.dosacitric.apw.Transformation;

import android.app.DownloadManager;
import android.content.Context;
import android.os.Environment;


public class pdfCreator {

	private int line_pointer = 872;
	private int btw_lines = 27;
	private PDFWriter mPDFWriter;

	public pdfCreator(){
		mPDFWriter = new PDFWriter(PaperSize.FOLIO_WIDTH, PaperSize.FOLIO_HEIGHT);
		mPDFWriter.setFont(StandardFonts.SUBTYPE, StandardFonts.TIMES_ROMAN, StandardFonts.WIN_ANSI_ENCODING);
		mPDFWriter.addRawContent("0.7 0.7 0.7 rg\n");
		mPDFWriter.addText(30, 90, 10, "® dosacitric", Transformation.DEGREES_270_ROTATION);
		mPDFWriter.addRawContent("1 0.4 0 rg\n");
		mPDFWriter.addText(30, 880, 38, "DOSACITRIC");
		mPDFWriter.addRawContent("0 0 0 rg\n");
		mPDFWriter.addText(277, 912, 14, "dosacitric@upv.es");
		mPDFWriter.addText(277, 896, 14, "Unidad de Mecanización y Tecnología Agraria");
		mPDFWriter.addText(277, 880, 14, "UNIVERSITAT POLITÈCNICA DE VALÈNCIA");
	}

	public void writeFile(){
		RWFile rw = new RWFile();
		String A = ""+
				"A IDENTIFICACI&Oacute;N DEL TRATAMIENTO<tipo>1<n>"+
				"Fecha 27/08/2015<tipo>3<n>"+
				"Identificaci&oacute;n de la parcela 3432<tipo>3<n>"+
				"Identificaci&oacute;n del tratamiento 12.34ADC<tipo>3<n>"+
				"Refer&eacute;ncia 78GYE-9384UYI<tipo>3";
		rw.write("A", A);
		String B = "B VOLUMEN DE APLICACICI&Oacute;N<tipo>1<n>"+
				"B.1 Caracter&iacute;sticas del cultivo<tipo>2<n>"+
				"Densidad foliar del &aacute;rbol Media<tipo>3<n>"+
				"Marco de plantaci&oacute;n 99.0 m x 6.0 m<tipo>3<n>"+
				"Volumen del &aacute;rbol Esferica<tipo>3<n>"+
				"Fecha de la &uacute;ltima poda 3 - 12 meses<tipo>3<n>"+
				"Grado de poda Medio<tipo>3";
		rw.write("B", B);
	}


	public void insertarMarca(String marca){
		btw_lines = 40;
		incrementLinePointer();incrementLinePointer();
		mPDFWriter.addRectangle(30, line_pointer-15, 410+80, 40);
		//insertLine("  "+marca,19);
		mPDFWriter.addText(30, line_pointer, 19, "  "+marca);
		line_pointer=line_pointer-10;
		//incrementLinePointer(); 
	}
	
	public void insertarPresion(String presion){
	    incrementLinePointer();
		mPDFWriter.addLine(30,line_pointer-3, 410+160,line_pointer-3);
		//insertLine(presion,19);
		mPDFWriter.addText(30, line_pointer, 19, presion);
	}
	
	public void insertarZonas(String zona){
		insertLine(zona,15);
	}

	public void dibujarTabla(String datos){
		mPDFWriter.addRectangle(80, line_pointer, 410+80, -40);
		mPDFWriter.addRectangle(80, line_pointer-40, 410+80, -40);
		mPDFWriter.addRectangle(40, line_pointer-40-40, 410+120, -40*4);

		mPDFWriter.addLine(80, line_pointer-40, 80, line_pointer-40-40-40*4);
		mPDFWriter.addLine(80+69*1, line_pointer-40, 80+69*1, line_pointer-40-40-40*4);
		mPDFWriter.addLine(80+69*2, line_pointer-40, 80+69*2, line_pointer-40-40-40*4);
		mPDFWriter.addLine(80+69*3, line_pointer-40, 80+69*3, line_pointer-40-40-40*4);
		mPDFWriter.addLine(80+69*4, line_pointer-40, 80+69*4, line_pointer-40-40-40*4);
		mPDFWriter.addLine(80+69*5, line_pointer-40, 80+69*5, line_pointer-40-40-40*4);
		mPDFWriter.addLine(80+69*6, line_pointer-40, 80+69*6, line_pointer-40-40-40*4);

		mPDFWriter.addLine(40,line_pointer-40-40-40*2, 410+160,line_pointer-40-40-40*2);
		mPDFWriter.addLine(40,line_pointer-40-40-40*3, 410+160,line_pointer-40-40-40*3);
		//finish_document("Dosacitric_C"+cal.get(Calendar.DAY_OF_MONTH)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.YEAR),cxt);
	}

	/*Método con el que se pueden modificar los parámetros de los 3 tipos
	de letra*/
	
	public void readFile(String filename){
		RWFile rw = new RWFile();
		String A = rw.read(filename);
		String[] Alines = A.split("<n>");
		for (int i=0;i<Alines.length;i++){
			Alines[i]=putAccent(Alines[i]);
			System.out.println(Alines[i]);
			String[] Aitem = Alines[i].split("<tipo>");
			switch(Integer.parseInt(Aitem[1])){
			case 1: insertLine("",24);insertLine(Aitem[0],22);
			break;
			case 2: insertLine("      "+Aitem[0],18);
			break;
			case 3: line_pointer=line_pointer+8;insertLine("      "+"      "+"      "+"  "+Aitem[0],11);
			break;
			case 4: insertLine(Aitem[0],22);
			default: 
				break;
			}
		}
	}

	public void create() {
		//String pdfcontent = generateHelloWorldPDF();
		//outputToFile("helloworld.pdf",pdfcontent,"ISO-8859-1");
	}

	private void incrementLinePointer(){
		int aux = line_pointer-btw_lines;
		if (aux < 32){
			mPDFWriter.newPage();
			mPDFWriter.setFont(StandardFonts.SUBTYPE, StandardFonts.TIMES_ROMAN, StandardFonts.WIN_ANSI_ENCODING);
			mPDFWriter.addRawContent("190 190 190 rg\n");
			mPDFWriter.addText(30, 90, 10, "® dosacitric", Transformation.DEGREES_270_ROTATION);
			line_pointer = 838;
			mPDFWriter.addRawContent("1 0.4 0 rg\n");
			mPDFWriter.addText(30, 880, 38, "DOSACITRIC");
			mPDFWriter.addRawContent("0 0 0 rg\n");
			mPDFWriter.addText(277, 912, 14, "dosacitric@upv.es");
			mPDFWriter.addText(277, 896, 14, "Unidad de Mecanización y Tecnología Agraria");
			mPDFWriter.addText(277, 880, 14, "UNIVERSITAT POLITÈCNICA DE VALÈNCIA");
		} else {
			line_pointer=line_pointer-btw_lines;
		}

	}

	public void insertLine(String str, int size){
		incrementLinePointer();
		mPDFWriter.addText(30, line_pointer, size, str);
		
	}

	public void finish_document(String filename, Context cxt){
		int pageCount = mPDFWriter.getPageCount();
		for (int i = 0; i < pageCount; i++) {
			mPDFWriter.setCurrentPage(i);
			mPDFWriter.addText(10, 10, 8, Integer.toString(i + 1) + " / " + Integer.toString(pageCount));
		}

		String s = mPDFWriter.asString();
		outputToFile(filename,s,"ISO-8859-1",cxt);
	}

	public String generateHelloWorldPDF() {
		mPDFWriter = new PDFWriter(PaperSize.FOLIO_WIDTH, PaperSize.FOLIO_HEIGHT);

		// note that to make this images snippet work
		// you have to uncompress the assets.zip file
		// included into your project assets folder

		mPDFWriter.setFont(StandardFonts.SUBTYPE, StandardFonts.TIMES_ROMAN);
		mPDFWriter.addRawContent("1 0 0 rg\n");
		mPDFWriter.addText(30, 880, 38, "DOSACITRIC\nfunca");
		mPDFWriter.addTextAsHex(70, 50, 12, "68656c6c6f20776f726c6420286173206865782921");
		mPDFWriter.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER, StandardFonts.WIN_ANSI_ENCODING);
		mPDFWriter.addRawContent("0 0 0 rg\n");
		mPDFWriter.addText(30, 90, 10, "® dosacitric", Transformation.DEGREES_270_ROTATION);

		mPDFWriter.newPage();
		mPDFWriter.addRawContent("[] 0 d\n");
		mPDFWriter.addRawContent("1 w\n");
		mPDFWriter.addRawContent("0 0 1 RG\n");
		mPDFWriter.addRawContent("0 1 0 rg\n");
		mPDFWriter.addRectangle(40, 50, 280, 50);
		mPDFWriter.addText(85, 75, 18, "Code Research Laboratories");
		mPDFWriter.addRawContent("0 0 0 rg\n");
		mPDFWriter.addText(30, 90, 10, "®dosacitric", Transformation.DEGREES_270_ROTATION);

		mPDFWriter.newPage();
		mPDFWriter.setFont(StandardFonts.SUBTYPE, StandardFonts.COURIER_BOLD);
		mPDFWriter.addText(150, 150, 14, "http://coderesearchlabs.com");
		mPDFWriter.addLine(150, 140, 270, 140);
		mPDFWriter.addRawContent("0 0 0 rg\n");
		mPDFWriter.addText(30, 90, 10, "®dosacitric", Transformation.DEGREES_270_ROTATION);

		int pageCount = mPDFWriter.getPageCount();
		for (int i = 0; i < pageCount; i++) {
			mPDFWriter.setCurrentPage(i);
			mPDFWriter.addText(10, 10, 8, Integer.toString(i + 1) + " / " + Integer.toString(pageCount));
		}

		String s = mPDFWriter.asString();
		return s;
	}

	public void outputToFile(String fileName, String pdfContent, String encoding,Context cnt) {
		String folder = "";
		try {

			File newFolder = new File(Environment.getExternalStorageDirectory(), "Descargas");
			folder="Descargas";
			if (!newFolder.exists()) {
				newFolder = new File(Environment.getExternalStorageDirectory(), "Download");
				folder="Download";
				if (!newFolder.exists()) 
					newFolder.mkdir();
			}

			File file = new File(newFolder, fileName+".pdf");

			file.createNewFile();
			//Context nuev = null;
			DownloadManager ola = (DownloadManager) cnt.getSystemService(Context.DOWNLOAD_SERVICE);
			ola.addCompletedDownload(fileName+".pdf", "Datos cultivo", true, "application/pdf", Environment.getExternalStorageDirectory()+"/"+folder+"/"+fileName+".pdf", (long) 1029.0, true);

			FileOutputStream fOut = new FileOutputStream(file);
			fOut.write(pdfContent.getBytes(encoding));
			fOut.close();
		} catch (Exception ex) {
			System.out.println("exeption: " + ex);
		}
	}
	private String putAccent(String str){
		str=str.replace("&aacute;","á");
		str=str.replace("&eacute;","é");
		str=str.replace("&iacute;","í");
		str=str.replace("&oacute;","ó");
		str=str.replace("&uacute;","ú");
		str=str.replace("&Aacute;","Á");
		str=str.replace("&Eacute;","É");
		str=str.replace("&Iacute;","Í");
		str=str.replace("&Oacute;","Ó");
		str=str.replace("&Uacute;","Ú");
		str=str.replace("&cubico;","³");
		str=str.replace("&cuadrado;","²");
		return str;
	}

} 