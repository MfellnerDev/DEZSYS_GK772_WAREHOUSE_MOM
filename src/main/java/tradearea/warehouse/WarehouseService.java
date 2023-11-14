package tradearea.warehouse;

import org.springframework.stereotype.Service;
import tradearea.model.WarehouseData;

import java.util.UUID;

@Service
public class WarehouseService {
	
	public String getGreetings( String inModule ) {
        return "Greetings from " + inModule;
    }

    public WarehouseData getWarehouseData(UUID inID) {
    	
    	WarehouseSimulation simulation = new WarehouseSimulation();
        return simulation.getData(inID);
        
    }
    
}