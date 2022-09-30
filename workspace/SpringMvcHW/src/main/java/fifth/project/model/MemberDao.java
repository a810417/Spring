package fifth.project.model;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MemberDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void delete(Member bean) {
		Session session = sessionFactory.openSession();
		if (bean != null) {
			session.beginTransaction();
			session.delete(bean);
			session.getTransaction().commit();
		}
		session.close();
	}

	public void deleteById(Integer id) {
		Session session = sessionFactory.openSession();

		Member member = session.get(Member.class, id);

		if (member != null) {
			session.beginTransaction();
			System.out.println("進來了");
			System.out.println(member.getAccount() + " " + member.getNickname());
			session.delete(member);
			session.getTransaction().commit();
		}

		session.close();
		System.out.println("session關閉");
	}

	public Member insert(Member m) {
		Session session = sessionFactory.openSession();

//		String hqlstr = "from member where account=:account";
//		Query<Member> query = session.createQuery(hqlstr, Member.class);
//		Member member = session.get(Member.class, m.getAccount());

//
//		if (query == null) {
//			session.beginTransaction();
//		m.setCreate_at(new Date());
		session.save(m);

//			session.getTransaction().commit();
//		}
		session.close();
		return m;
	}

}
