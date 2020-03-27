package info.u_team.useful_resources.resources;

import static info.u_team.useful_resources.api.type.BlockResourceType.*;
import static info.u_team.useful_resources.api.type.ItemResourceType.*;
import static info.u_team.useful_resources.util.GenerationUtil.*;
import static info.u_team.useful_resources.util.LootTableUtil.createFortuneBlockLootTableWithCount;
import static info.u_team.useful_resources.util.MaterialUtil.*;

import info.u_team.useful_resources.api.ResourceRegistry;
import info.u_team.useful_resources.api.resource.IResource;
import info.u_team.useful_resources.api.resource.special.*;
import info.u_team.useful_resources.util.LootTableUtil;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;

public class Resources {
	
	// VANILLA
	
	public static final IResource IRON = new VanillaIngotResource("iron", 0xf5f5f5, 1, 3, 3) //
			.setExisting(ORE, Blocks.IRON_ORE) //
			.setExisting(BLOCK, Blocks.IRON_BLOCK) //
			.setExisting(INGOT, Items.IRON_INGOT) //
			.setExisting(NUGGET, Items.IRON_NUGGET) //
			.setExisting(HELMET, Items.IRON_HELMET) //
			.setExisting(CHESTPLATE, Items.IRON_CHESTPLATE) //
			.setExisting(LEGGINGS, Items.IRON_LEGGINGS) //
			.setExisting(BOOTS, Items.IRON_BOOTS) //
			.setExisting(HORSE_ARMOR, Items.IRON_HORSE_ARMOR) //
			.setExisting(AXE, Items.IRON_AXE) //
			.setExisting(HOE, Items.IRON_HOE) //
			.setExisting(PICKAXE, Items.IRON_PICKAXE) //
			.setExisting(SHOVEL, Items.IRON_SHOVEL) //
			.setExisting(SWORD, Items.IRON_SWORD) //
			.setGenerationDefault(NETHER_ORE, state -> createOreFeatureRangeNether(state, 9, 10, 10, 20, 128));
	
	public static final IResource GOLD = new VanillaIngotResource("gold", 0xfff373, 2, 3, 3) //
			.setExisting(ORE, Blocks.GOLD_ORE) //
			.setExisting(BLOCK, Blocks.GOLD_BLOCK) //
			.setExisting(INGOT, Items.GOLD_INGOT) //
			.setExisting(NUGGET, Items.GOLD_NUGGET) //
			.setExisting(HELMET, Items.GOLDEN_HELMET) //
			.setExisting(CHESTPLATE, Items.GOLDEN_CHESTPLATE) //
			.setExisting(LEGGINGS, Items.GOLDEN_LEGGINGS) //
			.setExisting(BOOTS, Items.GOLDEN_BOOTS) //
			.setExisting(HORSE_ARMOR, Items.GOLDEN_HORSE_ARMOR) //
			.setExisting(AXE, Items.GOLDEN_AXE) //
			.setExisting(HOE, Items.GOLDEN_HOE) //
			.setExisting(PICKAXE, Items.GOLDEN_PICKAXE) //
			.setExisting(SHOVEL, Items.GOLDEN_SHOVEL) //
			.setExisting(SWORD, Items.GOLDEN_SWORD) //
			.setGenerationDefault(NETHER_ORE, state -> createOreFeatureRangeNether(state, 9, 10, 10, 20, 128));
	
	public static final IResource DIAMOND = new VanillaGemResource("diamond", 0x1cb5e8, 2, 3, 3, NETHER_ORE, 3, 7) //
			.setExisting(ORE, Blocks.DIAMOND_ORE) //
			.setExisting(BLOCK, Blocks.DIAMOND_BLOCK) //
			.setExisting(GEM, Items.DIAMOND) //
			.setExisting(HELMET, Items.DIAMOND_HELMET) //
			.setExisting(CHESTPLATE, Items.DIAMOND_CHESTPLATE) //
			.setExisting(LEGGINGS, Items.DIAMOND_LEGGINGS) //
			.setExisting(BOOTS, Items.DIAMOND_BOOTS) //
			.setExisting(HORSE_ARMOR, Items.DIAMOND_HORSE_ARMOR) //
			.setExisting(AXE, Items.DIAMOND_AXE) //
			.setExisting(HOE, Items.DIAMOND_HOE) //
			.setExisting(PICKAXE, Items.DIAMOND_PICKAXE) //
			.setExisting(SHOVEL, Items.DIAMOND_SHOVEL) //
			.setExisting(SWORD, Items.DIAMOND_SWORD) //
			.setLootTableWithFortune(NETHER_ORE, GEM, LootTableUtil::createFortuneBlockLootTable) //
			.setGenerationDefault(NETHER_ORE, state -> createOreFeatureRangeNether(state, 8, 1, 0, 0, 128));
	
	public static final IResource EMERALD = new VanillaGemResource("emerald", 0x0ccf4a, 2, 3, true) //
			.setExisting(ORE, Blocks.EMERALD_ORE) //
			.setExisting(BLOCK, Blocks.EMERALD_BLOCK) //
			.setExisting(GEM, Items.EMERALD) //
			.setArmor(createArmor(33, new int[] { 3, 6, 8, 3 }, 11)) //
			.setHorseArmor(11) //
			.setTools(createTools(new float[] { 5.0F, 0, 1, 1.5F, 3 }, new float[] { -3.0F, 0, -2.8F, -3, -2.4F }, 3, 1561, 8, 3, 10)) //
			.setLootTableWithFortune(NETHER_ORE, GEM, LootTableUtil::createFortuneBlockLootTable) //
			.setGenerationDefault(NETHER_ORE, state -> createOreFeatureRangeNether(state, 6, 1, 0, 0, 128));
	
	public static final IResource LAPIS = new VanillaGemResource("lapis", 0x1037e6, 1, 3, true) //
			.setExisting(ORE, Blocks.LAPIS_ORE) //
			.setExisting(BLOCK, Blocks.LAPIS_BLOCK) //
			.setExisting(GEM, Items.LAPIS_LAZULI) //
			.setArmor(createArmor(20, new int[] { 3, 5, 7, 3 }, 20)) //
			.setHorseArmor(9) //
			.setTools(createTools(new float[] { 4.5F, 0, 1, 1.5F, 2.5F }, new float[] { -3.0F, 0, -2.8F, -3, -2.4F }, 2, 500, 7, 3, 20)) //
			.setLootTableWithFortune(NETHER_ORE, GEM, (ore, drop) -> createFortuneBlockLootTableWithCount(ore, drop, 4, 9)) //
			.setGenerationDefault(NETHER_ORE, state -> createOreFeatureDeathAverageNether(state, 7, 1, 64, 64));
	
	public static final IResource QUARTZ = new VanillaGemResource("quartz", 0xfcfcf7, 1, 3, false) //
			.setExisting(NETHER_ORE, Blocks.NETHER_QUARTZ_ORE) //
			.setExisting(BLOCK, Blocks.QUARTZ_BLOCK) //
			.setExisting(GEM, Items.QUARTZ) //
			.setArmor(createArmor(20, new int[] { 2, 5, 7, 2 }, 15)) //
			.setHorseArmor(8) //
			.setTools(createTools(new float[] { 5, 0, 1, 1.5F, 3.5F }, new float[] { -2.8F, 0, -2.5F, -3, -2.1F }, 1, 400, 7, 2, 15)) //
			.setLootTableWithFortune(ORE, GEM, LootTableUtil::createFortuneBlockLootTable) //
			.setGenerationDefault(ORE, state -> createOreFeatureRangeOverworld(state, 6, 4, 0, 0, 64));
	
	// CUSTOM
	
	public static final IResource COPPER = new BasicIngotResource("copper", 0xc46c29, Rarity.COMMON, 1, 3) //
			.setArmor(createArmor(12, new int[] { 2, 5, 6, 2 }, 9)) //
			.setHorseArmor(6) //
			.setTools(createTools(new float[] { 6, 0, 1, 1.5F, 3 }, new float[] { -3.1F, -1, -2.8F, -3, -2.4F }, 2, 200, 5, 1, 14)) //
			.setGenerationDefault(ORE, state -> createOreFeatureRangeOverworld(state, 9, 20, 0, 0, 64)) //
			.setGenerationDefault(NETHER_ORE, state -> createOreFeatureRangeNether(state, 9, 10, 10, 20, 128));
	
	public static final IResource TIN = new BasicIngotResource("tin", 0xbad3db, Rarity.COMMON, 1, 3) //
			.setArmor(createArmor(12, new int[] { 2, 5, 6, 2 }, 9)) //
			.setHorseArmor(6) //
			.setTools(createTools(new float[] { 6, 0, 1, 1.5F, 3 }, new float[] { -3.1F, -1, -2.8F, -3, -2.4F }, 2, 200, 5, 1, 14)) //
			.setGenerationDefault(ORE, state -> createOreFeatureRangeOverworld(state, 9, 20, 0, 0, 64)) //
			.setGenerationDefault(NETHER_ORE, state -> createOreFeatureRangeNether(state, 9, 10, 10, 20, 128));
	
	public static final IResource ALUMINUM = new BasicIngotResource("aluminum", 0xebf0ee, Rarity.COMMON, 1, 2.6F) //
			.setArmor(createArmor(10, new int[] { 1, 3, 5, 2 }, 9)) //
			.setHorseArmor(5) //
			.setTools(createTools(new float[] { 6, 0, 1, 1.5F, 3 }, new float[] { -3.1F, -1, -2.8F, -3, -2.4F }, 1, 150, 5, 1, 14)) //
			.setGenerationDefault(ORE, state -> createOreFeatureRangeOverworld(state, 9, 20, 0, 0, 64)) //
			.setGenerationDefault(NETHER_ORE, state -> createOreFeatureRangeNether(state, 9, 10, 10, 20, 128));
	
	public static final IResource SILVER = new BasicIngotResource("silver", 0xabe9ff, Rarity.COMMON, 2, 4) //
			.setArmor(createArmor(15, new int[] { 2, 5, 6, 2 }, 9)) //
			.setHorseArmor(7) //
			.setTools(createTools(new float[] { 6, 0, 1, 1.5F, 3 }, new float[] { -3.1F, -1, -2.8F, -3, -2.4F }, 2, 250, 6, 2, 14)) //
			.setGenerationDefault(ORE, state -> createOreFeatureRangeOverworld(state, 9, 2, 0, 0, 32)) //
			.setGenerationDefault(NETHER_ORE, state -> createOreFeatureRangeNether(state, 9, 3, 10, 20, 128));
	
	public static final IResource LEAD = new BasicIngotResource("lead", 0x5b62c9, Rarity.COMMON, 2, 3) //
			.setArmor(createArmor(20, new int[] { 1, 3, 5, 2 }, 9)) //
			.setHorseArmor(7) //
			.setTools(createTools(new float[] { 6, 0, 1, 1.5F, 3 }, new float[] { -3.1F, -1, -2.8F, -3, -2.4F }, 1, 250, 6, 2, 14)) //
			.setGenerationDefault(ORE, state -> createOreFeatureRangeOverworld(state, 10, 3, 0, 0, 32)) //
			.setGenerationDefault(NETHER_ORE, state -> createOreFeatureRangeNether(state, 9, 3, 10, 20, 128));
	
	public static void register() {
		// Vanilla
		ResourceRegistry.register(IRON);
		ResourceRegistry.register(GOLD);
		ResourceRegistry.register(DIAMOND);
		ResourceRegistry.register(EMERALD);
		ResourceRegistry.register(LAPIS);
		ResourceRegistry.register(QUARTZ);
		
		// Ingots
		ResourceRegistry.register(COPPER);
		ResourceRegistry.register(TIN);
		ResourceRegistry.register(ALUMINUM);
		ResourceRegistry.register(SILVER);
		ResourceRegistry.register(LEAD);
		
		// Gems
	}
	
}
