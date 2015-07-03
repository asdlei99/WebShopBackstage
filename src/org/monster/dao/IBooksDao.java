package org.monster.dao;

import java.util.List;

import org.monster.entity.Books;

/**
 * 管理员数据操作接口
 */
public interface IBooksDao {
	/**
	 * 取得书籍分页信息
	 * @param pageSize 每个分页的记录数
	 * @param pageNum 当前要获取分页页码
	 * @return
	 */
	public List<Books> getBooksPageList(int pageSize, int pageNum);
	/**
	 * 取得书籍对象信息，用于后台管理修改前的查询
	 * @param id
	 * @return
	 */
	public Books getBooksItem(String id);
	/**
	 * 添加书籍信息
	 * @param item 对象中没有id值
	 * @return item 对象中含有id值
	 */
	public void addBooks(Books item);
	/** 
	 * 修改书籍信息
	 * @param item 要修改的对象
	 * @return
	 */
	public void editBooks(Books item);
	/**
	 * 删除书籍信息
	 * @param id
	 * @return
	 */
	public int delBooks(int id);
}
