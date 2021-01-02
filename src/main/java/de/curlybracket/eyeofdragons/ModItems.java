package de.curlybracket.eyeofdragons;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
    @GameRegistry.ObjectHolder(EyeOfDragonsMod.MODID + ":dragon_eye")
    public static Item dragon_eye = new ItemDragonEye();
}