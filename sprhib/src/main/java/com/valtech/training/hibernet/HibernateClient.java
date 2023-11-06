package com.valtech.training.hibernet;

import java.text.SimpleDateFormat;
import java.text.DateFormat;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateClient {

	public static void main(String[] args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Tx.class).addAnnotatedClass(TellerTx.class).addAnnotatedClass(ChequeTx.class)
				.addAnnotatedClass(AtmTx.class);
		cfg.addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class).addAnnotatedClass(Account.class);
		cfg.addAnnotatedClass(Registration.class).addAnnotatedClass(BankAccount.class);
		SessionFactory sesFac = cfg.buildSessionFactory();
		Session ses = sesFac.openSession();
		Transaction tx = ses.beginTransaction();
		ses.persist(new BankAccount(new BankAccountId("SB",1),3000));
		BankAccountId id=new BankAccountId("SB",1);
		BankAccount ba=(BankAccount)ses.load(BankAccount.class,id);

//		Customer cus = new Customer("Sneha", 22);
//		ses.save(cus);
//		Address addr = new Address("bgl", "vijayanagar", 560040);
//		addr.setCustomer(cus);
//		ses.save(addr);
//
//		Account acc = new Account(10000, "sbi");
//		Account acc1 = new Account(20000, "CA");
//		Tx tx1 = new Tx(1000);
//		Tx tx2 = new Tx(2000);
//		Tx tx3 = new Tx(3000);
//		Tx tx4 = new Tx(4000);
//		Tx tx5 = new ChequeTx(2000, 456789, 567890);
//
//  	ses.save(new Tx(1000));
//		ses.save(new ChequeTx(2000,123123,2345));
//		ses.save(new TellerTx(3000,123,234));
//		ses.save(new AtmTx(5000,789));
//	
//		
//		Customer cus1 = new Customer("Chandu", 23);
//		Customer cus2 = new Customer("Sanju", 45);
//		
//		Address addr1 = new Address("jayanagare", "bgl", 234567);
//		Address addr2 = new Address("vijanagar", "rbk", 45678);
//		
//		acc.addTx(tx1);
//		acc.addTx(tx2);
//		acc.addTx(tx3);
//		acc.addTx(tx4);
//		acc1.addTx(tx5);
//		
//		ses.persist(acc);
//		ses.persist(acc1);
//		
//		ses.persist(tx1);
//		ses.persist(tx2);
//		ses.persist(tx3);
//		ses.persist(tx4);
//		ses.persist(tx5);
//	
//		ses.persist(addr1);
//		ses.persist(addr2);
//		ses.persist(cus1);
//		ses.persist(cus2);
//		cus1.setAddress(addr1);
//		addr1.setCustomer(cus1);
//		cus2.setAddress(addr2);
//		addr2.setCustomer(cus2);
//		acc1.addCustomers(cus2);
//		acc1.addCustomers(cus);
//		acc.addCustomers(cus1);
//		acc.addCustomers(cus2);
//		acc.addCustomers(cus);

//		ses.createQuery("select  distinct tx.account from Tx tx").list().forEach(t -> System.out.println(t));
//		org.hibernate.Query query=ses.createQuery("select distinct c from Customer c join c.account a join a.txs t where t.amount>?");
//		query.setFloat(0, 3000);
//		query.list().forEach(t ->System.out.println(t));
		
		Query query=ses.getNamedQuery("Tx.findAllByCityAndAmountGreaterThan");
//				ses.createQuery("select t from Tx t Join t.account.customers c where c.address.city =? AND t.amount>?");
		query.setString(0,"blr");
		query.setFloat(1, 3000);
		query.list().forEach(t->System.out.println(t));
//		
//		int id = (Integer) ses.save(new Employee("Sneha", df.parse("17-05-2001"), 20000, 'F', false));
//		Employee e = (Employee) ses.get(Employee.class, 1);
//		System.out.println(e.getClass().getName());
//		e.setName("Chandu");
//      ses.merge(e);
		tx.commit();
		ses.close();
		sesFac.close();

	}
}
