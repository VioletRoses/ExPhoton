package vivi.exphoton.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LavaFluid.class)
public class LavaFluidMixin {

@Inject(method = "flow", at = @At("RETURN"))
    public void flow(WorldAccess world, BlockPos pos, BlockState state, Direction direction, FluidState fluidState, CallbackInfo ci) {
    System.out.println("it happened");
}
}
