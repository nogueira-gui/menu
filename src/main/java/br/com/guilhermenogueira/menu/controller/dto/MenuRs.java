package br.com.guilhermenogueira.menu.controller.dto;

import br.com.guilhermenogueira.menu.model.Menu;

public class MenuRs {

    private Long id;
    private String title;
    private String description;

    public static MenuRs converter(Menu m) {
        var menu = new MenuRs();
        menu.setId(m.getId());
        menu.setTitle(m.getTitle());
        menu.setDescription(m.getDescription());
        return menu;
    }

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