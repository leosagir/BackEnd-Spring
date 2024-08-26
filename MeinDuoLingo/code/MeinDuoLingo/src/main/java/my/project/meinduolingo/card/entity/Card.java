package my.project.meinduolingo.card.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="card")
public class Card {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
    @Column(name="language")
    private String  language;
    @Column(name="word")
    private String  word;
    @Column(name="example")
    private String example;
    @Column(name="translateLanguage")
    private String translateLanguage;
    @Column(name="translation")
    private String translation;
    @Column(name="cardGroup")
    private String cardGroup;
}
