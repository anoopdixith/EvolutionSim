package BuildingBlocks;

import java.util.*;

/**
 */
public class DNA {
    private static final int ASCII_LIMIT = 128;
    private String sequence;
    private int geneFractionFactor;
    private List<Gene> genes;

    public DNA(String sequence, int geneFractionFactor) {
        this.sequence = sequence;
        this.geneFractionFactor = geneFractionFactor;
        genes = new ArrayList<>();
    }

    public DNA(String sequence) {
        this(sequence, 10);
    }

    public String getSequence() {
        return sequence;
    }

    public int getGeneFractionFactor() {
        return geneFractionFactor;
    }

    public void setGeneFractionFactor(int geneFractionFactor) {
        this.geneFractionFactor = geneFractionFactor;
    }
    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public void mutate() {
        Random seed = new Random();
        int index = seed.nextInt(sequence.length());
        int geneChar = seed.nextInt(ASCII_LIMIT);
        char[] sequenceChars = sequence.toCharArray();
        sequenceChars[index] = (char) geneChar;
        sequence = new String(sequenceChars);
    }

    public void printSequence(int from, int to) {
        char[] sequenceChars = sequence.toCharArray();
        if(from < 0 || to > sequenceChars.length - 1) {
            System.out.println("Invalid Length");
            return;
        }
        System.out.print("DNA:");
        for(int i=from; i <= to; i++) {
            System.out.print(sequenceChars[i]);
        }
        System.out.println("\n===================");
    }

    public void printSequence() {
        printSequence(0, sequence.length() - 1);
    }

    public String getGene(int begin, int end) {
        if(end - begin > geneFractionFactor) {
            end = begin + geneFractionFactor;
        }
        String seq = new String(new StringBuilder(sequence).substring(begin, end));
        genes.add(new Gene(seq));
        return seq;
    }

    public String getGene() {
        int geneLength = new Random().nextInt(geneFractionFactor);
        int begin = new Random().nextInt(sequence.length() - geneLength - 1);
        int end = begin + geneLength;
        return getGene(begin, end);
    }
}
