package rnd.composite.model;

import rnd.composite.model.compositemodel.Product;
import rnd.composite.model.compositemodel.Recommendation;

import java.util.List;
import java.util.stream.Collectors;

public class ProductAggregated {

    private int productId;
    private String name;
    private int weight;
    private List<RecommendationSummary> recommendations;

    public ProductAggregated(Product product, List<Recommendation> recommendations){
        this.productId = product.getProductId();
        this.name = product.getProductName();
        this.weight = product.getWeight();

        if(recommendations != null){
            this.recommendations = recommendations.stream()
                    .map(r -> new RecommendationSummary(r.getRecommendationId(), r.getAuthor(), r.getRate()))
                    .collect(Collectors.toList());
        }
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public List<RecommendationSummary> getRecommendations() {
        return recommendations;
    }
}
