package vivi.exphoton.util;

import net.minecraft.block.Block;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class BlockCondition {
    public boolean test(Block block, ServerWorld world, BlockPos pos) {
        return false;
    }
}
