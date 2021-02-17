package vivi.exphoton;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import vivi.exphoton.init.BlockEntityInit;
import vivi.exphoton.util.crucible.CrucibleBlockRenderer;
import vivi.exphoton.util.sieve.SieveBlockEntityRenderer;

public class ExPhotonClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(BlockEntityInit.SIEVE_BLOCK_ENTITY, SieveBlockEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(BlockEntityInit.CRUCIBLE_BLOCK_ENTITY, CrucibleBlockRenderer::new);
    }
}
