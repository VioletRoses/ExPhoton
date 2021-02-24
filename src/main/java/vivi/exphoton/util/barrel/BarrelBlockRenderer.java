package vivi.exphoton.util.barrel;

import alexiil.mc.lib.attributes.fluid.amount.FluidAmount;
import alexiil.mc.lib.attributes.fluid.render.FluidRenderFace;
import alexiil.mc.lib.attributes.fluid.volume.FluidKeys;
import alexiil.mc.lib.attributes.fluid.volume.FluidVolume;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Direction;

import java.util.Collections;

public class BarrelBlockRenderer extends BlockEntityRenderer<BarrelBlockEntity> {
    private double xzScale = 12.0 / 16.0;
    private double xMin = 2.0 / 16.0;
    private double xMax = 14.0 / 16.0;
    private double zMin = 2.0 / 16.0;
    private double zMax = 14.0 / 16.0;
    private double yMin = 0.1875;
    private double yMax = 0.9375;


    FluidVolume fluid = FluidKeys.WATER.withAmount(FluidAmount.BUCKET);

    public BarrelBlockRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }
    double level = 0;

    @Override
    public void render(BarrelBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        level = entity.waterVolume / 1000.0;
        System.out.println(level);
        double yRender = (yMax - yMin) * 1 + yMin;
        fluid.render(Collections.singletonList(FluidRenderFace.createFlatFace(xMin, yMin, zMin, xMax, yRender, zMax, 16.0, Direction.UP)), vertexConsumers, matrices);
        matrices.pop();
    }
}
