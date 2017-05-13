package fingersome.abilitymod.item.baubles;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import baubles.api.BaubleType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemStack;

public abstract class ItemBaublesModifers extends ItemBaublesBase {
	
	
final Multimap<String, AttributeModifier> attributes = HashMultimap.create();

public ItemBaublesModifers(String name, BaubleType type, boolean addToTab) {
		super(name, type, addToTab);
	}
	
	@Override
	public void onEquippedOrLoadedIntoWorld(ItemStack stack, EntityLivingBase player) {
		attributes.clear();
		fillModifiers(attributes, stack);
		player.getAttributeMap().applyAttributeModifiers(attributes);
	}

	@Override
	public void onUnequipped(ItemStack stack, EntityLivingBase player) {
		attributes.clear();
		fillModifiers(attributes, stack);
		player.getAttributeMap().removeAttributeModifiers(attributes);
	}

	abstract void fillModifiers(Multimap<String, AttributeModifier> attributes, ItemStack stack);

	
	}

