package ShuttleSystemBackend.Controller;

import ShuttleSystemBackend.domain.BusDetails;
import ShuttleSystemBackend.services.BusDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by User on 2017/11/10.
 */

@RestController
@RequestMapping(value="/bus")

public class BusController {

    @Autowired
    private BusDetailService service;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public BusDetails findById(@PathVariable Long id){
        return   service.readById(id);
    }

    @RequestMapping(method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public BusDetails create(@RequestBody BusDetails resource){
        return  service.create(resource);
    }

    @RequestMapping(method =  RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody BusDetails resource){
        service.update(resource);
    }


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Set<BusDetails> findAll(){
        return service.readAll();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id")Long id){
        BusDetails busDetailsToDelete = service.readById(id);
        if(busDetailsToDelete !=null) {
            service.delete(busDetailsToDelete);
        }
    }

}
