package com.curdop.dao;

import com.curdop.entity.Product;
import com.curdop.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ProductHQLDAO {

    public List<Product> getProductsSortedByPriceAsc() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Product p ORDER BY p.price ASC", Product.class).list();
        }
    }

    public List<Product> getProductsSortedByPriceDesc() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Product p ORDER BY p.price DESC", Product.class).list();
        }
    }

    public List<Product> getProductsSortedByQuantityDesc() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Product p ORDER BY p.quantity DESC", Product.class).list();
        }
    }

    public List<Product> getProductsPage(int startIndex, int pageSize) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Product p ORDER BY p.id ASC", Product.class)
                    .setFirstResult(startIndex)
                    .setMaxResults(pageSize)
                    .list();
        }
    }

    public long countTotalProducts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT COUNT(p) FROM Product p", Long.class).getSingleResult();
        }
    }

    public long countInStockProducts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT COUNT(p) FROM Product p WHERE p.quantity > 0", Long.class).getSingleResult();
        }
    }

    public List<Object[]> countGroupedByDescription() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT p.description, COUNT(p) FROM Product p GROUP BY p.description",
                    Object[].class
            ).list();
        }
    }

    public Object[] minMaxPrice() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT MIN(p.price), MAX(p.price) FROM Product p",
                    Object[].class
            ).getSingleResult();
        }
    }

    public List<Product> getProductsWithinPriceRange(double min, double max) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM Product p WHERE p.price BETWEEN :min AND :max ORDER BY p.price ASC",
                    Product.class
            ).setParameter("min", min)
             .setParameter("max", max)
             .list();
        }
    }

    public List<Product> nameStartsWith(String prefix) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM Product p WHERE p.name LIKE :pat ORDER BY p.name",
                    Product.class
            ).setParameter("pat", prefix + "%").list();
        }
    }

    public List<Product> nameEndsWith(String suffix) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM Product p WHERE p.name LIKE :pat ORDER BY p.name",
                    Product.class
            ).setParameter("pat", "%" + suffix).list();
        }
    }

    public List<Product> nameContains(String sub) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM Product p WHERE p.name LIKE :pat ORDER BY p.name",
                    Product.class
            ).setParameter("pat", "%" + sub + "%").list();
        }
    }

    public List<Product> nameWithExactLength(int len) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM Product p WHERE LENGTH(p.name) = :len ORDER BY p.name",
                    Product.class
            ).setParameter("len", len).list();
        }
    }
}
