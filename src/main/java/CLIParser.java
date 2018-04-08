
import org.apache.commons.cli.*;
import org.slf4j.Logger;

import java.math.BigDecimal;

public class CLIParser {
    private Logger logger;


    public CLIParser(Logger logger) {
        this.logger = logger;
    }

    public TransactionData parseTrasactionData(String[] args) throws ParseException {
        TransactionData transactionData = new TransactionData();
        BigDecimal ticketPrice;
        Client client = new Client();
        int companyId;

        Options options = new Options();
        // add t option
        options.addOption("ticketPrice", true, "ticket price");
        options.addOption("clientAge", true, "client age");
        options.addOption("clientId", true, "client id");
        options.addOption("companyId", true, "company id");

        CommandLineParser parser = new DefaultParser();

        CommandLine cmd = parser.parse(options, args);
        if (cmd.hasOption("ticketPrice")) {
            ticketPrice = BigDecimal.valueOf(Double.valueOf((String) cmd.getParsedOptionValue("ticketPrice")));
            transactionData.setTicketPrice(ticketPrice);
        } else {
            throw new MissingArgumentException( "missing argument ticketPrice");
        }
        if (cmd.hasOption("clientAge")) {
            client.setClientAge( Integer.valueOf((String) cmd.getParsedOptionValue("clientAge")));
        } else {
            throw new MissingArgumentException( "missing argument clientAge");
        }
        if (cmd.hasOption("clientId")) {
            client.setClientId(Integer.valueOf((String) cmd.getParsedOptionValue("clientId")));
        } else {
            throw new MissingArgumentException( "missing argument clientId");
        }
        if (cmd.hasOption("companyId")) {
            companyId = Integer.valueOf((String) cmd.getParsedOptionValue("companyId"));
            transactionData.setCompanyId(companyId);
        } else {
            throw new MissingArgumentException( "missing argument companyId");
        }
        transactionData.setClient(client);
        logger.info("argument parsing successful");
        return transactionData;
    }
}
