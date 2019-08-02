package info.u_team.useful_resources.item;

import info.u_team.u_team_core.item.tool.UPickaxeItem;
import info.u_team.useful_resources.api.resource.IResource;
import info.u_team.useful_resources.api.resource.config.IResourceItemConfig;
import info.u_team.useful_resources.api.resource.type.IResourceItemType;
import info.u_team.useful_resources.init.UsefulResourcesItemGroups;
import info.u_team.useful_resources.type.ResourceItemTypes;
import net.minecraft.item.ItemStack;

public class ResourcePickaxeItem extends UPickaxeItem {
	
	private final IResource resource;
	
	public ResourcePickaxeItem(IResource resource, IResourceItemType type, IResourceItemConfig config) {
		super(resource.getName() + "_" + type.getName(), UsefulResourcesItemGroups.GROUP, new Properties().rarity(config.getRarity()), resource.getItems().getToolMaterial());
		this.resource = resource;
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == resource.getItems().getItem(ResourceItemTypes.INGOT);
	}
	
}
