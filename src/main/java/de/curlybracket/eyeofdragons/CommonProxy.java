package de.curlybracket.eyeofdragons;

import de.curlybracket.eyeofdragons.EntityDragonEye;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber
public class CommonProxy {
    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        registerUnspawnable(EntityEntryBuilder.<EntityDragonEye>create(), event, EntityDragonEye.class, "dragon_eye", 47);
    }

    public static void registerUnspawnable(EntityEntryBuilder builder, RegistryEvent.Register<EntityEntry> event, Class<? extends Entity> entityClass, String name, int id) {
        id += 1500;
        builder.entity(entityClass);
        builder.id(new ResourceLocation(EyeOfDragonsMod.MODID, name), id);
        builder.name(name);
        builder.tracker(64, 1, true);
        event.getRegistry().register(builder.build());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        // Items
        try {
            for (Field f : ModItems.class.getDeclaredFields()) {
                Object obj = f.get(null);
                if (obj instanceof Item) {
                    event.getRegistry().register((Item) obj);
                } else if (obj instanceof Item[]) {
                    for (Item item : (Item[]) obj) {
                        event.getRegistry().register(item);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void render() {
    }
}
