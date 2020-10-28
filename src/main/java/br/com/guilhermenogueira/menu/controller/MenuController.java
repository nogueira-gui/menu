package br.com.guilhermenogueira.menu.controller;

import br.com.guilhermenogueira.menu.controller.dto.MenuRq;
import br.com.guilhermenogueira.menu.controller.dto.MenuRs;
import br.com.guilhermenogueira.menu.repository.MenuRepository;
import br.com.guilhermenogueira.menu.model.Menu;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuRepository menuRepository;
    //private final PessoaCustomRepository pessoaCustomRepository;

    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping("/")
    public List<MenuRs> findAll() {
        var menus = menuRepository.findAll();
        return menus
                .stream()
                .map(MenuRs::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MenuRs findById(@PathVariable("id") Long id) {
        var menu = menuRepository.getOne(id);
        return MenuRs.converter(menu);
    }

    @PostMapping("/")
    public void saveMenu(@RequestBody MenuRq menu) {
        var m = new Menu();
        m.setTitle(menu.getTitle());
        m.setDescription(menu.getDescription());
        menuRepository.save(m);
    }

    @PutMapping("/{id}")
    public void updateMenu(@PathVariable("id") Long id, @RequestBody MenuRq menu) throws Exception {
        var m = menuRepository.findById(id);

        if (m.isPresent()) {
            var menuSave = m.get();
            menuSave.setTitle(menu.getTitle());
            menuSave.setDescription(menu.getDescription());
            menuRepository.save(menuSave);
        } else {
            throw new Exception("Menu ID não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMenu(@PathVariable("id") long id) throws Exception {
            try {
                menuRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    @DeleteMapping("/menu")
    public ResponseEntity<HttpStatus> deleteAllMenus() {
        try {
            menuRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/filter")
    public List<MenuRs> findByTitle(@RequestParam("titulo") String title) {
        return this.menuRepository.findByTitleContains(title)
                .stream()
                .map(MenuRs::converter)
                .collect(Collectors.toList());
    }

}