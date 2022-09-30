package fifth.project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberDao mDao;

	public void delete(Member m) {
		mDao.delete(m);
	}
	
	public void deleteById(Integer id) {
		mDao.deleteById(id);
	}
	
	public Member insertMem(Member m) {
		return mDao.insert(m);
	}
}
