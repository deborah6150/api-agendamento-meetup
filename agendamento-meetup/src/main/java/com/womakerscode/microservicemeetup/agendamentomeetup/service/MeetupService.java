package com.womakerscode.microservicemeetup.agendamentomeetup.service;

import java.util.List;

import com.womakerscode.microservicemeetup.agendamentomeetup.model.entity.Meetup;

public interface MeetupService {

	Meetup createMeetup(Meetup meetup);
	List<Meetup> getAllMeetups();
	Meetup getMeetupById(Long id);
	Meetup editMeetup(Long id, Meetup meetup);
	Object deleteMeetup(Long id);
}
