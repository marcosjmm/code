package com.marcosmelo.br.code.projeto.model.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="membros", schema="projeto")
@Data
@NoArgsConstructor
public class Membro {
	
	
	@EmbeddedId
	private MembroId id;

}
