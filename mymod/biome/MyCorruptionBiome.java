package mymod.biome;

import mymod.Main;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityMooshroom;    
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class MyCorruptionBiome extends BiomeGenBase
{
    public MyCorruptionBiome(int par1)
    {
        super(par1);
        
        this.setBiomeName("Corruption");
        
        this.topBlock = (byte)Main.MyBlock_2.blockID;
        this.fillerBlock = (byte)Block.beacon.blockID;
        
        this.spawnableCreatureList.add(new SpawnListEntry(EntityMagmaCube.class, 1, 100, 150));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPigZombie.class, 10, 20, 25));
        
        this.setMinMaxHeight(1.0F, 1.5F);
        this.setTemperatureRainfall(1.5F, 0.2F);
   
    }
}