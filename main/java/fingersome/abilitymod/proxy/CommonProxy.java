package fingersome.abilitymod.proxy;

import fingersome.abilitymod.entity.capability.AbilityCha;
import fingersome.abilitymod.entity.capability.AbilityCon;
import fingersome.abilitymod.entity.capability.AbilityDex;
import fingersome.abilitymod.entity.capability.AbilityInt;
import fingersome.abilitymod.entity.capability.AbilityStorage;
import fingersome.abilitymod.entity.capability.AbilityStr;
import fingersome.abilitymod.entity.capability.AbilityWis;
import fingersome.abilitymod.entity.capability.IAbilityScore;
import fingersome.abilitymod.network.PacketHandler;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy 
{

	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("Proxy PreInit");

		CapabilityManager.INSTANCE.register(IAbilityScore.class, new AbilityStorage(), AbilityScore.class);

		PacketHandler.registerMessages();
	}

	public void init(FMLInitializationEvent event) {
		
	}

	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
