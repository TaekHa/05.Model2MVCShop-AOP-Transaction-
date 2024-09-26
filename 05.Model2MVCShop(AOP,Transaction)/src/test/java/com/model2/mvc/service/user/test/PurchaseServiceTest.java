package com.model2.mvc.service.user.test;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.user.UserService;


/*
 *	FileName :  UserServiceTest.java
 * ㅇ JUnit4 (Test Framework) 과 Spring Framework 통합 Test( Unit Test)
 * ㅇ Spring 은 JUnit 4를 위한 지원 클래스를 통해 스프링 기반 통합 테스트 코드를 작성 할 수 있다.
 * ㅇ @RunWith : Meta-data 를 통한 wiring(생성,DI) 할 객체 구현체 지정
 * ㅇ @ContextConfiguration : Meta-data location 지정
 * ㅇ @Test : 테스트 실행 소스 지정
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:config/context-*.xml" })
@ContextConfiguration	(locations = {	"classpath:config/context-common.xml",
		"classpath:config/context-aspect.xml",
		"classpath:config/context-mybatis.xml",
		"classpath:config/context-transaction.xml" })
//@ContextConfiguration(locations = { "classpath:config/commonservice.xml" })
public class PurchaseServiceTest {

	//==>@RunWith,@ContextConfiguration 이용 Wiring, Test 할 instance DI
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;

	@Transactional
	@Test
	public void testAddPurchase() throws Exception {
		
		Purchase purchase = new Purchase();
		purchase.setPurchaseProd(productService.getProduct(10006));
		purchase.setBuyer(userService.getUser("admin"));
		purchase.setPaymentOption("1");
		purchase.setReceiverName("test");
		purchase.setReceiverPhone("0000000000");
		purchase.setDivyAddr("testAddr");
		purchase.setDivyRequest("testRequest");
		purchase.setTranCode("1");
		purchase.setDivyDate(new Date(1900,01,01));
		
		
		purchaseService.addPurchase(purchase);
		
		purchase = purchaseService.getPurchaseByProd(10006);

		//==> console 확인
		System.out.println(purchase);
		
		//==> API 확인
		Assert.assertEquals(10006, purchase.getPurchaseProd().getProdNo());
		Assert.assertEquals("admin", purchase.getBuyer().getUserId());
		Assert.assertEquals("1", purchase.getPaymentOption());
		Assert.assertEquals("test", purchase.getReceiverName());
		Assert.assertEquals("0000000000", purchase.getReceiverPhone());
		Assert.assertEquals("testAddr", purchase.getDivyAddr());
		Assert.assertEquals("testRequest", purchase.getDivyRequest());
		Assert.assertEquals("1", purchase.getTranCode());
		Assert.assertEquals(new Date(1900,01,01), purchase.getDivyDate());
		
	}
	
//	@Test
	public void testGetPurchase() throws Exception {
		
		Purchase purchase = new Purchase();
		//==> 필요하다면...
//		purchase.setPurchaseProd(productService.getProduct(10000));
//		purchase.setBuyer(userService.getUser("admin"));
//		purchase.setPaymentOption("0");
//		purchase.setReceiverName("test");
//		purchase.setReceiverPhone("0000000000");
//		purchase.setDivyAddr("testAddr");
//		purchase.setDivyRequest("testRequest");
//		purchase.setTranCode("1");
//		purchase.setDivyDate(new Date(1900,01,01));
		
		purchase = purchaseService.getPurchase(10027);

		//==> console 확인
		System.out.println(purchase);
		
		//==> API 확인
		Assert.assertEquals(10027, purchase.getTranNo());
		Assert.assertEquals(10006, purchase.getPurchaseProd().getProdNo());
		Assert.assertEquals("admin", purchase.getBuyer().getUserId());
		Assert.assertEquals("1", purchase.getPaymentOption());
		Assert.assertEquals("test", purchase.getReceiverName());
		Assert.assertEquals("0000000000", purchase.getReceiverPhone());
		Assert.assertEquals("testAddr", purchase.getDivyAddr());
		Assert.assertEquals("testRequest", purchase.getDivyRequest());
		Assert.assertEquals("1", purchase.getTranCode());
		Assert.assertEquals(new Date(1900,01,01), purchase.getDivyDate());
	
	}
	
//	@Test
	public void testGetPurchaseByProd() throws Exception {
		
		Purchase purchase = new Purchase();
		//==> 필요하다면...
//		purchase.setPurchaseProd(productService.getProduct(10000));
//		purchase.setBuyer(userService.getUser("admin"));
//		purchase.setPaymentOption("0");
//		purchase.setReceiverName("test");
//		purchase.setReceiverPhone("0000000000");
//		purchase.setDivyAddr("testAddr");
//		purchase.setDivyRequest("testRequest");
//		purchase.setTranCode("1");
//		purchase.setDivyDate(new Date(1900,01,01));
		
		purchase = purchaseService.getPurchaseByProd(10006);

		//==> console 확인
		System.out.println(purchase);
		
		//==> API 확인
		Assert.assertEquals(10027, purchase.getTranNo());
		Assert.assertEquals(10006, purchase.getPurchaseProd().getProdNo());
		Assert.assertEquals("admin", purchase.getBuyer().getUserId());
		Assert.assertEquals("1", purchase.getPaymentOption());
		Assert.assertEquals("test", purchase.getReceiverName());
		Assert.assertEquals("0000000000", purchase.getReceiverPhone());
		Assert.assertEquals("testAddr", purchase.getDivyAddr());
		Assert.assertEquals("testRequest", purchase.getDivyRequest());
		Assert.assertEquals("1", purchase.getTranCode());
		Assert.assertEquals(new Date(1900,01,01), purchase.getDivyDate());
		
	}
	
//	@Transactional
//	@Test
	 public void testUpdatePurchase() throws Exception{
		 
		Purchase purchase = purchaseService.getPurchase(10027);
		Assert.assertNotNull(purchase);
		
		Assert.assertEquals(10027, purchase.getTranNo());
		Assert.assertEquals(10006, purchase.getPurchaseProd().getProdNo());
		Assert.assertEquals("admin", purchase.getBuyer().getUserId());
		Assert.assertEquals("1", purchase.getPaymentOption());
		Assert.assertEquals("test", purchase.getReceiverName());
		Assert.assertEquals("0000000000", purchase.getReceiverPhone());
		Assert.assertEquals("testAddr", purchase.getDivyAddr());
		Assert.assertEquals("testRequest", purchase.getDivyRequest());
		Assert.assertEquals("1", purchase.getTranCode());
		Assert.assertEquals(new Date(1900,01,01), purchase.getDivyDate());

		purchase.setPaymentOption("2");
		purchase.setReceiverName("change");
		purchase.setReceiverPhone("9999999999");
		purchase.setDivyAddr("changeAddr");
		purchase.setDivyRequest("changeRequest");
		purchase.setDivyDate(new Date(2000,02,02));
		
		purchaseService.updatePurchase(purchase);
		
		purchase = purchaseService.getPurchase(10027);
		Assert.assertNotNull(purchase);
		
		//==> console 확인
		System.out.println(purchase);
			
		//==> API 확인
		Assert.assertEquals("2", purchase.getPaymentOption());
		Assert.assertEquals("change", purchase.getReceiverName());
		Assert.assertEquals("9999999999", purchase.getReceiverPhone());
		Assert.assertEquals("changeAddr", purchase.getDivyAddr());
		Assert.assertEquals("changeRequest", purchase.getDivyRequest());
		Assert.assertEquals(new Date(2000,02,02), purchase.getDivyDate());

	 }
	 
//	 @Transactional
//	 @Test
	 public void testUpdateTranCode() throws Exception{
			Purchase purchase = purchaseService.getPurchase(10027);
			Assert.assertNotNull(purchase);
			
			Assert.assertEquals(10027, purchase.getTranNo());
			Assert.assertEquals(10006, purchase.getPurchaseProd().getProdNo());
			Assert.assertEquals("admin", purchase.getBuyer().getUserId());
			Assert.assertEquals("2", purchase.getPaymentOption());
			Assert.assertEquals("change", purchase.getReceiverName());
			Assert.assertEquals("9999999999", purchase.getReceiverPhone());
			Assert.assertEquals("changeAddr", purchase.getDivyAddr());
			Assert.assertEquals("changeRequest", purchase.getDivyRequest());
			Assert.assertEquals("1", purchase.getTranCode());
			Assert.assertEquals(new Date(2000,02,02), purchase.getDivyDate());
			
			//==> console 확인
			System.out.println(purchase);
			
			purchaseService.updateTranCode(purchase, 1);
			
			//==> console 확인
			System.out.println(purchase.getTranCode());
			
			Assert.assertEquals("1", purchase.getTranCode());
	 }
	 
	 //==>  주석을 풀고 실행하면....
//	 @Test
	 public void testGetPurchaseList() throws Exception{
		 
	 	Search search = new Search();
	 	String userId = "user04";
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	Map<String,Object> map = purchaseService.getPurchaseList(search, userId);
	 	
	 	List<Object> list = (List<Object>)map.get("list");
	 	Assert.assertEquals(3, list.size());
	 	
		//==> console 확인
	 	//System.out.println(list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 }
	 	 
}