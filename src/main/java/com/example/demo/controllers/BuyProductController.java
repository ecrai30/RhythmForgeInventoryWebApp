// BuyProductController.java
package com.example.demo.controller;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.Optional;

@Controller
//@RequestMapping("/buyProductController")
public class BuyProductController {
@Autowired
    private ProductRepository productRepository;

@GetMapping("/buyProduct") //Part F
    public String buyProduct(@RequestParam("productId") Long productId, Model theModel) {
    Optional<Product> purchaseProd = productRepository.findById(productId);

    if (purchaseProd.isPresent()) {
        Product product = purchaseProd.get();

        if (product.getInv() > 0) {
            product.setInv(product.getInv() - 1);
            productRepository.save(product);
            return "redirect:confirmationBuyNow";
        } else {
            return "redirect:confirmationBuyNowError";
        }

    } else {
        return "redirect:confirmationBuyNowError";
    }


}
    @GetMapping("/confirmationBuyNow")
    public String displayPurchaseSuccess(){
        return"/confirmationBuyNow";
    }

    @GetMapping("confirmationBuyNowError")
    public String displayPurchaseError() {
        return "/confirmationBuyNowError";
    }
}
