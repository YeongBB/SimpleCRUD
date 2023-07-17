package crud.simplecrud.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Story {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String content;

    public Story() {
    }


    public Story(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public void update(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public Story(Long id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }


}
