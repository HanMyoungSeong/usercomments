package kr.ac.jejuuniv.service.electionmember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jejuuniv.model.ElectionMember;
import kr.ac.jejuuniv.repository.ElectionMemberRepository;

@Service
public class ElectionMemberServiceImpl implements ElectionMemberService {

	@Autowired
	private ElectionMemberRepository electionMemberRepository;

	@Override
	public void addElectionMember(ElectionMember electionMember) {
		electionMemberRepository.insert(electionMember);
	}

	@Override
	public List<ElectionMember> electionMemberList(int userId) {
		return electionMemberRepository.getAll(userId);
	}

	@Override
	public void addRecommend(int userId) {
		electionMemberRepository.recommend(userId);
	}

	@Override
	public void addOpposition(int userId) {
		electionMemberRepository.opposition(userId);
	}

	@Override
	public boolean isDuplicateRecommendation(int userId) {
		for (ElectionMember electionMember : electionMemberRepository.getAll(userId)) {
			if (electionMember.getRecommendation() == 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isDuplicateOpposition(int userId) {
		for (ElectionMember electionMember : electionMemberRepository.getAll(userId)) {
			if (electionMember.getOpposition() == 0) {
				return false;
			}
		}
		return true;
	}
}
