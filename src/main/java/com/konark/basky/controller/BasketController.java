package com.konark.basky.controller;

import com.konark.basky.entity.Basket;
import com.konark.basky.entity.Match;
import com.konark.basky.entity.Player;
import com.konark.basky.entity.Team;
import com.konark.basky.repo.BasketRepo;
import com.konark.basky.service.BasketService;
import com.konark.basky.service.MatchService;
import com.konark.basky.service.MessageService;
import com.konark.basky.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BasketController {
    @Autowired
    private BasketService basketService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private MatchService matchService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private BasketRepo basketRepo;

    @GetMapping("/createBasket/{id}")
    public String createBasket(@PathVariable("id") int  matchId,Model model, HttpSession session) {

        List<Player> player=new ArrayList<>();
        model.addAttribute("player", player);
        model.addAttribute("id",matchId);
        model.addAttribute("basket",new Basket());
        List<Player> players= (List<Player>) playerService.getAllPlayers();
        model.addAttribute("players",players);

        return "createBasket";
    }

    @PostMapping("/createBasket/{id}")
    public String createBasket(@PathVariable("id") int matchId,@ModelAttribute Basket basket, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
       basket.setMatchId(matchId);
        System.out.println(matchId);
        int playerId = basket.getPlayerId();
        Player player= (Player) playerService.getPlayerById(playerId);
        int teamId= player.getTeamId();
        Match match = (Match) matchService.getMatchById(matchId);
        if(match.getTeam1Id()==teamId){
            match.setTeam1Score(match.getTeam1Score()+ basket.getValue());
        }
        else{
            match.setTeam2Score(match.getTeam2Score()+ basket.getValue());
        }
        matchService.updateMatch(match);
        String errorMessage = null;

//        System.out.println(username);
//        System.out.println(basket.getFirstName());
//        System.out.println(basket.getDob());
//        System.out.println(basket.getFirstName());

        basketService.createBasket(basket);

        messageService.redirectWithSuccessMessage(redirectAttributes, "Successfully created basket user.");
        return "redirect:/match/{id}";
    }
    @GetMapping("/baskets/{id}")
    public String allBasketsMatch(@PathVariable("id") int matchId, Model model, HttpSession Session){
        List<Basket> baskets= basketRepo.getBasketsMatch(matchId);
        model.addAttribute("baskets",baskets);
        model.addAttribute("id",matchId);

        return "baskets";
    }
    @GetMapping("/updateBasket/{id}")
    public String updateBasket(@PathVariable("id") int basketId, Model model, HttpSession Session){
        Basket basket = basketRepo.getBasketById(basketId);
        model.addAttribute("basket", basket);
        model.addAttribute("id",  basketId);
        return "updateBasket";
    }
    @PostMapping("/updateBasket/{id}")
    public String updateTeam(@PathVariable("id") int basketId,Basket basket, Model model, HttpSession httpSession,RedirectAttributes attributes) {
        basket.setBasketId(basketId);
        try{
            basketRepo.update(basket);
            messageService.redirectWithSuccessMessage(attributes, "Team updated successfully.");
            return "redirect:/baskets/${basket.matchId}";
        }catch (Exception e){}
        messageService.displayErrorMessage(model, "team Does not exist");
        model.addAttribute("basket", basket);
        return "updateBasket";
    }


}
