package de.curlybracket.eyeofdragons;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EyeOfDragonsMod.MODID);

    public static final RegistryObject<Item> EYE_OF_FIREDRAGON = ITEMS.register("eye_of_firedragon", () ->
            new ItemFireDragonEye(
                    new Item.Properties()
                            .maxStackSize(16)
                            .group(EyeOfDragonsMod.ITEM_GROUP)));

    public static final RegistryObject<Item> EYE_OF_ICEDRAGON = ITEMS.register("eye_of_icedragon", () ->
            new ItemIceDragonEye(
                    new Item.Properties()
                            .maxStackSize(16)
                            .group(EyeOfDragonsMod.ITEM_GROUP)));

    public static final RegistryObject<Item> EYE_OF_LIGHTNINGDRAGON = ITEMS.register("eye_of_lightningdragon", () ->
            new ItemLightningDragonEye(
                    new Item.Properties()
                            .maxStackSize(16)
                            .group(EyeOfDragonsMod.ITEM_GROUP)));
}