package vivi.exphoton.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import vivi.exphoton.util.sieves.SieveBlock;

import static net.minecraft.util.registry.Registry.*;

public class BlockInit {
    public static Block SIEVE = new SieveBlock(FabricBlockSettings.of(Material.WOOD));

    public static void init() {
        register(BLOCK, new Identifier("photon", "sieve"), SIEVE);
        register(ITEM, new Identifier("photon", "sieve"), new BlockItem(SIEVE, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
    }
}
