package fingersome.abilitymod;

import fingersome.abilitymod.command.CommandAbilityQuery;
import fingersome.abilitymod.config.ConfigManager;
import fingersome.abilitymod.entity.capability.CapabilityHandler;
import fingersome.abilitymod.event.EventManager;
import fingersome.abilitymod.item.ItemList;
import fingersome.abilitymod.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = ModInfo.MODID, version = ModInfo.VERSION)
public class AbilityMod
{
    @SidedProxy(clientSide = "fingersome.abilitymod.proxy.ClientProxy",
    			serverSide = "fingersome.abilitymod.proxy.ServerProxy")

	public static CommonProxy proxy;
	public static ItemList items;

	@Instance(ModInfo.MODID)
	public static AbilityMod instance;

	public static CreativeTabs tab = new CreativeTabs("abilitymod") {
    	@Override
    	public String getTabLabel() {
    		return "abilitymod";
    	}
    	
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemList.itemTome,1);
		}
	};
	
	 @EventHandler
	 public void preinit(FMLPreInitializationEvent event) 
	 {    
	     // DEBUG
	     System.out.println("preInit()" + event.getModMetadata().name);
			MinecraftForge.EVENT_BUS.register(new ConfigManager());
			MinecraftForge.EVENT_BUS.register(new EventManager());
	     	MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
		
	    ConfigManager.init(event.getSuggestedConfigurationFile());
	   
	 	items.init();
		proxy.preInit(event);
	     
	 }
	 

	@EventHandler
	 public void init(FMLInitializationEvent event) 
	 {
	     // DEBUG
	     System.out.println("init()");
	
	 	proxy.init(event);
	  
	 }
	
	 @EventHandler
	 public void postinit(FMLPostInitializationEvent event)
	 {
	     // DEBUG
	     System.out.println("postInit()");
	       
	
	 	proxy.postInit(event);
	 }
 
	 @EventHandler
	 public void serverLoad(FMLServerStartingEvent event)
	 {
	     // register server commands
		 event.registerServerCommand(new CommandAbilityQuery());
	 }
		
}
