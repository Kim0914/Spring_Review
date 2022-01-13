package hello.core_review.order;

public interface OrderService {
    Order createOrder(Long memberID, String itemName, int itemPrice);
}
