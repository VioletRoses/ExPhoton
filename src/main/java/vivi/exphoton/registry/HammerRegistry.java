package vivi.exphoton.registry;

import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import vivi.exphoton.init.ItemInit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HammerRegistry extends BaseRegistry {

    public HammerRegistry(ArrayList<Item[]> entries, double probability) {
        super(entries, probability);
    }

    public Random rand = new Random();

    @Override
    public List<ItemStack> getOutput(Item input, BlockPos pos, ServerWorld world) {
        if(input == Items.COBBLESTONE) {
            boolean lavaContact = false, waterContact = false;
            ArrayList<ItemStack> returnValue = new ArrayList<>();
            if (world.getFluidState(pos.north()).getFluid() == Fluids.FLOWING_WATER) waterContact = true;
            if (world.getFluidState(pos.east()).getFluid() == Fluids.FLOWING_WATER) waterContact = true;
            if (world.getFluidState(pos.west()).getFluid() == Fluids.FLOWING_WATER) waterContact = true;
            if (world.getFluidState(pos.south()).getFluid() == Fluids.FLOWING_WATER) waterContact = true;
            if (world.getFluidState(pos.north()).getFluid() == Fluids.FLOWING_LAVA || (world.getFluidState(pos.north()).getFluid() == Fluids.LAVA))
                lavaContact = true;
            if (world.getFluidState(pos.east()).getFluid() == Fluids.FLOWING_LAVA || (world.getFluidState(pos.east()).getFluid() == Fluids.LAVA))
                lavaContact = true;
            if (world.getFluidState(pos.west()).getFluid() == Fluids.FLOWING_LAVA || (world.getFluidState(pos.west()).getFluid() == Fluids.LAVA))
                lavaContact = true;
            if (world.getFluidState(pos.south()).getFluid() == Fluids.FLOWING_LAVA || (world.getFluidState(pos.south()).getFluid() == Fluids.LAVA))
                lavaContact = true;
            if (lavaContact && waterContact) {
                if (rand.nextInt(100) < 50) returnValue.add(new ItemStack(Items.GRAVEL));
                if (rand.nextInt(100) < 25) returnValue.add(new ItemStack(ItemInit.IRON_CHUNK));
                if (rand.nextInt(100) < 25) returnValue.add(new ItemStack(ItemInit.IRON_CHUNK));
                if (rand.nextInt(100) < 10) returnValue.add(new ItemStack(ItemInit.GOLD_CHUNK));
                if (rand.nextInt(100) < 10) returnValue.add(new ItemStack(ItemInit.GOLD_CHUNK));
                if (rand.nextInt(100) < 1) returnValue.add(new ItemStack(Items.ANCIENT_DEBRIS));
                if (rand.nextInt(100) < 2) returnValue.add(new ItemStack(Items.DIAMOND));
                if (rand.nextInt(100) < 3) returnValue.add(new ItemStack(Items.EMERALD));
                return returnValue;
            }
        }
        return super.getOutput(input);
    }
}
