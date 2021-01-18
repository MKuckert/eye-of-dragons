package de.curlybracket.eyeofdragons;

import com.github.alexthe666.iceandfire.misc.IafSoundRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.EyeOfEnderEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.List;

public abstract class ItemEyeBase extends Item {
    public ItemEyeBase(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        player.setActiveHand(hand);

        if (!world.isRemote && world.getDimensionKey().equals(World.OVERWORLD)) {
            findDragonAndShoot(world, player, itemstack);
        }

        return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
    }

    protected abstract List<Entity> getNearbyEntities(World world, PlayerEntity player);

    private void findDragonAndShoot(World world, PlayerEntity player, ItemStack itemstack) {
        List<Entity> entities = getNearbyEntities(world, player);

        if (entities.size() == 0) {
            player.sendStatusMessage(new TranslationTextComponent("item.eyeofdragons.dragon_eye.nonfound"), true);
            return;
        }

        double nearestDistance = Integer.MAX_VALUE;
        Entity nearestEntity = null;
        for (Entity entity : entities) {
            double distance = entity.getDistance(player);
            if (distance < nearestDistance) {
                nearestDistance = distance;
                nearestEntity = entity;
            }
        }

        EyeOfEnderEntity finderEntity = new EyeOfEnderEntity(world, player.getPosX(), player.getPosYEye(), player.getPosZ());
        finderEntity.func_213863_b(itemstack);
        finderEntity.moveTowards(nearestEntity.getPosition());
        world.addEntity(finderEntity);

        world.playSound(null, player.getPosX(), player.getPosY(), player.getPosZ(), IafSoundRegistry.DRAGON_FLIGHT, SoundCategory.NEUTRAL, 1F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        world.playEvent(null, 1003, player.getPosition(), 0);

        if (!player.isCreative()) {
            itemstack.shrink(1);
        }
    }
}
