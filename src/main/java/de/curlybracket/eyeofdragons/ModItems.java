package de.curlybracket.eyeofdragons;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
    @GameRegistry.ObjectHolder(EyeOfDragonsMod.MODID + ":eye_of_firedragon")
    public static Item eye_of_firedragon = new ItemFireDragonEye();

    @GameRegistry.ObjectHolder(EyeOfDragonsMod.MODID + ":eye_of_icedragon")
    public static Item eye_of_icedragon = new ItemIceDragonEye();
}