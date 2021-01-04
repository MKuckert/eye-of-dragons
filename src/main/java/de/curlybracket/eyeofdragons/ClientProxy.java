package de.curlybracket.eyeofdragons;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class ClientProxy extends CommonProxy {
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ModItems.eye_of_firedragon, 0, new ModelResourceLocation(EyeOfDragonsMod.MODID + ":eye_of_firedragon", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.eye_of_firedragon, 1, new ModelResourceLocation(EyeOfDragonsMod.MODID + ":eye_of_firedragon", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.eye_of_icedragon, 0, new ModelResourceLocation(EyeOfDragonsMod.MODID + ":eye_of_icedragon", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.eye_of_icedragon, 1, new ModelResourceLocation(EyeOfDragonsMod.MODID + ":eye_of_icedragon", "inventory"));
    }

    @SideOnly(Side.CLIENT)
    @Override
    @SuppressWarnings("deprecation")
    public void render() {
        renderEntities();
    }

    @SuppressWarnings("deprecation")
    @SideOnly(Side.CLIENT)
    private void renderEntities() {
        RenderingRegistry.registerEntityRenderingHandler(EntityFireDragonEye.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ModItems.eye_of_firedragon, Minecraft.getMinecraft().getRenderItem()));
        RenderingRegistry.registerEntityRenderingHandler(EntityIceDragonEye.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ModItems.eye_of_icedragon, Minecraft.getMinecraft().getRenderItem()));
    }
}
