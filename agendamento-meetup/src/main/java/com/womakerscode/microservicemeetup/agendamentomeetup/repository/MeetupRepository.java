package com.womakerscode.microservicemeetup.agendamentomeetup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.womakerscode.microservicemeetup.agendamentomeetup.model.entity.Meetup;

@Repository
public interface MeetupRepository extends JpaRepository<Meetup, Long>{

}
