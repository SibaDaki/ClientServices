package ShuttleSystemBackend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by User on 2017/09/07.
 */
@Entity
public class BusDistributor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String contactNumber;

    public BusDistributor(BusDistributor.SupplierBuilder distributorBuilder){
        this.id=distributorBuilder.id;
        this.name=distributorBuilder.name;
        this.contactNumber=distributorBuilder.contactNumber;
    }
    private BusDistributor(){}
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }
    public static class SupplierBuilder{
        private  Long id;
        private String name;
        private String contactNumber;

        public BusDistributor.SupplierBuilder id(Long id){
            this.id=id;
            return  this;
        }
        public BusDistributor.SupplierBuilder name(String name){
            this.name=name;
            return  this;
        }
        public BusDistributor.SupplierBuilder contactNumber(String contactNumber){
            this.contactNumber=contactNumber;
            return this;
        }
        public BusDistributor.SupplierBuilder copy(BusDistributor supplier){
            this.id=supplier.id;
            this.name=supplier.name;
            this.contactNumber=supplier.contactNumber;
            return  this;
        }
        public BusDistributor build(){
            return new BusDistributor(this);
        }
    }
    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
