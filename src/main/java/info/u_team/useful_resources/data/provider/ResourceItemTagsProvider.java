package info.u_team.useful_resources.data.provider;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.*;

import info.u_team.u_team_core.data.*;
import info.u_team.u_team_core.util.TagUtil;
import info.u_team.useful_resources.api.ResourceRegistry;
import info.u_team.useful_resources.api.resource.IResource;
import info.u_team.useful_resources.api.type.*;
import info.u_team.useful_resources.resources.Resources;
import net.minecraft.item.*;
import net.minecraft.tags.Tag;
import net.minecraft.tags.Tag.Builder;
import net.minecraft.util.ResourceLocation;

public class ResourceItemTagsProvider extends CommonItemTagsProvider {
	
	public ResourceItemTagsProvider(GenerationData data) {
		super(data);
	}
	
	@Override
	protected void registerTags() {
		ResourceRegistry.getResources().forEach(resource -> {
			resource.iterateRegistryBlocks((type, block) -> {
				if (type.hasTag()) {
					copy(type.getTag(resource), TagUtil.fromBlockTag(type.getTag(resource)));
				}
				if (type.hasUnifyTag()) {
					copy(type.getUnifyTag(), TagUtil.fromBlockTag(type.getUnifyTag()));
				}
			});
			
			addMoreCommonTag(resource, new ResourceLocation("forge", "ores"), BlockResourceType.ORE, BlockResourceType.NETHER_ORE);
			// final boolean hasOre = resource.getBlocks().containsKey(BlockResourceType.ORE);
			// final boolean hasNetherOre = resource.getBlocks().containsKey(BlockResourceType.NETHER_ORE);
			// if (hasOre || hasNetherOre) {
			// final Tag<Item> tag = TagUtil.createItemTag("forge", "ores/" + resource.getName());
			// final Builder<Item> builder = getBuilder(tag);
			// if (hasOre) {
			// builder.add(TagUtil.fromBlockTag(BlockResourceType.ORE.getTag(resource)));
			// }
			// if (hasNetherOre) {
			// builder.add(TagUtil.fromBlockTag(BlockResourceType.NETHER_ORE.getTag(resource)));
			// }
			// getBuilder(Tags.Items.ORES).add(tag);
			// }
		});
		
		ResourceRegistry.getResources().forEach(resource -> {
			resource.iterateRegistryItems((type, item) -> {
				if (type.hasTag()) {
					final Tag<Item> tag = type.getTag(resource);
					getBuilder(tag).add(item);
					if (type.hasUnifyTag()) {
						getBuilder(type.getUnifyTag()).add(tag);
					}
				}
			});
		});
		
		getBuilder(TagUtil.createItemTag("forge", "tools")).add(ItemResourceType.AXE.getUnifyTag(), ItemResourceType.HOE.getUnifyTag(), ItemResourceType.PICKAXE.getUnifyTag(), ItemResourceType.SHOVEL.getUnifyTag(), ItemResourceType.SWORD.getUnifyTag());
		getBuilder(TagUtil.createItemTag("forge", "armors")).add(ItemResourceType.HELMET.getUnifyTag(), ItemResourceType.CHESTPLATE.getUnifyTag(), ItemResourceType.LEGGINGS.getUnifyTag(), ItemResourceType.BOOTS.getUnifyTag());
		
		// Special tags
		
		// Add vanilla ores to the right tags
		copyBlockTag(BlockResourceType.ORE, Resources.IRON);
		copyBlockTag(BlockResourceType.ORE, Resources.GOLD);
		copyBlockTag(BlockResourceType.ORE, Resources.DIAMOND);
		copyBlockTag(BlockResourceType.ORE, Resources.EMERALD);
		copyBlockTag(BlockResourceType.ORE, Resources.LAPIS);
		copyBlockTag(BlockResourceType.NETHER_ORE, Resources.QUARTZ);
		copyBlockTag(BlockResourceType.ORE, Resources.COAL);
		copyBlockTag(BlockResourceType.ORE, Resources.REDSTONE);
		
		// Add coal to the coal gem tag
		addItemTag(ItemResourceType.GEM, Resources.COAL, Items.COAL);
	}
	
	private void addMoreCommonTag(IResource resource, ResourceLocation baseTag, BlockResourceType... types) {
		final Map<BlockResourceType, Boolean> hasType = Stream.of(types).collect(Collectors.toMap( //
				Function.identity(), //
				type -> resource.getBlocks().containsKey(type), //
				(key, value) -> {
					throw new IllegalStateException(String.format("Duplicate key %s", key));
				}, LinkedHashMap::new));
		if (hasType.containsValue(true)) {
			final Tag<Item> tag = TagUtil.createItemTag(baseTag.getNamespace(), baseTag.getPath() + "/" + resource.getName());
			final Builder<Item> builder = getBuilder(tag);
			hasType.entrySet().stream().filter(entry -> entry.getValue().equals(true)).map(Entry::getKey).forEach(type -> {
				builder.add(TagUtil.fromBlockTag(type.getTag(resource)));
			});
			getBuilder(TagUtil.createItemTag(baseTag)).add(tag);
		}
	}
	
	private void addItemTag(ItemResourceType type, IResource resource, Item item) {
		final Tag<Item> tag = type.getTag(resource);
		getBuilder(tag).add(item);
		getBuilder(type.getUnifyTag()).add(tag);
	}
	
	private void copyBlockTag(BlockResourceType type, IResource resource) {
		copy(type.getTag(resource), TagUtil.fromBlockTag(type.getTag(resource)));
		copy(type.getUnifyTag(), TagUtil.fromBlockTag(type.getUnifyTag()));
	}
}
