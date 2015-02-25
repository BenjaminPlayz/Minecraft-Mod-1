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

public class MyHugeTreeBiome extends BiomeGenBase
{
    public MyHugeTreeBiome(int par1)
    {
        super(par1);
        
        this.setBiomeName("Gigantic Tree Hills");
        
        this.topBlock = (byte)Block.grass.blockID;
        this.fillerBlock = (byte)Block.dirt.blockID;
        
        
        
        this.theBiomeDecorator.flowersPerChunk = 5;
        this.theBiomeDecorator.grassPerChunk = 15;
        this.theBiomeDecorator.treesPerChunk = 8;
        
        this.setMinMaxHeight(0.9F, 0.6F);
        this.setTemperatureRainfall(0.3F, 0.4F);
   
    }
    
    
      /** Adds Huge Trees to your Biome */
        public WorldGenerator getRandomWorldGenForTrees(Random random)
        {
            return (WorldGenerator)
            new WorldGenHugeTrees(false, 50 + random.nextInt(25), 2, 0);
            /* Wood/Leaf Metadata: 0=Oak, 1=Spruce, 2=Birch, 3=Jungle Wood */
        }
    
    
    
}