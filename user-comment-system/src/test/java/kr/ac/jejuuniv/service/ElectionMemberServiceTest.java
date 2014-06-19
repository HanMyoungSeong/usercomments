package kr.ac.jejuuniv.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.swing.undo.UndoableEditSupport;

import kr.ac.jejuuniv.model.ElectionMember;
import kr.ac.jejuuniv.service.electionmember.ElectionMemberService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/ac/jejuuniv/repository/test-mybatis-context.xml"})
public class ElectionMemberServiceTest {
	
	private static final int 
	USER_ID = 0;

	private static final int 
	RECOMMENDATION = 1;

	private static final int 
	OPPOSITION = 1;
	
	@Autowired
	private ElectionMemberService electionMemberService;
	
	@Test
	public void //
	should_user_is_add_election_member() {
		ElectionMember election = new ElectionMember();
		election.setUserId(USER_ID);
		
		electionMemberService.addElectionMember(election);
		
		List<ElectionMember> electionMembers = electionMemberService.electionMemberList(USER_ID);
		
		assertFalse(electionMembers.isEmpty());
	}
	
	@Test
	public void //
	should_return_matched_result_when_user_is_recommed() {
		electionMemberService.addRecommend(USER_ID);
		ElectionMember electionMember = electionMemberService.electionMemberList(USER_ID).get(0);
		assertFalse(electionMember.getRecommendation() == RECOMMENDATION);
	}
	
	@Test
	public void //
	should_return_matched_result_when_user_is_opposition() {
		electionMemberService.addOpposition(USER_ID);
		ElectionMember electionMember = electionMemberService.electionMemberList(USER_ID).get(0);
		assertFalse(electionMember.getRecommendation() == OPPOSITION);
	}
	
	@Test	
	public void //
	should_throw_an_exception_when_user_is_duplicate_recommendation() {
		boolean isDuplicateRecommendation =electionMemberService.isDuplicateRecommendation(USER_ID);
		assertTrue(isDuplicateRecommendation);
	}
	
	@Test
	public void //
	should_throw_an_exception_when_user_is_duplciate_opposition() {
		boolean isDuplicateOpposition = electionMemberService.isDuplicateOpposition(USER_ID);
		assertTrue(isDuplicateOpposition);
	}
}
