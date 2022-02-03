package main.fractal;

import java.util.ArrayList;

public class Seed {
    private ArrayList<Seedling> seedlings;

    public Seed() {
        this.seedlings = new ArrayList<>();
    }

    public void addSeedling(Seedling seedling) {
        this.seedlings.add(seedling);
    }

    public ArrayList<Seedling> getSeedlings() {
        return seedlings;
    }
}
