package ShuttleSystemBackend.services;

import ShuttleSystemBackend.domain.BusDetails;
import ShuttleSystemBackend.factory.BusDetailsFactory;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by User on 2017/09/07.
 */
public class BusDetailServiceTest extends AbstractTestNGSpringContextTests

    {

        @Autowired
        private   BusDetailService service;

        @Test
        public void testCreateBus() throws Exception {
//        repository.deleteAll();
        BusDetails busDetails = BusDetailsFactory.createBus("CA45678",30);
        BusDetails savedBusDetails =service.create(busDetails);

        assertNotNull("CREATE TEST", busDetails);
    }

        @Test(dependsOnMethods = "testCreateBus")
        public void testReadAll() throws Exception {
        Iterable<BusDetails> buses =  service.readAll();

        assertNotNull("READ TEST",buses);
    }

        @Test(dependsOnMethods = "testReadAll")
        public void testUpdateAccount() throws Exception {
        BusDetails busDetailsFound = service.readById(2L);
        BusDetails updateBusDetails = new BusDetails.BusBuilder()
                .copy(busDetailsFound)
                .getnumberPlate("service1245")
                .build();
        BusDetails updatedBusDetails =service.update(updateBusDetails);
        Assert.assertEquals("UPDATE TEST", updatedBusDetails.getNumberPlate(), updateBusDetails.getNumberPlate());
    }

        @Test(dependsOnMethods = "testUpdateAccount")
        public void testDelete() throws Exception {
        BusDetails foundBusDetails = service.readById(3L);
        if(foundBusDetails !=null) {
            assertNotNull("BEFORE DELETE TEST", foundBusDetails);
            service.delete(foundBusDetails);
            BusDetails deletedBusDetails = service.readById(3L);

            assertNull("DELETE TEST", deletedBusDetails);
        }

    }
    }

