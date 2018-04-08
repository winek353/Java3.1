import java.math.BigDecimal;

public class TransactionData {
    private BigDecimal ticketPrice;
    private Client client;
    private int companyId;

//    public TransactionData(BigDecimal ticketPrice, Client client, int companyId) {
//        this.ticketPrice = ticketPrice;
//        this.client = client;
//        this.companyId = companyId;
//    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "TransactionData{" +
                "ticketPrice=" + ticketPrice +
                ", client=" + client +
                ", companyId=" + companyId +
                '}';
    }
}
