package pl.maciejburzynski.bakery.security;

import lombok.Getter;

@Getter
public enum UserPermission {
    ORDERS_READ("orders:read"),
    ORDERS_ADD("orders:add"),
    CUSTOMERS_READ("customers:read");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }
}
