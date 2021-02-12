package vivi.exphoton.registry;

import net.minecraft.item.Item;
import vivi.exphoton.init.BlockInit;
import vivi.exphoton.init.ItemInit;
import vivi.exphoton.util.BlockConditions;

import java.util.ArrayList;
import java.util.Arrays;

import static net.minecraft.item.Items.*;

public class ExPhotonRegistry {
    public static BaseRegistry HAMMER = new BaseRegistry(new ArrayList<>(Arrays.asList(
            new RegEntry(STONE, GRAVEL, 1),
            new RegEntry(COBBLESTONE, GRAVEL, 1),
            new RegEntry(GRAVEL, SAND, 1),

            new RegEntry(COBBLESTONE, ItemInit.IRON_CHUNK, 0.2).addCondition(BlockConditions.isInCobbleGen),
            new RegEntry(COBBLESTONE, ItemInit.IRON_CHUNK, 0.2).addCondition(BlockConditions.isInCobbleGen),
            new RegEntry(COBBLESTONE, ItemInit.GOLD_CHUNK, 0.1).addCondition(BlockConditions.isInCobbleGen),
            new RegEntry(COBBLESTONE, EMERALD, 0.02).addCondition(BlockConditions.isInCobbleGen),
            new RegEntry(COBBLESTONE, DIAMOND, 0.01).addCondition(BlockConditions.isInCobbleGen),
            new RegEntry(COBBLESTONE, ANCIENT_DEBRIS, 0.005).addCondition(BlockConditions.isInCobbleGen)
    )));

    public static BaseRegistry CROOK = new BaseRegistry(new ArrayList<>(Arrays.asList(
            new RegEntry(OAK_LEAVES, APPLE, 0.2),
            new RegEntry(JUNGLE_LEAVES, COCOA_BEANS, 0.1),
            new RegEntry(OAK_LEAVES, OAK_SAPLING, 0.2),
            new RegEntry(ACACIA_LEAVES, ACACIA_SAPLING, 0.2),
            new RegEntry(BIRCH_LEAVES, BIRCH_SAPLING, 0.2),
            new RegEntry(DARK_OAK_LEAVES, DARK_OAK_SAPLING, 0.2),
            new RegEntry(SPRUCE_LEAVES, SPRUCE_SAPLING, 0.2),
            new RegEntry(JUNGLE_LEAVES, JUNGLE_SAPLING, 0.2)
    )));

    public static BaseRegistry SIEVE = new BaseRegistry(new ArrayList<>(Arrays.asList(
            new RegEntry(DIRT, WHEAT_SEEDS, 0.2),
            new RegEntry(DIRT, MELON_SEEDS, 0.1)
    )));
}
