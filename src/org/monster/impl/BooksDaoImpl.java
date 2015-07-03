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
 * �鼮���ݿ����ʵ����
 */
public class BooksDaoImpl implements IBooksDao {
	/**
	 * ȡ���鼮��ҳ��Ϣ�������ҳ�Ǹ�ģ�壬�����е����ݿⶼһ��
	 * @param pageSize ÿ����ҳ�ļ�¼��
	 * @param pageNum ��ǰҪ��ȡ��ҳҳ��
	 * @return
	 */
	@SuppressWarnings("unchecked")   //��仰ȥ����ƥ�����ʾ
	public List<Books> getBooksPageList(int pageSize, int pageNum){
		List<Books> list = new ArrayList<Books>();
		Session session = HibernateSessionFactory.getSession();
		try{
			String hql = "from Books order by id desc";     //hql�ǴӶ����н��в�ѯ��ʹ��Books�����Ǳ�Books
			Query q = session.createQuery(hql);
			q.setFirstResult((pageNum-1)*pageSize);   //����ǰ���pageNum-1ҳ������
			q.setMaxResults(pageSize);   //ȡ����ǰҳ��������
			list = q.list();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	/**
	 * ȡ���鼮������Ϣ
	 * @param id
	 * @return
	 */
	public Books getBooksItem(String id){
		Books item = null;
		Session session = HibernateSessionFactory.getSession();
		try{
			String hql = "from Books where id=?";     //hql�ǴӶ����н��в�ѯ��ʹ��Books�����Ǳ�Books
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
	 * ����鼮��Ϣ
	 * ��Ҫ������
	 */
	public void addBooks(Books item){
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();  //��������
		try{
			session.save(item);
			tran.commit();   //ִ������
		}catch(Exception ex){
			tran.rollback();  //�ع�����
			ex.printStackTrace();
		}finally{
			session.close();
		}
		
	}
	
	/** 
	 * �޸��鼮��Ϣ[����ͼ����ֶ�ֵ�ܶ࣬����ԱҲ��ֻ��Ҫ��Ӳ����ֶΣ����Կ���ͨ��session�ӿڽ��в���]
	 * @param item Ҫ�޸ĵĶ���
	 * @return
	 */
	public void  editBooks(Books item){
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();  //��������
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
	 * ɾ���鼮��Ϣ
	 * @param id
	 * @return
	 */
	public int delBooks(int id){
		int iRow =0 ;  //Ӱ�������
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();  //��������

		try{
			String hql = "delete from Books where id=?";     //hql�ǴӶ����н��в�ѯ��ʹ��Books�����Ǳ�Books
			Query q = session.createQuery(hql);
			q.setInteger(0,id);
			iRow = q.executeUpdate();
			tran.commit();   //ִ������
		}catch(Exception ex){
			tran.rollback();  //�ع�����
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return iRow;
	}
}
