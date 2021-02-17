package vivi.exphoton.util.sieve;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import vivi.exphoton.init.BlockEntityInit;
import vivi.exphoton.registry.ExPhotonRegistry;

import java.util.List;


public class SieveBlockEntity extends BlockEntity {
    public int stage = 0;
    public ItemStack input = ItemStack.EMPTY;


    public SieveBlockEntity() {
        super(BlockEntityInit.SIEVE_BLOCK_ENTITY);
    }

    public ActionResult interact(World world, BlockPos pos, PlayerEntity player, Hand hand) {
        ItemStack handStack = player.getStackInHand(hand);
        if(input.isEmpty() && ExPhotonRegistry.SIEVE.isRegistered(handStack.getItem())) {
            input = handStack;
            handStack.setCount(handStack.getCount() - 1);
        } else if(stage >= 7) {
            if(!world.isClient) {
                List<ItemStack> output = ExPhotonRegistry.SIEVE.getOutput(input.getItem(), world, pos);
                output.forEach(player::giveItemStack);
            }
            input = ItemStack.EMPTY;
            stage = 0;
        } else {
            stage++;
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        tag.putInt("stage", stage);
        tag.put("input", input.toTag(new CompoundTag()));
        return tag;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        if (tag == null) {
            System.out.println("Sieve has no NBT data");
        } else {
            input = ItemStack.fromTag(tag.getCompound("input"));
            stage = tag.getInt("stage");
        }
    }
}
