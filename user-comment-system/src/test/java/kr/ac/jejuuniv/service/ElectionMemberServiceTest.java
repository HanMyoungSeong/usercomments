package kr.ac.jejuuniv.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
	should_add_election_member_when_user_is_not_election_member(){
		try {
			ElectionMember election = new ElectionMember();
			election.setUserId(USER_ID);
			electionMemberService.addElectionMember(election);
		} catch (Exception e) {
			ElectionMember electionMember = electionMemberService.findByUserId(USER_ID);
			assertTrue(electionMember.getUserId() == USER_ID);
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void //
	should_throw_an_exception_when_user_is_duplicated_election_member() {
		ElectionMember electionMember = new ElectionMember();
		electionMember.setUserId(USER_ID);
		electionMemberService.addElectionMember(electionMember);
	}
	
	@Test
	public void //
	should_return_matched_result_when_user_is_opposition() {
		try {
			electionMemberService.addOpposition(USER_ID);
		} catch (Exception e) {
			ElectionMember electionMember = electionMemberService.findByUserId(USER_ID);
			assertTrue(electionMember.getOpposition() == OPPOSITION);
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void //
	should_throw_an_exception_when_user_is_duplicated_opposition() {
		electionMemberService.addOpposition(USER_ID);
	}
	
	@Test
	public void //
	should_return_matched_result_when_user_is_recommedation() {
		try {
			electionMemberService.addRecommend(USER_ID);
		} catch (Exception e) {
			ElectionMember electionMember = electionMemberService.findByUserId(USER_ID);
			assertTrue(electionMember.getRecommendation() == RECOMMENDATION);
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void //
	should_throw_an_exception_when_user_is_duplicated_recommendation() {
		electionMemberService.addRecommend(USER_ID);
	}
}
