package my.project.meinduolingo.card.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class RequestCardDto {
    private String language;
    private String word;
    private String example;
    private String translateLanguage;
    private String translation;
    private String cardGroup;

}
