package Spring.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public String getTitleById(Long id){
        return productRepository.findById(id).getTitle();
    }
}
