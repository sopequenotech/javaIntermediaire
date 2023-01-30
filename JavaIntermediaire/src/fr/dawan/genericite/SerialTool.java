package fr.dawan.genericite;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SerialTool {
	
	public static <T> void ExportXML(List<T> lst, String chemin) {
		try {
			XMLEncoder xml = new XMLEncoder(new FileOutputStream(chemin));
			xml.writeObject(lst);
			xml.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Méthode de désérialisation XML: XmlDecoder
	
	public static <T> List<T> ImportXML(String chemin){
		List<T> lst = new ArrayList<>();
		try {
			XMLDecoder xml = new XMLDecoder(new FileInputStream(chemin));
			lst= (List<T>) xml.readObject();
			xml.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return lst;
	}
	
	//Méthode de sérialisation CSV
	
	public static <T> void ExportCSV(List<T> lst, String chemin) throws Exception{
		
		try(FileOutputStream fos = new FileOutputStream(chemin)){
			for(T obj : lst) {
				Class<?> clazz = obj.getClass();
				Field[] fields = clazz.getDeclaredFields();
				
				StringBuilder sb = new StringBuilder();
				for(Field f : fields) {
					//construction de la ligne à insérer dans le fichier
					f.setAccessible(true); //l'accès aux attributs passe par les get/set - Activation du Getteur
					sb.append(f.get(obj).toString()).append(";"); //1;pc dell;1500;
				}
				//Insertion du sb dans le fichier et suppression du dernier ;
				String result = sb.substring(0, sb.length()-1);
				result = result+"\n";
				fos.write(result.getBytes());
				
			}
		}//fis.close() est exécuté par le try with resource
	}
	
	public static <T> List<T> ImportCSV(String chemin, Class<T> clazz){
		List<T> lst = new ArrayList<>();
		try {
			/*
			 * 2 types de flux pour traiter les fichiers: flux binaire (char/char) - flux caractères(ligne/ligne)
			 * FileInputStream - FileOutputStream: traitement binaire char/char
			 * FileReader - FileWriter: traitement ligne/ligne - Buffer: permet de traiter des fichiers lourds plus rapidemet
			 */
			BufferedReader br = new BufferedReader(new FileReader(chemin), 16384);
			String ligne = null;
			while((ligne = br.readLine()) != null) {
				String[] tab = ligne.split(";"); //["1","PC Dell","1500"]
				T obj = clazz.getDeclaredConstructor().newInstance(); //une instance générique
				Field[] fields = clazz.getDeclaredFields();
				int i = 0;
				for(Field f : fields) {
					f.setAccessible(true);
					Class<?> type = f.getType();
					
					if(type.equals(int.class)) {
						f.set(obj, Integer.parseInt(tab[i]));
					}else if(type.equals(String.class)) {
						f.set(obj, tab[i]);
					}else if(type.equals(double.class)) {
						f.set(obj, Double.parseDouble(tab[i]));
					}else if(type.equals(Boolean.class)) {
						f.set(obj, Boolean.parseBoolean(tab[i]));
					}
					i++;
				}
				lst.add(obj);
			}
			br.close();
			
			return lst;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
		
		
	}


}
/*
1;pc dell;1500
2;ecran hp;120


*/