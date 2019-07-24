package info.u_team.useful_resources.data.provider;

import java.io.IOException;

import static info.u_team.useful_resources.UsefulResourcesMod.MODID;

import java.nio.file.Path;

import org.apache.logging.log4j.*;

import com.google.gson.JsonObject;

import info.u_team.useful_resources.type.Resources;
import net.minecraft.block.Block;
import net.minecraft.data.*;

public class BlockStatesProvider extends CommonProvider {
	
	private final Marker marker = MarkerManager.getMarker(getName());
	
	public BlockStatesProvider(DataGenerator generator) {
		super("Resources-BlockStates", generator);
	}
	
	@Override
	public void act(DirectoryCache cache) throws IOException {
		Resources.VALUES.forEach(resource -> {
			for (Block block : resource.getBlocks().getArray()) {
				final String blockName = block.getRegistryName().getPath();
				
				JsonObject object = new JsonObject();
				JsonObject variantsObject = new JsonObject();
				JsonObject modelObject = new JsonObject();
				
				modelObject.addProperty("model", MODID + ":block/" + blockName);
				variantsObject.add("", modelObject);
				object.add("variants", variantsObject);
				
				try {
					write(cache, object, path.resolve(blockName + ".json"));
				} catch (IOException ex) {
					LOGGER.error(marker, "Could not write data.", ex);
				}
			}
		});
	}
	
	@Override
	protected Path resolvePath(Path outputFolder) {
		return resolveAssets(outputFolder).resolve("blockstates");
	}
}
