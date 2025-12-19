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
    this.inventoryd = inventoryid;
    this.quantitySold
}