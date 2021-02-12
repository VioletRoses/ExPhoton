package vivi.exphoton;

import net.fabricmc.api.ModInitializer;
import net.minecraft.advancement.criterion.UsedTotemCriterion;
import net.minecraft.block.CauldronBlock;
import net.minecraft.block.ComposterBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.PickaxeItem;
import vivi.exphoton.init.ItemInit;
import vivi.exphoton.init.ToolInit;

public class ExPhoton implements ModInitializer {

    @Override
    public void onInitialize() {
        System.out.println("ExPhoton is starting...");
        ToolInit.init();
        ItemInit.init();
    }

}
