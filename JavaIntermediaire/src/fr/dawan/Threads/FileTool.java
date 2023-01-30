package fr.dawan.Threads;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileTool {
	
	public static void copy(String source, String cible) throws Exception {
		FileInputStream fis = new FileInputStream(source);
		FileOutputStream fos = new FileOutputStream(cible);
		
		int value;
		while((value = fis.read()) != -1) { //si value = -1 => aucun caractère récupéré
			fos.write(value);
		}
		
		fis.close();
		fos.close();
		
	}

}
