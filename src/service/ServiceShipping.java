package service;

import model.product.ShippableItems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceShipping {
//     I did here List of shippable Items because in an interface ,
//     it can call any object that has implemented the methods that are in the interface
//
    public static void ship(List<ShippableItems> items){
        if(items.isEmpty()){
            return;
        }
        System.out.println("\n** Shipment notice **");
        double totalWeight=0;
        Map<String,Integer> itemCount=new HashMap<>();
        Map<String,Double> itemWeight=new HashMap<>();
        for(ShippableItems item:items){
            String name=item.getName();
            itemCount.put(name,itemCount.getOrDefault(name,0)+1);
            itemWeight.put(name, item.getWeight());
            totalWeight+=item.getWeight();
        }
        for(String name: itemCount.keySet()){
            System.out.printf("%dx %s %.0fg\n", itemCount.get(name), name, itemWeight.get(name) * 1000);
        }
        System.out.printf("Total package weight %.1fkg\n", totalWeight);

    }
}
