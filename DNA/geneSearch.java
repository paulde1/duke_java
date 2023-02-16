


public class geneSearch {
    public StorageResource getAllGenes (String dna) {
        int startIndex = 0;
        while (true) {
            String currentGene = findGene(dna,startIndex)
            if (currentGene.isEmpty()){
                break;
            }
            geneList.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex);
            currentGene.length()
        }
        return geneList;
    }

    public void testOn (String dna){
        System.out.println("Testing getAllGenes")
        StorageResource gene = getAllGenes(dna);
        for(String g : gene.getData())
        System.out.println(g);
    }
    public void test () {
        testOn("ATGATCTAATTTATGCTGCAACGGTAAGA")
    }

}