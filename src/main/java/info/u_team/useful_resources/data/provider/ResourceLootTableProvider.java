package info.u_team.useful_resources.data.provider;

import java.util.function.BiConsumer;

import info.u_team.u_team_core.data.*;
import info.u_team.useful_resources.api.ResourceRegistry;
import info.u_team.useful_resources.api.resource.data.OreType;
import info.u_team.useful_resources.api.type.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTable;

public class ResourceLootTableProvider extends CommonLootTablesProvider {
	
	public ResourceLootTableProvider(GenerationData data) {
		super(data);
	}
	
	@Override
	protected void registerLootTables(BiConsumer<ResourceLocation, LootTable> consumer) {
		ResourceRegistry.getResources().forEach(resource -> {
			resource.getBlocks().forEach((type, block) -> {
				final LootTable lootTable;
				if (type == BlockResourceType.MOLTEN_BLOCK) {
					lootTable = null;
				} else if (resource.getDataGeneratorConfigurator().getOreType() == OreType.GEM) {
					lootTable = addFortuneBlockLootTable(block, resource.getItems().get(ItemResourceType.BOOTS)); // SET GEM THERE WHEN WE HAVE A GEM TYPE
				} else {
					lootTable = addBasicBlockLootTable(block);
				}
				if (lootTable != null) {
					registerBlock(block, lootTable, consumer);
				}
			});
		});
	}
}
