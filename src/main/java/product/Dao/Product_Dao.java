package product.Dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import product.Model.Product;


@Component
public class Product_Dao
{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//Create Product
	@Transactional
	public void createProduct(Product product)
	{
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	//Get all Products
	public List<Product> getAllProducts()
	{
	  List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	// Delete single Product
	@Transactional
	public void deleteProduct(int product_id)
	{
		Product p = this.hibernateTemplate.get(Product.class,product_id);
		this.hibernateTemplate.delete(p);
	}
	
	// Get Single Product
	public Product getProduct(int product_id)
	{
		 Product product = this.hibernateTemplate.get(Product.class,product_id);
		 return product;
	}
}
