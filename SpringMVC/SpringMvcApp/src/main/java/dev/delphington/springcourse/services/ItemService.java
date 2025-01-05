package dev.delphington.springcourse.services;

import dev.delphington.springcourse.models.Item;
import dev.delphington.springcourse.models.Person;
import dev.delphington.springcourse.repositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemService {

    @Autowired
    private final ItemsRepository itemsRepository;

    public ItemService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }


    public List<Item> findByName(String itemName){
        return  itemsRepository.findByItemName(itemName);
    }

    public List<Item> findByOwner(Person person){
        return itemsRepository.findByOwner(person);
    }
}
