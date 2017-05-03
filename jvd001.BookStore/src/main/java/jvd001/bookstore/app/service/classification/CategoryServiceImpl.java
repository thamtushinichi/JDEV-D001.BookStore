package jvd001.bookstore.app.service.classification;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import jvd001.bookstore.app.dao.classification.CategoryDAO;
import jvd001.bookstore.app.model.classification.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	private CategoryDAO categoryDAO;

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@Override
	@Transactional
	public void addCategory(Category p) {
		this.categoryDAO.addCategory(p);
	}

	@Override
	@Transactional
	public void updateCategory(Category p) {
		this.categoryDAO.updateCategory(p);
	}

	@Override
	@Transactional
	public List<Category> listCategory() {
		return this.categoryDAO.listCategory();
	}

	@Override
	@Transactional
	public Category getCategoryById(int id) {
		return this.categoryDAO.getCategoryById(id);
	}

	@Override
	@Transactional
	public void removeCategory(int id) {
		this.categoryDAO.removeCategory(id);
	}

}
