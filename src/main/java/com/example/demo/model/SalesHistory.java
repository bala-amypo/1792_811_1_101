pacakage com.example.inventory.entity;

import jakarta.prsistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sales_history")
public class SalesHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long inventoryId;
    private int quantitySold;
    private LocalDate saleDate;

    pulicSaleHistory() {}

    public SalesHistory(Long inventoryId, int quantitySold, LocalDate SaleDate) {
    this.inventoryId = inventoryid;
    this.quantitySold = quantitysold;
    this.saleDate = saledate;

    public Long getId() {
        return id;
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getQantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this quantitySold = quantitySold;
    }

    public 
}