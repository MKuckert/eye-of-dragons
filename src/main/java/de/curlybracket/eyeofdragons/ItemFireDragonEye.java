package de.curlybracket.eyeofdragons;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import com.github.alexthe666.iceandfire.entity.EntityFireDragon;

import java.util.List;

public class ItemFireDragonEye extends ItemEyeBase {
    public ItemFireDragonEye(Properties properties) {
        super(properties);
    }

    @Override
    protected List<Entity> getNearbyEntities(World world, PlayerEntity player) {
        AxisAlignedBB bb = new AxisAlignedBB(player.getPosition()).grow(500);
        return world.getEntitiesWithinAABB(EntityFireDragon.class, bb);
    }
}
