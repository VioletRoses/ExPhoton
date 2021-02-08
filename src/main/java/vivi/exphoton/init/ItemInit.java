package vivi.exphoton.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

import static net.minecraft.util.registry.Registry.*;

public class ItemInit {
    public static Item IRON_CHUNK = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static Item GOLD_CHUNK = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

    public static void init() {
        register(ITEM, new Identifier("photon", "iron_chunk"), IRON_CHUNK);
        register(ITEM, new Identifier("photon", "gold_chunk"), GOLD_CHUNK);
    }
}
