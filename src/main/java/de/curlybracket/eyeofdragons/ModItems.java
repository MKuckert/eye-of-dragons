package de.curlybracket.eyeofdragons;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.github.alexthe666.iceandfire.entity.EntityIceDragon;

public class ModItems {
    @GameRegistry.ObjectHolder(EyeOfDragonsMod.MODID + ":eye_of_firedragon")
    public static Item eye_of_firedragon = new ItemFireDragonEye();
    @GameRegistry.ObjectHolder(EyeOfDragonsMod.MODID + ":eye_of_icedragon")
    public static Item eye_of_icedragon = new ItemIceDragonEye();
}