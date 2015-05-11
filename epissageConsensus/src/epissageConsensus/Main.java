package epissageConsensus;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;

public class Main {

	public static String loadFile(File f) {
	    try {
	       BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
	       StringWriter out = new StringWriter();
	       int b;
	       while ((b=in.read()) != -1)
	           out.write(b);
	       out.flush();
	       out.close();
	       in.close();
	       return out.toString();
	    }
	    catch (IOException ie)
	    {
	         ie.printStackTrace();
	         return "erreur chargement fichier";
	    }
	}
	
	public static void  main(String[] args) {
		//File fich1 = new File("H:/4INFO/TP4info/BigData/Projet/test1.txt");
		//File fich2 = new File("H:/4INFO/TP4info/BigData/Projet/test2.txt");
		//String f1 = loadFile(fich1);
		//String f2 = loadFile(fich2);
		//char[] c1 = f1.toCharArray();
		//char[] c2 = f2.toCharArray();
	}
	
}
