package info.ashutosh.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import info.ashutosh.entity.Product;
import info.ashutosh.utility.HibernateUtil;

public class Test {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = HibernateUtil.getSession();

		// Product product = openSession.get(Product.class, 1l);
		Product product = new Product();
		product.setPid(1l);
		product.setName("Updated");

		Transaction beginTransaction = openSession.beginTransaction();

		// update only provided column value and remaining will be marked as null
		// according to entity class column data type
		openSession.update(product);

		beginTransaction.commit();

		openSession.close();
		sessionFactory.close();

	}
}
