package de.curlybracket.eyeofdragons;

import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EyeOfDragonsMod.MODID)
public class EyeOfDragonsMod {
    public static final String MODID = "eyeofdragons";
    public static final ItemGroup ITEM_GROUP = new GroupEyeOfDragons();

    public EyeOfDragonsMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemInit.ITEMS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
