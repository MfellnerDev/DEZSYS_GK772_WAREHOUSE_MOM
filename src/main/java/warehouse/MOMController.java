package warehouse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;

/**
 * Controller for consuming all the contents in the message queue
 *
 * @author Manuel Fellner
 * @version 14.11.2023
 */
@RestController
public class MOMController {

    @CrossOrigin
    @RequestMapping(value = "/warehouse/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public String allWarehouseData()    {
        // send, read and return all messages from the queue
        return new MOMReceiver().getAllWarehouseData();
    }
}
