package myshop.service;


import lombok.AllArgsConstructor;
import myshop.data.MyShopDto;
import myshop.mapper.MyShopMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MyShopService {

    private final MyShopMapper myshopMapper;

    public int getTotalCount() {
        return myshopMapper.getTotalCount();
    }

    public void insertShop(MyShopDto dto) {
        myshopMapper.insertShop(dto);
    }

    public List<MyShopDto> getSangpumList() {
        return myshopMapper.getSangpumList();
    }

    public MyShopDto getData(int num) {
        return myshopMapper.getData(num);
    }

    public void delete(int num) {
        myshopMapper.delete(num);
    }

}
