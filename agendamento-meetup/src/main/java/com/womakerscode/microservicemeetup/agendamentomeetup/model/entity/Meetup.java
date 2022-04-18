package com.womakerscode.microservicemeetup.agendamentomeetup.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "TB_MEETUP")
public class Meetup {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String event;

    @JoinColumn(name = "id_meetup")
    @ManyToOne
    private Registration registration;

    @Column
    private String dataMeetup;;

    @Column
    private Boolean registered;
}
