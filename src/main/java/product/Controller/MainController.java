package product.Controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;
import product.Dao.Product_Dao;
import product.Model.Product;

@Controller
public class MainController
{
	@Autowired
	private Product_Dao productdao;
	
	@RequestMapping("/")
	public String home(Model m)
	{
		List<Product> Products = productdao.getAllProducts();
		m.addAttribute("products", Products);
		return "index";
	}
	
	// For add Product
	@RequestMapping("/add-product")
	public String addProduct(Model m)
	{
		m.addAttribute("title", "Add Product");
    	return "add_product_form";			
	}

	@RequestMapping(value="/handle",method=RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest request)
	{
		productdao.createProduct(product);
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	// For Delete Product
	@RequestMapping("/delete/{product-id}")
	public RedirectView deleteProduct(@PathVariable("product-id") int id ,HttpServletRequest request)
	{
	   this.productdao.deleteProduct(id);
	   RedirectView redirectView= new RedirectView();
	   redirectView.setUrl(request.getContextPath()+"/");
	   return redirectView;
	}
	
	// For Update Product
	@RequestMapping("/update/{id}")
	public String updateform(@PathVariable("id") int id,Model m)
	{
		Product product = this.productdao.getProduct(id);
		m.addAttribute("p", product);	
		return "update_form";
	}
}
