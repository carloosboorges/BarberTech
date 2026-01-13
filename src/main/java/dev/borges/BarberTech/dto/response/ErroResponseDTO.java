package dev.borges.BarberTech.dto.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErroResponseDTO {
    private int status;
    private String mensagem;
    private LocalDateTime timestamp;
}
