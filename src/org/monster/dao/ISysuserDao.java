package org.monster.dao;

import java.util.List;

import org.monster.entity.Sysuser;


/**
 * 管理员数据操作接口
 */
public interface ISysuserDao {
	/**
	 * 取得管理员分页信息
	 * @param pageSize 每个分页的记录数
	 * @param pageNum 当前要获取分页页码
	 * @return
	 */
	public List<Sysuser> getSysuserPageList(int pageSize, int pageNum);
	/**
	 * 取得管理员对象信息，用于后台管理修改前的查询
	 * @param id
	 * @return
	 */
	public Sysuser getSysuserItem(int id);
	/**
	 * 通过用户名和密码取得管理员信息
	 * @param id
	 * @return
	 */
	public Sysuser getSysuserByUnameAndUpass(String uname, String upass);
	/**
	 * 添加管理员信息
	 * @param item 对象中没有id值
	 * @return item 对象中含有id值
	 */
	public Sysuser addSysuser(Sysuser item);
	/** 
	 * 修改管理员信息
	 * @param item 要修改的对象
	 * @return
	 */
	public int editSysuser(Sysuser item);
	/**
	 * 删除管理员信息
	 * @param id
	 * @return
	 */
	public int delSysuser(int id);
}
