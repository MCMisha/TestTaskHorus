package org.example;


import org.example.impl.BlockImpl;
import org.example.impl.CompositeBlockImpl;
import org.example.interfaces.Block;
import org.example.interfaces.CompositeBlock;
import org.example.interfaces.Structure;
import org.example.models.Wall;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Block block = new BlockImpl("Red", "Stone");
        System.out.println(block.getColor());
        System.out.println(block.getMaterial());

        CompositeBlock compositeBlock = new CompositeBlockImpl(List.of(new BlockImpl("Red", "Stone"), new BlockImpl("Blue", "Wood")));
        System.out.println(compositeBlock.getColor());
        System.out.println(compositeBlock.getMaterial());

        Structure wall = new Wall(List.of(new BlockImpl("Red", "Stone"), new BlockImpl("Blue", "Wood")));
        System.out.println(wall.findBlockByColor("Red").isPresent());
        System.out.println(wall.findBlocksByMaterial("Stone").size());
        System.out.println(wall.count());
    }
}