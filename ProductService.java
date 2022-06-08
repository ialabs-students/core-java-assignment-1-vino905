

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductService {
	ProductRepository prod = new ProductRepository();
	List<Product> product=prod.getList();
	String name1;
	public String findNameByCode(int productcode){
		for(Product i:product) {
			try {
				//System.out.println(i.getProductcode());
				if(productcode==i.getProductcode()) {
					name1 = i.getName();
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return name1;
			
		}
	double temp=0;
	String name;
	public String findMaxPriceProduct(String category){
		for(Product i:product) {
			try {
				if(category==i.getCategory()) {
				if(temp<i.getPrice()) {
				temp=i.getPrice();
				}
				
				}
				
				
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(Product i:product) {
			if(temp==i.getPrice()) {
				name= i.getName();
	}
			
			}
		return name;
	}
	ArrayList<Product> al=new ArrayList<>();

	public ArrayList<Product> getProductByCategory(String category){
		for(Product i:product) {
			//System.out.println(i.getCategory());
			if(category==i.getCategory()) {
				al.add(i);
			}
			
		}
		return  al;
	}

	public static void main(String[] args) {
		ProductService ps=new ProductService();
		System.out.println(ps.findNameByCode(2));
		System.out.println(ps.findMaxPriceProduct("stationary"));
		System.out.println(ps.findMaxPriceProduct("clothing"));
		ArrayList<Product> cat =ps.getProductByCategory("clothing");
		//System.out.println(cat.size());
		Iterator<Product> itr =cat.iterator();
		while(itr.hasNext()) {
			Product product =itr.next();
			System.out.println(product.getCategory()+","+product.getName()+","+product.getPrice()+","+product.getProductcode());
		}
	}

}
