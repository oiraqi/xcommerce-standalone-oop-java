package ecommerce.core;

import java.io.Serializable;

public enum OrderStatus implements Serializable{
    HANDLING,
    SHIPPED,
    DELIVERED,
    ONHOLD,
    CANCELED
}
