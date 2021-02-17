package vivi.exphoton.util.sieve;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SieveBlock extends Block implements BlockEntityProvider {
    public SieveBlock(Settings settings) {
        super(settings);
    }

    VoxelShape outline = VoxelShapes.union(
            createCuboidShape(0.0, 0.0, 0.0, 2.0, 12.0, 2.0),
            createCuboidShape(14.0, 0.0, 0.0, 16.0, 12.0, 2.0),
            createCuboidShape(0.0, 0.0, 14.0, 2.0, 12.0, 16.0),
            createCuboidShape(14.0, 0.0, 14.0, 16.0, 12.0, 16.0),
            createCuboidShape(0.0, 8.0, 0.0, 16.0, 12.0, 16.0));

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return outline;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockEntity entity = world.getBlockEntity(pos);
        if (entity instanceof SieveBlockEntity) return ((SieveBlockEntity) entity).interact(world, pos, player, hand);
        else return super.onUse(state, world, pos, player, hand, hit);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new SieveBlockEntity();
    }


}
