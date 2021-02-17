package vivi.exphoton.init;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;
import vivi.exphoton.util.crucible.CrucibleBlockEntity;
import vivi.exphoton.util.sieve.SieveBlockEntity;

import static net.minecraft.util.registry.Registry.*;

public class BlockEntityInit {
    public static BlockEntityType<SieveBlockEntity> SIEVE_BLOCK_ENTITY;
    public static BlockEntityType<CrucibleBlockEntity> CRUCIBLE_BLOCK_ENTITY;

    public static void init() {
        SIEVE_BLOCK_ENTITY = register(BLOCK_ENTITY_TYPE, "photon:sieve", BlockEntityType.Builder.create(SieveBlockEntity::new, BlockInit.SIEVE).build(null));
        CRUCIBLE_BLOCK_ENTITY = register(BLOCK_ENTITY_TYPE, "photon:crucible", BlockEntityType.Builder.create(CrucibleBlockEntity::new, BlockInit.CRUCIBLE).build(null));
    }
}
