package hb;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.answeris.hb.entity.Book;
import com.answeris.hb.entity.BookDetail;
import com.answeris.hb.entity.Comment;
import com.answeris.hb.entity.Note;
import com.answeris.hb.entity.NoteView;

public class Ex4_ManyToManyProgram {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("com/answeris/hb/config/hibernate.cfg.xml")
									.addAnnotatedClass(Note.class) //이걸로 엔티티 추가할 수 있음(hibernate.cfg.xml에서 해도되고)
									.addAnnotatedClass(NoteView.class)
									.addAnnotatedClass(Book.class)
									.addAnnotatedClass(BookDetail.class)
									.addAnnotatedClass(Comment.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		
		Note note = session.get(Note.class, 76);
		System.out.println(note.getTitle());
		
		List<Book> books = note.getBooks();
		for(Book b : books)
			System.out.println("\tbook title:"+b.getTitle());
		
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

}
