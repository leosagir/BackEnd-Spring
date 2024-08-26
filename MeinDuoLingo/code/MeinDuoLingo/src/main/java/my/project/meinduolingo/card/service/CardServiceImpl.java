package my.project.meinduolingo.card.service;

import lombok.AllArgsConstructor;
import my.project.meinduolingo.card.dto.RequestCardDto;
import my.project.meinduolingo.card.dto.ResponseCardDto;
import my.project.meinduolingo.card.entity.Card;
import my.project.meinduolingo.card.repository.CardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class CardServiceImpl implements CardService{
   private final CardRepository cardRepository;
   private final ModelMapper modelMapper;


    @Override
    public List<ResponseCardDto> findAll() {
        return cardRepository.findAll().stream()
                .map(e->modelMapper.map(e,ResponseCardDto.class))
                .toList();
    }

    @Override
    public ResponseCardDto save(RequestCardDto requestCardDto) {
        Card card = modelMapper.map(requestCardDto, Card.class);
        Card savedCard = cardRepository.save(card);
        return modelMapper.map(savedCard,ResponseCardDto.class);
    }

    @Override
    public List<ResponseCardDto> findByLanguageAndTranslateLanguage(String language, String translateLanguage) {
        List<Card> cardsByLanguageAndTranslateLanguage = cardRepository.findByLanguageAndTranslateLanguage(language, translateLanguage);
        return cardsByLanguageAndTranslateLanguage.stream()
                .map(c -> modelMapper.map(c,ResponseCardDto.class))
                .toList();
    }

    @Override
    public List<ResponseCardDto> findByWord(String word) {
        List<Card> cardByWord=cardRepository.findByWord(word);
        return cardByWord.stream()
                .map(c -> modelMapper.map(c,ResponseCardDto.class))
                .toList();
    }

    @Override
    public void deleteCardById(Long id) {
        cardRepository.deleteById(id);

    }
}
