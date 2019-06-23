package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author zhengquan
 */
@RestController
@RequestMapping("/consumer/depart")
public class DepartController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient client;

    private static final String SERVICE_PROVIDER = "http://abcmsc-provider-depart";

    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Depart depart) {
        String url = SERVICE_PROVIDER + "/provider/depart/save";
        return restTemplate.postForObject(url, depart, Boolean.class);
    }

    @GetMapping("/discovery")
    public Object discoveryHandle() {
        //获取服务列表中所有服务名称,即spring.application.name的值
        List<String> services = client.getServices();
        for (String name : services) {
            //获取指定名称的所有服务提供者
            List<ServiceInstance> instances = client.getInstances(name);
            for (ServiceInstance instance : instances) {
                //获取服务id，即eureka,instance,instance-id
                String serviceId = instance.getServiceId();
                URI uri = instance.getUri();
                String host = instance.getHost();
                int port = instance.getPort();
                System.out.println(serviceId + ":" + uri);
                System.out.println(host + ":" + port);
            }
        }
        return services;
    }
}
