package cdu.edu.hospital.service;

import java.util.List;

import cdu.edu.hospital.entity.Category;

public interface CategoryService {
	
	/**
	 * ��ѯ��������
	 * @param category
	 */
	public List<Category> categoryQuery(Category category);
	/**
	 * ���²������͵ļ۸�
	 * @param category
	 */
	public void categoryUpdate(Category category);
}
