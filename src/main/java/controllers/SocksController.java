package controllers;

import dto.MarketDTO;
import models.Colors;
import models.Size;
import org.springframework.web.bind.annotation.*;
import service.MarketService;

@RestController
@RequestMapping("/socks")
public class SocksController {

    private final MarketService marketService;

    public SocksController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping
    public int getSockQuantity(@RequestParam(required = false, name = "color") Colors colors,
                               @RequestParam(required = false, name = "size") Size size,
                               @RequestParam(required = false, name = "cottonMin") Integer cottonMin,
                               @RequestParam(required = false, name = "cottonMax") Integer cottonMax) {
        return marketService.getSockQuantity(colors, size, cottonMin, cottonMax);
    }

    @PostMapping
    public void addSocks(@RequestBody MarketDTO marketDTO) {
        marketService.addSocks(marketDTO);
    }

    @PutMapping
    public void soldSocks(@RequestBody MarketDTO marketDTO) {
        marketService.soldSocks(marketDTO);
    }

    @DeleteMapping
    public void removedSocks(@RequestBody MarketDTO marketDTO) {
        marketService.removedSocks(marketDTO);
    }

}

