package zdoctor.bloodbaubles.common.item.baubles;

public class BasicRing extends BloodRing {
	public BasicRing() {
		super("BasicRing", true);
		setSubCount(2);
	}

	@Override
	public String getNameFromMeta(int itemDamage) {
		return super.getRegistryName().getResourcePath() + ((itemDamage == 0) ? "_iron" : "_gold");
	}
}
