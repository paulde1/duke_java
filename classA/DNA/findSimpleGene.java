package classA.DNA;

public class findSimpleGene {
     public String findGene(String dna) {
        int startCodon = dna.indexOf("ATG");
        if(startCodon == -1) {
            return "";
        }
        int stopCodon = dna.indexOf("TAA", startCodon + 3 );
        if(stopCodon == -1) {
            return "";
        }
        if((stopCodon - startCodon) % 3 == 0) {
            return dna.substring(startCodon, stopCodon + 3);
        }
        return "";
    }
    
    public void testSimpleGene() {
        String dna = "CGTGATTCTAATG"; //prints empty string has no ATG
        System.out.println("DNA strand is " + dna);
        String gene = findGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "CGATGAAATGCTG"; //prints empty string has no TAA
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "CGAAATGCTG"; //prints empty string has no ATG or TAA
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "TGCATGTTTCTGTAATG"; //prints ATGTTTCTGTAA
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "TGCATGTTCTGTAATG"; //prints empty string not multiple of 3
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "AAATGCCCTAACTAGATTAAGAAACC"; //prints ATGCCCTAA
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "AAATGCCCCTGTGCGGTTAACTAGATTAAGAAACC"; //prints ATGCCCCTGTGCGGTTAA
        System.out.println("DNA strand is " + dna);
        gene = findGene(dna);
        System.out.println("Gene is " + gene);
    }
}
