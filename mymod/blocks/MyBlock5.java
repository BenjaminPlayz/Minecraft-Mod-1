package mymod.blocks;

import java.util.Random;

import mymod.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MyBlock5 extends Block {

    private String texturePath = "mymod:";  
    private int thisBlockID;
    
    public MyBlock5 (int par1, Material blockMaterial, String textureName) {
        
        super(par1, blockMaterial);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setUnlocalizedName(textureName);
        texturePath += textureName;
        thisBlockID = par1;
    }

public int idDropped(int par1, Random par2Random, int par3)
    {
        return Main.MyFood_8.itemID;
    }

    
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        return this.quantityDropped(par2Random) + par2Random.nextInt(par1 + 1);
    }


public int quantityDropped(Random par1Random)
    {
        return 1 + par1Random.nextInt(2);
    }
    
    
}

