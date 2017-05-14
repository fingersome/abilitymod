package fingersome.abilitymod.item;

import fingersome.abilitymod.ModInfo;
import fingersome.abilitymod.item.baubles.ItemRingCha;
import fingersome.abilitymod.item.baubles.ItemRingCon;
import fingersome.abilitymod.item.baubles.ItemRingDex;
import fingersome.abilitymod.item.baubles.ItemRingInt;
import fingersome.abilitymod.item.baubles.ItemRingStr;
import fingersome.abilitymod.item.baubles.ItemRingWis;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemList 
{
	
	//DECLARE ITEMS

	public static Item itemTome;
	public static Item itemRingStr;
	public static Item itemRingDex;
	public static Item itemRingCon;
	public static Item itemRingInt;
	public static Item itemRingWis;
	public static Item itemRingCha;
	

	    public static void init() {

	        itemTome		= new ItemTome			(ItemInfo.ITEM_TOME_UNLOCALIZED);
	        itemRingStr		= new ItemRingStr		(ItemInfo.ITEM_RING_STR_UNLOCALIZED, true);
	        itemRingDex		= new ItemRingDex		(ItemInfo.ITEM_RING_DEX_UNLOCALIZED, true);
	        itemRingCon		= new ItemRingCon		(ItemInfo.ITEM_RING_CON_UNLOCALIZED, true);
	        itemRingInt		= new ItemRingInt		(ItemInfo.ITEM_RING_INT_UNLOCALIZED, true);
	        itemRingWis		= new ItemRingWis		(ItemInfo.ITEM_RING_WIS_UNLOCALIZED, true);
	        itemRingCha		= new ItemRingCha		(ItemInfo.ITEM_RING_CHA_UNLOCALIZED, true);
	        
	        registerItems();
	    }

	    public static void registerItems() {

	        GameRegistry.register(itemTome, 	new ResourceLocation(ModInfo.MODID, ItemInfo.ITEM_TOME_UNLOCALIZED));
	        GameRegistry.register(itemRingStr, 	new ResourceLocation(ModInfo.MODID, ItemInfo.ITEM_RING_STR_UNLOCALIZED));
	        GameRegistry.register(itemRingDex, 	new ResourceLocation(ModInfo.MODID, ItemInfo.ITEM_RING_DEX_UNLOCALIZED));
	        GameRegistry.register(itemRingCon, 	new ResourceLocation(ModInfo.MODID, ItemInfo.ITEM_RING_CON_UNLOCALIZED));
	        GameRegistry.register(itemRingInt, 	new ResourceLocation(ModInfo.MODID, ItemInfo.ITEM_RING_INT_UNLOCALIZED));
	        GameRegistry.register(itemRingWis, 	new ResourceLocation(ModInfo.MODID, ItemInfo.ITEM_RING_WIS_UNLOCALIZED));
	        GameRegistry.register(itemRingCha, 	new ResourceLocation(ModInfo.MODID, ItemInfo.ITEM_RING_CHA_UNLOCALIZED));
	    }
	    
	    public static void registerRenders() {      

	    	ItemTome.registerRender			(itemTome);
	    	ItemRingStr.registerRender		(itemRingStr);
	    	ItemRingDex.registerRender		(itemRingDex);
	    	ItemRingCon.registerRender		(itemRingCon);
	    	ItemRingInt.registerRender		(itemRingInt);
	    	ItemRingWis.registerRender		(itemRingWis);
	    	ItemRingCha.registerRender		(itemRingCha);
	    	
	    }

	  
		
}
	    
	   

