package start;


import rpc.RpcProvider;
import service.BatterCakeService;
import service.BatterCakeServiceImpl;

public class RpcBootStrap {
    public static void main(String[] args) throws Exception {
        //实例化“卖煎饼”这个服务的实现类
        BatterCakeService batterCakeService =new BatterCakeServiceImpl();
        //发布卖煎饼的服务：注册在20006端口，并把提供服务的实例传入
        RpcProvider.export(20006,batterCakeService);
    }
}