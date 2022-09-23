package tw.tylu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	public boolean checkLogin(Account account) {
		return accountDao.checkLogin(account);
		
	}

}
