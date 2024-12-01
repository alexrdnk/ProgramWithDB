package pwr.jp.radionenko.service;

import pwr.jp.radionenko.dao.OrderDao;
import pwr.jp.radionenko.model.Order;

import java.util.List;

public class OrganizerService {

    private final OrderDao OrderDao = new OrderDao();

    public List<Order> getOrdersToRealize() {
        return OrderDao.findAll().stream()
                .filter(z -> "In realization".equals(z.getStatus()))
                .toList();
    }

    public void confirmParticipants(int id) {

        Order order = OrderDao.findAll().stream()
                .filter(z -> z.getId() == id)
                .findFirst()
                .orElse(null);

        if (order != null) {
            order.setStatus("Accepted");
            OrderDao.update(order);
        } else {
            System.out.println("Order with this ID is not found");
        }

    }

}
