package classA.DNA;

public class findSimpleGene {
     public String findGene(String dna, int startCodon, int stopCodon) {
        for (int i = 0; i < dna.length(); i++) {
            if(Character.isUpperCase(dna.charAt(i))) {
                startCodon = dna.indexOf("ATG");
                stopCodon = dna.indexOf("TAA", startCodon + 3 );
            } else {
                startCodon = dna.indexOf("atg");
                stopCodon = dna.indexOf("taa", startCodon + 3 );
            }
        }
        if(startCodon == -1) {
            return "";
        }
        if(stopCodon == -1) {
            return "";
        }
        if((stopCodon - startCodon) % 3 == 0) {
            return dna.substring(startCodon, stopCodon + 3);
        }
        return "";
    }
    public int howMany(String stringa, String stringb) {
        int count = 0;
        int index = stringb.indexOf(stringa);
        while(index >= 0) {
            index = stringb.indexOf(stringa, index + stringa.length());
            count++;
        }
        return count; 
    }
    
    public void testHowMany() {
        System.out.println(howMany("GAA", "ATGAACGAATTGAATC"));
        System.out.println(howMany("AA", "ATAAAA"));
    }
    public void testGene() {
        String dna = "CGTGATTCTAATG"; //prints empty string has no ATG
        System.out.println("DNA strand is " + dna);
        String gene = findGene(dna, 0, 12);
        System.out.println("Gene is " + gene);
        
        dna = "CGATGAAATGCTG"; //prints empty string has no TAA
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna, 2, 5);
        System.out.println("Gene is " + gene);
        
        dna = "CGAAATGCTG"; //prints empty string has no ATG or TAA
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna, 5, 7);
        System.out.println("Gene is " + gene);
        
        dna = "TGCATGTTTCTGTAATG"; //prints ATGTTTCTGTAA
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna, 0, 15);
        System.out.println("Gene is " + gene);
        
        dna = "gatgctataat"; //prints atgctataa
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna, 0, 15);
        System.out.println("Gene is " + gene);
        
        dna = "TGCATGTTCTGTAATG"; //prints empty string not multiple of 3
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna, 0, 10);
        System.out.println("Gene is " + gene);
    }
}
