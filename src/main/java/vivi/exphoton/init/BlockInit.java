package vivi.exphoton.init;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import vivi.exphoton.util.sieves.SieveBlock;

public class BlockInit {
    public static Block SIEVE = new SieveBlock(FabricBlockSettings.of(Material.WOOD));
}
