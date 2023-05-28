package com.sagem.emt.dao.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sagem.emt.config.StringListConverter;
import com.sagem.emt.dao.bo.MovementDirectionCount;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emt_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	@Column(nullable = false, unique = true)
	private String email;
	private String mobile;
	@Column(updatable = false, nullable = false)
	private String password;
	@Convert(converter = StringListConverter.class)
	private List<String> permissions;
	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Movement> movements;
	@Transient
	private List<MovementDirectionCount> counts;
}
