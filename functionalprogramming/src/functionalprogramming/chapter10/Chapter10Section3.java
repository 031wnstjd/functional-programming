package functionalprogramming.chapter10;

import functionalprogramming.chapter10.model.Price;
import functionalprogramming.chapter10.service.BasicPriceProcessor;
import functionalprogramming.chapter10.service.DiscountPriceProcessor;
import functionalprogramming.chapter10.service.PriceProcessor;
import functionalprogramming.chapter10.service.TaxPriceProcessor;

public class Chapter10Section3 {

	public static void main(String[] args) {
		Price unprocessedPrice = new Price("Original Price");	
		
		PriceProcessor basicPriceProcessor = new BasicPriceProcessor();
		PriceProcessor discountProcessor = new DiscountPriceProcessor();
		PriceProcessor taxPriceProcessor = new TaxPriceProcessor();
		
		PriceProcessor decoratedPriceProcessor = basicPriceProcessor
			.andThen(discountProcessor)
			.andThen(taxPriceProcessor);
		Price processedPrice = decoratedPriceProcessor.process(unprocessedPrice);
		System.out.println(processedPrice.getPrice());
		
		PriceProcessor decoratedPriceProcessor2 = basicPriceProcessor
				.andThen(taxPriceProcessor)
				.andThen(price -> new Price(price.getPrice() + ", then apply another procedu"));
		Price processedPrice2 = decoratedPriceProcessor2.process(unprocessedPrice);
		System.out.println(processedPrice2.getPrice());
	}

}
