package com.model2.mvc.service.purchase.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseDao;
import com.model2.mvc.service.purchase.PurchaseService;

@Service("purchaseServiceImpl")
public class PurchaseServiceImpl implements PurchaseService {
	//Field
	@Autowired
	@Qualifier("purchaseDaoImpl")
	private PurchaseDao purchaseDao;
	
	//Constructor
	public PurchaseServiceImpl() {
		purchaseDao = new PurchaseDaoImpl();
	}
	
	//method
	@Override
	public void addPurchase(Purchase purchase) throws Exception {
		// TODO Auto-generated method stub
		purchaseDao.addPurchase(purchase);
	}

	@Override
	public Purchase getPurchase(int tranNo) throws Exception {
		
		return purchaseDao.getPurchase(tranNo);
	}
	
	@Override
	public Purchase getPurchaseByProd(int prodNo) throws Exception {
		// TODO Auto-generated method stub
		return purchaseDao.getPurchaseByProd(prodNo);
	}

	@Override
	public Map<String, Object> getPurchaseList(Search search, String userId) throws Exception {
		return purchaseDao.getPurchaseList(search, userId);
	}

	@Override
	public Map<String, Object> getSaleList(Search search) throws Exception {
		// TODO Auto-generated method stub
		return purchaseDao.getSaleList(search);
	}

	@Override
	public void updatePurchase(Purchase purchase) throws Exception {
		// TODO Auto-generated method stub
		purchaseDao.updatePurchase(purchase);
	}

	@Override
	public void updateTranCode(Purchase purchase, int tranStatusCode) throws Exception {
		// TODO Auto-generated method stub
		purchaseDao.updateTranCode(purchase, tranStatusCode);
	}

}
