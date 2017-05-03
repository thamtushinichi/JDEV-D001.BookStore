package jvd001.bookstore.app.service.classification;

import java.util.List;

import jvd001.bookstore.app.model.classification.Category;

public interface CategoryService {
	public void addCategory(Category p);
	public void updateCategory(Category p);
	public List<Category> listCategory();
	public Category getCategoryById(int id);
	public void removeCategory(int id);
}
