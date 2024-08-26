package my.project.meinduolingo.card.dto;

import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ResponseCardDto {
    private Long id;
    private String language;
    private String word;
    private String example;
    private String translateLanguage;
    private String translation;
    private String cardGroup;
}
