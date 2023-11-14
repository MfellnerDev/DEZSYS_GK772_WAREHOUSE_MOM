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
    @Autowired
    private MOMReceiverService receiverService;

    @Autowired
    private MOMSenderService senderService;

    @CrossOrigin
    @RequestMapping(value = "/warehouse/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public String allWarehouseData()    {
        // send all articles from the LINZ warehouse to the queue
        senderService.sendMessage();
        // read and return all messages from the queue
        return receiverService.readMessageQueue();
    }
}
