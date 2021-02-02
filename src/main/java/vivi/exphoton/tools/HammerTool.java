package vivi.exphoton.tools;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.*;
import vivi.exphoton.registry.ExPhotonRegistry;

import java.util.Set;

public class HammerTool extends MiningToolItem {


    public HammerTool(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(attackDamage, attackSpeed, material, null, settings);
    }

    public static boolean isHammer(String tk) {
        switch(tk) {
            case "item.photon.wooden_hammer":
            case "item.photon.stone_hammer":
            case "item.photon.iron_hammer":
            case "item.photon.gold_hammer":
            case "item.photon.diamond_hammer":
            case "item.photon.netherite_hammer":
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean isEffectiveOn(BlockState state) {
        return ExPhotonRegistry.HAMMER.isRegistered(state.getBlock().asItem());
    }
}
