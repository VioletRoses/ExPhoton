package vivi.exphoton.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vivi.exphoton.registry.ExPhotonRegistry;
import vivi.exphoton.tools.CrookTool;
import vivi.exphoton.tools.HammerTool;

import java.util.List;

@Mixin(Block.class)
public class BlockHarvestMixin {

    @Inject(method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;", at = @At("RETURN"), cancellable = true)
    private static void getDroppedStacks(BlockState state, ServerWorld world, BlockPos pos, BlockEntity blockEntity, Entity entity, ItemStack stack, CallbackInfoReturnable<List<ItemStack>> cir) {
        if(ExPhotonRegistry.HAMMER.isRegistered(state.getBlock().asItem()) && HammerTool.isHammer(stack.getItem().getTranslationKey())) {
            cir.setReturnValue(ExPhotonRegistry.HAMMER.getOutput(state.getBlock(), world, pos));
        } else if(ExPhotonRegistry.CROOK.isRegistered(state.getBlock().asItem()) && CrookTool.isCrook(stack.getItem().getTranslationKey())) {
            cir.setReturnValue(ExPhotonRegistry.CROOK.getOutput(state.getBlock(), world, pos));
        }
    }

}
