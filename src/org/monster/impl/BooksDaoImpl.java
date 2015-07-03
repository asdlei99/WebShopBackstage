package org.monster.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.monster.dao.HibernateSessionFactory;
import org.monster.dao.IBooksDao;
import org.monster.entity.Books;

/**
 * 书籍数据库操作实现类
 */
public class BooksDaoImpl implements IBooksDao {
	/**
	 * 取得书籍分页信息，这个分页是个模板，对所有的数据库都一样
	 * @param pageSize 每个分页的记录数
	 * @param pageNum 当前要获取分页页码
	 * @return
	 */
	@SuppressWarnings("unchecked")   //这句话去掉不匹配的提示
	public List<Books> getBooksPageList(int pageSize, int pageNum){
		List<Books> list = new ArrayList<Books>();
		Session session = HibernateSessionFactory.getSession();
		try{
			String hql = "from Books order by id desc";     //hql是从对象中进行查询，使用Books而不是表Books
			Query q = session.createQuery(hql);
			q.setFirstResult((pageNum-1)*pageSize);   //过滤前面的pageNum-1页的数据
			q.setMaxResults(pageSize);   //取出当前页的数据来
			list = q.list();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	/**
	 * 取得书籍对象信息
	 * @param id
	 * @return
	 */
	public Books getBooksItem(String id){
		Books item = null;
		Session session = HibernateSessionFactory.getSession();
		try{
			String hql = "from Books where id=?";     //hql是从对象中进行查询，使用Books而不是表Books
			Query q = session.createQuery(hql);
			q.setString(0, id);
			item = (Books) q.uniqueResult();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return item;
	}
	
	/**
	 * 添加书籍信息
	 * 需要事务处理
	 */
	public void addBooks(Books item){
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();  //开启事务
		try{
			session.save(item);
			tran.commit();   //执行事务
		}catch(Exception ex){
			tran.rollback();  //回滚事务
			ex.printStackTrace();
		}finally{
			session.close();
		}
		
	}
	
	/** 
	 * 修改书籍信息[由于图书的字段值很多，管理员也许只需要添加部分字段，所以可以通过session接口进行操作]
	 * @param item 要修改的对象
	 * @return
	 */
	public void  editBooks(Books item){
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();  //开启事务
		try{
			session.update(item);   
			tran.commit();
		}catch(Exception ex){
			tran.rollback();
			ex.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	/**
	 * 删除书籍信息
	 * @param id
	 * @return
	 */
	public int delBooks(int id){
		int iRow =0 ;  //影响的行数
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();  //开启事务

		try{
			String hql = "delete from Books where id=?";     //hql是从对象中进行查询，使用Books而不是表Books
			Query q = session.createQuery(hql);
			q.setInteger(0,id);
			iRow = q.executeUpdate();
			tran.commit();   //执行事务
		}catch(Exception ex){
			tran.rollback();  //回滚事务
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return iRow;
	}
}
