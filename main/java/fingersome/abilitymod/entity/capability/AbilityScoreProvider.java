package fingersome.abilitymod.entity.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

/**

 * Ability provider

 *

 * This class is responsible for providing a capability. Other modders may

 * attach their own provider with implementation that returns another

 * implementation of IAbilityScore to the target's (Entity, TE, ItemStack, etc.) disposal.

 */

public class AbilityScoreProvider implements ICapabilitySerializable<NBTBase>

{

 @CapabilityInject(IAbilityScore.class)
 public static final Capability<IAbilityScore> PLAYER_ABILITY = null;
 private IAbilityScore instance = PLAYER_ABILITY.getDefaultInstance();

	 @Override
	 public boolean hasCapability(Capability<?> capability, EnumFacing facing) {

		 return capability == PLAYER_ABILITY;
	
	 }

	 @Override
	 public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
	
		 return capability == PLAYER_ABILITY ? PLAYER_ABILITY.<T> cast(this.instance) : null;
	
	 }
	 
	 @Override
	 public NBTBase serializeNBT() {

		 return PLAYER_ABILITY.getStorage().writeNBT(PLAYER_ABILITY, this.instance, null);

	 }

	 @Override
	 public void deserializeNBT(NBTBase nbt) {

		 PLAYER_ABILITY.getStorage().readNBT(PLAYER_ABILITY, this.instance, null, nbt);

	 }

}