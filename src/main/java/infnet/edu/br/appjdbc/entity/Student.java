package infnet.edu.br.appjdbc.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student {

    @EqualsAndHashCode.Include
    private Integer id;

    private String name;

    private String email;
    

    public Student(Integer id, String name){
        this.name = name;
        this.id = id;
    }
    

    public Student(){

    }

}
