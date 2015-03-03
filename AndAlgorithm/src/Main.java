import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 For each query term t
 1. retrieve lexicon entry for t
 2. note ft and address of It (inverted list)
 2. Sort query terms by increasing ft
 
 3. Initialize candidate set C with It of the term with the smallest ft
4. For each remaining t

1. Read It
2. For each d ϵ C, if d ɇ It, C <- C – {d}
3. If C = {}, return… there are no relevant docs
5. Look up each d ϵϵ C and return to the user
 
 
 */
public class Main {

	
	
	public static void main(String[] args) {
		TreeMap<String, String[]> col = readFile();
		search(col,"Trond");
		
		
		System.out.println("Trond er så mye mer awesomeee");
		System.out.println("Test");
	}
	
	public static String search(TreeMap<String, String[]> col, String searchParam){
		
		TreeMap<String,Integer> docFreq = new TreeMap<String,Integer>();
		for(Entry<String,String[]> index : col.entrySet()){
			String key = index.getKey();
			String[] array = index.getValue();
			
			System.out.println("\n"+key+"\n");
			int freq = 0;
			for(String ind : array){
				System.out.println(ind);
				
				if(searchParam.equals(ind)){
					freq++;
				docFreq.put(key,freq);
				
				}
			}
			
		}
		
		
		for(Entry<String,Integer> entry : docFreq.entrySet()){
		ArrayList<Integer> list = new ArrayList<Integer>();
		String key = entry.getKey();
		int val = entry.getValue();
		
		System.out.println(entry.getValue());
		
		list.add(val);
		Collections.sort(list);
		
		for(int x : list){
		//	System.out.println(x);
		}
		
		}
		
		return "test";
	}

	
	
	
	
	
	public static TreeMap<String, String[]> readFile(){
		TreeMap<String,String[]> collection = new TreeMap<String,String[]>();
		try{
		
			File[] documents = getDocuments();
			
			for(File d : documents){
	
			Scanner scan = new Scanner(d);
			String[] document = null;
			String text = "";
			String docName = "";
			docName = d.getName();
			while(scan.hasNextLine()){
			text = text + " " + scan.nextLine();
			
		
		}

		    text = text.replaceAll("[^\\p{L}\\p{Nd}]+", " ");
			document = text.split(" ");
			collection.put(docName,document);
		
			}
			
			
			
		}catch(Exception e){	
		}
		
		return collection;
	}
	public static File[] getDocuments(){
		File fil = new File("Files");
		return fil.listFiles(new FilenameFilter() { 
	         public boolean accept(File dir, String filename)
	              { return filename.endsWith(".txt"); }
	} );
	}
	
	
}
	

