package vivi.exphoton.util.barrel;

import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Tickable;
import vivi.exphoton.init.BlockEntityInit;

public class BarrelBlockEntity extends BlockEntity implements Tickable, BlockEntityClientSerializable {
    public BarrelBlockEntity() {
        super(BlockEntityInit.BARREL_BLOCK_ENTITY);
    }

    int waterVolume = 0;
    int timer = 20;

    public ActionResult interact(PlayerEntity player, Hand hand) {
        ItemStack handStack = player.getStackInHand(hand);
        if(handStack.getItem() == Items.BUCKET && waterVolume >= 1000) {
            player.setStackInHand(hand, new ItemStack(Items.LAVA_BUCKET));
            waterVolume -= 1000;
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void tick() {
        if(timer > 0) {
            timer--;
        } else {
            timer = 20;
            if (world.isSkyVisible(pos.up()) && world.isRaining() && waterVolume < 1000) {
                waterVolume += 5;
            }
        }
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        waterVolume = tag.getInt("waterVolume");
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        tag.putInt("waterVolume", waterVolume);
        return tag;
    }

    @Override
    public void fromClientTag(CompoundTag tag) {
        waterVolume = tag.getInt("waterVolume");
    }

    @Override
    public CompoundTag toClientTag(CompoundTag tag) {
        tag.putInt("waterVolume", waterVolume);
        return tag;
    }
}
