package models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "cars")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, of = {"model", "kilometraj", "transmisie", "combustibil"})
@ToString(callSuper = true, of = {"model", "kilometraj", "transmisie", "combustibil"})

public class Car extends BaseEntity{
    public Car(String nrInmatriculare, String model, Integer kilometraj, Transmisie transmisie, Combustibil combustibil, Client id_client, Order order) {
        super(nrInmatriculare);
        this.model = model;
        this.kilometraj = kilometraj;
        this.transmisie = transmisie;
        this.combustibil = combustibil;
        this.id_client = id_client;
        this.order = order;
    }

    //    @Id
//    private String nrInmatriculare;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Integer kilometraj;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Transmisie transmisie;

    @Getter
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Combustibil combustibil;


    @ManyToOne(cascade = CascadeType.ALL)
  //  @JoinColumn(name = "id_client", referencedColumnName = "nrInmatriculare")
    private Client id_client;

    @OneToOne
    private Order order;

//
//    @Column(nullable = false)
//    private String make;
//
//    @Column(nullable = false)
//    private String model;
//
//    @Column(nullable = false)
//    @Enumerated(EnumType.STRING)
//    private Engine engine;
//
//    @Column(name = "travelled_distance", nullable = false)
//    private Double travelledDistance;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "client_id", referencedColumnName = "id")
//    private Client client;
//
//    @ManyToMany(mappedBy = "cars")
//    private List<Order> orders;
}
