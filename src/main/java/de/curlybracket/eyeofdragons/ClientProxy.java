package de.curlybracket.eyeofdragons;

import de.curlybracket.eyeofdragons.EntityDragonEye;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Mod.EventBusSubscriber
public class ClientProxy extends CommonProxy {
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ModItems.dragon_eye, 0, new ModelResourceLocation("eyeofdragons:dragon_eye", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.dragon_eye, 1, new ModelResourceLocation("eyeofdragons:dragon_eye", "inventory"));
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
        RenderingRegistry.registerEntityRenderingHandler(EntityDragonEye.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ModItems.dragon_eye, Minecraft.getMinecraft().getRenderItem()));
    }
}
