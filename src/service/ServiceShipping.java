package service;

import model.product.ShippableItems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceShipping {
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
            System.out.println(itemCount.get(name)+"x "+name +" "+ (itemWeight.get(name)*1000));
        }
        System.out.printf("Total package weight %.1fkg\n", totalWeight);

    }
}
