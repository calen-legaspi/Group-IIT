package com.onb.shoppingcart.web.sessionmanager;

import java.io.Serializable;
import java.util.List;

import com.onb.shoppingcart.domain.Category;
import com.onb.shoppingcart.domain.Order;
import com.onb.shoppingcart.domain.OrderDetail;
import com.onb.shoppingcart.domain.Product;

public class ShoppingSessionManager implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Category> categories;
	private Order order;
	private Category currentCategory;
	private Product currentProduct;
	private OrderDetail currentOrderDetail;

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}

	public void setCurrentCategory(Category currentCategory) {
		this.currentCategory = currentCategory;
	}

	public void setCurrentProduct(Product currentProduct) {
		this.currentProduct = currentProduct;
	}

	public void setCurrentOrderDetail(OrderDetail currentOrderDetail) {
		this.currentOrderDetail = currentOrderDetail;
	}
	
	/**
	 * Generates an order detail if the product does not exist in the order.
	 * Otherwise extract the existing order.
	 * @param productId
	 * @return
	 */
	public OrderDetail generateOrderDetail(int productId) {
		Product toTest = new Product(productId);
		/**
		 * Search first if the order detail is in there somewhere.
		 */
		for(OrderDetail od: order.getOrderDetails()) {
			if(od.getProduct().equals(toTest)) {
				return od;
			}
		}
		/**
		 * The OrderDetail is not on the order
		 */
		for(Category category: categories) {
			for(Product product: category.getProducts()) {
				if(product.equals(toTest)) {
					return new OrderDetail(0,product.getUnitPrice(),0,product,order);
				}
			}
		}
		return null;
	}

	public Product findProductById(int id) {
		for(Category category:categories) {
			if(category.getProducts().contains(new Product(id))) {
				return category.getProducts().get(category.getProducts().indexOf(new Product(id)));
			}
		}
		return null;
	}
	
	public Category findCategoryById(int id) {
		return categories.get(categories.indexOf(new Category(id)));
	}

	public List<Category> getCategories() {
		return categories;
	}

	public Order getOrder() {
		return order;
	}

	public Category getCurrentCategory() {
		return currentCategory;
	}

	public Product getCurrentProduct() {
		return currentProduct;
	}

	public OrderDetail getCurrentOrderDetail() {
		return currentOrderDetail;
	}
}
