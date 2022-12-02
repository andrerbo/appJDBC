package infnet.edu.br.appjdbc.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Subject {
    
    @EqualsAndHashCode.Include
    private Integer id;

    private String name;
    
    private String description;


    
}
