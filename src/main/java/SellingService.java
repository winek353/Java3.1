import com.external.PaymentsService;
import com.internal.DiscountCalculator;
import org.slf4j.Logger;

import java.math.BigDecimal;

public class SellingService {
    private PaymentsService paymentsService;
    private DiscountCalculator discountCalculator;
    private Logger logger;

    public SellingService(PaymentsService paymentsService, DiscountCalculator discountCalculator, Logger logger) {
        this.paymentsService = paymentsService;
        this.discountCalculator = discountCalculator;
        this.logger = logger;
    }

    public BigDecimal computeFinalPrice(TransactionData transactionData){
        BigDecimal computedPrice = transactionData.getTicketPrice()
                .subtract(discountCalculator.
                        calculateDiscount(transactionData.getTicketPrice(),
                                transactionData.getClient().getClientAge()));
        logger.info("computed price = " + computedPrice + " " +
                "for client id = " + transactionData.getClient().getClientId()  );
        return computedPrice;
    }

    public boolean pay (BigDecimal price, TransactionData transactionData){
        if(paymentsService.makePayment(transactionData.getClient().getClientId(), transactionData.getCompanyId(), price)){
            return true;
        }
        else{
            logger.warn("payment unsuccessful " + "client id =" + transactionData.getClient().getClientId());
            return false;
        }
    }
    public boolean sell(TransactionData transactionData){
        BigDecimal finalPrice = computeFinalPrice(transactionData);
        if(pay(finalPrice, transactionData)){
            logger.info("selling successful for client id = " + transactionData.getClient().getClientId());
            return true;
        }
        else {
            return false;
        }
    }
}
