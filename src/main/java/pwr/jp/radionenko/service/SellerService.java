package pwr.jp.radionenko.service;

import pwr.jp.radionenko.dao.OrderDao;
import pwr.jp.radionenko.model.Order;

import java.util.List;

public class SellerService {

    private final OrderDao OrderDao = new OrderDao();

    public List<Order> getOrdersForApproval() {
        return OrderDao.findAll().stream()
                .filter(z -> "Waiting for realization".equals(z.getStatus()))
                .toList();
    }

    public void approveOrder(int id) {
        Order order = OrderDao.findAll().stream()
                .filter(z -> z.getId() == id)
                .findFirst()
                .orElse(null);

        if (order != null) {
            order.setStatus("In realization");
            OrderDao.update(order);
        } else {
            System.out.println("Order with this ID is not found");
        }
    }

}
