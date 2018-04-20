package hb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.answeris.hb.entity.Book;

public class Ex1_CRUDProgram {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("com/answeris/hb/config/hibernate.cfg.xml")
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		
		
	/*-------1. insert-------*/
	/*Book book = new Book("오키도키","pic.png","jaho");
	session.save(book);*/
	

	/*-------2. select-------*/
	//Book book = session.get(Book.class, 5);
	//List<Book> books = session.createQuery("from Book").getResultList();
	
	/*-------3. update-------*/
						/*session //이 방법은 최후의 방법.
						.createQuery("update Book set title='aaa' where id=3")
						.executeUpdate();*/
	Book book = session.get(Book.class, 5);	
	book.setTitle("바뀐제목");
	session.update(book);
	
	
	/*-------4. delete-------*/
	//session.delete(arg0);
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

}
