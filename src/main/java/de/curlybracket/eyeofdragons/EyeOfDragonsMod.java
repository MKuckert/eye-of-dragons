package de.curlybracket.eyeofdragons;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.SidedProxy;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.common.MinecraftForge;

import java.util.Random;

@Mod(modid = EyeOfDragonsMod.MODID,
        dependencies = "required-after:llibrary@[1.7.9,)",
        name = EyeOfDragonsMod.NAME, version = EyeOfDragonsMod.VERSION)
public class EyeOfDragonsMod
{
    public static final String MODID = "eyeofdragons";
    public static final String NAME = "Eye of Dragons";
    public static final String VERSION = "0.0.1";

    private static Logger logger;
    @SidedProxy(clientSide = "de.curlybracket.eyeofdragons.ClientProxy", serverSide = "de.curlybracket.eyeofdragons.CommonProxy")
    public static CommonProxy PROXY;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        MinecraftForge.EVENT_BUS.register(PROXY);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        PROXY.render();
    }
}
