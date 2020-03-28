package info.u_team.useful_resources.util;

public class ExtraPropertiesUtil {
	
	public static float getFloat(Object object) {
		if (object instanceof Integer) {
			return (int) object;
		} else if (object instanceof Float) {
			return (float) object;
		} else if (object instanceof Double) {
			return (float) ((double) object);
		} else {
			return 0;
		}
	}
	
}
