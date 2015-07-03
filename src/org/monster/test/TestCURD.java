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
		List<Books> bookList=dao.getBooksPageList(20, 1);  //�õ�ͼ���б�
		for(int i=0;i<bookList.size();i++){
			Books book=bookList.get(i);
			System.err.println("������"+book.getPublisherName());
		}
	}

	public void testGetBooksItem() {
		IBooksDao dao=new BooksDaoImpl();
		Books book=dao.getBooksItem("0130284190");
		System.out.println("����"+book.getPublisherName());
	}

	public void testAddBooks() {
			/**����Books�����Ҹ�ֵ**/
			Books book=new Books();
			book.setIsbn("010102023");
			book.setTitle("�ף�����ô�ֳ��ڻ���");
			book.setPrice(250.0);
			book.setPubDt(new Date());
			book.setPublisherName("���ݳ�����");
			
			/**������Ӳ���**/
			IBooksDao dao=new BooksDaoImpl();
			dao.addBooks(book);
		}


	private String getData() {
		// �õ�ʱ��ķ���
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:SS;mm");
		String str=format.format(date);
		return str;
	}

	public void testEditBooks() {
		IBooksDao dao=new BooksDaoImpl();
		Books book=new Books();
		book.setIsbn("0130829288");
		book.setPublisherName("���ʳ�����");
		book.setPrice(120.00);
		book.setTitle("�����������Һ�����- -!!");
		book.setPubDt(new Date());
		dao.editBooks(book);
	}

	public void testDelBooks() {
		IBooksDao dao=new BooksDaoImpl();
		int i=dao.delBooks(1);
		System.out.println("��������" +i);
	}

}
