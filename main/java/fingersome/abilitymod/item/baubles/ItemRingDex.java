package fingersome.abilitymod.item.baubles;

import java.util.List;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.cap.IBaublesItemHandler;
import fingersome.abilitymod.AbilityMod;
import fingersome.abilitymod.ModInfo;
import fingersome.abilitymod.item.ItemInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemRingDex extends ItemBaublesRing {

	 public ItemRingDex(String name, boolean addToTab) {
		super(name, addToTab);
        setUnlocalizedName(name);
        setCreativeTab(AbilityMod.tab);
        setMaxStackSize(1);
	}

	 	@Override
	    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
	        tooltip.add("+1 Dexterity");
	        super.addInformation(stack, player, tooltip, advanced);
	    }
 
		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
			if(!world.isRemote) { 
				IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
				for(int i = 0; i < baubles.getSlots(); i++) 
					if((baubles.getStackInSlot(i) == null || baubles.getStackInSlot(i).isEmpty()) && baubles.isItemValidForSlot(i, player.getHeldItem(hand), player)) {
						baubles.setStackInSlot(i, player.getHeldItem(hand).copy());
						if(!player.capabilities.isCreativeMode){
							player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
						}
						onEquipped(player.getHeldItem(hand), player);
						break;
					}
			}
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
		}

		@Override
		public void onWornTick(ItemStack itemstack, EntityLivingBase player) {

		}

		@Override
		public boolean hasEffect(ItemStack stack) {
			return false;
		}

		@Override
		public EnumRarity getRarity(ItemStack stack) {
			return EnumRarity.UNCOMMON;
		}

		@Override
		public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
			player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, .75F, 1.9f);
		}

		@Override
		public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
			player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, .75F, 2f);
		}

	    
		public static void registerRender(Item item) {

	        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(ModInfo.MODID + ":" + ItemInfo.ITEM_RING_DEX_UNLOCALIZED, "inventory"));		
		}

}
