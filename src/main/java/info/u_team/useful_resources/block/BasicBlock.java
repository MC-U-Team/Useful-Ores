package info.u_team.useful_resources.block;

import info.u_team.useful_resources.init.UsefulResourcesItemGroups;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.*;
import net.minecraftforge.common.ToolType;

public class BasicBlock extends ParticleBlock {
	
	public BasicBlock(Rarity rarity, int harvestLevel, float hardness, float resistance) {
		super(UsefulResourcesItemGroups.GROUP, Properties.create(Material.IRON).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(harvestLevel).setRequiresTool().hardnessAndResistance(hardness, resistance), new Item.Properties().rarity(rarity));
	}
	
}
