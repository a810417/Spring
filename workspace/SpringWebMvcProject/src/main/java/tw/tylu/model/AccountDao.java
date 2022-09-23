package tw.tylu.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AccountDao {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean checkLogin(Account account) {
		Session session = sessionFactory.openSession();

		String hqlstr = "from Account where username=:user and userpwd=:pwd";
		Query<Account> query = session.createQuery(hqlstr, Account.class);
		query.setParameter("user", account.getUsername());
		query.setParameter("pwd", account.getUserpwd());

		Account myAccount = query.uniqueResult(); // 回傳 single instance(有找到資料) 或是 null(無資料)
		session.close();

		if (myAccount != null) {
			return true;
		}

		return false;
	}
}
