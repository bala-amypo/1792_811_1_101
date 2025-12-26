// ProductService
Product createProduct(Product product);
List<Product> getAllProducts();
Product getProductById(long id);

// WarehouseService
Warehouse createWarehouse(Warehouse warehouse);
List<Warehouse> getAllWarehouses();
Warehouse getWarehouseById(long id);

// StockRecordService
StockRecord createStockRecord(StockRecord record);
List<StockRecord> getRecordsByProduct(long productId);

// ConsumptionLogService
ConsumptionLog createLog(ConsumptionLog log);
List<ConsumptionLog> getLogsByStockRecord(long stockId);

// PredictionService
PredictionRule predictRestockDate(long stockId);
