package ShuttleSystemBackend.repository;

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
public class BusDistrCrudTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private BusDistributorRepository repository;

    @Test
    public void testCreateBusSupplier() throws Exception {
//        repository.deleteAll();
        BusDistributor busDistributor = BusDistributorFactory.createSupplier("Test","1234567890");
        BusDistributor savedBusDistributor =repository.save(busDistributor);

        assertNotNull("CREATE TEST", savedBusDistributor);
    }

    @Test(dependsOnMethods = "testCreateBusSupplier")
    public void testReadAll() throws Exception {
        Iterable<BusDistributor> busSuppliers =  repository.findAll();

        assertNotNull("READ TEST",busSuppliers);
    }

    @Test(dependsOnMethods = "testReadAll")
    public void testUpdateSupplier() throws Exception {
        BusDistributor supplierFound= repository.findOne(2L);
        BusDistributor updateSupplier = new BusDistributor.SupplierBuilder()
                .copy(supplierFound)
                .name("admin")
                .build();
        BusDistributor updatedSupplier=repository.save(updateSupplier);
        Assert.assertEquals("UPDATE TEST",updatedSupplier.getName(),updateSupplier.getName());
    }

    @Test(dependsOnMethods = "testUpdateSupplier")
    public void testDelete() throws Exception {
        BusDistributor foundSupplier = repository.findOne(3L);
        if(foundSupplier !=null) {
            assertNotNull("BEFORE DELETE TEST",foundSupplier);
            repository.delete(3L);
            BusDistributor deletedSupplier = repository.findOne(3L);

            assertNull("DELETE TEST",deletedSupplier);
        }

    }
}
