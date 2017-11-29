package rnd.recommendation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rnd.recommendation.model.Recommendation;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecommendationController {

    @RequestMapping("/recommendation")
    public List<Recommendation> getRecommendations(
            @RequestParam(value = "productId", required = true) int productId) {
        List<Recommendation> list = new ArrayList<>();
        list.add(new Recommendation(productId, 1, "Author 1", 1, "Content 1"));
        list.add(new Recommendation(productId, 2, "Author 2", 2, "Content 2"));
        list.add(new Recommendation(productId, 3, "Author 3", 3, "Content 3"));

        return list;
    }
}
