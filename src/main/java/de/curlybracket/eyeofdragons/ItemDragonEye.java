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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import com.github.alexthe666.iceandfire.entity.EntityFireDragon;

import java.util.List;

public class ItemDragonEye extends Item {

    public ItemDragonEye() {
        super();
        this.setTranslationKey("eyeofdragons.dragon_eye");
        this.setRegistryName(EyeOfDragonsMod.MODID, "dragon_eye");
        this.maxStackSize = 16;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        player.setActiveHand(hand);

        if(!worldIn.isRemote && player.dimension == 0)
        {
            findDragonAndShoot(worldIn, player, itemstack);
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }

    private void findDragonAndShoot(World world, EntityPlayer player, ItemStack itemstack)
    {
        AxisAlignedBB bb = new AxisAlignedBB(player.getPosition()).grow(500);

        List<Entity> entities = world.getEntitiesWithinAABB(EntityFireDragon.class, bb);

        if(entities.size()==0) {
            player.sendStatusMessage(new TextComponentTranslation("item.greater_eye.greater_eye.nonfound"), true);
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

        EntityDragonEye finderentity = new EntityDragonEye(world, player.posX, player.posY + player.height, player.posZ, getDamage(itemstack));
        world.spawnEntity(finderentity);
        finderentity.setDestination(nearestEntity.posX, nearestEntity.posY, nearestEntity.posZ);

        world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ENDEREYE_LAUNCH, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        world.playEvent((EntityPlayer)null, 1003, player.getPosition(), 0);

        if (!player.capabilities.isCreativeMode) {
            itemstack.shrink(1);
        }
    }
}
