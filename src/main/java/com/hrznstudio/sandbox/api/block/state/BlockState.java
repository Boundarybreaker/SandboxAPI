package com.hrznstudio.sandbox.api.block.state;

import com.hrznstudio.sandbox.api.block.IBlock;

public interface BlockState {
    IBlock getBlock();

    default boolean isAir() {
        return getBlock().isAir(this);
    }
}
