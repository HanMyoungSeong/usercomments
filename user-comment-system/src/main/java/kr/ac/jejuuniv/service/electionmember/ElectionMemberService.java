package kr.ac.jejuuniv.service.electionmember;

import kr.ac.jejuuniv.model.ElectionMember;

public interface ElectionMemberService {

	void addElectionMember(ElectionMember electionMember);

	void addRecommend(int userId);

	void addOpposition(int userId);

	ElectionMember findByUserId(int userId);

}
