@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class SalesHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private Integer soldQty;
    private LocalDate saleDate;
}
