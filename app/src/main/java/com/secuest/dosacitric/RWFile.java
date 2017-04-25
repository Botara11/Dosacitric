package com.secuest.dosacitric;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;


import android.os.Environment;

public class RWFile {

	public RWFile(){

	}


	public String read (String nameFile){
		//Find the directory for the SD Card using the API
		//*Don't* hardcode "/sdcard"

		File newFolder;
		newFolder = new File(Environment.getExternalStorageDirectory(), ".xaBIOS");
		if (!newFolder.exists()) {
			newFolder = new File(Environment.getExternalStorageDirectory(), ".xaBIOS");
			if (!newFolder.exists()) {
				newFolder.mkdir();
			}
		}
		
		//Get the text file
		File file = new File(newFolder,nameFile);

		//Read text from file
		String res = "";
		StringBuilder text = new StringBuilder();{

			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = "";

				while ((line = br.readLine()) != null) {
					text.append(line);
				}
				br.close();
				res= text.toString();
			}
			catch (IOException e) {
				System.out.println("Excep_en_readFile: "+e);
				//write( nameFile, "0"); In this case "Flexiones" I dont want to write
				return null;
				//You'll need to add proper error handling here
			}

		}
		return res;
	}

	public void write(String nameFile,String text){
		try {
			File newFolder;
			newFolder = new File(Environment.getExternalStorageDirectory(), ".xaBIOS");
			if (!newFolder.exists()) {
				newFolder = new File(Environment.getExternalStorageDirectory(), ".xaBIOS");
				if (!newFolder.exists()) {
					newFolder.mkdir();
					System.out.println("Makedir Downloads");
				}
			}
			try {
				File file = new File(newFolder, nameFile);
				file.createNewFile();

				FileOutputStream fOut = new FileOutputStream(file);
				OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
				myOutWriter.append(text);
				myOutWriter.close();
				fOut.close();
			} catch (Exception ex) {
				System.out.println("exeption: writing " + ex);
			}
		} catch (Exception e) {
			System.out.println("e: " + e);
		}
	}
}
