import edu.duke.*;
import java.io.*;


public class GeneFinderAndTester {
    public String findGeneSimple(String dna) {
        String result = 'invalid sequence';
        int startIndex = dna.indexOf('ATG');
        int endIndex = dna.indexOf('TAA', startIndex + 3); 
		if(startIndex > -1 || endIndex > -1) {
				if ((startIndex - endIndex) % 3 == 0) {
// 			return dna.substring(start, stop+3);
// 		}
        result = dna.substring(startIndex, endIndex + 3);
		}
		return result;
    }
}


public String findGene (String dna) {
	dna = dna.toLowercase();
	int startIndex = dna.indexOf('dna');
	int currentIndex = dna.indexOf('TAA', startIndex + 3);
	while (currentIndex != -1 ) {
		if((currentIndex - startIndex) % 3 == 0) {
			return dna.substring(startIndex, currentIndex + 3);
		}else {
			currentIndex = dna.indexOf('TAA', currentIndex + 1);
		}
	}
	return ''
}

public int findStopCodon(String dna, int startIndex, String stopCodon) {
	int currIndex = dna.indexof(stopCodon, startIndex + 3);
	while( currIndex != -1 ) {
		int diff = currIndex - startIndex;
		if( diff % 3 == 0 ) {
			return currIndex;
	} else {
		currIndex = dna.indexOf(stopCodon)
	}
}

public String findTheGene (String dna) {
	int startIndex = dna.indexOf('ATG');
	if(startIndex == -1) {
		return ''
	}

	int taaIndex = findStopCodon(dna, startIndex, 'TAA');
	int tagIndex = findStopCodon(dna, startIndex, 'TAG');
	int tgaIndex = findStopCodon(dna, startIndex, 'TGA');

	int temp = Math.min(taaIndex, tagIndex);
	int min = Math.min(temp,tgaIndex);

	if( min == dna.length()){
		return ''
	}
	return dna.substring(startIndex, min + 3 );
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
}


	