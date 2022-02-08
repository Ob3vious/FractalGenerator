package main.userinterface;

import javafx.scene.Node;
import javafx.scene.control.ListView;
import main.fractal.Seed;

import java.util.ArrayList;

public class SeedlingList implements UIContent, UpdateCallback {
    private ListView list;
    private ArrayList<SeedlingEntry> seedlings = new ArrayList<>();
    private Seed seed;

    public SeedlingList() {
        seed = new Seed();
        list = new ListView();
        addSeedling();
    }

    public void addSeedling() {
        SeedlingEntry entry = new SeedlingEntry(seed, this);
        seedlings.add(entry);
        list.getItems().add(entry.getContent());
    }

    public void updateSeed() {
        seed.empty();
        for (SeedlingEntry entry : seedlings) {
            seed.addSeedling(entry.getSeedling());
        }
    }

    public void removeSeedling(SeedlingEntry entry) {
        seedlings.remove(entry);
        list.getItems().remove(entry.getContent());
        if (seedlings.size() == 0) {
            addSeedling();
        }
        onUpdate();
    }

    public Seed getSeed() {
        return seed;
    }

    @Override
    public Node getContent() {
        return list;
    }

    @Override
    public void onUpdate() {
        updateSeed();
    }
}
