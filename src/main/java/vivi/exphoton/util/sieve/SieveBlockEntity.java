package vivi.exphoton.util.sieve;

import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import vivi.exphoton.init.BlockEntityInit;
import vivi.exphoton.init.ItemInit;
import vivi.exphoton.registry.ExPhotonRegistry;

import java.util.List;


public class SieveBlockEntity extends BlockEntity implements BlockEntityClientSerializable, Tickable {
    public int stage = 0;
    public ItemStack input = ItemStack.EMPTY;
    public ItemStack mesh = ItemStack.EMPTY;

    public SieveBlockEntity() {
        super(BlockEntityInit.SIEVE_BLOCK_ENTITY);
    }

    public ActionResult interact(World world, BlockPos pos, PlayerEntity player, Hand hand) {
        ItemStack handStack = player.getStackInHand(hand);
        if(mesh.isEmpty() && handStack.getItem() == ItemInit.MESH) {
            mesh = handStack;
            markDirty();
        } else if(input.isEmpty() && ExPhotonRegistry.SIEVE.isRegistered(handStack.getItem()) && !mesh.isEmpty()) {
            input = handStack;
            handStack.setCount(handStack.getCount() - 1);
            markDirty();
        } else if(stage >= 7) {
            if(!world.isClient) {
                List<ItemStack> output = ExPhotonRegistry.SIEVE.getOutput(input.getItem(), world, pos);
                for (ItemStack itemStack : output) {
                    ItemEntity itemEntity = new ItemEntity(world, (double) pos.getX() + 0.4d, (double) pos.getY() + 0.75d, (double) pos.getZ() + 0.4d, itemStack);
                    itemEntity.setToDefaultPickupDelay();
                    world.spawnEntity(itemEntity);
                }
            }
            input = ItemStack.EMPTY;
            stage = 0;
            markDirty();
        } else {
            stage++;
            markDirty();
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        tag.putInt("stage", stage);
        tag.put("input", input.toTag(new CompoundTag()));
        tag.put("mesh", mesh.toTag(new CompoundTag()));
        return tag;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        if (tag == null) {
            System.out.println("Sieve has no NBT data");
        } else {
            input = ItemStack.fromTag(tag.getCompound("input"));
            mesh = ItemStack.fromTag(tag.getCompound("mesh"));
            stage = tag.getInt("stage");
        }
    }

    @Override
    public void fromClientTag(CompoundTag tag) {
        if (tag == null) {
            System.out.println("Sieve has no NBT data");
        } else {
            input = ItemStack.fromTag(tag.getCompound("input"));
            mesh = ItemStack.fromTag(tag.getCompound("mesh"));
            stage = tag.getInt("stage");
        }
    }

    @Override
    public CompoundTag toClientTag(CompoundTag tag) {
        tag.putInt("stage", stage);
        tag.put("input", input.toTag(new CompoundTag()));
        tag.put("mesh", mesh.toTag(new CompoundTag()));
        return tag;
    }

    @Override
    public void tick() {

    }
}
