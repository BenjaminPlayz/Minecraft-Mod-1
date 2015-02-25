package mymod.biome;

import java.util.Random;

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
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class MyIceMontainBiome extends BiomeGenBase
{
    public MyIceMontainBiome(int par1)
    {
        super(par1);
        
        this.setBiomeName("Ice Montains");
        
        this.topBlock = (byte)Block.ice.blockID;
        this.fillerBlock = (byte)Block.blockSnow.blockID;
        
        
        
      
        this.theBiomeDecorator.treesPerChunk = 3;
        
        this.setMinMaxHeight(3.4F, 0.7F);
        this.setTemperatureRainfall(0.1F, 0.1F);
   
    }
    
    
}