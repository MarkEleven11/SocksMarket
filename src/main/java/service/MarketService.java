package service;

import Exeptions.EmptyFieldExeptions;
import Exeptions.EmptyMarketExeptions;
import Exeptions.InvalidArgumentExeption;
import dto.MarketDTO;
import models.Colors;
import models.Size;
import models.SocksModel;

import java.util.HashMap;
import java.util.Map;

public class MarketService {
    private final Map<SocksModel, Integer> socks = new HashMap<>();

    public void addSocks(MarketDTO marketDTO) {
        checkExeptions(marketDTO);
        SocksModel socksModel = mapToModel(marketDTO);
        if (socks.containsKey(socksModel)) {
            socks.put(socksModel, socks.get(socksModel) + marketDTO.getQuantity());
        }
        else {socks.put(socksModel, marketDTO.getQuantity());
        }
    }

    public void soldSocks (MarketDTO marketDTO) {
        quantitySocks(marketDTO);
    }

    public void removedSocks (MarketDTO marketDTO) {
        quantitySocks(marketDTO);
    }

    private void quantitySocks (MarketDTO marketDTO) {
        checkExeptions(marketDTO);
        SocksModel socksModel = mapToModel((marketDTO));
        int quantity = socks.getOrDefault(socksModel, 0);
        if (quantity >= marketDTO.getQuantity()) {
            socks.put(socksModel, quantity - marketDTO.getQuantity());
        } else {
            throw new EmptyMarketExeptions("Количество товара отсутствует");
        }
    }

    public int getSockQuantity (Colors colors, Size size, Integer cottonMin, Integer cottonMax) {
        int total = 0;
        for (Map.Entry<SocksModel, Integer> entry : socks.entrySet()) {
            if (colors != null && !entry.getKey().getColor().equals(colors)) {
                continue;
            }
            if (size != null && !entry.getKey().getSize().equals(size)) {
                continue;
            }
            if (cottonMin != null && entry.getKey().getCottonPart() < cottonMin) {
                continue;
            }
            if (cottonMax != null && entry.getKey().getCottonPart() > cottonMax) {
                continue;
            }
            total += entry.getValue();
        }
        return total;
    }

    private void checkExeptions(MarketDTO marketDTO) {
        if (marketDTO.getColor() == null || marketDTO.getSize() == null) {
            throw new EmptyFieldExeptions("Поля пустые. Заполните необходимые поля");
        }
        if (marketDTO.getQuantity() <= 0) {
            throw new InvalidArgumentExeption("Количество носков не может быть отрицательным, введите верное значение.");
        }
        if (marketDTO.getCottonPart() < 0 || marketDTO.getCottonPart() > 100) {
            throw new InvalidArgumentExeption("Количество хлопка не может быть меньше нуля или больше ста, введите верное значение.");
        }
    }

    private SocksModel mapToModel(MarketDTO marketDTO) {
        return new SocksModel(marketDTO.getColor(), marketDTO.getSize(), marketDTO.getCottonPart());
    }
}
