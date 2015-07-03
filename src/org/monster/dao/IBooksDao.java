package org.monster.dao;

import java.util.List;

import org.monster.entity.Books;

/**
 * ����Ա���ݲ����ӿ�
 */
public interface IBooksDao {
	/**
	 * ȡ���鼮��ҳ��Ϣ
	 * @param pageSize ÿ����ҳ�ļ�¼��
	 * @param pageNum ��ǰҪ��ȡ��ҳҳ��
	 * @return
	 */
	public List<Books> getBooksPageList(int pageSize, int pageNum);
	/**
	 * ȡ���鼮������Ϣ�����ں�̨�����޸�ǰ�Ĳ�ѯ
	 * @param id
	 * @return
	 */
	public Books getBooksItem(String id);
	/**
	 * ����鼮��Ϣ
	 * @param item ������û��idֵ
	 * @return item �����к���idֵ
	 */
	public void addBooks(Books item);
	/** 
	 * �޸��鼮��Ϣ
	 * @param item Ҫ�޸ĵĶ���
	 * @return
	 */
	public void editBooks(Books item);
	/**
	 * ɾ���鼮��Ϣ
	 * @param id
	 * @return
	 */
	public int delBooks(int id);
}
