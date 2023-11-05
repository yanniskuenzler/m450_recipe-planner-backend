package ch.vanessen.menu.controller;

import ch.vanessen.menu.entities.Menu;
import ch.vanessen.menu.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = {"http://localhost:3000", "http://192.168.1.157:3000"})
public class MenuesController {

    private final MenuRepository menuRepository;

    public MenuesController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping("/menues")
    public List<Menu> getMenues() {
        return (List<Menu>) menuRepository.findAll();
    }

    @PostMapping(value = "/menu", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
    void addMenu(@RequestPart Menu menu, @RequestPart(value="file", required=true) MultipartFile file) throws IOException {
        log.info(file.getName());
        log.info(file.getOriginalFilename());
        log.info(file.getBytes().toString());
        menuRepository.save(menu);
    }

}
