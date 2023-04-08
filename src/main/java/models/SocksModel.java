package models;

import java.util.Objects;

public class SocksModel {
    private final Colors color;

    private final Size size;

    private final int cottonPart;

    public SocksModel(Colors color, Size size, int cottonPart) {
        this.color = color;
        this.size = size;
        this.cottonPart = cottonPart;
    }

    public Colors getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public int getCottonPart() {
        return cottonPart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocksModel that = (SocksModel) o;
        return cottonPart == that.cottonPart && color == that.color && size == that.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, size, cottonPart);
    }
}
