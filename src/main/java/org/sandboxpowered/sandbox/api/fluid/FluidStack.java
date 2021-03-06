package org.sandboxpowered.sandbox.api.fluid;

import org.sandboxpowered.sandbox.api.component.Component;
import org.sandboxpowered.sandbox.api.util.Functions;
import org.sandboxpowered.sandbox.api.util.Mono;
import org.sandboxpowered.sandbox.api.util.nbt.CompoundTag;
import org.sandboxpowered.sandbox.api.util.nbt.ReadableCompoundTag;

public interface FluidStack {

    static FluidStack of(Mono<Fluid> mono) {
        return of(mono, 1);
    }

    static FluidStack of(Mono<Fluid> mono, int amount) {
        return mono.isPresent() ? of(mono.get(), amount) : empty();
    }

    static FluidStack of(Fluid fluid) {
        return of(fluid, 1000);
    }

    static FluidStack of(Fluid fluid, int amount) {
        return Functions.fluidStackFunction.apply(fluid, amount);
    }

    static FluidStack empty() {
        return of(Fluids.EMPTY, 0);
    }

    static FluidStack read(ReadableCompoundTag tag) {
        return Functions.fluidStackFromTagFunction.apply(tag);
    }

    boolean isEmpty();

    Fluid getFluid();

    int getVolume();

    FluidStack setVolume(int volume);

    FluidStack copy();

    default FluidStack shrink() {
        return shrink(1);
    }

    FluidStack shrink(int amount);

    default FluidStack grow() {
        return shrink(1);
    }

    FluidStack grow(int amount);

    boolean hasTag();

    CompoundTag getTag();

    void setTag(CompoundTag tag);

    CompoundTag getOrCreateTag();

    CompoundTag getChildTag(String key);

    CompoundTag getOrCreateChildTag(String key);

    CompoundTag asTag();

    default <X> Mono<X> getComponent(Component<X> component) {
        return getFluid().getComponent(component, this);
    }

    boolean isEqualTo(FluidStack stack);

    boolean areTagsEqual(FluidStack stack);
}
