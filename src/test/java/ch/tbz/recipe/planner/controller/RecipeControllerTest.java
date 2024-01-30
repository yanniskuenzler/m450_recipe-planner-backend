package ch.tbz.recipe.planner.controller;

import ch.tbz.recipe.planner.controller.RecipeController;
import ch.tbz.recipe.planner.domain.Ingredient;
import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.service.RecipeService;
import org.apache.coyote.Request;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static ch.tbz.recipe.planner.domain.Unit.PIECE;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class RecipeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    RecipeService recipeService;

    @BeforeEach
    public void setup() {
        Ingredient ingredientEntity = new Ingredient();
        ingredientEntity.setId(UUID.fromString("cfdc5074-c16e-45f5-90fc-966366a145e9"));
        ingredientEntity.setName("Bacon");
        ingredientEntity.setComment("alkdsfjöaldg");
        ingredientEntity.setUnit(PIECE);
        ingredientEntity.setAmount(1);

        List<Ingredient> ingredients = Arrays.asList(ingredientEntity);

        Recipe recipeEntity = new Recipe();
        recipeEntity.setId(UUID.fromString("45df3de8-8397-4638-a71c-07c7ef63c7da"));
        recipeEntity.setName("Spaghetti alla Carbonara");
        recipeEntity.setDescription("öaksjdgökadjgökadg");
        recipeEntity.setImageUrl("https://www.deliciousmagazine.co.uk/wp-content/uploads/2020/01/lasagne.jp");
        recipeEntity.setIngredients(ingredients);

        List<Recipe> recipes = Arrays.asList(recipeEntity);

        when(recipeService.getRecipes()).thenReturn(recipes);
        when(recipeService.getRecipeById(UUID.fromString("45df3de8-8397-4638-a71c-07c7ef63c7da"))).thenReturn(recipeEntity);
    }

     @Test
     public void TestGetRecipes() throws Exception {

         RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/recipes")
                 .accept(MediaType.APPLICATION_JSON);

         mockMvc.perform(requestBuilder)
                 .andDo(MockMvcResultHandlers.print())
                 .andExpect(status().isOk())
                 .andExpect(MockMvcResultMatchers.content().json("[{\"id\":\"45df3de8-8397-4638-a71c-07c7ef63c7da\",\"name\":\"Spaghetti alla Carbonara\",\"description\":\"öaksjdgökadjgökadg\",\"imageUrl\":\"https://www.deliciousmagazine.co.uk/wp-content/uploads/2020/01/lasagne.jp\",\"ingredients\":[{\"id\":\"cfdc5074-c16e-45f5-90fc-966366a145e9\",\"name\":\"Bacon\",\"comment\":\"alkdsfjöaldg\",\"unit\":\"PIECE\",\"amount\":1}]}]"));

     }

     @Test
     public void TestGetRecipe() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/recipes/recipe/45df3de8-8397-4638-a71c-07c7ef63c7da")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":\"45df3de8-8397-4638-a71c-07c7ef63c7da\",\"name\":\"Spaghetti alla Carbonara\",\"description\":\"öaksjdgökadjgökadg\",\"imageUrl\":\"https://www.deliciousmagazine.co.uk/wp-content/uploads/2020/01/lasagne.jp\",\"ingredients\":[{\"id\":\"cfdc5074-c16e-45f5-90fc-966366a145e9\",\"name\":\"Bacon\",\"comment\":\"alkdsfjöaldg\",\"unit\":\"PIECE\",\"amount\":1}]}"));
     }

    @Test
    public void TestPostRecipe() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/recipes")
                .accept(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"83df3de8-8393-4638-a72c-07c7ef63c7da\",\"name\":\"Spaghetti Napoli\",\"description\":\"öaksjdgökadjgökadg\",\"imageUrl\":\"https://www.deliciousmagazine.co.uk/wp-content/uploads/2020/01/lasagne.jp\",\"ingredients\":[{\"id\":\"ufdc5934-c16e-87f5-90fc-966366a145e9\",\"name\":\"Tomatoes\",\"comment\":\"alkdsfjöaldg\",\"unit\":\"PIECE\",\"amount\":1}]}");

        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());





     }


}