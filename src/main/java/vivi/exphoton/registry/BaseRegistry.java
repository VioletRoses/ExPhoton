package vivi.exphoton.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseRegistry {
    public BaseRegistry(ArrayList<RegEntry> entries) {
        this.entries = entries;
    }
    public ArrayList<RegEntry> entries;
    public boolean isRegistered(Item item) {
        return entries.stream().anyMatch(entry -> entry.input == item);
    }
    public List<ItemStack> getOutput(Block block, ServerWorld world, BlockPos pos) {
        ArrayList<ItemStack> returnValue = new ArrayList<>();
        for (RegEntry entry : entries)
            if (entry.input == block.asItem())
                if (entry.condition == null || entry.condition.test(block, world, pos))
                    if (new Random().nextInt(100) < entry.probability * 100)
                        returnValue.add(new ItemStack(entry.output, 1));

        return returnValue;
    }
}
