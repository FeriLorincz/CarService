package models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "clients")
@Data
//@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = {"id_client", "nume", "CNP", "telefon", "tara"})
@ToString(callSuper = true, of = {"id_client", "nume", "CNP", "telefon", "tara"})
public class Client {

    public Client(String nume, String CNP, Integer telefon, String tara, List<Car> carList, List<Order> orderList) {
        this.nume = nume;
        this.CNP = CNP;
        this.telefon = telefon;
        this.tara = tara;
        this.carList = carList;
        this.orderList = orderList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_client;

    @Column(nullable = false)
    private String nume;

    @Column(nullable = false)
    private String CNP;

    @Column(nullable = false)
    private Integer telefon;

    @Column(nullable = false)
    private String tara;

    @OneToMany(mappedBy = "id_client")
    private List<Car> carList;

    @OneToMany(mappedBy = "id_client")
    private List<Order> orderList;

}
