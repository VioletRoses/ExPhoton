package vivi.exphoton;

import net.fabricmc.api.ModInitializer;
import vivi.exphoton.init.ToolInit;

public class ExPhoton implements ModInitializer {

    @Override
    public void onInitialize() {
        System.out.println("ExPhoton is starting...");
        ToolInit.init();
    }

}
