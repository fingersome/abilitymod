package fingersome.abilitymod.item;

import fingersome.abilitymod.ModInfo;
import fingersome.abilitymod.item.baubles.ItemRingStr;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemList 
{
	
	//DECLARE ITEMS

	public static Item itemTome;
	public static Item itemRingStr;
	

	    public static void init() {

	        itemTome		= new ItemTome			(ItemInfo.ITEM_TOME_UNLOCALIZED);
	        itemRingStr		= new ItemRingStr		(ItemInfo.ITEM_RING_STR_UNLOCALIZED, true);
	        
	        registerItems();
	    }

	    public static void registerItems() {

	        GameRegistry.register(itemTome, 	new ResourceLocation(ModInfo.MODID, ItemInfo.ITEM_TOME_UNLOCALIZED));
	        GameRegistry.register(itemRingStr, 	new ResourceLocation(ModInfo.MODID, ItemInfo.ITEM_RING_STR_UNLOCALIZED));
	    }
	    
	    public static void registerRenders() {      

	    	ItemTome.registerRender			(itemTome);
	    	ItemRingStr.registerRender		(itemRingStr);
	    	
	    }

	  
		
}
	    
	   

