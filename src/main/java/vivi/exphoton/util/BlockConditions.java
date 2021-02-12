package vivi.exphoton.util;

import net.minecraft.block.Block;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class BlockConditions {

    public static BlockCondition isInCobbleGen = new BlockCondition() {
        @Override
        public boolean test(Block block, ServerWorld world, BlockPos pos) {
            boolean waterContact = false;
            boolean lavaContact = false;
            if(world.getFluidState(pos.north()).getFluid() == Fluids.FLOWING_WATER
                    || world.getFluidState(pos.east()).getFluid() == Fluids.FLOWING_WATER
                    || world.getFluidState(pos.south()).getFluid() == Fluids.FLOWING_WATER
                    || world.getFluidState(pos.west()).getFluid() == Fluids.FLOWING_WATER) waterContact = true;
            if(world.getFluidState(pos.north()).getFluid() == Fluids.FLOWING_LAVA
                    || world.getFluidState(pos.east()).getFluid() == Fluids.FLOWING_LAVA
                    || world.getFluidState(pos.south()).getFluid() == Fluids.FLOWING_LAVA
                    || world.getFluidState(pos.west()).getFluid() == Fluids.FLOWING_LAVA) lavaContact = true;
            if(world.getFluidState(pos.north()).getFluid() == Fluids.LAVA
                    || world.getFluidState(pos.east()).getFluid() == Fluids.LAVA
                    || world.getFluidState(pos.south()).getFluid() == Fluids.LAVA
                    || world.getFluidState(pos.west()).getFluid() == Fluids.LAVA) lavaContact = true;
            return waterContact && lavaContact;
        }
    };
}
