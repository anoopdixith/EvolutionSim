package TestUtility;

import BuildingBlocks.*;
import Utility.*;

/**
 */
public class TestDNA {
    public static void main(String args[]) {
        DNA dna = new DNA(Utilities.getDNASequence(100));
        dna.printSequence();
        dna.mutate();
        dna.printSequence();
    }
}
