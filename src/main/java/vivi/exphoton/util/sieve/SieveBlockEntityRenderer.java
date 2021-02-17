package vivi.exphoton.util.sieve;

import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;

public class SieveBlockEntityRenderer extends BlockEntityRenderer<SieveBlockEntity> {
    private static ItemStack stack = ItemStack.EMPTY;
    private static ItemStack meshStack = ItemStack.EMPTY;

    public SieveBlockEntityRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(SieveBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        int lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getPos().up());
        meshStack = entity.mesh;
        MatrixStack matricesMesh = matrices;
        matricesMesh.push();
        //matricesMesh.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(90f));
        //matricesMesh.translate(0.5, 0.5, -0.525);
        matricesMesh.translate(0.5, 0.5, 0.5);
        matricesMesh.scale(1.9f, 0.5f, 1.9f);
        //matricesMesh.scale(0.9f, 0.9f, 0.25f);
        MinecraftClient.getInstance().getItemRenderer().renderItem(meshStack, ModelTransformation.Mode.FIXED, lightAbove, OverlayTexture.DEFAULT_UV, matricesMesh, vertexConsumers);
        matricesMesh.pop();

        matrices.push();
        stack = entity.input;
        double offset = 0.69 - (0.025 * entity.stage);
        matrices.translate(0.5, offset, 0.5);
        matrices.scale(1.9f, 0.2f, 1.9f);
        MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.FIXED, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers);
        matrices.pop();
    }

}
