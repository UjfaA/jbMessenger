package ujfaA.jbMessenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ujfaA.jbMessenger.model.Message;
import ujfaA.jbMessenger.resources.beans.MessageFilter;
import ujfaA.jbMessenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages(@BeanParam MessageFilter filter) {
		if (filter.getYear() > 0) 
			return messageService.getAllMessagesForYear(filter.getYear());
		if (filter.getStart() > 0 && filter.getSize() > 0)
			return messageService.getAllMessagesPagineted(filter.getStart(), filter.getSize());
		return messageService.getAllMessages();
	}
	
	@POST
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}
	
	@Path("/{messageId}")
	@GET
	public Message getMessage(@PathParam("messageId") long id) {
		return messageService.getMessage(id);
	}

	@Path("/{messageId}")
	@PUT
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);	
	}
	
	@Path("/{messageId}")
	@DELETE
	public void deleteMessage(@PathParam("messageId") long id) {
		messageService.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
}
