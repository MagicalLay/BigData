package epissageConsensus;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class traitementARN {
	
	public String[] loadFile(File f) {
	    try {
	       BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
	       int b;
	       String[] st = new String[20];
	       while ((b=in.read()) != -1){
		       out.write(b);
		       out.flush();
		       out.close();
		       in.close();
	       }
	       	return out.toString();
	    }
	    catch (IOException ie)
	    {
	         ie.printStackTrace();
	         return "erreur";
	    }
	}
	
	public static void main(String[] args){
		for(int j = 0 ; j<nbpeople ; j++){
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(new File("arns"+(j+1))));
				// normalement si le fichier n'existe pas, il est crée à la racine du projet
				for(int i = 0 ; i< 20 ; i++) {
					System.out.println(arnEpisse[j][i]);
					writer.write(">Ident"+i);
					writer.write("\n");
					writer.write(arnEpisse[j][i].toString());
					writer.write("\n");
				}
				writer.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}
