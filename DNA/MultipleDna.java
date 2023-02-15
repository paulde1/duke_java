import edu.duke.*;
import java.io.*;


public class Part1 {
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
return -1;
}

public String findGene (String dna) {
	int startIndex = dna.indexOf('ATG');
	if(startIndex == -1) {
		return ''
	}

	int taaIndex = findStopCodon(dna, startIndex, 'TAA');
	int tagIndex = findStopCodon(dna, startIndex, 'TAG');
	int tgaIndex = findStopCodon(dna, startIndex, 'TGA');

	int temp = Math.min(taaIndex, tagIndex);
	int min = Math.min(temp,tgaIndex);


	if(taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
		minIndex = tgaIndex;
	} else {
		minIndex = taaIndex;
	}

	if (minIndex == -1 || (tgaIndex != -1 && tagIndex < min)) {
		minIndex = tagIndex;
	}

	if( min == dna.length()){
		return ''
	}
	return dna.substring(startIndex, min + 3 );
}

public void printAllGenes (String dna) {
	int start = 0;
	while ( true) {
		String currentGene = findTheGene(dna,start);
		if(currentGene.isEmpty()) {
			break;
		}
	}
	System.out.println(currentGene)
	start = dna.indexOf(currentGene,start)+ currentGene.length();
}

public void testStopCodon () {
	String dna = 'tffffgssfvsfdvsdTAAdtgrdgdfggdgggrTAAuu';
	int test = findStopCodon(dna, 0, 'TAA');
	if (test != 16 ) System.out.println('error');
	test = findStopCodon(dna, 16, 'TAA');
	if (test != 16 ) System.out.println('error after 16');
}
public void testFindGene(){
    String sample = 'AATGCGTAATATGGT';
    System.out.println(" The DNA strand is " + sample);
    String gene = findTheGene(sample);
    System.out.println("The gene is " + gene);

    sample = 'AATGCTAGGGTAATATGGT';
    System.out.println(" The DNA strand is " + sample);
    gene = findTheGene(sample);
    System.out.println("The gene is " + gene);

    sample = 'ATCTATGCTTCGGCTGVTVTAATATGGT';
    System.out.println(" The DNA strand is " + sample);
    gene = findTheGene(sample);
    System.out.println("The gene is " + gene);
}
}

public class Part2 {
    public int howMany (String a , String b) {
    int pos = dna.indexOf(a);
        int counter = 0;
     while (pos >= 0) {
      count = count + 1;
      pos = dna.indexOf(a,pos +1);
}
System.out.println(count);

        return counter;
    }
}


	while (count < 3) {
  count += 1;
  newDna = newDna + dna.substring(startPos,pos);
  startPos = pos+1;
  pos = dna.indexOf("T", startPos);
  if (pos == -1) {
    break;
  }
}