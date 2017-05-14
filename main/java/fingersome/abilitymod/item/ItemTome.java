package fingersome.abilitymod.item;

import java.util.List;

import fingersome.abilitymod.AbilityMod;
import fingersome.abilitymod.ModInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemTome extends Item {

    public ItemTome(String name) {
        setUnlocalizedName(name);
        setCreativeTab(AbilityMod.tab);
    }   

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add("Debug item, used to view your character's ability scores");
        super.addInformation(stack, playerIn, tooltip, advanced);
    }

    //Changes name colour in tooltip
    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.COMMON;
    }

    //Displays enchantment glow
    @Override
    public boolean hasEffect(ItemStack stack) {
        return false;
    }

	public static void registerRender(Item item) {
		
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(ModInfo.MODID + ":" + ItemInfo.ITEM_TOME_UNLOCALIZED, "inventory"));
	}
}