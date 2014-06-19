package kr.ac.jejuuniv.service.electionmember;

import java.util.List;

import kr.ac.jejuuniv.model.ElectionMember;

public interface ElectionMemberService {

	void addElectionMember(ElectionMember electionMember);

	List<ElectionMember> electionMemberList(int userId);

	void addRecommend(int userId);

	void addOpposition(int userId);

	boolean isDuplicateRecommendation(int userId);

	boolean isDuplicateOpposition(int userId);

}
