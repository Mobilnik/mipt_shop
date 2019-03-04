package ru.milandr.courses.myshop.services;

import org.springframework.stereotype.Service;
import ru.milandr.courses.myshop.daos.GoodDao;
import ru.milandr.courses.myshop.dtos.GoodDto;
import ru.milandr.courses.myshop.entities.Good;

@Service
public class GoodService {

    private GoodDao goodDao;

    public GoodService(GoodDao goodDao) {
        this.goodDao = goodDao;
    }

    public GoodDto findGood(Long goodId) {
        Good good = goodDao.findOne(goodId);
        return buildGoodDtoFromGood(good);
    }

    private GoodDto buildGoodDtoFromGood(Good good) {
        GoodDto goodDto = new GoodDto();
        goodDto.setId(good.getId());
        goodDto.setName(good.getName());
        goodDto.setPhoto(good.getPhoto());
        goodDto.setPrice(good.getPrice());

        return goodDto;
    }
}