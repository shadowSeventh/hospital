package cdu.edu.hospital.dao;

import java.util.List;
import cdu.edu.hospital.entity.Category;

public interface CategoryDao {
	/**
	 * �������͵Ĳ�ѯ
	 * @param category
	 * @return
	 */
	public List<Category> categoryQuery(Category category);
	/**
	 * ���²������͵ļ۸�
	 * @param category
	 */
	public void categoryUpdate(Category category);
}
