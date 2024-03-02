package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass  //nu creaza baze de date si pt ea deoarece le mosteneste
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private  String nrInmatriculare;
}
