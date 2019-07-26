package info.u_team.useful_resources.api;

import info.u_team.u_team_core.api.registry.IUArrayRegistryType;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.Tag;

public interface IResourceBlocks extends IUArrayRegistryType<Block> {
	
	IResource getResource();
	
	Block getBlock(IBlockResourceTypes type);
	
	boolean hasBlock(IBlockResourceTypes type);
	
	default Tag<Block> getBlockTag(IBlockResourceTypes type) {
		return type.getBlockTag(this);
	}
	
	default Tag<Item> getTag(IBlockResourceTypes type) {
		return type.getTag(this);
	}
	
	default Tag<Block> getUnifyBlockTag(IBlockResourceTypes type) {
		return type.getUnifyBlockTag();
	}
	
	default Tag<Item> getUnifyTag(IBlockResourceTypes type) {
		return type.getUnifyTag();
	}
	
}
