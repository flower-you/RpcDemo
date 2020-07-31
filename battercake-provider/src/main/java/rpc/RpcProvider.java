package rpc;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * RPC服务提供器
 * 1,将需要发布的服务存储在一个内存变量serviceList中
 * 2,启动socket，server.accept()方法阻塞在那，监听输入
 * 3,针对每一个请求，单独启动一个线程处理
 */
public class RpcProvider {

    //存储注册的服务列表
    private static List<Object> serviceList;

    /**
     * 发布rpc服务
     * @param services 提供（卖煎饼）服务的实例对象
     * @param port 监听的端口
     * @throws Exception
     */
    public static void export(int port,Object... services) throws Exception {
        serviceList=Arrays.asList(services);
        ServerSocket server = new ServerSocket(port);
        Socket client = null;
        while (true) {
            //阻塞等待输入，每来一个请求就会产生一个socket对象
            client = server.accept();
            //每一个请求，启动一个线程处理
            new Thread(new ServerThread(client,serviceList)).start();
        }
    }
}