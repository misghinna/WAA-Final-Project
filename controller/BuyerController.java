package miu.main.controller;


import miu.main.domain.Address;
import miu.main.domain.Buyer;
import miu.main.domain.Order;
import miu.main.service.BuyerService;
import miu.main.service.OrderService;
import miu.main.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/buyers")
@RestController
public class BuyerController {
    @Autowired
    BuyerService buyerService;

    @Autowired
    OrderService orderService;

    @Autowired
    SellerService sellerService;

    @GetMapping
    public List<Buyer> getAllBuyers(){
        return buyerService.getAllBuyers();
    }

    @GetMapping("/{id}")
    public Buyer getBuyerById(@PathVariable("id") long id){
        return buyerService.findBuyerById(id);
    }

    @PostMapping
    public void addBuyer(@RequestBody Buyer buyer) {
        buyerService.addBuyer(buyer);
    }

    @GetMapping("/buyers/{id}/addresses") // get buyer addresses
    public List<Address> getBuyerAddress(@PathVariable long id){
        return buyerService.getAddressesOfBuyer(id);
    }

    @PostMapping("/buyers/{id}/addresses") // add buyer address
    public Address addBuyerAddress(@RequestBody Address address, @PathVariable long id){
      return buyerService.addAddressToBuyer(address, id);
    }

    @GetMapping("/buyers/{id}/orders") // get buyer orders
    public List<Order> getOrdersForBuyer(@PathVariable long id){
        return buyerService.findOrdersById(id);
        return null;
    }

//    @PostMapping("/buyers/{id}/products/{productId}/reviews") // add buyer review
//    public Review addReviewToProductByBuyer
//            (@RequestBody Review review, @PathVariable long id, @PathVariable long productId){
//       // return buyerService.addReviewByBuyerId(review, id, productId);
//        return null;
////    }








}
