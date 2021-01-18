package de.curlybracket.eyeofdragons;

import com.github.alexthe666.iceandfire.entity.EntityLightningDragon;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

public class ItemLightningDragonEye extends ItemEyeBase {
    public ItemLightningDragonEye(Properties properties) {
        super(properties);
    }

    @Override
    protected List<Entity> getNearbyEntities(World world, PlayerEntity player) {
        AxisAlignedBB bb = new AxisAlignedBB(player.getPosition()).grow(500);
        return world.getEntitiesWithinAABB(EntityLightningDragon.class, bb);
    }
}
