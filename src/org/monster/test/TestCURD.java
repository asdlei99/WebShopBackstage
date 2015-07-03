package org.monster.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.monster.dao.IBooksDao;
import org.monster.entity.Books;
import org.monster.impl.BooksDaoImpl;

import junit.framework.TestCase;

public class TestCURD extends TestCase {

	public void testGetBooksPageList() {
		IBooksDao dao=new BooksDaoImpl();
		List<Books> bookList=dao.getBooksPageList(20, 1);  //得到图书列表
		for(int i=0;i<bookList.size();i++){
			Books book=bookList.get(i);
			System.err.println("出版社"+book.getPublisherName());
		}
	}

	public void testGetBooksItem() {
		IBooksDao dao=new BooksDaoImpl();
		Books book=dao.getBooksItem("0130284190");
		System.out.println("数据"+book.getPublisherName());
	}

	public void testAddBooks() {
			/**创建Books对象并且赋值**/
			Books book=new Books();
			book.setIsbn("010102023");
			book.setTitle("亲，我怎么又成炮灰了");
			book.setPrice(250.0);
			book.setPubDt(new Date());
			book.setPublisherName("滨州出版社");
			
			/**进行添加操作**/
			IBooksDao dao=new BooksDaoImpl();
			dao.addBooks(book);
		}


	private String getData() {
		// 得到时间的方法
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:SS;mm");
		String str=format.format(date);
		return str;
	}

	public void testEditBooks() {
		IBooksDao dao=new BooksDaoImpl();
		Books book=new Books();
		book.setIsbn("0130829288");
		book.setPublisherName("临沂出版社");
		book.setPrice(120.00);
		book.setTitle("我是书名，我好伤心- -!!");
		book.setPubDt(new Date());
		dao.editBooks(book);
	}

	public void testDelBooks() {
		IBooksDao dao=new BooksDaoImpl();
		int i=dao.delBooks(1);
		System.out.println("返回行数" +i);
	}

}
