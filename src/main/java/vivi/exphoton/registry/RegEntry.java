package vivi.exphoton.registry;

import net.minecraft.item.Item;
import vivi.exphoton.util.BlockCondition;

public class RegEntry {
    public Item input, output;
    public double probability;
    public BlockCondition condition = null;

    public RegEntry(Item input, Item output, double probability) {
        this.input = input;
        this.output = output;
        this.probability = probability;
    }

    public RegEntry addCondition(BlockCondition condition) {
        this.condition = condition;
        return this;
    }
}
