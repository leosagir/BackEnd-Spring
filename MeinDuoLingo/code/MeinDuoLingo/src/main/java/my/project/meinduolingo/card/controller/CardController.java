package my.project.meinduolingo.card.controller;

import lombok.AllArgsConstructor;
import my.project.meinduolingo.card.dto.RequestCardDto;
import my.project.meinduolingo.card.dto.ResponseCardDto;
import my.project.meinduolingo.card.entity.Card;
import my.project.meinduolingo.card.service.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class CardController {
    private CardService cardService;

    @GetMapping( "/cards")
    public List<ResponseCardDto> getAllCards(Model model) {

        return cardService.findAll();
    }

    @PostMapping("/cards")
    public ResponseCardDto createNewCard(@RequestBody RequestCardDto requestCardDto) {
        return cardService.save(requestCardDto);
    }
    @GetMapping("/cards/search-by-word")
    public List<ResponseCardDto> getCardsByWord(Model model, String word) {
       return cardService.findByWord(word);
    }
    @GetMapping("/cards/search-by-languages")
    public List<ResponseCardDto> getCardsByLanguageAndTranslateLanguage(Model model, String language, String translateLanguage) {
       return cardService.findByLanguageAndTranslateLanguage(language, translateLanguage);
    }
@DeleteMapping("cards/{id}")
    public void deleteCard(@PathVariable Long id) {
        cardService.deleteCardById(id);
}



}
