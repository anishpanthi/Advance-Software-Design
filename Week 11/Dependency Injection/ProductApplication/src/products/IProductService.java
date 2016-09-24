package products;

public interface IProductService {
	public Product getProduct(int productNumber);

	public int getNumberInStock(int productNumber);
}
