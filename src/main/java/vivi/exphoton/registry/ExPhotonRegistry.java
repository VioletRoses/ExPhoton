package vivi.exphoton.registry;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.ArrayList;
import java.util.Arrays;

public class ExPhotonRegistry {
    public static HammerRegistry HAMMER = new HammerRegistry(new ArrayList<>(Arrays.asList(
            new Item[]{Items.COBBLESTONE, Items.GRAVEL},
            new Item[]{Items.GRAVEL, Items.SAND},
            new Item[]{Items.STONE, Items.GRAVEL})), 1);

    public static BaseRegistry CROOK = new BaseRegistry(new ArrayList<>(Arrays.asList(
            new Item[]{Items.OAK_LEAVES, Items.OAK_SAPLING, Items.APPLE},
            new Item[]{Items.BIRCH_LEAVES, Items.BIRCH_SAPLING},
            new Item[]{Items.ACACIA_LEAVES, Items.ACACIA_SAPLING},
            new Item[]{Items.JUNGLE_LEAVES, Items.JUNGLE_SAPLING, Items.COCOA_BEANS},
            new Item[]{Items.SPRUCE_LEAVES, Items.SPRUCE_SAPLING},
            new Item[]{Items.DARK_OAK_LEAVES, Items.DARK_OAK_SAPLING}

    )), 0.2);
}
