package BuildingBlocks;

import java.util.*;

/**
 */
public class Protein {
    private ProteinCategory category;
    private List<Gene> genesToBuild;

    public ProteinCategory getCategory() {
        return category;
    }

    public void setCategory(ProteinCategory category) {
        this.category = category;
    }

    public List<Gene> getGenesToBuild() {
        return genesToBuild;
    }

    public void setGenesToBuild(List<Gene> genesToBuild) {
        this.genesToBuild = genesToBuild;
    }

    public Protein(List<Gene> genesToBuild) {
        this.genesToBuild = genesToBuild;
    }
}
