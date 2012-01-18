package emross.json.bean;

import emross.json.bean.item.Event;
import emross.json.bean.item.Status;
import emross.json.bean.item.User;

public class UserInfo {

	private User user;
	private Event[] events;
	private Status status;

	public final User getUser() {
		return user;
	}

	public final void setUser(User user) {
		this.user = user;
	}

	public final Event[] getEvents() {
		return events;
	}

	public final void setEvents(Event[] events) {
		this.events = events;
	}

	public final Status getStatus() {
		return status;
	}

	public final void setStatus(Status status) {
		this.status = status;
	}

}
