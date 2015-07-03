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
 * 管理员数据库操作实现类
 */
public class SysuserDaoImpl implements ISysuserDao {
	/**
	 * 取得管理员分页信息，这个分页是个模板，对所有的数据库都一样
	 * @param pageSize 每个分页的记录数
	 * @param pageNum 当前要获取分页页码
	 * @return
	 */
	@SuppressWarnings("unchecked")   //这句话去掉不匹配的提示
	public List<Sysuser> getSysuserPageList(int pageSize, int pageNum){
		List<Sysuser> list = new ArrayList<Sysuser>();
		Session session = HibernateSessionFactory.getSession();
		try{
			String hql = "from Sysuser order by id desc";     //hql是从对象中进行查询，使用Sysuser而不是表sysuser
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
	 * 取得管理员对象信息
	 * @param id
	 * @return
	 */
	public Sysuser getSysuserItem(int id){
		Sysuser item = null;
		Session session = HibernateSessionFactory.getSession();
		try{
			String hql = "from Sysuser where id=?";     
			Query q = session.createQuery(hql);
			q.setInteger(0, id);   //占位符的匹配是从0开始的,sql查询是从1开始
			item = (Sysuser) q.uniqueResult();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return item;
	}
	
	/**
	 * 通过用户名和密码取得管理员信息
	 * @param id
	 * @return
	 */
	public Sysuser getSysuserByUnameAndUpass(String uname, String upass){
		Sysuser item = null;
		Session session = HibernateSessionFactory.getSession();
		try{
			String hql = "from Sysuser where uname=? and upass=?";     //hql是从对象中进行查询，使用Sysuser而不是表sysuser
			Query q = session.createQuery(hql);
			q.setString(0, uname);   //占位符的匹配是从0开始的,sql查询是从1开始
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
	 * 添加管理员信息
	 * @param item 对象中没有id值
	 * @return item 对象中含有id值
	 * 需要事务处理
	 */
	public Sysuser addSysuser(Sysuser item){
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
		return item;
	}
	
	/** 
	 * 修改管理员信息
	 * @param item 要修改的对象
	 * @return
	 */
	public int editSysuser(Sysuser item){
		int iRow =0 ;  //影响的行数
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.beginTransaction();  //开启事务
		try{
			session.update(item);   //如果这句话不能实现目标的话，要用复杂方式进行更新
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
	 * 删除管理员信息
	 * @param id
	 * @return
	 */
	public int delSysuser(int id){
		int iRow =0 ;  //影响的行数
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