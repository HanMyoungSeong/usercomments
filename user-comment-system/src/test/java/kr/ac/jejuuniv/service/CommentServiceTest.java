package kr.ac.jejuuniv.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import kr.ac.jejuuniv.model.Comment;
import kr.ac.jejuuniv.service.comment.CommentService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:kr/ac/jejuuniv/repository/test-mybatis-context.xml" })
public class CommentServiceTest {

	private static final int 
	FOREIGN_KEY_ID = 21;

	private static final int 
	COMMENT_ID = 102;

	private static final String 
	AUTHOR = "testname650130925";

	private static final String 
	COMMENT = "testcomment";

	private static final int 
	RECOMMENDATION = 0;

	private static final int 
	OPPOSITION = 0;

	private static final String 
	DATE = "2014.06.17";

	private static final String 
	TIME = "0";
	
	@Autowired
	private CommentService commentService;

	@Test
	public void //
	should_return_matched_result_when_importing_a_comment() {
		Comment comment = commentService.findByCommentId(COMMENT_ID);

		assertThat(comment.getId(), is(FOREIGN_KEY_ID));
		assertThat(comment.getCommentId(), is(COMMENT_ID));
		assertThat(comment.getAuthor(), is(AUTHOR));
		assertThat(comment.getComment(), is(COMMENT));
		assertThat(comment.getDate(), is(DATE));
		assertThat(comment.getTime(), is(TIME));
		assertFalse(comment.getRecommendation() == RECOMMENDATION);
		assertFalse(comment.getOpposition() == OPPOSITION);
	}

	@Test
	public void //
	should_return_matched_result_when_user_is_added_comment() {
		Comment comment = new Comment();
		comment.setId(FOREIGN_KEY_ID);
		comment.setAuthor(AUTHOR);
		comment.setComment(COMMENT);
		comment.setRecommendation(RECOMMENDATION);
		comment.setOpposition(OPPOSITION);
		commentService.addComment(comment);

		Comment findComment = commentService.findByCommentId(COMMENT_ID);

		assertThat(findComment.getId(), is(FOREIGN_KEY_ID));
		assertThat(findComment.getCommentId(), is(COMMENT_ID));
		assertThat(findComment.getAuthor(), is(AUTHOR));
		assertThat(findComment.getComment(), is(COMMENT));
		assertThat(findComment.getDate(), is(DATE));
		assertThat(comment.getTime(), is(TIME));
		assertFalse(findComment.getRecommendation() == RECOMMENDATION);
		assertFalse(findComment.getOpposition() == OPPOSITION);
	}

	@Test
	public void //
	should_return_matched_result_when_importing_the_comment_list() {
		List<Comment> commentList = commentService.commentList();
		assertFalse(commentList.isEmpty());
	}

	@Test
	public void //
	should_return_null_when_user_is_deleted_comment() {
		int deleteCommentId = 4;
		commentService.deleteComment(deleteCommentId);
		Comment deletedComment = commentService.findByCommentId(deleteCommentId);
		assertNull(deletedComment);
	}

	@Test
	public void //
	should_return_matched_result_when_user_is_recommend_comment() {
		commentService.addRecommend(COMMENT_ID);
		Comment comment = commentService.findByCommentId(COMMENT_ID);
		assertFalse(comment.getRecommendation() == RECOMMENDATION);
	}

	@Test
	public void //
	should_return_matched_result_when_user_is_oppose_comment() {
		commentService.addOpposition(COMMENT_ID);
		Comment comment = commentService.findByCommentId(COMMENT_ID);
		assertFalse(comment.getOpposition() == OPPOSITION);
	}
}