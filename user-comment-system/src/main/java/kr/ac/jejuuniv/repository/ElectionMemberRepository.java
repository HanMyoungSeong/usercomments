package kr.ac.jejuuniv.repository;

import java.util.List;

import kr.ac.jejuuniv.model.ElectionMember;

import org.springframework.stereotype.Repository;

@Repository
public interface ElectionMemberRepository {

	void insert(ElectionMember electionMember);

	List<ElectionMember> getAll(int userId);

	void recommend(int userId);

	void opposition(int userId);

	ElectionMember get(int userId);
}