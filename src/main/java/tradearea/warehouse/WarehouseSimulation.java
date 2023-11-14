package tradearea.warehouse;

import tradearea.model.Product;
import tradearea.model.WarehouseData;

import java.util.UUID;
import java.util.Random;

public class WarehouseSimulation {

	private static final String[] productNames = {
			"Milch", "Eier", "Brot", "Reis", "Nudeln", "Kartoffeln", "Tomaten",
			"Bananen", "Äpfel", "Hühnchen", "Rindfleisch", "Lachs", "Butter",
			"Käse", "Joghurt"
	};

	private static final String[] productCategories = {
			"Milchprodukte", "Eier", "Brot und Backwaren", "Getreide und Reis",
			"Nudeln", "Gemüse", "Obst", "Obst", "Obst", "Fleisch", "Fleisch",
			"Fisch", "Milchprodukte", "Milchprodukte", "Milchprodukte"
	};

	private static final Random random = new Random();

	private static double getRandomDouble(int inMinimum, int inMaximum) {
		double number = random.nextDouble() * (inMaximum - inMinimum + 1) + inMinimum;
		return Math.round(number * 100.0) / 100.0;
	}

	private static int getRandomInt(int inMinimum, int inMaximum) {
		return random.nextInt(inMaximum - inMinimum + 1) + inMinimum;
	}

	private static int[] getFourRandomNumbers() {
		int firstRandomNumber = getRandomInt(0, productNames.length - 1);
		int secondRandomNumber = getRandomInt(0, productNames.length - 1);
		int thirdRandomNumber = getRandomInt(0, productNames.length - 1);
		int fourthRandomNumber = getRandomInt(0, productNames.length - 1);
		return new int[]{firstRandomNumber, secondRandomNumber, thirdRandomNumber, fourthRandomNumber};
	}

	private static Product[] getFourProductData() {
		int[] randomNumbers = getFourRandomNumbers();
		Product[] products = new Product[4];
		for (int i = 0; i < 4; i++) {
			products[i] = new Product(UUID.randomUUID(), productNames[randomNumbers[i]],
					productCategories[randomNumbers[i]], getRandomInt(75, 200),
					i == 1 ? "1L/Packung" : (i == 2 ? "3KG/Packung" : "500ML/Packung"));
		}
		return products;
	}

	public static WarehouseData getData(UUID inID) {
		WarehouseData data = new WarehouseData();
		// parse String into UUID object, we currently want a static id
		data.setWarehouseID(inID);
		data.setWarehouseName("Linz Bahnhof");
		data.setWarehouseCity("Linz");
		data.setWarehouseAddress("WhoKnows Straße 12");
		data.setWarehouseCountry("Austria");
		data.setWarehousePostalCode(4000);
		data.setProductData(getFourProductData());
		return data;
	}
}