package zdoctor.bloodbaubles.common.baubles;

public class GodsGift extends BloodRing {
	public GodsGift() {
		super("GodsGift", true);
		setSubCount(2);
	}
	
	@Override
	public String getNameFromMeta(int itemDamage) {
		return super.getRegistryName().getResourcePath() + (itemDamage == 0 ? "_Inactive" : "_Active");
	}
}