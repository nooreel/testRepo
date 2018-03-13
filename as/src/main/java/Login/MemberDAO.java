package Login;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import User.Model.EmployeeBean;


@Component
public class MemberDAO {

	@Inject
	SqlSession sqlSession;
	
	private final String namespace="LoginMapper";
	
	
	public boolean loginCheck(EmployeeBean vo){

		String one = sqlSession.selectOne(namespace+".loginCheck",vo);

		return (one==null)?false:true;

		


	}
}
