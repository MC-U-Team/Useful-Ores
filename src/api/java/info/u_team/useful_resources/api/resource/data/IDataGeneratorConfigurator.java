package info.u_team.useful_resources.api.resource.data;

import java.util.Map;
import java.util.function.Supplier;

import info.u_team.useful_resources.api.type.BlockResourceType;
import info.u_team.useful_resources.api.worldgen.WorldGenFeatures;
import net.minecraft.loot.LootTable;

public interface IDataGeneratorConfigurator {
	
	ResourceType getResourceType();
	
	Map<String, Supplier<WorldGenFeatures>> getWorldGeneration();
	
	Map<BlockResourceType, Supplier<LootTable>> getExtraLootTables();
	
	Map<String, Object> getExtraProperties();
	
	void clearDataGeneratorConfig();
	
	public enum ResourceType {
		
		INGOT("ingot"),
		GEM("gem"),
		DUST("dust"),
		BLOCK("block");
		
		private final String name;
		
		private ResourceType(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
	}
	
}
