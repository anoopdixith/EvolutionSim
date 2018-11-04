package BuildingBlocks;

import java.util.*;

/**
 */
public class Gene {
    private String sequence;
    private int geneLength;

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public Gene(DNA dna) {
        this.sequence = dna.getGene();
    }

    public Gene(String sequence) {
        this.sequence = sequence;
    }

    public void printGene() {
        System.out.print("Gene:");
        System.out.print(sequence);
        System.out.println("\n========================");
    }
}
