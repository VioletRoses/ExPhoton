package vivi.exphoton.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import vivi.exphoton.util.crucible.CrucibleBlock;
import vivi.exphoton.util.sieve.SieveBlock;

import static net.minecraft.util.registry.Registry.*;

public class BlockInit {
    public static Block SIEVE = new SieveBlock(FabricBlockSettings.of(Material.WOOD).nonOpaque());
    public static Block CRUCIBLE = new CrucibleBlock(FabricBlockSettings.of(Material.STONE).nonOpaque());
    public static Block UNFIRED_CRUCIBLE = new Block(FabricBlockSettings.of(Material.SOIL).nonOpaque());

    public static void init() {
        register(BLOCK, new Identifier("photon", "sieve"), SIEVE);
        register(ITEM, new Identifier("photon", "sieve"), new BlockItem(SIEVE, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

        register(BLOCK, new Identifier("photon", "crucible"), CRUCIBLE);
        register(ITEM, new Identifier("photon", "crucible"), new BlockItem(CRUCIBLE, new FabricItemSettings().group(ItemGroup.DECORATIONS)));

        register(BLOCK, new Identifier("photon", "unfired_crucible"), UNFIRED_CRUCIBLE);
        register(ITEM, new Identifier("photon", "unfired_crucible"), new BlockItem(UNFIRED_CRUCIBLE, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
    }
}
