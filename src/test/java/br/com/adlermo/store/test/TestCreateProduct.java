package br.com.adlermo.store.test;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.adlermo.store.dao.CategoryDao;
import br.com.adlermo.store.dao.ProductDao;
import br.com.adlermo.store.model.Category;
import br.com.adlermo.store.model.Product;
import br.com.adlermo.store.util.JPAUtil;

public class TestCreateProduct {

    public static void main(String[] args) {
        Category category = new Category("ELETRONICS");

        Product phone = new Product(
                "Lenovo Ideapad Gaming 3i",
                "Windows 11 (Intel Core i5-11300H - 8GB RAM - GTX 1650 4GB - SSD 500 GB)",
                new BigDecimal(749.90), category);

        EntityManager em = JPAUtil.getEntityManager();

        CategoryDao categoryDao = new CategoryDao(em);
        ProductDao productDao = new ProductDao(em);

        em.getTransaction().begin();

        categoryDao.create(category);
        productDao.create(phone);

        em.getTransaction().commit();
        em.close();
    }

}
