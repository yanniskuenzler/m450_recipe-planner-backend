package ch.vanessen.menu.controller;

import ch.vanessen.menu.entities.RecipeEntity;
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
public class RecipeController {

    private final MenuRepository menuRepository;

    public RecipeController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping("/menues")
    public List<RecipeEntity> getMenues() {
        return (List<RecipeEntity>) menuRepository.findAll();
    }

    // works for files
//    @PostMapping(value = "/menu", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
//    void addMenu(@RequestPart RecipeEntity recipeEntity, @RequestPart(value="file", required=true) MultipartFile file) throws IOException {
//        log.info(file.getName());
//        log.info(file.getOriginalFilename());
//        log.info(file.getBytes().toString());
//        menuRepository.save(recipeEntity);
//    }

    @PostMapping(value = "/menu", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
    void addMenu(@RequestPart RecipeEntity recipeEntity, @RequestPart(value="file", required=true) MultipartFile file) throws IOException {
        log.info(file.getName());
        log.info(file.getOriginalFilename());
        log.info(file.getBytes().toString());
        menuRepository.save(recipeEntity);
    }

}
