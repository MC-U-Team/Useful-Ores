package info.u_team.useful_resources.api.feature;

@FunctionalInterface
public interface IResourceFeatureBuilder {
	
	IResourceFeature build(IDeferredRegisterProvider provider, String name);
	
}
