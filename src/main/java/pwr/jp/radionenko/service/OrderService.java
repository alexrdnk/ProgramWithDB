package pwr.jp.radionenko.service;

import pwr.jp.radionenko.dao.OrderDao;
import pwr.jp.radionenko.model.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OrderService {

    private final OrderDao OrderDao = new OrderDao();

    public void placeOrder(int clientId, int offerId) {
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Order order = new Order(0, clientId, 1, offerId, "Waiting for realization", now, null);
        OrderDao.save(order);
    }

    public void setRealizationDate(int id, String realizationDate) {
        Order order = OrderDao.findAll().stream()
                .filter(z -> z.getId() == id)
                .findFirst()
                .orElse(null);

        if (order != null) {
            order.setRealizationDate(realizationDate);
            OrderDao.update(order);
        } else {
            System.out.println("Order with this ID is not found");
        }
    }

    public List<Order> getOrdersByClientId(int clientId) {
        return OrderDao.findByClientId(clientId);
    }


}
