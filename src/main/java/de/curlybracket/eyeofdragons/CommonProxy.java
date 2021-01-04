package de.curlybracket.eyeofdragons;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber
public class CommonProxy {
    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        registerUnspawnable(EntityEntryBuilder.<EntityFireDragonEye>create(), event, EntityFireDragonEye.class, "eye_of_firedragon", 47);
        registerUnspawnable(EntityEntryBuilder.<EntityIceDragonEye>create(), event, EntityIceDragonEye.class, "eye_of_icedragon", 48);
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
