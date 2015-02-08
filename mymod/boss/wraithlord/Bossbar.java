package mymod.boss.wraithlord;

import net.minecraft.entity.boss.IBossDisplayData;

public interface Bossbar extends IBossDisplayData
{
    float getMaxHealth();

    float getHealth();

    /**
     * Gets the username of the entity.
     */
    String getEntityName();
}
