package com.model2.mvc.service.product.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;

import junit.framework.Assert;


/*
 *	FileName :  UserServiceTest.java
 * �� JUnit4 (Test Framework) �� Spring Framework ���� Test( Unit Test)
 * �� Spring �� JUnit 4�� ���� ���� Ŭ������ ���� ������ ��� ���� �׽�Ʈ �ڵ带 �ۼ� �� �� �ִ�.
 * �� @RunWith : Meta-data �� ���� wiring(����,DI) �� ��ü ����ü ����
 * �� @ContextConfiguration : Meta-data location ����
 * �� @Test : �׽�Ʈ ���� �ҽ� ����
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/context-common.xml",
									"classpath:config/context-aspect.xml",
									"classpath:config/context-mybatis.xml",
									"classpath:config/context-transaction.xml" })
public class ProductServiceTest {

	//==>@RunWith,@ContextConfiguration �̿� Wiring, Test �� instance DI
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;

	//@Test
	public void testAddProduct() throws Exception {
		
		Product product = new Product();
		product.setProdName("testprod");
		product.setProdDetail("testprodde");
		product.setManuDate("20010204");
		product.setPrice(554885);
		product.setFileName("iknow");
				
		productService.addProduct(product);
		
//		product = productService.getProduct(10141);
//
//		//==> console Ȯ��
//		//System.out.println(user);
//		
//		//==> API Ȯ��
//		Assert.assertEquals("�츰�źϼ�", product.getProdName());
//		Assert.assertEquals("�ٸ����", product.getProdDetail());
//		Assert.assertEquals("20170201", product.getManuDate());
//		Assert.assertEquals(10000, product.getPrice());
//		Assert.assertEquals("", product.getFileName());
		
	}
	
	//@Test
	public void testGetProduct() throws Exception {
		
		Product product = new Product();
		
		
		product.setProdName("testprod");
		product.setProdDetail("testprodde");
		product.setManuDate("20010204");
		product.setPrice(554885);
		product.setFileName("iknow");
		
		
		
		product = productService.getProduct(10142);


		System.out.println(product);
//		
//		//==> API Ȯ��
//		Assert.assertEquals(10040, product.getProdNo());
//		Assert.assertEquals("�츰�źϼ�", product.getProdName());
//		Assert.assertEquals("�ٸ����", product.getProdDetail());
//		Assert.assertEquals("20170201", product.getManuDate());
//		Assert.assertEquals(10000, product.getPrice());
//		
//		
//
////		Assert.assertNotNull(productService.getProduct(10002));
////		Assert.assertNotNull(productService.getProduct(10003));
	}
//	
	//@Test
	 public void testUpdateProduct() throws Exception{
		 
				
		Product product = productService.getProduct(10026);
//		Assert.assertNotNull(product);
//		
//		Assert.assertEquals("testprodname", product.getProdName());
//		Assert.assertEquals("testproddetail", product.getProdDetail());
//		Assert.assertEquals("20011212", product.getManuDate());
//		Assert.assertEquals(6546544, product.getPrice());
//		Assert.assertEquals("idonknow", product.getFileName());

		product.setProdName("change");
		product.setProdDetail("asdfasdfasdf");
		product.setManuDate("20000115");
		product.setPrice(888888);
		product.setFileName("youtoo");
				
		productService.updateProduct(product);
		
//		product = productService.getProduct(10141);
//		Assert.assertNotNull(product);
//		
//		//==> console Ȯ��
//		System.out.println(product);
//			
//		
//		Assert.assertEquals("change", product.getProdName());
//		Assert.assertEquals("asdfasdfasdf", product.getProdDetail());
//		Assert.assertEquals("20000115", product.getManuDate());
//		Assert.assertEquals(888888, product.getPrice());
//		Assert.assertEquals("youtoo", product.getFileName());
	 }
	 
//	

	 //@Test
	 public void testGetProductListAll() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	
	 	Map<String,Object> map = productService.getProductList(search);
	 	
	 	List<Object> list = (List<Object>)map.get("list");
	 	//Assert.assertEquals(3, list.size());
	 	
		//==> console Ȯ��
	 	System.out.println(list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("0");
	 	search.setSearchKeyword("");
	 	map = productService.getProductList(search);
	 	
	 	list = (List<Object>)map.get("list");
	 	//Assert.assertEquals(3, list.size());
	 	
	 	
	 	System.out.println(list);
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 }
	 
	 //@Test
	 public void testGetProductListByProdNo() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("0");
	 	search.setSearchKeyword("10000");
	 	Map<String,Object> map = productService.getProductList(search);
	 	
	 	List<Object> list = (List<Object>)map.get("list");
	 	Assert.assertEquals(1, list.size());
	 	
		
	 	System.out.println(list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	search.setSearchCondition("0");
	 	search.setSearchKeyword(""+System.currentTimeMillis());
	 	map = productService.getProductList(search);
	 	
	 	list = (List<Object>)map.get("list");
	 	Assert.assertEquals(0, list.size());
	 	
		System.out.println(list);
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 }
	 
	//@Test
	public void testGetProductListByProdName() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("1");
	 	search.setSearchKeyword("������");
	 	Map<String,Object> map = productService.getProductList(search);
	 	
	 	List<Object> list = (List<Object>)map.get("list");
	 	Assert.assertEquals(1, list.size());
	 	
		
	 	System.out.println(list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	search.setSearchCondition("0");
	 	search.setSearchKeyword(""+System.currentTimeMillis());
	 	map = productService.getProductList(search);
	 	
	 	list = (List<Object>)map.get("list");
	 	Assert.assertEquals(0, list.size());
	 	
		System.out.println(list);
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 }
	@Test
		public void testGetProductListByPrice() throws Exception{
			 
		 	Search search = new Search();
		 	search.setCurrentPage(1);
		 	search.setPageSize(3);
		 	search.setSearchCondition("2");
		 	search.setSearchKeyword("11");
		 	Map<String,Object> map = productService.getProductList(search);
		 	
		 	List<Object> list = (List<Object>)map.get("list");
		 	//Assert.assertEquals(1, list.size());
		 	
			
		 	System.out.println(list);
		 	
		 	Integer totalCount = (Integer)map.get("totalCount");
		 	System.out.println(totalCount);
		 	
		 	System.out.println("=======================================");
		 	
		 	search.setSearchCondition("0");
		 	search.setSearchKeyword(""+System.currentTimeMillis());
		 	map = productService.getProductList(search);
		 	
		 	list = (List<Object>)map.get("list");
		 	Assert.assertEquals(0, list.size());
		 	
			
		 	System.out.println(list);
		 	
		 	totalCount = (Integer)map.get("totalCount");
		 	System.out.println(totalCount);
		 }
}