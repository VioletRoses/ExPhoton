package vivi.exphoton.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseRegistry {
    public BaseRegistry(ArrayList<Item[]> entries, double probability) {
        this.entries = entries;
        this.probability = probability;
    }
    public double probability = 1;
    public ArrayList<Item[]> entries;
    public boolean isRegistered(Item item) {
        for(int i = 0; i < entries.size(); i++) {
            if (entries.get(i)[0] == item) {
                return true;
            }
        }
        return false;
    }
    public List<ItemStack> getOutput(Item input) {
        ArrayList<ItemStack> returnValue = new ArrayList<>();
        for(int i = 0; i < entries.size(); i++) {
            if (entries.get(i)[0] == input) {
                for(int j = 1; j < entries.get(i).length; j++) {
                    if(new Random().nextInt(100) < probability * 100) {
                        returnValue.add(new ItemStack(entries.get(i)[j], 1));
                    }
                }
            }
        }
        return returnValue;
    }

    public List<ItemStack> getOutput(Item input, BlockPos pos, ServerWorld world) {
        return null;
    }
}
