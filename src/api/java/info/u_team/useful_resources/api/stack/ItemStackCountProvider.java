package info.u_team.useful_resources.api.stack;

import info.u_team.useful_resources.api.resource.IResource;
import info.u_team.useful_resources.api.type.ItemResourceType;
import net.minecraft.item.*;
import net.minecraft.util.IItemProvider;

public class ItemStackCountProvider implements IItemCountProvider {
	
	private final ItemStack stack;
	
	public ItemStackCountProvider(IResource resource, ItemResourceType type, int count) {
		this(resource.getItems().get(type), count);
	}
	
	public ItemStackCountProvider(IItemProvider item, int count) {
		this(new ItemStack(item, count));
	}
	
	public ItemStackCountProvider(ItemStack stack) {
		this.stack = stack;
	}
	
	@Override
	public Item asItem() {
		return stack.getItem();
	}
	
	@Override
	public int getCount() {
		return stack.getCount();
	}
	
	@Override
	public ItemStack getItemStack() {
		return stack.copy();
	}
	
}
