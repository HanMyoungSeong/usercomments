package kr.ac.jejuuniv.service.electionmember;

import kr.ac.jejuuniv.model.ElectionMember;
import kr.ac.jejuuniv.repository.ElectionMemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectionMemberServiceImpl implements ElectionMemberService {

	@Autowired
	private ElectionMemberRepository electionMemberRepository;

	@Override
	public ElectionMember findByUserId(int userId) {
		return electionMemberRepository.get(userId);
	}

	@Override
	public void addElectionMember(ElectionMember electionMember) {
		ElectionMember addedUser = electionMemberRepository.get(electionMember.getUserId());
		if (addedUser == null)
			electionMemberRepository.insert(electionMember);
		else
			throw new IllegalArgumentException("user is duplicated election member(" + electionMember.getUserId() + ") METHOD : addElectionMember()");
	}

	@Override
	public void addRecommend(int userId) {
		ElectionMember electionMember = electionMemberRepository.get(userId);
		System.out.println(electionMember.getRecommendation());
		if(electionMember.getRecommendation() == 0){
			electionMemberRepository.recommend(userId);
		}else{
			throw new IllegalArgumentException("user is dupliated election ("+userId+") METHOD : addRecommend()");
		}
	}

	@Override
	public void addOpposition(int userId) {
		ElectionMember electionMember = electionMemberRepository.get(userId);
		if(electionMember.getOpposition() == 0){
			electionMemberRepository.opposition(userId);
		}else{
			throw new IllegalArgumentException("user is dupliated election ("+userId+") METHOD : addOpposition()");
		}
	}
}
