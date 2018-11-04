package TestUtility;

import BuildingBlocks.*;
import Utility.*;

/**
 */
public class TestGene {
    public static void main(String args[]) {
        DNA dna = new DNA(Utilities.getDNASequence(100));
        dna.printSequence();
        Gene x = new Gene(dna);
        x.printGene();
    }
}
