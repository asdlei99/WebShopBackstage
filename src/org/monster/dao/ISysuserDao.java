package org.monster.dao;

import java.util.List;

import org.monster.entity.Sysuser;


/**
 * ����Ա���ݲ����ӿ�
 */
public interface ISysuserDao {
	/**
	 * ȡ�ù���Ա��ҳ��Ϣ
	 * @param pageSize ÿ����ҳ�ļ�¼��
	 * @param pageNum ��ǰҪ��ȡ��ҳҳ��
	 * @return
	 */
	public List<Sysuser> getSysuserPageList(int pageSize, int pageNum);
	/**
	 * ȡ�ù���Ա������Ϣ�����ں�̨�����޸�ǰ�Ĳ�ѯ
	 * @param id
	 * @return
	 */
	public Sysuser getSysuserItem(int id);
	/**
	 * ͨ���û���������ȡ�ù���Ա��Ϣ
	 * @param id
	 * @return
	 */
	public Sysuser getSysuserByUnameAndUpass(String uname, String upass);
	/**
	 * ��ӹ���Ա��Ϣ
	 * @param item ������û��idֵ
	 * @return item �����к���idֵ
	 */
	public Sysuser addSysuser(Sysuser item);
	/** 
	 * �޸Ĺ���Ա��Ϣ
	 * @param item Ҫ�޸ĵĶ���
	 * @return
	 */
	public int editSysuser(Sysuser item);
	/**
	 * ɾ������Ա��Ϣ
	 * @param id
	 * @return
	 */
	public int delSysuser(int id);
}
