package milestone1;

public class StoreFront {
    private String name;
    private String location;
    private InventoryManager inventory;

    public StoreFront(String name, String location, InventoryManager inventory) {
        this.setName(name);
        this.setLocation(location);
        this.inventory = inventory;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

    public void purchaseProduct(SalableProduct product, int quantity) {
    	int qty = product.getQuantity() - quantity;
    	inventory.updateProduct(product, qty);
    }

    public void cancelPurchase(SalableProduct product, int quantity) {
    	int qty = product.getQuantity() + quantity;
    	inventory.updateProduct(product, qty);
    }
}

