package pwr.jp.radionenko.service;

import pwr.jp.radionenko.dao.OfferDao;
import pwr.jp.radionenko.model.Offer;

import java.util.List;

public class OfferService {

    private final OfferDao offerDao = new OfferDao();

    public List<Offer> getAllOffers() {
        List<Offer> offers = offerDao.findAll();
        if (offers.isEmpty()) {
            System.out.println("No offers are currently available.");
        }
        return offers;
    }

    public void addOffer(String name, String description, double price) {
        if (name == null || name.isEmpty() || price <= 0) {
            throw new IllegalArgumentException("Invalid offer data: Name must not be empty, and price must be positive.");
        }
        Offer offer = new Offer(0, name, description, price);
        offerDao.save(offer);
    }

}

