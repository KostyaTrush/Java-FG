package rnd.composite.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rnd.composite.model.ProductAggregated;
import rnd.composite.model.compositemodel.Product;
import rnd.composite.model.compositemodel.Recommendation;

import java.util.List;

@RestController
public class ProductCompositeController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductCompositeIntegration.class);

    @Autowired
    ProductCompositeIntegration integration;

    @Autowired
    Util util;

    @RequestMapping("/product/{productId}")
    public ResponseEntity<ProductAggregated> getProduct(@PathVariable int productId){
        ResponseEntity<Product> productResult = integration.getProduct(productId);

        if(!productResult.getStatusCode().is2xxSuccessful()) {
            return util.createResponse(null, productResult.getStatusCode());
        }

        List<Recommendation> recommendations = null;
        try {
            ResponseEntity<List<Recommendation>> recommendationsResult = integration.getRecommendations(productId);
            if (!recommendationsResult.getStatusCode().is2xxSuccessful()) {
                LOG.debug("Call to getRecommendations failed: {}", recommendationsResult.getStatusCode());
            } else {
                recommendations = recommendationsResult.getBody();
            }
        } catch (Throwable t) {
            LOG.error("getProduct erro ", t);
            throw t;
        }

        return util.createOkResponse(new ProductAggregated(productResult.getBody(), recommendations));
    }
}
