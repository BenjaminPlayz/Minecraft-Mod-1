package mymod;

import java.awt.Color;

import mymod.armor.MyArmor;
import mymod.armor.MyFleshArmor;
import mymod.armor.MyLapisArmor;
import mymod.biome.MyBiome;
import mymod.biome.MyCorruptionBiome;
import mymod.biome.MyFlatBiome;
import mymod.biome.MyHugeTreeBiome;
import mymod.biome.MyIceMontainBiome;
import mymod.blocks.MyBlock;
import mymod.blocks.MyBlockGen;
import mymod.boss.wraithlord.MyEntityWraithlord;
import mymod.boss.wraithlord.MyModelWraithlord;
import mymod.boss.wraithlord.MyRenderWraithlord;
import mymod.entity.ogre.MyEntityOgre;
import mymod.entity.ogre.MyModelOgre;
import mymod.entity.ogre.MyRenderOgre;
import mymod.entity.wraith.MyEntityWraith;
import mymod.entity.wraith.MyModelWraith;
import mymod.entity.wraith.MyRenderWraith;
import mymod.entity.zombie.MyEntityZombie;
import mymod.entity.zombie.MyRenderZombie;
import mymod.handlers.MyCraftingHandler;
import mymod.handlers.MyPickupHandler;
import mymod.items.MyAxe;
import mymod.items.MyBow;
import mymod.items.MyFood;
import mymod.items.MyItem;
import mymod.items.MyPickaxe;
import mymod.items.MyShovel;
import mymod.items.MySword;
import mymod.items.MySword2;
import mymod.items.MySword4;
import mymod.items.MySword5;
import mymod.projectiles.MyEntityProjectile;
import mymod.projectiles.MyProjectile;
import mymod.projectiles.MyRenderProjectile;
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
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
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
	@Mod( modid = "mymod", name = "The Battle of The Biome RPG", version = "1.3.5")
	@NetworkMod(clientSideRequired=true, serverSideRequired=false)	


public class Main {

/*	PROXY INFO */
	@SidedProxy(clientSide = "mymod.proxies.ClientProxy", serverSide = "mymod.proxies.CommonProxy")
	public static CommonProxy proxy;
		
	
/**	
 * DECLARATION SECTION 
 * *********************************************************** */

                                     /** 1st is Harvest Level, 2nd is Durability, 3rd is Mining Speed, 4th is Attack Damage(Hearts not Hit points) And fifth is Enchantability */
        public static EnumToolMaterial MyToolMaterial = EnumHelper.addToolMaterial("Ice Shard", 3, 2000, 10.0F, 3.0F, 22);

                              /** 1st is Harvest Level, 2nd is Durability, 3rd is Mining Speed, 4th is Attack Damage(Hearts not Hit points) And fifth is Enchantability */
        public static EnumToolMaterial MyToolMaterialLapisSword = EnumHelper.addToolMaterial("LSWORD", 3, 4567, 5.0F, 5.7F, 22);

        public static EnumToolMaterial MyToolMaterialRedstoneSword = EnumHelper.addToolMaterial("RSWORD", 3, 10000, 5.0F, 4.5F, 22);

        
        public static EnumToolMaterial MyToolMaterialCorruptSword = EnumHelper.addToolMaterial("CORRUPTSWORD", 3, 6000, 1.0F, 10.0F, 10);



                     /** 1st is Harvest Level, 2nd is Durability, 3rd is Mining Speed, 4th is Attack Damage(Hearts not Hit points) And fifth is Enchantability */
        public static EnumToolMaterial MyToolMaterialLapisPick = EnumHelper.addToolMaterial("LPICK", 3, 4304, 18.3F, 1.3F, 22);





        public static EnumToolMaterial MyToolMaterialCrimsonatePickaxe = EnumHelper.addToolMaterial("Crimsonate Pickaxe", 3, 4683, 23.0F, 3.0F, 22);
        


        public static EnumToolMaterial MyToolMaterialCrimsonateSword = EnumHelper.addToolMaterial("Crimsonate Sword", 3, 4864, 8.0F, 9.0F, 100);



        public static EnumToolMaterial MyToolMaterialFleshPick = EnumHelper.addToolMaterial("FleshPickaxe", 3, 9366, 28.5F, 3.0F, 40);


        public static EnumToolMaterial MyToolMaterialFleshSword = EnumHelper.addToolMaterial("FleshSword", 3, 10000, 8.0F, 14.0F, 10);



        public static EnumToolMaterial MyToolMaterialUthoria = EnumHelper.addToolMaterial("Uthoria", 3, 10000, 8.0F, 17.0F, 0);



        public static EnumToolMaterial MyToolMaterialCreative = EnumHelper.addToolMaterial("Creative", 3, 1000000000, 8.0F, 100000000.0F, 0);




  /** maxDamageFactor, damageReductionAmountArray, enchantability */
        public static EnumArmorMaterial MyArmorMaterial_1 = EnumHelper.addArmorMaterial("CrimsonateArmor", 4350, new int[]{10, 10, 10, 8}, 100);
                                 
                                 

  /** maxDamageFactor, damageReductionAmountArray, enchantability */
        public static EnumArmorMaterial MyArmorMaterial_2 = EnumHelper.addArmorMaterial("FleshArmor", 6000, new int[]{12, 16, 14, 10}, 100);
                                 
                                 

  /** maxDamageFactor, damageReductionAmountArray, enchantability */
        public static EnumArmorMaterial MyArmorMaterial_3 = EnumHelper.addArmorMaterial("LapisArmor", 250, new int[]{5, 9, 5, 5}, 100);
                                        
                                 
                                 
                                
        // BIOME AREA
        public static  BiomeGenBase MyBiome_1;  

        public static  BiomeGenBase MyCorruptionBiome_1;  

        public static  BiomeGenBase MyFlatBiome_1;

        public static  BiomeGenBase MyHugeTreeBiome_1;

        public static  BiomeGenBase MyIceMontainBiome_1;

        static int MyEntityID = 300;
    

        public static int getUniqueEntityId() {
            do {
                MyEntityID++;
            }
            while (EntityList.getStringFromID(MyEntityID) != null);
            return MyEntityID++;
        }
    

        public static void registerEntityEgg(Class <? extends Entity> entity, int primaryColor, int secondaryColor) {
            int id = getUniqueEntityId();
            EntityList.IDtoClassMapping.put(id, entity);
            EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
        }



        // ACHIEVMENT AREA
    	public static Achievement MyAchievement_1;
    	public static Achievement MyAchievement_2;



    	// Sorry Projectile TBH there will only be one of you
        public static Item MyProjectile_1;

        // SWORD AREA
        public static Item MySword_1;
        public static Item MySword_2;        
        public static Item MySword_3;
        public static Item MySword_4;
        public static Item MySword_5;
        public static Item MySword_6;    
        public static Item MySword_7;      
        public static Item MySword_8;      
            
        // BLOCK AREA
        public static Block MyBlock_1;
        public static Block MyBlock_2;
        public static Block MyBlock_3;
        public static Block MyBlock_4;
        public static Block MyBlock_5;
        public static Block MyBlock_6;
        public static Block MyBlock_7; 
     
        
        
        // ITEM AREA
        public static Item MyItem_1;
        public static Item MyItem_2;        
        public static Item MyItem_3;
        public static Item MyItem_4;
        public static Item MyItem_5;
        public static Item MyItem_6;   
        public static Item MyItem_7;   
        public static Item MyItem_8;
        public static Item MyItem_9;
   
       
   
        // PICKAXE AREA
        public static Item MyPickaxe_1;
        public static Item MyPickaxe_2;        
        public static Item MyPickaxe_3;
        public static Item MyPickaxe_4;
   
   
        // ARMOR AREA
        
        public static Item MyHelmet_1;
        public static Item MyChest_1;
        public static Item MyLeggings_1;
        public static Item MyBoots_1;
        
        public static Item MyHelmet_2;
        public static Item MyChest_2;
        public static Item MyLeggings_2;
        public static Item MyBoots_2;
        
        public static Item MyHelmet_3;
        public static Item MyChest_3;
        public static Item MyLeggings_3;
        public static Item MyBoots_3;
   
        
        // FOOD AREA
        public static Item MyFood_1;
        public static Item MyFood_2;
        public static Item MyFood_3;
        public static Item MyFood_4;
        public static Item MyFood_5;
        public static Item MyFood_6;
        public static Item MyFood_7;
        public static Item MyFood_8;
        public static Item MyFood_9;
        public static Item MyFood_10;
        public static Item MyFood_11;
   
        // AXES AREA
        public static Item MyAxe_1;
        public static Item MyAxe_2; 
        public static Item MyAxe_3;   
        // SHOVEL AREA
        public static Item MyShovel_1;
        public static Item MyShovel_2;
        
        
        // BOW AREA
        public static Item MyBow_1;
        
    
    // FURNACE AREA TESTING STUFF
    
    public static Block blockLapisFurnaceIdle;
    public static Block blockLapisFurnaceActive;
    
    
    
    
        
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	


@EventHandler	
	public  void preInit( FMLPreInitializationEvent event ) 
	{
/**	
 * LOAD SECTION 
 * *********************************************************** */ 

 //  SWORD AREA
        MySword_1 = new MySword(2021, MyToolMaterial, "MySword_1");
        GameRegistry.registerItem(MySword_1, "MySword_1");
        LanguageRegistry.addName(MySword_1, "Magma Blade"); 


        MySword_2 = new MySword2(2024, MyToolMaterialCrimsonateSword, "MySword_2");
        GameRegistry.registerItem(MySword_2, "MySword_2");
        LanguageRegistry.addName(MySword_2, "Crimsonate Sword");  


        MySword_3 = new MySword(2093, MyToolMaterialFleshSword, "MySword_3");
        GameRegistry.registerItem(MySword_3, "MySword_3");
        LanguageRegistry.addName(MySword_3, "Flesh Sword");     


        MySword_4 = new MySword4(2102, MyToolMaterialUthoria, "MySword_4");
        GameRegistry.registerItem(MySword_4, "MySword_4");
        LanguageRegistry.addName(MySword_4, "Uthoria");


        MySword_5 = new MySword5(2103, MyToolMaterialCreative, "MySword_5");
        GameRegistry.registerItem(MySword_5, "MySword_5");
        LanguageRegistry.addName(MySword_5, "Insta Killer");


        MySword_6 = new MySword(2110, MyToolMaterialLapisSword, "MySword_6");
        GameRegistry.registerItem(MySword_6, "MySword_6");
        LanguageRegistry.addName(MySword_6, "Lapis Sword");



        MySword_7 = new MySword2(2124, MyToolMaterialRedstoneSword, "MySword_7");
        GameRegistry.registerItem(MySword_7, "MySword_7");
        LanguageRegistry.addName(MySword_7, "Redstone Sword");




        MySword_8 = new MySword(2125, MyToolMaterialCorruptSword, "MySword_8");
        GameRegistry.registerItem(MySword_8, "MySword_8");
        LanguageRegistry.addName(MySword_8, "Corrupt Blade");






// PICKAXE AREA
        MyPickaxe_1 = new MyPickaxe(2022, MyToolMaterial, "MyPickaxe_1");
        GameRegistry.registerItem(MyPickaxe_1, "MyPickaxe_1");
        LanguageRegistry.addName(MyPickaxe_1, "Ice Pickaxe"); 
	

        MyPickaxe_2 = new MyPickaxe(2023, MyToolMaterialCrimsonatePickaxe, "MyPickaxe_2");
        GameRegistry.registerItem(MyPickaxe_2, "MyPickaxe_2");
        LanguageRegistry.addName(MyPickaxe_2, "Crimsonate Pickaxe"); 
	
	
        MyPickaxe_3 = new MyPickaxe(2091, MyToolMaterialFleshPick, "MyPickaxe_3");
        GameRegistry.registerItem(MyPickaxe_3, "MyPickaxe_3");
        LanguageRegistry.addName(MyPickaxe_3, "Flesh Pickaxe"); 
	
	
	    MyPickaxe_4 = new MyPickaxe(2120, MyToolMaterialLapisPick, "MyPickaxe_4");
        GameRegistry.registerItem(MyPickaxe_4, "MyPickaxe_4");
        LanguageRegistry.addName(MyPickaxe_4, "Lapis Pickaxe"); 
	
	
	
	
	
	
	
	//  BLOCK AREA
                                                                    /** Hardness is how long it takes to mine block, Resistance is how strong the block is to Explosions */     	
        MyBlock_1 = new MyBlock(250, Material.rock, "MyBlock_1").setLightValue(0.7586F).setHardness(10.5F).setResistance(14.5F).setStepSound(Block.soundStoneFootstep);
        GameRegistry.registerBlock(MyBlock_1, "MyBlock_1");
        LanguageRegistry.addName(MyBlock_1, "Crimsonate"); 
		MinecraftForge.setBlockHarvestLevel(MyBlock_1, "pickaxe", 3);
                                                                    /** Hardness is how long it takes to mine block, Resistance is how strong the block is to Explosions */     	
        MyBlock_2 = new MyBlock(251, Material.grass, "MyBlock_2").setHardness(5.0F).setResistance(7.5F).setStepSound(Block.soundStoneFootstep);
        GameRegistry.registerBlock(MyBlock_2, "MyBlock_2");
        LanguageRegistry.addName(MyBlock_2, "Crimsified Grass"); 
		MinecraftForge.setBlockHarvestLevel(MyBlock_2, "pickaxe", 1);

 
        MyBlock_3 = new MyBlock(2080, Material.grass, "MyBlock_3");
        GameRegistry.registerBlock(MyBlock_3, "MyBlock_3");
        LanguageRegistry.addName(MyBlock_3, "Crimsified Stone"); 
		MinecraftForge.setBlockHarvestLevel(MyBlock_3, "pickaxe", 1);

 
        MyBlock_4 = new MyBlock(252, Material.grass, "MyBlock_4").setHardness(0.6F).setStepSound(Block.soundGrassFootstep);
        GameRegistry.registerBlock(MyBlock_4, "MyBlock_4");
        LanguageRegistry.addName(MyBlock_4, "Corrupt Grass"); 
		MinecraftForge.setBlockHarvestLevel(MyBlock_4, "shovel", 1);



		MyBlock_5 = new MyBlock(253, Material.anvil, "MyBlock_5").setHardness(10.6F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep);
        GameRegistry.registerBlock(MyBlock_5, "MyBlock_5");
        LanguageRegistry.addName(MyBlock_5, "Coffee Ore"); 
		MinecraftForge.setBlockHarvestLevel(MyBlock_5, "pickaxe", 2);


		MyBlock_6 = new MyBlock(254, Material.anvil, "MyBlock_6").setHardness(10.6F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep);
        GameRegistry.registerBlock(MyBlock_6, "MyBlock_6");
        LanguageRegistry.addName(MyBlock_6, "Green Stone Brick"); 
		MinecraftForge.setBlockHarvestLevel(MyBlock_6, "pickaxe", 2);



		MyBlock_7 = new MyBlock(255, Material.anvil, "MyBlock_7").setHardness(10.6F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setLightValue(1.0F);
        GameRegistry.registerBlock(MyBlock_7, "MyBlock_7");
        LanguageRegistry.addName(MyBlock_7, "Luminant Green Stone Brick"); 
		MinecraftForge.setBlockHarvestLevel(MyBlock_7, "pickaxe", 2);




		



	// ITEM AREA
        MyItem_1 = new MyItem(2030, "MyItem_1").setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64);
        GameRegistry.registerItem(MyItem_1, "MyItem_1");
        LanguageRegistry.addName(MyItem_1, "Crimsonate Ingot");  
    
    
        MyItem_2 = new MyItem(2031, "MyItem_2").setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64);
        GameRegistry.registerItem(MyItem_2, "MyItem_2");
        LanguageRegistry.addName(MyItem_2, "Crimsonate Stick");  
    
    
        MyItem_3 = new MyItem(2090, "MyItem_3").setCreativeTab(CreativeTabs.tabMaterials);
        GameRegistry.registerItem(MyItem_3, "MyItem_3");
        LanguageRegistry.addName(MyItem_3, "Flesh Ingot");  
	
    
        MyItem_4 = new MyItem(2092, "MyItem_4").setCreativeTab(CreativeTabs.tabMaterials);
        GameRegistry.registerItem(MyItem_4, "MyItem_4");
        LanguageRegistry.addName(MyItem_4, "Flesh Stick");  
    
    
        MyItem_5 = new MyItem(2098, "MyItem_5").setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64);
        GameRegistry.registerItem(MyItem_5, "MyItem_5");
        LanguageRegistry.addName(MyItem_5, "Crimsonate Shard");  
	
	
        MyItem_6 = new MyItem(2099, "MyItem_6").setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64);
        GameRegistry.registerItem(MyItem_6, "MyItem_6");
        LanguageRegistry.addName(MyItem_6, "Crimsonate Chunk");  
	
   
   
    	MyItem_7 = new MyItem(2126, "MyItem_7").setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64);
        GameRegistry.registerItem(MyItem_7, "MyItem_7");
        LanguageRegistry.addName(MyItem_7, "Corrupt Shard"); 
   
   
        MyItem_8 = new MyItem(2127, "MyItem_8").setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64);
        GameRegistry.registerItem(MyItem_8, "MyItem_8");
        LanguageRegistry.addName(MyItem_8, "Corrupt Chunk"); 
   
   
   
        MyItem_9 = new MyItem(2128, "MyItem_9").setCreativeTab(CreativeTabs.tabMaterials).setMaxStackSize(64);
        GameRegistry.registerItem(MyItem_9, "MyItem_9");
        LanguageRegistry.addName(MyItem_9, "Corrupt Ingot"); 
   
   
   
   
   
   
        MyProjectile_1 = new  MyProjectile(2101, " MyProjectile_1").setCreativeTab(CreativeTabs.tabMaterials);
        GameRegistry.registerItem( MyProjectile_1, " MyProjectile_1");
        LanguageRegistry.addName( MyProjectile_1, "The Boomstick");  
        
    
    
    
     //  AXE AREA
        MyAxe_1 = new MyAxe(2100, MyToolMaterialCrimsonatePickaxe, "MyAxe_1");
        GameRegistry.registerItem(MyAxe_1, "MyAxe_1");
        LanguageRegistry.addName(MyAxe_1, "Crimsonate Axe");  
    
 
        MyAxe_2 = new MyAxe(2121, MyToolMaterialLapisPick, "MyAxe_2");
        GameRegistry.registerItem(MyAxe_2, "MyAxe_2");
        LanguageRegistry.addName(MyAxe_2, "Lapis Axe");
    
    
 
        MyAxe_3 = new MyAxe(2122, MyToolMaterialLapisPick, "MyAxe_3");
        GameRegistry.registerItem(MyAxe_3, "MyAxe_3");
        LanguageRegistry.addName(MyAxe_3, "Redstone Axe");
    
    
    
    
    
    // SHOVEL AREA
        MyShovel_1 = new MyShovel(2118, MyToolMaterialCrimsonatePickaxe, "MyShovel_1");
        GameRegistry.registerItem(MyShovel_1, "MyShovel_1");
        LanguageRegistry.addName(MyShovel_1, "Crimsonate Spade");  
  
 
        MyShovel_2 = new MyShovel(2123, MyToolMaterialLapisPick, "MyShovel_2");
        GameRegistry.registerItem(MyShovel_2, "MyShovel_2");
        LanguageRegistry.addName(MyShovel_2, "Lapis Spade");  
  
  
  
  
  
  
  
  
        // BOW AREA
  
        MyBow_1 = new MyBow(2109);
        GameRegistry.registerItem(MyBow_1, "MyBow_1");
        LanguageRegistry.addName(MyBow_1, "Crimsonate Bow [WIP] DO NOT USE");  
  
  
    
     // FOOD AREA
                          /** First Vaule is HealPoints, Then Saturation Value, Then the last is True or False and it is saying IsWolfsFavoriteFood. */     
        MyFood_1 = new MyFood(2040, 4, 2.5F, true, "MyFood_1").setAlwaysEdible().setPotionEffect(Potion.moveSpeed.id, 45, 8, 0.3F).setPotionEffect(Potion.damageBoost.id, 5, 1, 0.1F).setCreativeTab(CreativeTabs.tabFood).setMaxStackSize(32);
        GameRegistry.registerItem(MyFood_1, "MyFood_1");
        LanguageRegistry.addName(MyFood_1, "Marshmallow"); 
 
                          /** First Vaule is HealPoints, Then Saturation Value, Then the last is True or False and it is saying IsWolfsFavoriteFood. */     
        MyFood_2 = new MyFood(2104, 6, 4.5F, true, "MyFood_2").setPotionEffect(Potion.resistance.id, 45, 8, 0.1F).setCreativeTab(CreativeTabs.tabFood).setMaxStackSize(64);
        GameRegistry.registerItem(MyFood_2, "MyFood_2");
        LanguageRegistry.addName(MyFood_2, "Gobler Meat"); 
   
                              /** First Vaule is HealPoints, Then Saturation Value, Then the last is True or False and it is saying IsWolfsFavoriteFood. */     
        MyFood_3 = new MyFood(2111, 2, 1.5F, false, "MyFood_3").setCreativeTab(CreativeTabs.tabFood).setMaxStackSize(64);
        GameRegistry.registerItem(MyFood_3, "MyFood_3");
        LanguageRegistry.addName(MyFood_3, "Cheese");
       
                                 /** First Vaule is HealPoints, Then Saturation Value, Then the last is True or False and it is saying IsWolfsFavoriteFood. */     
        MyFood_4 = new MyFood(2112, 12, 2.5F, false, "MyFood_4").setCreativeTab(CreativeTabs.tabFood).setMaxStackSize(64);
        GameRegistry.registerItem(MyFood_4, "MyFood_4");
        LanguageRegistry.addName(MyFood_4, "Pepperoni Pizza");
       
       
                                     /** First Vaule is HealPoints, Then Saturation Value, Then the last is True or False and it is saying IsWolfsFavoriteFood. */     
        MyFood_5 = new MyFood(2113, 10, 2.5F, false, "MyFood_5").setCreativeTab(CreativeTabs.tabFood).setMaxStackSize(64);
        GameRegistry.registerItem(MyFood_5, "MyFood_5");
        LanguageRegistry.addName(MyFood_5, "Cheese Pizza");
       
       
                                          /** First Vaule is HealPoints, Then Saturation Value, Then the last is True or False and it is saying IsWolfsFavoriteFood. */     
        MyFood_6 = new MyFood(2114, 2, 1.5F, false, "MyFood_6").setCreativeTab(CreativeTabs.tabFood).setMaxStackSize(64);
        GameRegistry.registerItem(MyFood_6, "MyFood_6");
        LanguageRegistry.addName(MyFood_6, "Pepperoni");
       
       
                                               /** First Vaule is HealPoints, Then Saturation Value, Then the last is True or False and it is saying IsWolfsFavoriteFood. */     
        MyFood_7 = new MyFood(2115, 0, 0.0F, false, "MyFood_7").setPotionEffect(Potion.moveSpeed.id, 200, 5, 1.0F).setAlwaysEdible().setCreativeTab(CreativeTabs.tabFood).setMaxStackSize(64);
        GameRegistry.registerItem(MyFood_7, "MyFood_7");
        LanguageRegistry.addName(MyFood_7, "Coffee");
       
       
        MyFood_8 = new MyFood(2116, 0, 0.0F, false, "MyFood_8").setAlwaysEdible().setCreativeTab(CreativeTabs.tabFood).setMaxStackSize(16);
        GameRegistry.registerItem(MyFood_8, "MyFood_8");
        LanguageRegistry.addName(MyFood_8, "Coffee Bean");
       
       
        MyFood_9 = new MyFood(2117, 0, 0.0F, false, "MyFood_9").setPotionEffect(Potion.digSpeed.id, 200, 1, 1.0F).setAlwaysEdible().setCreativeTab(CreativeTabs.tabFood).setMaxStackSize(16);
        GameRegistry.registerItem(MyFood_9, "MyFood_9");
        LanguageRegistry.addName(MyFood_9, "Latte");
    
    
        MyFood_10 = new MyFood(2119, 0, 0.0F, false, "MyFood_10").setPotionEffect(Potion.moveSpeed.id, 200, 10, 1.0F).setAlwaysEdible().setCreativeTab(CreativeTabs.tabFood).setMaxStackSize(16);
        GameRegistry.registerItem(MyFood_10, "MyFood_10");
        LanguageRegistry.addName(MyFood_10, "Uber food (Creative Only)");

    
    
    //  ARMOR AREA 
        MyHelmet_1 = new MyArmor(2060, MyArmorMaterial_1, 0, 0, "myarmor").setCreativeTab(CreativeTabs.tabCombat);
        GameRegistry.registerItem(MyHelmet_1, "MyHelmet_1");
        LanguageRegistry.addName(MyHelmet_1, "Crimsonate Helmet");      
    
    
        MyChest_1 = new MyArmor(2061, MyArmorMaterial_1, 0, 1, "myarmor").setCreativeTab(CreativeTabs.tabCombat);
        GameRegistry.registerItem(MyChest_1, "MyChest_1");
        LanguageRegistry.addName(MyChest_1, "Crimsonate Chestplate");


        MyLeggings_1 = new MyArmor(2062, MyArmorMaterial_1, 0, 2, "myarmor").setCreativeTab(CreativeTabs.tabCombat);
        GameRegistry.registerItem(MyLeggings_1, "MyLeggings_1");
        LanguageRegistry.addName(MyLeggings_1, "Crimsonate Leggings");


        MyBoots_1 = new MyArmor(2063, MyArmorMaterial_1, 0, 3, "myarmor").setCreativeTab(CreativeTabs.tabCombat);
        GameRegistry.registerItem(MyBoots_1, "MyBoots_1");
        LanguageRegistry.addName(MyBoots_1, "Crimsonate Feet");
    
        MyHelmet_2 = new MyFleshArmor(2094, MyArmorMaterial_2, 0, 0, "myflesharmor");
        GameRegistry.registerItem(MyHelmet_2, "MyHelmet_2");
        LanguageRegistry.addName(MyHelmet_2, "Flesh Helmet");      

        MyChest_2 = new MyFleshArmor(2095, MyArmorMaterial_2, 0, 1, "myflesharmor");
        GameRegistry.registerItem(MyChest_2, "MyChest_2");
        LanguageRegistry.addName(MyChest_2, "Flesh Chestplate");

        MyLeggings_2 = new MyFleshArmor(2096, MyArmorMaterial_2, 0, 2, "myflesharmor");
        GameRegistry.registerItem(MyLeggings_2, "MyLeggings_2");
        LanguageRegistry.addName(MyLeggings_2, "Flesh Legs");

        MyBoots_2 = new MyFleshArmor(2097, MyArmorMaterial_2, 0, 3, "myflesharmor");
        GameRegistry.registerItem(MyBoots_2, "MyBoots_2");
        LanguageRegistry.addName(MyBoots_2, "Flesh Greaves");
        
        MyHelmet_3 = new MyLapisArmor(2105, MyArmorMaterial_3, 0, 0, "mylapisarmor");
        GameRegistry.registerItem(MyHelmet_3, "MyHelmet_3");
        LanguageRegistry.addName(MyHelmet_3, "Lapis Helmet");      
    

        MyChest_3 = new MyLapisArmor(2106, MyArmorMaterial_3, 0, 1, "mylapisarmor");
        GameRegistry.registerItem(MyChest_3, "MyChest_3");
        LanguageRegistry.addName(MyChest_3, "Lapis Chestplate");


        MyLeggings_3 = new MyLapisArmor(2107, MyArmorMaterial_3, 0, 2, "mylapisarmor");
        GameRegistry.registerItem(MyLeggings_3, "MyLeggings_3");
        LanguageRegistry.addName(MyLeggings_3, "Lapis Legs");


        MyBoots_3 = new MyLapisArmor(2108, MyArmorMaterial_3, 0, 3, "mylapisarmor");
        GameRegistry.registerItem(MyBoots_3, "MyBoots_3");
        LanguageRegistry.addName(MyBoots_3, "Lapis Boots");
    
    

    
     //  BIOMES AREA
        MyBiome_1 = new MyBiome(30);
        GameRegistry.addBiome(MyBiome_1);
       
        MyCorruptionBiome_1 = new MyCorruptionBiome(31);
        GameRegistry.addBiome(MyCorruptionBiome_1);


        MyFlatBiome_1 = new MyFlatBiome(32);
        GameRegistry.addBiome(MyFlatBiome_1);
        
        
         MyHugeTreeBiome_1 = new MyHugeTreeBiome(33);
        GameRegistry.addBiome(MyHugeTreeBiome_1);
        
        MyIceMontainBiome_1 = new MyIceMontainBiome(34);
        GameRegistry.addBiome(MyIceMontainBiome_1);
        

        // ENTITY AREA MOBS
        EntityRegistry.registerGlobalEntityID(MyEntityZombie.class, "Face Gobler", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.addSpawn(MyEntityZombie.class, 50, 1, 5, EnumCreatureType.monster, BiomeGenBase.desert); 
        EntityRegistry.addSpawn(MyEntityZombie.class, 50, 1, 5, EnumCreatureType.monster, MyBiome_1);     
        registerEntityEgg(MyEntityZombie.class, (new Color(112, 0, 16)).getRGB(), (new Color(0, 0, 0)).getRGB());
        RenderingRegistry.registerEntityRenderingHandler(MyEntityZombie.class, new MyRenderZombie());
        ModLoader.addLocalization("entity.Face Gobler.name", "Face Gobler");
	
  
         EntityRegistry.registerGlobalEntityID(MyEntityProjectile.class, "MyProjectile_1", 1);
         EntityRegistry.registerModEntity(MyEntityProjectile.class, "MyProjectile_1", 1, this, 256, 1, true);
         LanguageRegistry.instance().addStringLocalization("entity.modid.MyProjectile_1.name", "My Awesome Projectile");
         RenderingRegistry.registerEntityRenderingHandler(MyEntityProjectile.class, new MyRenderProjectile(MyProjectile_1));
         
       
        EntityRegistry.registerGlobalEntityID(MyEntityWraith.class, "Corrupt Wraith", EntityRegistry.findGlobalUniqueEntityId());  
        EntityRegistry.addSpawn(MyEntityWraith.class, 1, 0, 0, EnumCreatureType.monster, MyCorruptionBiome_1);  
        registerEntityEgg(MyEntityWraith.class, (new Color(255, 255, 255)).getRGB(), (new Color(0, 0, 0)).getRGB());
        RenderingRegistry.registerEntityRenderingHandler(MyEntityWraith.class, new MyRenderWraith(new MyModelWraith(), 0.3F));
        ModLoader.addLocalization("entity.Corrupt Wraith.name", "Corrupt Wraith");
	
	
        EntityRegistry.registerGlobalEntityID(MyEntityWraithlord.class, "Wraith Lord", EntityRegistry.findGlobalUniqueEntityId());  
        EntityRegistry.addSpawn(MyEntityWraithlord.class, 1, 1, 1, EnumCreatureType.monster, MyBiome_1);  
        registerEntityEgg(MyEntityWraithlord.class, (new Color(255, 255, 255)).getRGB(), (new Color(0, 0, 0)).getRGB());
        RenderingRegistry.registerEntityRenderingHandler(MyEntityWraithlord.class, new MyRenderWraithlord(new MyModelWraithlord(), 0.3F));
        ModLoader.addLocalization("entity.Wraith Lord.name", "Wraith Lord");

	
	
	
	    //  REGISTER YOUR ENTITY
        EntityRegistry.registerGlobalEntityID(MyEntityOgre.class, "Ogre", EntityRegistry.findGlobalUniqueEntityId()); 
        EntityRegistry.addSpawn(MyEntityOgre.class, 50, 1, 5, EnumCreatureType.monster, MyHugeTreeBiome_1);  
        registerEntityEgg(MyEntityOgre.class, (new Color(0, 132, 199)).getRGB(), (new Color(108, 255, 155)).getRGB());
        RenderingRegistry.registerEntityRenderingHandler(MyEntityOgre.class, new MyRenderOgre(new MyModelOgre(), 0.3F));
        ModLoader.addLocalization("entity.Ogre.name", "Ogre");
        
	
	
        
	
	// ACHIEVEMENT AREA
		MyAchievement_1 = new Achievement(2001, "MyAchievement_1", -1, -1, MyItem_1, AchievementList.openInventory).registerAchievement();
		MyAchievement_2 = new Achievement(2002, "MyAchievement_2", -2, -1, MyItem_4, AchievementList.openInventory).registerAchievement();
		//	(id, "NameOfAchievement", x, y coordinates on Achievement map, icon, Required Achievement to unlock)
		// 	For no Pre-required achievement, use "(Achievement)null"	
        		
        		

        		
    

	
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

        		
        		
        		        //  PICKAXE RECIPE  
        GameRegistry.addRecipe(new ItemStack(MyPickaxe_4, 1), new Object[]
        {
                "XXX",
                " S ",
                " S ",
            'S', Item.stick,
            'X', Block.blockLapis,
            
        }); 
        		
        		
        	    		
         //  ITEM RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyItem_3, 3), new Object[]
        {
                "XXX",
                "XSX",
                "XXX",
            'S', Block.beacon,
            'X', MyItem_1,
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




//  HELMET RECIPE   
    GameRegistry.addRecipe(new ItemStack(MyHelmet_2, 1), new Object[]
    {
            "XXX",
            "X X",
        'X', MyItem_3,
    });         

//  CHESTPLATE RECIPE   
    GameRegistry.addRecipe(new ItemStack(MyChest_2, 1), new Object[]
    {
            "X X",
            "XXX",
            "XXX",
        'X', MyItem_3,
    });         

//  LEGGINGS RECIPE 
    GameRegistry.addRecipe(new ItemStack(MyLeggings_2, 1), new Object[]
    {
            "XXX",
            "X X",
            "X X",
        'X', MyItem_3,
    });         

//  BOOTS RECIPE    
    GameRegistry.addRecipe(new ItemStack(MyBoots_2, 1), new Object[]
    {
            "X X",
            "X X",
        'X', MyItem_3,
    });    




//  HELMET RECIPE   
    GameRegistry.addRecipe(new ItemStack(MyHelmet_3, 1), new Object[]
    {
            "XXX",
            "X X",
        'X', Block.blockLapis,
    });         

//  CHESTPLATE RECIPE   
    GameRegistry.addRecipe(new ItemStack(MyChest_3, 1), new Object[]
    {
            "X X",
            "XXX",
            "XXX",
        'X', Block.blockLapis,
    });         

//  LEGGINGS RECIPE 
    GameRegistry.addRecipe(new ItemStack(MyLeggings_3, 1), new Object[]
    {
            "XXX",
            "X X",
            "X X",
        'X', Block.blockLapis,
    });         

//  BOOTS RECIPE    
    GameRegistry.addRecipe(new ItemStack(MyBoots_3, 1), new Object[]
    {
            "X X",
            "X X",
        'X', Block.blockLapis,
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
        

 //  SWORD RECIPE  
        GameRegistry.addRecipe(new ItemStack(MySword_6, 1), new Object[]
        {
                "XX ",
                " XX",
                " S ",
            'S', Item.stick,
            'X', Block.blockLapis,
        }); 
        

//  CHEESE PIZZA RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyFood_5, 2), new Object[]
        {
                "SSS",
                "XXX",
            'S', MyFood_3,
            'X', Item.bread,  
        }); 




 //  CRIMSONATE INGOT RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyItem_1, 1), new Object[]
        {
                "SSS",
                "SSS",
                "SSS",
            'S', MyItem_6,
        });


 //  LUMINANT GREEN BRICKS RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyBlock_7, 8), new Object[]
        {
                "SSS",
                "SXS",
                "SSS",
            'S', MyBlock_6,
            'X', Block.glowStone,
        });




//  CRIMSONATE CHUNK RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyItem_6, 1), new Object[]
        {
                "SSS",
                "SSS",
                "SSS",
            'S', MyItem_5,
        });


//  CRIMSONATE AXE RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyAxe_1, 1), new Object[]
        {
                "SS",
                "SX",
                " X",
            'S', MyItem_1,
            'X', MyItem_2,
        });


// LAPIS AXE RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyAxe_2, 1), new Object[]
        {
                "SS",
                "SX",
                " X",
            'S', Block.blockLapis,
            'X', Item.stick,
        });



// REDSTONE AXE RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyAxe_3, 1), new Object[]
        {
                "SS",
                "SX",
                " X",
            'S', Block.blockRedstone,
            'X', Item.stick,
        });









//  CHEESE RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyFood_3, 3), new Object[]
        {
                "SSS",
            'S', Item.bucketMilk,
        });


//  PEPPERONI PIZZA RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyFood_4, 1), new Object[]
        {
                "SX",
            'S', MyFood_5,
            'X', MyFood_6,
        });


//  PEPPERONI RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyFood_6, 3), new Object[]
        {
                "SX",
            'S', Item.beefCooked,
            'X', Item.porkCooked,
        });


//  LATTE RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyFood_9, 1), new Object[]
        {
                "SX",
            'S', MyFood_7,
            'X', Item.bucketMilk,
        });



//  GREEN STONE BRICK RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyBlock_6, 8), new Object[]
        {
                "SSS",
                "SXS",
                "SSS",
            'S', Block.stoneBrick,
            'X', Item.slimeBall,
        });




//  COFFEE RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyFood_7, 1), new Object[]
        {
                "S",
                "X",
            'S', Item.bucketEmpty,
            'X', MyFood_8,
        });



//  CRIMSONATE SPADE RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyShovel_1, 1), new Object[]
        {
                "S",
                "X",
                "X",
            'S', MyItem_1,
            'X', MyItem_2,
        });




//  LAPIS SPADE RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyShovel_2, 1), new Object[]
        {
                "S",
                "X",
                "X",
            'S', Block.blockLapis,
            'X', Item.stick,
        });





//  REDSTONE SWORD RECIPE         
        GameRegistry.addRecipe(new ItemStack(MySword_7, 1), new Object[]
        {
                "S",
                "S",
                "X",
            'S', Block.blockRedstone,
            'X', Item.stick,
        });







//  BOOMSTICK RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyProjectile_1, 1), new Object[]
        {
                "SX",
            'S', Block.tnt,
            'X', Item.stick,
        });



//  CORRUPT CHUNK RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyItem_8, 1), new Object[]
        {
                "SSS",
                "SSS",
                "SSS",
            'S', MyItem_7,
        });





//  CORRUPT INGOT RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyItem_9, 2), new Object[]
        {
                "SSS",
                "SSS",
                "SSS",
            'S', MyItem_8,
        });





//  SMELTING RECIPE
        GameRegistry.addSmelting(MyBlock_5.blockID, (new ItemStack(MyFood_8, 2)), 45);




/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
/**	
 * EXTRA METHODS SECTION 
 * *********************************************************** */


     //  REGISTER THE ORE GENERATION 
    GameRegistry.registerWorldGenerator(new MyBlockGen());
        
 //	CHANGE THE TEXT OF THE ACHIEVEMENTS	
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_1", "en_US", "Awesome thing");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_1.desc", "en_US", "Congrats yo");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_2", "en_US", "Awesome Thing2");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_2.desc", "en_US", "Test one");

  //  REGISTER PICKUP HANDLER
        MyPickupHandler MyPickupHandler_1 = new MyPickupHandler();
        GameRegistry.registerPickupHandler(MyPickupHandler_1);  
         
         
             //  REGISTER CRAFTING HANDLER
        MyCraftingHandler MyCraftingHandler_1 = new MyCraftingHandler();
        GameRegistry.registerCraftingHandler(MyCraftingHandler_1);  


/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
	}

@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) 
	{

	}
	
}
