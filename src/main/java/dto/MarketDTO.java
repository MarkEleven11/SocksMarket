package dto;

import models.Colors;
import models.Size;


    public class MarketDTO {

        private Colors color;

        private Size size;

        private int cottonPart;

        private int quantity;

        public MarketDTO(Colors color, Size size, int cottonPart, int quantity) {
            this.color = color;
            this.size = size;
            this.cottonPart = cottonPart;
            this.quantity = quantity;
        }

        public Colors getColor() {
            return color;
        }

        public void setColor(Colors color) {
            this.color = color;
        }

        public Size getSize() {
            return size;
        }

        public int getCottonPart() {
            return cottonPart;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setSize(Size size) {
            this.size = size;
        }

        public void setCottonPart(int cottonPart) {
            this.cottonPart = cottonPart;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

