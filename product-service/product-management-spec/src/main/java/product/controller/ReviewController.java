package product.controller;

import com.product.apis.ReviewsApi;
import com.product.models.ReviewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("client-api/v1")
public class ReviewController implements ReviewsApi {
    @Override
    public ResponseEntity<ReviewModel> createNewReview(Long productId, ReviewModel reviewModel) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteReviewById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<ReviewModel>> getAllReviewsForProduct(Long productId) {
        return null;
    }

    @Override
    public ResponseEntity<ReviewModel> getReviewById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ReviewModel> updateReview(Long id, ReviewModel reviewModel) {
        return null;
    }
}
