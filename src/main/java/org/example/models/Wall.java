package org.example.models;

import org.example.interfaces.Block;
import org.example.interfaces.CompositeBlock;
import org.example.interfaces.Structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private final List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        for (Block block : blocks) {
            if (block.getColor().equals(color)) {
                return Optional.of(block);
            }
            if (block instanceof CompositeBlock) {
                List<Block> blocksFromComposite = ((CompositeBlock) block).getBlocks();
                for (Block blockFromComposite : blocksFromComposite) {
                    if (blockFromComposite.getColor().contains(color)){
                        return Optional.of(blockFromComposite);
                    }
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        ArrayList<Block> blocksByMaterial = new ArrayList<>();
        for (Block block : blocks) {
            if (block.getMaterial().equals(material)) {
                blocksByMaterial.add(block);
            }
            if (block instanceof CompositeBlock) {
                List<Block> blocksFromComposite = ((CompositeBlock) block).getBlocks();
                for (Block blockFromComposite : blocksFromComposite) {
                    if (blockFromComposite.getMaterial().contains(material)){
                        blocksByMaterial.add(blockFromComposite);
                    }
                }
            }
        }
        return blocksByMaterial;
    }

    @Override
    public int count() {
        return blocks.size();
    }
}
