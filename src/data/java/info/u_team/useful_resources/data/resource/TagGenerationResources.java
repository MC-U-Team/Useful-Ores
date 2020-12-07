package info.u_team.useful_resources.data.resource;

import java.util.*;
import java.util.function.Consumer;

import info.u_team.useful_resources.api.resource.IResource;
import info.u_team.useful_resources.resources.Resources;
import info.u_team.useful_resources.util.FakeNameResource;
import net.minecraft.util.Util;

public class TagGenerationResources {
	
	static final Set<IResource> RESOURCES = Util.make(new TreeSet<>(GenerationResources.COMPARATOR), list -> GenerationResources.forEach(list::add));
	
	static {
		RESOURCES.add(new FakeNameResource("aluminium", Resources.ALUMINUM));
		RESOURCES.add(new FakeNameResource("uranium", Resources.URANIUM_238));
	}
	
	public static Set<IResource> getResources() {
		return Collections.unmodifiableSet(RESOURCES);
	}
	
	public static void forEach(Consumer<? super IResource> action) {
		RESOURCES.forEach(action);
	}
}
