package vivi.exphoton.util.crucible;

import alexiil.mc.lib.attributes.fluid.amount.FluidAmount;
import alexiil.mc.lib.attributes.fluid.render.FluidRenderFace;
import alexiil.mc.lib.attributes.fluid.volume.FluidKeys;
import alexiil.mc.lib.attributes.fluid.volume.FluidVolume;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Direction;

import java.util.Collections;

public class CrucibleBlockRenderer extends BlockEntityRenderer<CrucibleBlockEntity> {
    public CrucibleBlockRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    private double xzScale = 12.0/16.0;
    private double xMin = 2.0 / 16.0;
    private double xMax = 14.0 / 16.0;
    private double zMin = 2.0 / 16.0;
    private double zMax = 14.0 / 16.0;
    private double yMin = 5.0/16.0;
    private double yMax = 15.0/16.0;

    FluidVolume fluid = FluidKeys.LAVA.withAmount(FluidAmount.BUCKET);
    double level = 0;


    @Override
    public void render(CrucibleBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if(entity.stoneVolume > 0) {
            MatrixStack cobbleMatrices = matrices;
            cobbleMatrices.push();
            double cobbleLevel = entity.stoneVolume / 1000.0;
            if (cobbleLevel > 1) cobbleLevel = 1;
            double yRenderCobble = (yMax - yMin) * cobbleLevel + yMin;
            cobbleMatrices.scale(1.9f, 0.3f, 1.9f);
            cobbleMatrices.translate(0.275, 0.65 + (cobbleLevel * 2), 0.275);
            int lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getPos().up());
            MinecraftClient.getInstance().getItemRenderer().renderItem(new ItemStack(Items.COBBLESTONE), ModelTransformation.Mode.FIXED, lightAbove, OverlayTexture.DEFAULT_UV, cobbleMatrices, vertexConsumers);
            cobbleMatrices.pop();
        }

        if(entity.lavaVolume > 0) {
            matrices.push();
            level = entity.lavaVolume / 1000.0;
            if (level > 1) level = 1;
            double yRender = (yMax - yMin) * level + yMin;
            fluid.render(Collections.singletonList(FluidRenderFace.createFlatFace(xMin, yMin, zMin, xMax, yRender, zMax, 2.0, Direction.UP)), vertexConsumers, matrices);
            matrices.pop();
        }
    }
}
