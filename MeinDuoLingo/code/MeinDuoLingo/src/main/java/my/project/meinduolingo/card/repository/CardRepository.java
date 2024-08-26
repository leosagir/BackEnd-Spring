package my.project.meinduolingo.card.repository;

import my.project.meinduolingo.card.dto.ResponseCardDto;
import my.project.meinduolingo.card.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card,Long> {
List<Card> findByLanguageAndTranslateLanguage(String language, String translateLanguage);
List<Card> findByWord(String word);
}
