package info.u_team.useful_resources.data.provider;

import static info.u_team.useful_resources.util.LootTableUtil.createDoorBlockLootTable;

import java.util.Map;
import java.util.function.*;

import info.u_team.u_team_core.data.*;
import info.u_team.useful_resources.api.type.BlockResourceType;
import info.u_team.useful_resources.data.resource.GenerationResources;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;

public class ResourceLootTablesProvider extends CommonLootTablesProvider {
	
	public ResourceLootTablesProvider(GenerationData data) {
		super(data);
	}
	
	@Override
	protected void registerLootTables(BiConsumer<ResourceLocation, LootTable> consumer) {
		GenerationResources.forEach(resource -> {
			resource.iterateRegistryBlocks((type, block) -> {
				final LootTable lootTable;
				final Map<BlockResourceType, Supplier<LootTable>> extraLootTables = resource.getDataGeneratorConfigurator().getExtraLootTables();
				if (block.getLootTable().equals(LootTables.EMPTY)) {
					lootTable = null;
				} else if (extraLootTables.containsKey(type)) {
					lootTable = extraLootTables.get(type).get();
				} else if (type == BlockResourceType.DOOR) {
					lootTable = createDoorBlockLootTable(block, block);
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
