package ShuttleSystemBackend.services;

import ShuttleSystemBackend.domain.BusDistributor;
import ShuttleSystemBackend.factory.BusDistributorFactory;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by User on 2017/09/07.
 */
public class BusDistributorServTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private BusDistributorService service;

    @Test
    public void testCreateBusSupplier() throws Exception {
//        repository.deleteAll();
        BusDistributor busDistributor = BusDistributorFactory.createSupplier("serviceTest","1234567890");
        BusDistributor savedBusDistributor =service.create(busDistributor);

        assertNotNull("CREATE TEST", savedBusDistributor);
    }

    @Test(dependsOnMethods = "testCreateBusSupplier")
    public void testReadAll() throws Exception {
        Iterable<BusDistributor> busSuppliers =  service.readAll();

        assertNotNull("READ TEST",busSuppliers);
    }

    @Test(dependsOnMethods = "testReadAll")
    public void testUpdateSupplier() throws Exception {
        BusDistributor supplierFound= service.readById(2L);
        BusDistributor updateSupplier = new BusDistributor.SupplierBuilder()
                .copy(supplierFound)
                .name("service admin")
                .build();
        BusDistributor updatedSupplier=service.update(updateSupplier);
        Assert.assertEquals("UPDATE TEST",updatedSupplier.getName(),updateSupplier.getName());
    }

    @Test(dependsOnMethods = "testUpdateSupplier")
    public void testDelete() throws Exception {
        BusDistributor foundSupplier = service.readById(4L);
        if(foundSupplier !=null) {
            assertNotNull("BEFORE DELETE TEST",foundSupplier);
            service.delete(foundSupplier);
            BusDistributor deletedSupplier = service.readById(4L);

            assertNull("DELETE TEST",deletedSupplier);
        }

    }
}

