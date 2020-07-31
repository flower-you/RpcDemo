package service;


/**
 * 卖煎饼服务的实现类
 *
 */
public class BatterCakeServiceImpl implements BatterCakeService {

    public String sellBatterCake(String name) {
        return name+"煎饼,卖的特别好";
    }    
}