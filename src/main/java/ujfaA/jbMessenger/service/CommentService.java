package ujfaA.jbMessenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ujfaA.jbMessenger.database.DatabaseClass;
import ujfaA.jbMessenger.model.Comment;
import ujfaA.jbMessenger.model.Message;

public class CommentService {
	
	static long commentsCreated = 0;
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllcomments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment) {
		
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		commentsCreated++;
		comment.setId(commentsCreated);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComent(long messageId, Comment comment) {
		if (comment.getId() <= 0)
			return null;
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
}
