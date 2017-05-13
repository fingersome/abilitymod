package fingersome.abilitymod.command;

import java.util.ArrayList;
import java.util.List;

import fingersome.abilitymod.entity.capability.AbilityCha;
import fingersome.abilitymod.entity.capability.AbilityCon;
import fingersome.abilitymod.entity.capability.AbilityDex;
import fingersome.abilitymod.entity.capability.AbilityInt;
import fingersome.abilitymod.entity.capability.AbilityScoreProvider;
import fingersome.abilitymod.entity.capability.AbilityStr;
import fingersome.abilitymod.entity.capability.AbilityWis;
import fingersome.abilitymod.entity.capability.IAbilityScore;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class CommandAbilityQuery implements ICommand {

    ArrayList aliases = new ArrayList(); 
    
    public CommandAbilityQuery() 
    { 
        aliases.add("abilityquery"); 
        aliases.add("ability"); 
    } 

	@Override
	public int compareTo(ICommand o) {
		return 0;
	}

	@Override
	public String getName() {
		return "abilityquery";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "/abilityquery";
	}

	@Override
	public List<String> getAliases() {
		return aliases;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

		 World world = server.getEntityWorld();	 
		 EntityPlayer player = Minecraft.getMinecraft().player;
		 
		 AbilityStr Str = new AbilityStr();
		 AbilityDex Dex = new AbilityDex();
		 AbilityCon Con = new AbilityCon();
		 AbilityInt Int = new AbilityInt();
		 AbilityWis Wis = new AbilityWis();
		 AbilityCha Cha = new AbilityCha();
		 
		 int scoreStr = Str.getAbilityScore();
		 int scoreDex = Dex.getAbilityScore();
		 int scoreCon = Con.getAbilityScore();
		 int scoreInt = Int.getAbilityScore();
		 int scoreWis = Wis.getAbilityScore();
		 int scoreCha = Cha.getAbilityScore();

		 String labelStr = Str.getAbilityName();
		 String labelDex = Dex.getAbilityName();
		 String labelCon = Con.getAbilityName();
		 String labelInt = Int.getAbilityName();
		 String labelWis = Wis.getAbilityName();
		 String labelCha = Cha.getAbilityName();
		 
		 player.sendMessage(new TextComponentString((TextFormatting.RED) 			+ labelStr + (TextFormatting.WHITE) + " " + scoreStr));
		 player.sendMessage(new TextComponentString((TextFormatting.GREEN) 			+ labelDex + (TextFormatting.WHITE) + " " + scoreDex));
		 player.sendMessage(new TextComponentString((TextFormatting.YELLOW)			+ labelCon + (TextFormatting.WHITE) + " " + scoreCon));
		 player.sendMessage(new TextComponentString((TextFormatting.AQUA) 			+ labelInt + (TextFormatting.WHITE) + " " + scoreInt));
		 player.sendMessage(new TextComponentString((TextFormatting.LIGHT_PURPLE) 	+ labelWis + (TextFormatting.WHITE) + " " + scoreWis));
		 player.sendMessage(new TextComponentString((TextFormatting.DARK_PURPLE)	+ labelCha + (TextFormatting.WHITE) + " " + scoreCha ));
			 
	}
			 
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return true;
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,	BlockPos targetPos) {
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return false;
	}

}
