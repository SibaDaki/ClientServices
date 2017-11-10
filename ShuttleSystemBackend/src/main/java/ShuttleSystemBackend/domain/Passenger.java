package ShuttleSystemBackend.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by User on 2017/09/07..
 */
@Entity
public class Passenger implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;


    private Passenger(PassengerBuilder objBuilder) {
        this.id = objBuilder.id;
        this.firstName = objBuilder.name;
        this.lastName = objBuilder.lastName;

    }

    private Passenger() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static class PassengerBuilder {
        private Long id;
        private String name;
        private String lastName;


        public PassengerBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public PassengerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PassengerBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }


        public PassengerBuilder copy(Passenger objPassenger) {
            this.id = objPassenger.id;
            this.name = objPassenger.firstName;
            this.lastName = objPassenger.lastName;

            return this;
        }

        public Passenger build() {
            return new Passenger(this);
        }


    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}