package br.com.guilhermenogueira.menu.model;

import javax.persistence.*;

@Entity
@Table(name = "MENU")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="menu_id")
	private Long id;

	@Column(name="titulo")
	private String title;

	@Column(name="descri")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
