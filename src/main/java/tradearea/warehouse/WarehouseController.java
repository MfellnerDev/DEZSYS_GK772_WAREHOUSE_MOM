package tradearea.warehouse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;

import tradearea.model.WarehouseData;

import java.util.UUID;

@RestController
public class WarehouseController {

    @Autowired
    private WarehouseService service;
	
    @RequestMapping("/")
    public String warehouseMain() {
    	String mainPage = "This is the warehouse application! (DEZSYS_WAREHOUSE_REST) <br/><br/>" +
                          "<a href='http://localhost:8080/warehouse/469d7240-b974-441d-9562-2c56a7b28767/data'>Link to warehouse/469d7240-b974-441d-9562-2c56a7b28767/data</a><br/>" +
                          "<a href='http://localhost:8080/warehouse/469d7240-b974-441d-9562-2c56a7b28767/xml'>Link to warehouse/469d7240-b974-441d-9562-2c56a7b28767/xml</a><br/>" +
                          "<a href='http://localhost:8080/warehouse/469d7240-b974-441d-9562-2c56a7b28767/transfer'>Link to warehouse/469d7240-b974-441d-9562-2c56a7b28767/transfer</a><br/>";
        return mainPage;
    }

    @CrossOrigin
    @RequestMapping(value="/warehouse/{inID}/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public WarehouseData warehouseData( @PathVariable UUID inID ) {
        return service.getWarehouseData(inID);
    }

    @CrossOrigin
    @RequestMapping(value="/warehouse/{inID}/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public WarehouseData warehouseDataXML( @PathVariable UUID inID ) {
        return service.getWarehouseData(inID);
    }

    @CrossOrigin
    @RequestMapping("/warehouse/{inID}/transfer")
    public String warehouseTransfer( @PathVariable UUID inID ) {
        return service.getGreetings("Warehouse.Transfer!");
    }

}