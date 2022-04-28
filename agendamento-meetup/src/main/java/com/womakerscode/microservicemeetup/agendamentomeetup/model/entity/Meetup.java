package com.womakerscode.microservicemeetup.agendamentomeetup.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotEmpty(message = "Campo obrigatorio")
    private String evento;
    
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataMeetup;

    @Column
    @NotEmpty(message = "Campo obrigatorio.")
    private String local;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "meetup", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Registration> listaRegistrations = new ArrayList<Registration>();
}
