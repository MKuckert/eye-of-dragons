package de.curlybracket.eyeofdragons;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import java.util.List;

public abstract class ItemEyeBase extends Item {

    public ItemEyeBase(String name) {
        super();
        this.setTranslationKey(EyeOfDragonsMod.MODID+"."+name);
        this.setRegistryName(EyeOfDragonsMod.MODID, name);
        this.maxStackSize = 16;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        player.setActiveHand(hand);

        if(!worldIn.isRemote && player.dimension == 0)
        {
            findDragonAndShoot(worldIn, player, itemstack);
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
    }

    protected abstract List<Entity> getNearbyEntities(World world, EntityPlayer player);
    protected abstract EntityEyeBase createEntity(World world, EntityPlayer player, ItemStack itemstack);

    private void findDragonAndShoot(World world, EntityPlayer player, ItemStack itemstack)
    {
        List<Entity> entities = getNearbyEntities(world, player);

        if(entities.size()==0) {
            player.sendStatusMessage(new TextComponentTranslation("item.eyeofdragons.dragon_eye.nonfound"), true);
            return;
        }

        double nearestDistance = Integer.MAX_VALUE;
        Entity nearestEntity = null;
        for (Entity entity: entities) {
            double distance = entity.getDistance(player.posX, player.posY, player.posZ);
            if(distance < nearestDistance) {
                nearestDistance = distance;
                nearestEntity = entity;
            }
        }

        EntityEyeBase finderEntity = createEntity(world, player, itemstack);
        world.spawnEntity(finderEntity);
        finderEntity.moveTowards(nearestEntity.posX, nearestEntity.posY, nearestEntity.posZ);

        world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ENDEREYE_LAUNCH, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        world.playEvent(null, 1003, player.getPosition(), 0);

        if (!player.capabilities.isCreativeMode) {
            itemstack.shrink(1);
        }
    }
}
