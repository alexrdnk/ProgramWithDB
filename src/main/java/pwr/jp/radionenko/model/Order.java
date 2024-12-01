package pwr.jp.radionenko.model;

public class Order {

    private int id;
    private final int clientId;
    private final int organizerId;
    private final int offerId;
    private String status;
    private final String creatingDate;
    private String realizationDate;


    public Order(int id, int clientId, int organizerId, int offerId, String status, String creatingDate, String realizationDate) {
        this.id = id;
        this.clientId = clientId;
        this.organizerId = organizerId;
        this.offerId = offerId;
        this.status = status;
        this.creatingDate = creatingDate;
        this.realizationDate = realizationDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public int getOrganizerId() {
        return organizerId;
    }

    public int getOfferId() {
        return offerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatingDate() {
        return creatingDate;
    }

    public String getRealizationDate() {
        return realizationDate;
    }

    public void setRealizationDate(String realizationDate) {
        this.realizationDate = realizationDate;
    }


    @Override
    public String toString() {
        return "Order [ " +
                "(id - " + id +
                ") (ClientId - " + clientId +
                ") (OrganizerId - " + organizerId +
                ") (OfferId - " + offerId +
                ") (Status - " + status +
                ") (Creating Date - " + creatingDate +
                ") (Realization date - " + realizationDate +
                ") ]";
    }

}
