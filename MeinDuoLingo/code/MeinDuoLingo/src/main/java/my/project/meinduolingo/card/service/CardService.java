package my.project.meinduolingo.card.service;

import my.project.meinduolingo.card.dto.RequestCardDto;
import my.project.meinduolingo.card.dto.ResponseCardDto;

import java.util.List;

public interface CardService {
    List<ResponseCardDto> findAll();
    ResponseCardDto save(RequestCardDto requestCardDto);
    List<ResponseCardDto> findByLanguageAndTranslateLanguage(String language, String translateLanguage);
    List<ResponseCardDto> findByWord(String word);
    void deleteCardById(Long id);
}
