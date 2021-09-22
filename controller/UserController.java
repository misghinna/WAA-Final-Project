package miu.main.controller;

import miu.main.dto.UserDTO;
import miu.main.service.BuyerService;
import miu.main.service.SellerServiceImpl;
import miu.main.service.UserDetailsImpl;
import miu.main.service.UserDetailsServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    BuyerService buyerService;

    @Autowired
    SellerServiceImpl sellerService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping({ "/current" })
    public @ResponseBody
    UserDTO getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userdetails = (UserDetailsImpl) auth.getPrincipal();
        return modelMapper.map(userdetails.getUser(), UserDTO.class);
    }
//    @GetMapping({ "/mysellerinfo" })
//    public @ResponseBody SellerDTO getCurrentSeller() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserDetailsImpl userdetails = (UserDetailsImpl) auth.getPrincipal();
//        List<Seller> sellerList  = sellerService.getAll();
//        Optional<Seller> seller = sellerList
//                                .stream()
//                                .filter(s -> s.getUser().getUsername().compareToIgnoreCase(userdetails.getUsername()) == 0).findFirst();
//        if(seller.isPresent())
//            return modelMapper.map(seller.get(), SellerDTO.class);
//        return null;
//    }

//    @GetMapping({ "/mybuyerinfo" })
//    public @ResponseBody
//    BuyerDTO getCurrentBuyer() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserDetailsImpl userdetails = (UserDetailsImpl) auth.getPrincipal();
//        Optional<Buyer> buyer =  buyerService.findAll().stream().filter(x->x.getUser().getUsername().equalsIgnoreCase(userdetails.getUsername())).findFirst();
//        if(buyer.isPresent())
//            return modelMapper.map(buyer.get(), BuyerDTO.class);
//        return null;
//    }

//    @PostMapping("/update")
//    public @ResponseBody  UserDTO updateSellerProfile(@RequestBody  NewUser updateUser){
//        User user = userDetailsService.updateProfile(updateUser);
//        if(user != null)
//            return modelMapper.map(user, UserDTO.class);
//        return null;
//    }

}
