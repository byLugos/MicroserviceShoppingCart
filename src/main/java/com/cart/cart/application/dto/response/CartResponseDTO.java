package com.cart.cart.application.dto.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.Map;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartResponseDTO {
    private Long id;
    private Long idUser;
    private Map<String, Integer> articles;
    private LocalDate creationDate;
    private LocalDate actualizationDate;
}
