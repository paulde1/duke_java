import edu.duke.*;
import java.io.*;


public class GeneFinderAndTester {
    public String findGeneSimple(String dna) {
        String result = '';
        int startIndex = dna.indexOf('ATG');
		if(startIndex > -1){
			 int endIndex = dna.lastIndexOf('TAA');
        //int endIndex = dna.indexof('TAA', startIndex + 3); 
        result = dna.substring(startIndex, endIndex + 3);
        return result;
		}else {
			return result;
		}
    }
}


public void testGeneFinder(){
    String sample = 'AATGCGTAATATGGT';
    System.out.println(" The DNA strand is " + sample);
    String gene = geneFinder(sample);
    System.out.println("The gene is " + gene);

    sample = 'AATGCTAGGGTAATATGGT';
    System.out.println(" The DNA strand is " + sample);
    gene = geneFinder(sample);
    System.out.println("The gene is " + gene);

    sample = 'ATCTATGCTTCGGCTGVTVTAATATGGT';
    System.out.println(" The DNA strand is " + sample);
    gene = geneFinder(sample);
    System.out.println("The gene is " + gene);
}


public class TagFinder {
	public String findProtein(String dna) {
		int start = dna.indexOf("atg");
		if (start == -1) {
			return "";
		}
		int stop = dna.indexOf("tag", start+3);
		if ((stop - start) % 3 == 0) {
			return dna.substring(start, stop+3);
		}
		else {
			return "";
		}
	}
	
	public void testing() {
		String a = "cccatggggtttaaataataataggagagagagagagagttt";
		String ap = "atggggtttaaataataatag";
		//String a = "atgcctag";
		//String ap = "";
		//String a = "ATGCCCTAG";
		//String ap = "ATGCCCTAG";
		String result = findProtein(a);
		if (ap.equals(result)) {
			System.out.println("success for " + ap + " length " + ap.length());
		}
		else {
			System.out.println("mistake for input: " + a);
			System.out.println("got: " + result);
			System.out.println("not: " + ap);
		}
	}
}