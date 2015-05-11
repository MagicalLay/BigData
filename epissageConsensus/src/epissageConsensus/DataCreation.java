package epissageConsensus;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

public class DataCreation
{
	
	public DataCreation(){}
	
	public StringBuilder alterateString(String entryChain){
		StringBuilder res = new StringBuilder(entryChain);
		int lg = res.length();
		Random rand = new Random();
		int nb = rand.nextInt(2) * lg/50;
		int pos;
		int val;
		char[] acides = new char[4];
		acides[0] = 'A';
		acides[1] = 'G';
		acides[2] = 'C';
		acides[3] = 'T';
		for (int i = 0 ; i<nb ; i++){
			pos = rand.nextInt(lg);
			val = rand.nextInt(4);
			res.setCharAt(pos, acides[val]);
		}
		return res;
	}
	
	public StringBuilder[] cutString(StringBuilder st){
		StringBuilder[] res = new StringBuilder[20];
		int lg = st.length();
		Random rand = new Random();
		for(int i = 0 ; i<20 ; i++){
			int begin = rand.nextInt(lg);
			int end = begin + rand.nextInt(lg-begin);
			if(end-begin>70){end=begin+70;}
			res[i] = new StringBuilder(st.substring(begin, end));
		}
		return res;
	}

	public static void main(String[] args){
		DataCreation dc = new DataCreation();
		
		char[] acides = new char[4];
		acides[0] = 'A';
		acides[1] = 'G';
		acides[2] = 'C';
		acides[3] = 'T';
		String consensusData = RandomStringUtils.random(300,acides);
		
		int nbpeople=4;
		StringBuilder[] adns = new StringBuilder[nbpeople];
		for(int i = 0 ; i<nbpeople ; i++){
			adns[i] = dc.alterateString(consensusData);
		}
		
		for(int j = 0 ; j<nbpeople ; j++){
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(new File("adns"+(j+1))));
				// normalement si le fichier n'existe pas, il est crée à la racine du projet
				System.out.println(adns[j]);
				writer.write(">IdentADN"+j);
				writer.write("\n");
				writer.write(adns[j].toString());
				writer.write("\n");
				writer.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		StringBuilder[][] arnEpisse = new StringBuilder[nbpeople][20];
		for(int j = 0 ;  j < nbpeople; j++){
			arnEpisse[j] = dc.cutString(adns[j]);
		}
		
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
