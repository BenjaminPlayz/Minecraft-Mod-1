package mymod;

import java.awt.Color;

import mymod.armor.MyArmor;
import mymod.armor.MyArmor2;
import mymod.biome.MyBiome;
import mymod.blocks.MyBlock;
import mymod.blocks.MyBlockGen;
import mymod.entity.zombie.MyEntityZombie;
import mymod.entity.zombie.MyRenderZombie;
import mymod.items.MyFood;
import mymod.items.MyItem;
import mymod.items.MyPickaxe;
import mymod.items.MySword;
import mymod.items.MySword2;
import mymod.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


/* 	MOD INFO */
	@Mod( modid = "mymod", name = "Bens Mod", version = "1.0")
	@NetworkMod(clientSideRequired=true, serverSideRequired=false)	


public class Main {

/*	PROXY INFO */
	@SidedProxy(clientSide = "mymod.proxies.ClientProxy", serverSide = "mymod.proxies.CommonProxy")
	public static CommonProxy proxy;
		
	
/**	
 * DECLARATION SECTION 
 * *********************************************************** */

//  DECLARE THE SWORD 
        public static Item MySword_1;

  //  DECLARE THE PICKAXE 
        public static Item MyPickaxe_1;
        
        //  DECLARE THE PICKAXE 
        public static Item MyPickaxe_2;
        

 //  DECLARE NEW TOOL MATERIAL
                                     /** 1st is Harvest Level, 2nd is Durability, 3rd is Mining Speed, 4th is Attack Damage(Hearts not Hit points) And fifth is Enchantability */
        public static EnumToolMaterial MyToolMaterial = EnumHelper.addToolMaterial("Ice Shard", 3, 2000, 10.0F, 3.0F, 22);

 //  DECLARE NEW TOOL MATERIAL
        public static EnumToolMaterial MyToolMaterialCrimsonatePickaxe = EnumHelper.addToolMaterial("Crimsonate Pickaxe", 3, 4683, 23.0F, 3.0F, 22);

 //  DECLARE NEW TOOL MATERIAL
        public static EnumToolMaterial MyToolMaterialCrimsonateSword = EnumHelper.addToolMaterial("Crimsonate Sword", 3, 4864, 8.0F, 7.0F, 22);


//  DECLARE NEW TOOL MATERIAL
        public static EnumToolMaterial MyToolMaterialFleshPick = EnumHelper.addToolMaterial("FleshPickaxe", 3, 9366, 28.5F, 3.0F, 40);

 //  DECLARE NEW TOOL MATERIAL
        public static EnumToolMaterial MyToolMaterialFleshSword = EnumHelper.addToolMaterial("FleshSword", 3, 10000, 8.0F, 14.0F, 10);



 //  DECLARE THE BLOCK
        public static Block MyBlock_1;

 //  DECLARE THE ITEM
        public static Item MyItem_1;
    
    
    //  DECLARE THE SWORD 
        public static Item MySword_2;

//  DECLARE THE ITEM
        public static Item MyItem_2;


    //  DECLARE THE FOOD
        public static Item MyFood_1;


    //  DECLARE THE ARMOR
        public static Item MyHelmet_1;
        public static Item MyChest_1;
        public static Item MyLeggings_1;
        public static Item MyBoots_1;

  //  DECLARE THE ARMOR MATERIAL
  /** maxDamageFactor, damageReductionAmountArray, enchantability */
        public static EnumArmorMaterial MyArmorMaterial_1 = EnumHelper.addArmorMaterial("CrimsonateArmor", 4350, new int[]{10, 10, 10, 8}, 100);
                                 
                                 
                                 //  DECLARE THE ARMOR MATERIAL
  /** maxDamageFactor, damageReductionAmountArray, enchantability */
        public static EnumArmorMaterial MyArmorMaterial_2 = EnumHelper.addArmorMaterial("FleshArmor", 6000, new int[]{12, 16, 14, 10}, 100);
                                 
                                 
                                 
//  DECLARE THE BIOME
        public static  BiomeGenBase MyBiome_1;  

//  DECLARE THE BLOCK
        public static Block MyBlock_2;

 // DECLARE THE BLOCK
        public static Block MyBlock_3;


//  DECLARE THE MOD ID
        static int MyEntityID = 300;
    
    //  SEARCH FOR UNIQUE ID    
        public static int getUniqueEntityId() {
            do {
                MyEntityID++;
            }
            while (EntityList.getStringFromID(MyEntityID) != null);
            return MyEntityID++;
        }
    
    //  DECLARE A NEW EGG
        public static void registerEntityEgg(Class <? extends Entity> entity, int primaryColor, int secondaryColor) {
            int id = getUniqueEntityId();
            EntityList.IDtoClassMapping.put(id, entity);
            EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
        }

 //  DECLARE THE ITEM
        public static Item MyItem_3;


//  DECLARE THE PICKAXE 
        public static Item MyPickaxe_3;
      

  //  DECLARE THE ITEM
        public static Item MyItem_4;
    
 //  DECLARE THE SWORD 
        public static Item MySword_3;
    

//  DECLARE THE ARMOR
        public static Item MyHelmet_2;
        public static Item MyChest_2;
        public static Item MyLeggings_2;
        public static Item MyBoots_2;


//  DECLARE THE ITEM
        public static Item MyItem_5;



/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	


@EventHandler	
	public  void preInit( FMLPreInitializationEvent event ) 
	{
/**	
 * LOAD SECTION 
 * *********************************************************** */ 

 //  LOAD THE SWORD
        MySword_1 = new MySword(2021, MyToolMaterial, "MySword_1");
        GameRegistry.registerItem(MySword_1, "MySword_1");
        LanguageRegistry.addName(MySword_1, "Magma Blade"); 

//  LOAD THE PICKAXE
        MyPickaxe_1 = new MyPickaxe(2022, MyToolMaterial, "MyPickaxe_1");
        GameRegistry.registerItem(MyPickaxe_1, "MyPickaxe_1");
        LanguageRegistry.addName(MyPickaxe_1, "Ice Pickaxe"); 
	
	//  LOAD THE PICKAXE
        MyPickaxe_2 = new MyPickaxe(2023, MyToolMaterialCrimsonatePickaxe, "MyPickaxe_2");
        GameRegistry.registerItem(MyPickaxe_2, "MyPickaxe_2");
        LanguageRegistry.addName(MyPickaxe_2, "Crimsonate Pickaxe"); 
	
	//  LOAD THE BLOCK 
                                                                    /** Hardness is how long it takes to mine block, Resistance is how strong the block is to Explosions */     	
        MyBlock_1 = new MyBlock(250, Material.rock, "MyBlock_1").setLightValue(0.7586F).setHardness(10.5F).setResistance(14.5F).setStepSound(Block.soundStoneFootstep);
        GameRegistry.registerBlock(MyBlock_1, "MyBlock_1");
        LanguageRegistry.addName(MyBlock_1, "Crimsonate Ore"); 
		MinecraftForge.setBlockHarvestLevel(MyBlock_1, "pickaxe", 3);

 //  LOAD THE BLOCK 
        MyBlock_2 = new MyBlock(2085, Material.grass, "MyBlock_2").setHardness(5.0F).setResistance(7.5F).setStepSound(Block.soundStoneFootstep);
        GameRegistry.registerBlock(MyBlock_2, "MyBlock_2");
        LanguageRegistry.addName(MyBlock_2, "Crimsified Grass"); 
		MinecraftForge.setBlockHarvestLevel(MyBlock_2, "pickaxe", 1);

 //  LOAD THE BLOCK 
        MyBlock_3 = new MyBlock(2080, Material.grass, "MyBlock_3");
        GameRegistry.registerBlock(MyBlock_3, "MyBlock_3");
        LanguageRegistry.addName(MyBlock_3, "Crimsified Stone"); 
		MinecraftForge.setBlockHarvestLevel(MyBlock_3, "pickaxe", 1);




	//  LOAD THE ITEM
        MyItem_1 = new MyItem(2030, "MyItem_1").setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64);
        GameRegistry.registerItem(MyItem_1, "MyItem_1");
        LanguageRegistry.addName(MyItem_1, "Crimsonate Ingot");  
    
    
    //  LOAD THE SWORD
        MySword_2 = new MySword2(2024, MyToolMaterialCrimsonateSword, "MySword_2");
        GameRegistry.registerItem(MySword_2, "MySword_2");
        LanguageRegistry.addName(MySword_2, "Crimsonate Sword");  
    
    
    
     //  LOAD THE ITEM
        MyItem_2 = new MyItem(2031, "MyItem_2").setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64);
        GameRegistry.registerItem(MyItem_2, "MyItem_2");
        LanguageRegistry.addName(MyItem_2, "Crimsonate Stick");  
    
     //  LOAD THE FOOD
                          /** First Vaule is HealPoints, Then Saturation Value, Then the last is True or False and it is saying IsWolfsFavoriteFood. */     
        MyFood_1 = new MyFood(2040, 4, 2.5F, true, "MyFood_1").setAlwaysEdible().setPotionEffect(Potion.moveSpeed.id, 45, 8, 0.1F).setCreativeTab(CreativeTabs.tabFood).setMaxStackSize(32);
        GameRegistry.registerItem(MyFood_1, "MyFood_1");
        LanguageRegistry.addName(MyFood_1, "Marshmallow"); 
    
    
    //  LOAD HELMET 
        MyHelmet_1 = new MyArmor(2060, MyArmorMaterial_1, 0, 0, "myarmor").setCreativeTab(CreativeTabs.tabCombat);
        GameRegistry.registerItem(MyHelmet_1, "MyHelmet_1");
        LanguageRegistry.addName(MyHelmet_1, "Crimsonate Helmet");      
    
//  LOAD CHESTPLATE
        MyChest_1 = new MyArmor(2061, MyArmorMaterial_1, 0, 1, "myarmor").setCreativeTab(CreativeTabs.tabCombat);
        GameRegistry.registerItem(MyChest_1, "MyChest_1");
        LanguageRegistry.addName(MyChest_1, "Crimsonate Chestplate");

//  LOAD LEGGINGS    
        MyLeggings_1 = new MyArmor(2062, MyArmorMaterial_1, 0, 2, "myarmor").setCreativeTab(CreativeTabs.tabCombat);
        GameRegistry.registerItem(MyLeggings_1, "MyLeggings_1");
        LanguageRegistry.addName(MyLeggings_1, "Crimsonate Leggings");

//  LOAD BOOTS   
        MyBoots_1 = new MyArmor(2063, MyArmorMaterial_1, 0, 3, "myarmor").setCreativeTab(CreativeTabs.tabCombat);
        GameRegistry.registerItem(MyBoots_1, "MyBoots_1");
        LanguageRegistry.addName(MyBoots_1, "Crimsonate Feet");
    
     //  LOAD BIOME
        MyBiome_1 = new MyBiome(30);
        GameRegistry.addBiome(MyBiome_1);
        
//  REMOVE OTHER BIOMES
        GameRegistry.removeBiome(BiomeGenBase.beach);
        GameRegistry.removeBiome(BiomeGenBase.desert);
        GameRegistry.removeBiome(BiomeGenBase.desertHills);
        GameRegistry.removeBiome(BiomeGenBase.desertHills);
        GameRegistry.removeBiome(BiomeGenBase.extremeHills);
        GameRegistry.removeBiome(BiomeGenBase.extremeHillsEdge);
        GameRegistry.removeBiome(BiomeGenBase.forest);
        GameRegistry.removeBiome(BiomeGenBase.forestHills);
        GameRegistry.removeBiome(BiomeGenBase.frozenOcean);
        GameRegistry.removeBiome(BiomeGenBase.frozenRiver);
        GameRegistry.removeBiome(BiomeGenBase.iceMountains);
        GameRegistry.removeBiome(BiomeGenBase.icePlains);
        GameRegistry.removeBiome(BiomeGenBase.jungle);
        GameRegistry.removeBiome(BiomeGenBase.jungleHills);
        GameRegistry.removeBiome(BiomeGenBase.mushroomIsland);
        GameRegistry.removeBiome(BiomeGenBase.ocean);
        GameRegistry.removeBiome(BiomeGenBase.plains);
        GameRegistry.removeBiome(BiomeGenBase.river);
        GameRegistry.removeBiome(BiomeGenBase.swampland);
        GameRegistry.removeBiome(BiomeGenBase.taiga);
        GameRegistry.removeBiome(BiomeGenBase.taigaHills);           

    
   
	 //  REGISTER YOUR ENTITY
        EntityRegistry.registerGlobalEntityID(MyEntityZombie.class, "Face Gobler", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.addSpawn(MyEntityZombie.class, 50, 1, 5, EnumCreatureType.monster, BiomeGenBase.desert); 
        EntityRegistry.addSpawn(MyEntityZombie.class, 50, 1, 5, EnumCreatureType.monster, MyBiome_1);     
        registerEntityEgg(MyEntityZombie.class, (new Color(112, 0, 16)).getRGB(), (new Color(0, 0, 0)).getRGB());
        RenderingRegistry.registerEntityRenderingHandler(MyEntityZombie.class, new MyRenderZombie());
        ModLoader.addLocalization("entity.Face Gobler.name", "Face Gobler");
	
   
	//  LOAD THE ITEM
        MyItem_3 = new MyItem(2090, "MyItem_3").setCreativeTab(CreativeTabs.tabMaterials);
        GameRegistry.registerItem(MyItem_3, "MyItem_3");
        LanguageRegistry.addName(MyItem_3, "Flesh Ingot");  
	
	
	 //  LOAD THE PICKAXE
        MyPickaxe_3 = new MyPickaxe(2091, MyToolMaterialFleshPick, "MyPickaxe_3");
        GameRegistry.registerItem(MyPickaxe_3, "MyPickaxe_3");
        LanguageRegistry.addName(MyPickaxe_3, "Flesh Pickaxe");  
	
  //  LOAD THE ITEM
        MyItem_4 = new MyItem(2092, "MyItem_4").setCreativeTab(CreativeTabs.tabMaterials);
        GameRegistry.registerItem(MyItem_4, "MyItem_4");
        LanguageRegistry.addName(MyItem_4, "Flesh Stick");  
    
	
	 //  LOAD THE SWORD
        MySword_3 = new MySword(2093, MyToolMaterialFleshSword, "MySword_3");
        GameRegistry.registerItem(MySword_3, "MySword_3");
        LanguageRegistry.addName(MySword_3, "Flesh Sword");     

    
     //  LOAD HELMET 
        MyHelmet_2 = new MyArmor2(2094, EnumArmorMaterial.IRON, 0, 0, "myarmor2");
        GameRegistry.registerItem(MyHelmet_2, "MyHelmet_2");
        LanguageRegistry.addName(MyHelmet_2, "Flesh Helmet");      
    
//  LOAD CHESTPLATE
        MyChest_2 = new MyArmor2(2095, EnumArmorMaterial.IRON, 0, 1, "myarmor2");
        GameRegistry.registerItem(MyChest_2, "MyChest_2");
        LanguageRegistry.addName(MyChest_2, "Flesh Chestplate");

//  LOAD LEGGINGS    
        MyLeggings_2 = new MyArmor2(2096, EnumArmorMaterial.IRON, 0, 2, "myarmor2");
        GameRegistry.registerItem(MyLeggings_2, "MyLeggings_2");
        LanguageRegistry.addName(MyLeggings_2, "Flesh Legs");

//  LOAD BOOTS   
        MyBoots_2 = new MyArmor2(2097, EnumArmorMaterial.IRON, 0, 3, "myarmor2");
        GameRegistry.registerItem(MyBoots_2, "MyBoots_2");
        LanguageRegistry.addName(MyBoots_2, "Flesh Greaves");
    
	//  LOAD THE ITEM
        MyItem_5 = new MyItem(2098, "MyItem_5").setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64);
        GameRegistry.registerItem(MyItem_5, "MyItem_5");
        LanguageRegistry.addName(MyItem_5, "Crimsonate Shard");  
	
	
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	}

@EventHandler
	public static void init( FMLInitializationEvent event ) 
	{
	
/**	
 * RECIPES SECTION 
 * *********************************************************** */


//  SWORD RECIPE  
        GameRegistry.addRecipe(new ItemStack(MySword_1, 1), new Object[]
        {
                " X ",
                " X ",
                " S ",
            'S', Item.blazeRod,
            'X', Item.magmaCream,
        }); 
	
 //  PICKAXE RECIPE  
        GameRegistry.addRecipe(new ItemStack(MyPickaxe_1, 1), new Object[]
        {
                "XXX",
                " S ",
                " S ",
            'S', Item.stick,
            'X', Block.ice,
        }); 
        
        
        //  PICKAXE RECIPE  
        GameRegistry.addRecipe(new ItemStack(MyPickaxe_2, 1), new Object[]
        {
                "XXX",
                " S ",
                " S ",
            'S', MyItem_2,
            'X', MyItem_1,
            
        }); 

 //  SMELTING RECIPE
        GameRegistry.addSmelting(MyBlock_1.blockID, (new ItemStack(MyItem_1, 2)), 10);
        		
        		
        		
        		
         //  CRIMSONATE INGOT RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyItem_1, 2), new Object[]
        {
                "XSX",
                "SOS",
                "XSX",
            'S', Block.blockDiamond,
            'X', Block.blockEmerald,
            'O', Block.beacon,
        });
        		
         //  ITEM RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyItem_2, 2), new Object[]
        {
                "  ",
                "  ",
                "SX",
            'S', Item.stick,
            'X', MyItem_1,
        });

//  SWORD RECIPE  
        GameRegistry.addRecipe(new ItemStack(MySword_2, 1), new Object[]
        {
                " X ",
                " X ",
                " S ",
            'S', MyItem_2,
            'X', MyItem_1,
        }); 


 //  FOOD RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyFood_1, 1), new Object[]
        {
               
                "SS",
                "SS",
            'S', Item.sugar,
        });


//  HELMET RECIPE   
    GameRegistry.addRecipe(new ItemStack(MyHelmet_1, 1), new Object[]
    {
            "XXX",
            "X X",
        'X', MyItem_1,
    });         

//  CHESTPLATE RECIPE   
    GameRegistry.addRecipe(new ItemStack(MyChest_1, 1), new Object[]
    {
            "X X",
            "XXX",
            "XXX",
        'X', MyItem_1,
    });         

//  LEGGINGS RECIPE 
    GameRegistry.addRecipe(new ItemStack(MyLeggings_1, 1), new Object[]
    {
            "XXX",
            "X X",
            "X X",
        'X', MyItem_1,
    });         

//  BOOTS RECIPE    
    GameRegistry.addRecipe(new ItemStack(MyBoots_1, 1), new Object[]
    {
            "X X",
            "X X",
        'X', MyItem_1,
    });    



//  SMELTING RECIPE
        GameRegistry.addSmelting(MyBlock_3.blockID, (new ItemStack(Block.stone, 2)), 20);


//  ITEM RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyItem_3, 2), new Object[]
        {
                "SSS",
                "SXS",
                "SSS",
            'S', MyItem_1,
            'X', Block.beacon,
        });



//  PICKAXE RECIPE  
        GameRegistry.addRecipe(new ItemStack(MyPickaxe_3, 1), new Object[]
        {
                "XXX",
                " S ",
                " S ",
            'S', MyItem_4,
            'X', MyItem_3,
        }); 


//  ITEM RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyItem_4, 2), new Object[]
        {
               
                "SX",
            'S', MyItem_3,
            'X', MyItem_2,
        });


  //  SWORD RECIPE  
        GameRegistry.addRecipe(new ItemStack(MySword_3, 1), new Object[]
        {
                " X ",
                " X ",
                " S ",
            'S', MyItem_4,
            'X', MyItem_3,
        }); 
        


/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
/**	
 * EXTRA METHODS SECTION 
 * *********************************************************** */


     //  REGISTER THE ORE GENERATION 
    GameRegistry.registerWorldGenerator(new MyBlockGen());
        



/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
	}

@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) 
	{

	}
	
}
