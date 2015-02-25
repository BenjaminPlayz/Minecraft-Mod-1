package mymod.biome;

import mymod.Main;
import mymod.entity.wraith.MyEntityWraith;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityMooshroom;    
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class MyFlatBiome extends BiomeGenBase
{
    public MyFlatBiome(int par1)
    {
        super(par1);
        
        this.setBiomeName("Flat Lands");
        
        this.topBlock = (byte)Block.grass.blockID;
        this.fillerBlock = (byte)Block.oreCoal.blockID;
        
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySlime.class, 1, 100, 150));
        
        
        this.theBiomeDecorator.flowersPerChunk = 15;
        this.theBiomeDecorator.grassPerChunk = 5;
        
        this.setMinMaxHeight(0.0F, 0.0F);
        this.setTemperatureRainfall(1.6F, 1.6F);
   
    }
}