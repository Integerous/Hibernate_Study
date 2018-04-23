package hb;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.answeris.hb.entity.Book;
import com.answeris.hb.entity.BookDetail;

public class Ex2_OneToOneProgram {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("com/answeris/hb/config/hibernate.cfg.xml")
									.addAnnotatedClass(BookDetail.class) //이걸로 엔티티 추가할 수 있음(hibernate.cfg.xml에서 해도되고)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		/*-------부모 레코드도 함께 레코드 가져오기--------*/
		/*BookDetail detail = session.get(BookDetail.class, 1);
		Book book = detail.getBook();
		System.out.println(book.getTitle());*/
		
		
		/*-------부모 레코드도 함께 레코드 삽입하기--------*/
		/*Book book = new Book("하이요", "hi.png", "newlec");
		BookDetail detail = new BookDetail();
		
		detail.setPublisher("자호미디어");
		detail.setBook(book);
		session.save(detail);*///입력을 자식 레코드만 입력하도록 요청 -> 부모없이 자식만 들어갈 수 있나?
							//-> 제약조건이 있으므로 에러가 난다. -> entity의 부모객체에 cascadeType.all을 줘서 둘 다 들어갈 수 있게한다.		
		
		
		/*-------부모 레코드도 함께 레코드 삭제하기--------*/
		/*BookDetail bookDetail = session.get(BookDetail.class, 38);
		session.delete(bookDetail);*/
		
		
		/*-------자식 레코드도 함께 레코드 가져오기--------*/
		/*Book book = session.get(Book.class, 118);
		BookDetail detail = book.getBookDetail();
		
		
		System.out.println(detail.getPublisher());*/
		
		
		/*-------Bi-Directional 자식 레코드도 함께 레코드 가져오기--------*/
			//부모 entity의 자식객체에 @OneToOne(mappedBy="book", cascade=CascadeType.ALL) 추가
		
		
		/*-------Bi-Directional 제한적으로 cascade 옵션 설정하기--------*/
			//자식 entity의 부모객체에서 @OneToOne(cascade={CascadeType.DETACH,
		
		
		/*-------자식 레코드만 삭제하기--------*/
		BookDetail bookDetail = session.get(BookDetail.class, 129);
		
		bookDetail.getBook().setBookDetail(null);
		//부모가 자식을 참조하고있으므로 자식이 삭제되어도 부모가 자동으로 자식의 값이 null이 아니게 한다.
		//때문에 자식에서.부모를얻고.부모에서 자식의 값을 null로 지정해줌으로써 객체관계를 끊어야한다.
		session.delete(bookDetail);
		
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

}
