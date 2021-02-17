package vivi.exphoton;

import net.fabricmc.api.ModInitializer;
import vivi.exphoton.init.BlockEntityInit;
import vivi.exphoton.init.BlockInit;
import vivi.exphoton.init.ItemInit;
import vivi.exphoton.init.ToolInit;

public class ExPhoton implements ModInitializer {

    @Override
    public void onInitialize() {
        System.out.println("ExPhoton is starting...");
        ToolInit.init();
        ItemInit.init();
        BlockInit.init();
        BlockEntityInit.init();
    }

}
