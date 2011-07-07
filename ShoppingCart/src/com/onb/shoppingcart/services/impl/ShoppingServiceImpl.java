package com.onb.shoppingcart.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onb.shoppingcart.dao.CategoryDAO;
import com.onb.shoppingcart.dao.OrderDAO;
import com.onb.shoppingcart.dao.OrderDetailDAO;
import com.onb.shoppingcart.dao.ProductDAO;
import com.onb.shoppingcart.dao.UserDAO;
import com.onb.shoppingcart.domain.Category;
import com.onb.shoppingcart.domain.Order;
import com.onb.shoppingcart.domain.OrderDetail;
import com.onb.shoppingcart.domain.User;
import com.onb.shoppingcart.services.ShoppingService;
import com.onb.shoppingcart.services.exceptions.ServiceException;

@Service("shoppingService")
public class ShoppingServiceImpl implements ShoppingService {
	private OrderDAO orderDAO;
	private UserDAO userDAO;
	private CategoryDAO categoryDAO;
	private ProductDAO productDAO;
	private OrderDetailDAO orderDetailDAO;

	@Autowired(required = true)
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	@Autowired(required = true)
	public void setOrderDetailDAO(OrderDetailDAO orderDetailDAO) {
		this.orderDetailDAO = orderDetailDAO;
	}

	@Autowired(required = true)
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	@Autowired(required = true)
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Autowired(required = true)
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@Override
	public User getUserByUsername(String username) {
		return userDAO.getUserByUsername(username);
	}

	@Override
	public List<Category> getCategories() {
		return categoryDAO.getAll();
	}
	
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void checkout(Order order) throws ServiceException {
		orderDAO.create(order);
		for(OrderDetail orderDetail:order.getOrderDetails()) {
			if(orderDetail.getQuantity() > 0) {
				orderDetailDAO.create(orderDetail);
				productDAO.reduceQuantity(orderDetail.getProduct(), orderDetail.getQuantity());
			}
		}
	}

}
