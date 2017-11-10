package ShuttleSystemBackend.factory;

import ShuttleSystemBackend.domain.BusDistributor;

/**
 * Created by User on 2017/09/07.
 */
public class BusDistributorFactory {

    public static BusDistributor createSupplier(String name, String contactNumber){
        return new BusDistributor.SupplierBuilder()
                .name(name)
                .contactNumber(contactNumber)
                .build();
    }
}
