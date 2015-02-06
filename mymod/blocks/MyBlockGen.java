package mymod.blocks;

import java.util.Random;

import mymod.Main;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class MyBlockGen implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId)
        {
            case 0: 
                generateSurface(world, random,chunkX*16,chunkZ*16);            
        }              
    }



    private void generateSurface(World world, Random random, int BlockX, int BlockZ) {
        for(int i =0; i<0.2553; i++){ 
            int Xcoord = BlockX + random.nextInt(16);
            int Zcoord = BlockZ + random.nextInt(16);
            int Ycoord = random.nextInt(16); 
            (new WorldGenMinable(Main.MyBlock_1.blockID, 6)).generate(world, random, Xcoord, Ycoord, Zcoord);
        }
    }



}   
    

