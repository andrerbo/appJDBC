package infnet.edu.br.appjdbc.entity;

import java.time.LocalDateTime;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Session {

    @EqualsAndHashCode.Include
    private Integer id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
    
}
