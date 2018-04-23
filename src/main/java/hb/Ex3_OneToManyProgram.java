package hb;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.answeris.hb.entity.Book;
import com.answeris.hb.entity.Comment;
import com.answeris.hb.entity.Note;
import com.answeris.hb.entity.NoteView;

public class Ex3_OneToManyProgram {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("com/answeris/hb/config/hibernate.cfg.xml")
									.addAnnotatedClass(Note.class) //이걸로 엔티티 추가할 수 있음(hibernate.cfg.xml에서 해도되고)
									.addAnnotatedClass(Comment.class)
									.addAnnotatedClass(NoteView.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		/*-------1. Note 목록 가져오기--------*/
		//List<Note> notes = session.createQuery("from Note").getResultList();
		
		/*Query query = session.createQuery("from Note", Note.class);
		List<Note> notes = query.getResultList();
		
		for(Note n: notes)
			System.out.println(n.getTitle());
			*/
		
		/*-------2. 각 Note에 Comment 목록을 채우기--------*/
		/*for(Note n : notes) {
			Query query1 = session.createQuery("from Comment where noteId=:noteId", Comment.class);
			query1.setParameter("noteId", n.getId());
			List<Comment> comments = query.getResultList();
			n.setComments(comments);
		}*/
		
		/*-------3. NoteView 목록 가져오기--------*/
		Query query2 = session.createQuery("from NoteView", NoteView.class);
		List<NoteView> notes = query2.getResultList();
		
		for(Note n: notes)
			System.out.println(n.getTitle());
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

}
