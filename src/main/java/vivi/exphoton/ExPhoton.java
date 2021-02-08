package vivi.exphoton;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.CauldronBlock;
import net.minecraft.block.ComposterBlock;
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
