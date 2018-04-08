public class Client {
    int clientAge;
    int clientId;

    public int getClientAge() {
        return clientAge;
    }

    public void setClientAge(int clientAge) {
        this.clientAge = clientAge;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientAge=" + clientAge +
                ", clientId=" + clientId +
                '}';
    }
}
