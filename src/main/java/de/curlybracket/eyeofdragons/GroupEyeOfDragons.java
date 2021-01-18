package de.curlybracket.eyeofdragons;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GroupEyeOfDragons extends ItemGroup {
    public GroupEyeOfDragons() {
        super(EyeOfDragonsMod.MODID);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemInit.EYE_OF_FIREDRAGON.get());
    }
}
