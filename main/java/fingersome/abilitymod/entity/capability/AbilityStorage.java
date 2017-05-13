package fingersome.abilitymod.entity.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

/**

 * This class is responsible for saving and reading ability score data from or to server

 */

public class AbilityStorage implements IStorage<IAbilityScore>

{

 @Override

 public NBTBase writeNBT(Capability<IAbilityScore> capability, IAbilityScore instance, EnumFacing side)

 {

 return new NBTTagFloat(instance.getAbilityScore());

 }



 @Override

 public void readNBT(Capability<IAbilityScore> capability, IAbilityScore instance, EnumFacing side, NBTBase nbt)

 {

 instance.setAbilityScore(((NBTPrimitive) nbt).getInt());

 }

}