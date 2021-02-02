package vivi.exphoton.init;

import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import vivi.exphoton.tools.CrookTool;
import vivi.exphoton.tools.HammerTool;

public class ToolInit {
    public static ToolItem WOODEN_HAMMER = new HammerTool(ToolMaterials.WOOD, 6f, -3.4f, new Item.Settings().group(ItemGroup.TOOLS));
    public static ToolItem STONE_HAMMER = new HammerTool(ToolMaterials.STONE, 6f, -3.4f, new Item.Settings().group(ItemGroup.TOOLS));
    public static ToolItem IRON_HAMMER = new HammerTool(ToolMaterials.IRON, 6f, -3.3f, new Item.Settings().group(ItemGroup.TOOLS));
    public static ToolItem GOLD_HAMMER = new HammerTool(ToolMaterials.GOLD, 6f, -3.2f, new Item.Settings().group(ItemGroup.TOOLS));
    public static ToolItem DIAMOND_HAMMER = new HammerTool(ToolMaterials.DIAMOND, 6f, -3.2f, new Item.Settings().group(ItemGroup.TOOLS));
    public static ToolItem NETHERITE_HAMMER = new HammerTool(ToolMaterials.NETHERITE, 6f, -3.2f, new Item.Settings().group(ItemGroup.TOOLS));

    public static ToolItem CROOK = new CrookTool(ToolMaterials.STONE, new Item.Settings().group(ItemGroup.TOOLS));

    public static void init() {
        Registry.register(Registry.ITEM, new Identifier("photon", "wooden_hammer"), WOODEN_HAMMER);
        Registry.register(Registry.ITEM, new Identifier("photon", "stone_hammer"), STONE_HAMMER);
        Registry.register(Registry.ITEM, new Identifier("photon", "iron_hammer"), IRON_HAMMER);
        Registry.register(Registry.ITEM, new Identifier("photon", "gold_hammer"), GOLD_HAMMER);
        Registry.register(Registry.ITEM, new Identifier("photon", "diamond_hammer"), DIAMOND_HAMMER);
        Registry.register(Registry.ITEM, new Identifier("photon", "netherite_hammer"), NETHERITE_HAMMER);

        Registry.register(Registry.ITEM, new Identifier("photon", "crook"), CROOK);

    }
}
