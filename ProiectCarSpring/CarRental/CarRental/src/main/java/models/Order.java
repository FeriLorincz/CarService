package models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = {"id_comanda", "suma", "data"})
@ToString(callSuper = true, of = {"id_comanda", "suma", "data"})
public class Order extends BaseEntityOrder{
    public Order(Integer id_comanda, Double suma, LocalDate data, Client id_client, Car car) {
        this.suma = suma;
        this.data = data;
        this.id_client = id_client;
        this.car = car;
    }

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id_comanda;

    private Double suma;
    private LocalDate data;

    @ManyToOne
    private Client id_client;

    @OneToOne
    private Car car;
}
