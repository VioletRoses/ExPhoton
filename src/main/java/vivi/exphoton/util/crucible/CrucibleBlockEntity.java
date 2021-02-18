package vivi.exphoton.util.crucible;

import alexiil.mc.lib.attributes.fluid.FluidExtractable;
import alexiil.mc.lib.attributes.fluid.amount.FluidAmount;
import alexiil.mc.lib.attributes.fluid.volume.FluidKeys;
import alexiil.mc.lib.attributes.fluid.volume.FluidVolume;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import vivi.exphoton.init.BlockEntityInit;

public class CrucibleBlockEntity extends BlockEntity implements Tickable, FluidExtractable, BlockEntityClientSerializable {
    public CrucibleBlockEntity() {
        super(BlockEntityInit.CRUCIBLE_BLOCK_ENTITY);
    }

    public int heat = 0;
    public int timer = 20;
    public int stoneVolume = 0;
    public int lavaVolume = 0;

    public FluidVolume volume = FluidKeys.LAVA.withAmount(FluidAmount.ZERO);

    public ActionResult interact(World world, BlockPos pos, PlayerEntity player, Hand hand) {
        ItemStack handStack = player.getStackInHand(hand);
        if(stoneVolume + (volume.getAmount_F().numerator / volume.getAmount_F().denominator) > 2000) {
        } else if(handStack.getItem() == Items.COBBLESTONE && stoneVolume <= 750) {
            stoneVolume += 250;
            handStack.setCount(handStack.getCount() - 1);
            markDirty();
        } else if(handStack.getItem() == Items.BUCKET && lavaVolume > 1000) {
            player.setStackInHand(hand, new ItemStack(Items.LAVA_BUCKET));
            lavaVolume -= 1000;
            markDirty();
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void tick() {
        if(timer > 0) {
            timer--;
        } else {
            timer = 20;
            Block blockUnder = world.getBlockState(pos.down()).getBlock();
            if (blockUnder == Blocks.TORCH) heat = 1;
            else if (blockUnder == Blocks.FIRE) heat = 2;
            else if (blockUnder == Blocks.LAVA) heat = 3;
            if(stoneVolume > 0 && heat > 0 && lavaVolume < 2000) {
                stoneVolume -= heat;
                lavaVolume += heat;
            }
        }
    }


    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        tag.putInt("stoneVolume", stoneVolume);
        tag.putInt("lavaVolume", lavaVolume);
        return tag;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        if (tag == null) {
            System.out.println("Crucible has no NBT data");
        } else {
            stoneVolume = tag.getInt("stoneVolume");
            lavaVolume = tag.getInt("lavaVolume");
        }
    }

    @Override
    public void fromClientTag(CompoundTag tag) {
        if (tag == null) {
            System.out.println("Crucible has no NBT data");
        } else {
            stoneVolume = tag.getInt("stoneVolume");
            lavaVolume = tag.getInt("lavaVolume");
        }

    }

    @Override
    public CompoundTag toClientTag(CompoundTag tag) {
        tag.putInt("stoneVolume", stoneVolume);
        tag.putInt("lavaVolume", lavaVolume);
        return tag;
    }


}
