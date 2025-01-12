package org.learning.Machine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Inventory {

    private Map<Integer, Integer> availableProducts;
    private Map<Integer, Product> idProductMap;
    private final ReentrantLock reentrantLock = new ReentrantLock(true);

    Inventory() {
        availableProducts = new ConcurrentHashMap<>();
        idProductMap = new ConcurrentHashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        reentrantLock.lock();
        try {
            availableProducts.put(product.getId(),
                    availableProducts.getOrDefault(product.getId(), 0) + quantity);

            if (!idProductMap.containsKey(product.getId())) {
                idProductMap.put(product.getId(), product);
            }
            System.out.println("Product added successfully");
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while adding the product");
        } finally {
            reentrantLock.unlock();
        }
    }

    public void removeProduct(Product product) {
        reentrantLock.lock();
        try {
            if (availableProducts.containsKey(product.getId())) {
                availableProducts.remove(product.getId());

                idProductMap.remove(product.getId());

                System.out.println("Product removed successfully");
            } else {
                throw new RuntimeException("Product does not exist");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while removing the product");
        } finally {
            reentrantLock.unlock();
        }
    }

    public void updateStock(int productId, int quantity) {
        availableProducts.put(productId,
                availableProducts.get(productId) - quantity);
    }

    public void displayAvailableProducts() {
        reentrantLock.lock();
        try {
            System.out.println("\t \t Available Products");
            System.out.println("*****************************************");
            for (Map.Entry<Integer, Integer> availableProduct: availableProducts.entrySet()) {
                Product product = idProductMap.get(availableProduct.getKey());
                System.out.println("Product - " + product.getName() + " Quantity - " + availableProduct.getValue());
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean isProductAvailable(int id) {
        reentrantLock.lock();
        try {
            if (idProductMap.containsKey(id)) {
                if (availableProducts.containsKey(id) && availableProducts.get(id) > 0) {
                    return true;
                }
                System.out.println("Entered Product does not exist and is out of stock");
            } else {
                System.out.println("Please Enter a valid product Id");
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public Product getProductDetails(int productId) {
        if (idProductMap.containsKey(productId)) {
            return idProductMap.get(productId);
        } else {
            throw new RuntimeException("Product does not exist.");
        }
    }
}
