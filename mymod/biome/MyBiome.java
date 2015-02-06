package mymod.biome;

import mymod.Main;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityMooshroom;    
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class MyBiome extends BiomeGenBase
{
    public MyBiome(int par1)
    {
        super(par1);
        
        this.setBiomeName("Crimson");
        
        this.topBlock = (byte)Main.MyBlock_2.blockID;
        this.fillerBlock = (byte)Block.blockNetherQuartz.blockID;
        
        this.theBiomeDecorator.bigMushroomsPerChunk = 10;
        this.theBiomeDecorator.treesPerChunk = 5;    

        this.spawnableCreatureList.add(new SpawnListEntry(EntityMagmaCube.class, 1, 100, 150));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPigZombie.class, 10, 20, 25));
        
        this.setMinMaxHeight(0.1F, 0.5F);
        this.setTemperatureRainfall(1.5F, 0.2F);
   
    }
}