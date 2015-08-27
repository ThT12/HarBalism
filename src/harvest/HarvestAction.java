package harvest;

import area.AreaSize;
import area.HarvestArea;
import maths.Percent;

public class HarvestAction {
	private HarvestArea ha;
	private Percent quantity;
	private AreaSize size;
	
	public HarvestAction() throws Exception{
		this.setHarvestArea(new HarvestArea());
		this.setQuantity(new Percent(0));
		this.setSize(AreaSize.NULL);
	}
	
	public HarvestAction(HarvestArea ha, double quantity) throws Exception {
		this.setHarvestArea(ha);
		this.setQuantity(new Percent(quantity));
		this.setSize(AreaSize.NULL);
	}
	
	public HarvestAction(HarvestArea ha, double quantity, AreaSize size) throws Exception {
		this.setHarvestArea(ha);
		this.setQuantity(new Percent(quantity));
		this.setSize(size);
	}
	
	public void applyHarvest() throws Exception{
		this.ha.updateDisponibility(this.quantity.getPercent(), this.size);
	}


	public HarvestArea getHarvestArea() {
		return ha;
	}

	public void setHarvestArea(HarvestArea ha) {
		this.ha = ha;
	}

	public Percent getQuantity() {
		return quantity;
	}

	public void setQuantity(Percent quantity) {
		this.quantity = quantity;
	}

	public AreaSize getSize() {
		return size;
	}

	public void setSize(AreaSize size) {
		this.size = size;
	}

}
