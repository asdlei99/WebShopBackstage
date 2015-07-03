package org.monster.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.monster.dao.HibernateSessionFactory;
import org.monster.dao.ISysuserDao;
import org.monster.entity.Sysuser;

/**
 * ����Ա���ݿ����ʵ����
 */
public class SysuserDaoImpl implements ISysuserDao {
	/**
	 * ȡ�ù���Ա��ҳ��Ϣ�������ҳ�Ǹ�ģ�壬�����е����ݿⶼһ��
	 * @param pageSize ÿ����ҳ�ļ�¼��
	 * @param pageNum ��ǰҪ��ȡ��ҳҳ��
	 * @return
	 */
	@SuppressWarnings("unchecked")   //��仰ȥ����ƥ�����ʾ
	public List<Sysuser> getSysuserPageList(int pageSize, int pageNum){
		List<Sysuser> list = new ArrayList<Sysuser>();
		Session session = HibernateSessionFactory.getSession();
		try{
			String hql = "from Sysuser order by id desc";     //hql�ǴӶ����н��в�ѯ��ʹ��Sysuser�����Ǳ�sysuser
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
	 * ȡ�ù���Ա������Ϣ
	 * @param id
	 * @return
	 */
	public Sysuser getSysuserItem(int id){
		Sysuser item = null;
		Session session = HibernateSessionFactory.getSession();
		try{
			String hql = "from Sysuser where id=?";     
			Query q = session.createQuery(hql);
			q.setInteger(0, id);   //ռλ����ƥ���Ǵ�0��ʼ��,sql��ѯ�Ǵ�1��ʼ
			item = (Sysuser) q.uniqueResult();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return item;
	}
	
	/**
	 * ͨ���û���������ȡ�ù���Ա��Ϣ
	 * @param id
	 * @return
	 */
	public Sysuser getSysuserByUnameAndUpass(String uname, String upass){
		Sysuser item = null;
		Session session = HibernateSessionFactory.getSession();
		try{
			String hql = "from Sysuser where uname=? and upass=?";     //hql�ǴӶ����н��в�ѯ��ʹ��Sysuser�����Ǳ�sysuser
			Query q = session.createQuery(hql);
			q.setString(0, uname);   //ռλ����ƥ���Ǵ�0��ʼ��,sql��ѯ�Ǵ�1��ʼ
			q.setString(1, upass);
			item = (Sysuser) q.uniqueResult();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return item;
	}

	/**
	 * ��ӹ���Ա��Ϣ
	 * @param item ������û��idֵ
	 * @return item �����к���idֵ
	 * ��Ҫ������
	 */
	public Sysuser addSysuser(Sysuser item){
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
		return item;
	}
	
	/** 
	 * �޸Ĺ���Ա��Ϣ
	 * @param item Ҫ�޸ĵĶ���
	 * @return
	 */
	public int editSysuser(Sysuser item){
		int iRow =0 ;  //Ӱ�������
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();  //��������
		try{
			session.update(item);   //�����仰����ʵ��Ŀ��Ļ���Ҫ�ø��ӷ�ʽ���и���
			tran.commit();
		}catch(Exception ex){
			tran.rollback();
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return iRow;
	}
	
	/**
	 * ɾ������Ա��Ϣ
	 * @param id
	 * @return
	 */
	public int delSysuser(int id){
		int iRow =0 ;  //Ӱ�������
		Session session = HibernateSessionFactory.getSession();

		try{
			String hql = "delete from Sysuser where id=?";  			
			Query q = session.createQuery(hql);
			q.setInteger(0,id);
			iRow = q.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return iRow;
	}
}