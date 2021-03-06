package com.xrw.springCloudAlibaba.service;

import com.xrw.springCloudAlibaba.vo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 文件服务调用接口,by openFeign
 * @return:
 * @Author: 谢荣旺
 * @Date: 2020/12/21
 */
@Service
@FeignClient(value = "cloud-file",fallback = TestFallbackService.class)
public interface FileFeignService {

    /**
     * @Description: 测试类
     * @return: void
     * @Author: 谢荣旺
     * @Date: 2020/12/14
     */
    @RequestMapping("/cloud/file/upload")
    public CommonResult<String> upload();

    /**
     * @Description: 超时控制
     * @return: void
     * @Author: 谢荣旺
     * @Date: 2020/12/14
     */
    @GetMapping(value = "/cloud/file/feign/timeout")
    public CommonResult<String> paymentFeignTimeout();

    /**
     * @Description: 测试feign的fallback兜底方法
     * @param : 
     * @return: com.xrw.springCloudAlibaba.vo.CommonResult
     * @Author: 谢荣旺
     * @Date: 2020/12/28
     */
    @RequestMapping("/cloud/file/testSentinelResource3")
    public CommonResult testSentinelResource3();

}
