import com.external.PaymentsService;
import com.internal.DiscountCalculator;
import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args){

        CLIParser cliParser = new CLIParser(LoggerFactory.getLogger(CLIParser.class));
        SellingService sellingService = new SellingService(new PaymentsService(), new DiscountCalculator(),
                LoggerFactory.getLogger(SellingService.class));

        TransactionData transactionData = null;
        try {
            transactionData = cliParser.parseTrasactionData(args);
            sellingService.sell(transactionData);
        }catch (MissingArgumentException e){
            logger.error("unable to sell because of " + e.getMessage());
        } catch (org.apache.commons.cli.ParseException e) {
            logger.error("unable to sell because of parse exception \"" + e.getMessage() + "\"");
        }
    }
}
