package labExam_Jan13;

public class MerchandiseInventory implements Comparable<MerchandiseInventory> {
    @Override
    public int compareTo(MerchandiseInventory o) {
        return this.itemId.compareTo(o.itemId);
    }

    private String itemId;

    public MerchandiseInventory(String itemId, int quantity, double price) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }

    private int quantity;
    private double price;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MerchandiseInventory{");
        sb.append("itemId='").append(itemId).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
