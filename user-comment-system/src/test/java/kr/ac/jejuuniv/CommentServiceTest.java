package kr.ac.jejuuniv;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import kr.ac.jejuuniv.service.CommentService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:kr/ac/jejuuniv/repository/test-mybatis-context.xml" })
public class CommentServiceTest {

	private static final int 
	FOREIGN_KEY_ID = 2;
	
	private static final int 
	COMMEND_ID = 1;
	
	private static final String 
	AUTHOR = "testname3";
	
	private static final String 
	COMMENT = "testcomment";
	
	private static final int 
	RECOMMENDATION = 0;
	
	private static final int 
	OPPOSITION = 0;
	
	private static final String 
	DATE = "2014.06.15";

	@Autowired
	private CommentService commentService;

	@Test
	public void //
	should_return_matched_result_when_importing_a_comment() {
		Comment comment = commentService.findByCommentId(COMMEND_ID);

		assertThat(comment.getId(), is(FOREIGN_KEY_ID));
		assertThat(comment.getAuthor(), is(AUTHOR));
		assertThat(comment.getComment(), is(COMMENT));
		assertThat(comment.getRecommendation(), is(RECOMMENDATION));
		assertThat(comment.getOpposition(), is(OPPOSITION));
		assertThat(comment.getDate(), is(DATE));
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

		Comment findComment = commentService.findByCommentId(COMMEND_ID);

		assertThat(findComment.getId(), is(FOREIGN_KEY_ID));
		assertThat(findComment.getAuthor(), is(AUTHOR));
		assertThat(findComment.getComment(), is(COMMENT));
		assertThat(findComment.getRecommendation(), is(RECOMMENDATION));
		assertThat(findComment.getOpposition(), is(OPPOSITION));
		assertThat(findComment.getDate(), is(DATE));

	}

	@Test
	public void //
	should_return_matched_result_when_importing_the_comment_list() {
		List<Comment> commentList = commentService.commentList();

		Comment commentListIndexZero = commentList.get(0);

		assertThat(commentListIndexZero.getId(), is(FOREIGN_KEY_ID));
		assertThat(commentListIndexZero.getAuthor(), is(AUTHOR));
		assertThat(commentListIndexZero.getComment(), is(COMMENT));
		assertThat(commentListIndexZero.getRecommendation(), is(RECOMMENDATION));
		assertThat(commentListIndexZero.getOpposition(), is(OPPOSITION));
		assertThat(commentListIndexZero.getDate(), is(DATE));
	}

	@Test
	public void //
	user_is_deleted_comment() {
		int deleteCommentId = 4;
		commentService.deleteComment(deleteCommentId);

		Comment deletedComment = commentService.findByCommentId(deleteCommentId);

		assertNull(deletedComment);

	}
}
