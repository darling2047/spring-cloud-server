package com.darling.eureka.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @description: 复制均衡策略设置
 * @author: dll
 * @date: Created in 2021/9/2 11:37
 * @version: 1.0
 * @modified By:
 */
@Component
public class RibbonConfig {

    /**
     * 负载均衡策略配置
     * 默认：ZoneAvoidanceRule（区域权衡策略）：复合判断Server所在区域的性能和Server的可用性，轮询选择服务器。
     * BestAvailableRule（最低并发策略）：会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务。
     *       逐个找服务，如果断路器打开，则忽略。
     * RoundRobinRule  简单轮询选择一个服务器
     * RandomRule      随机选择一个服务器
     * AvailabilityFilteringRule（可用过滤策略）：会先过滤掉多次访问故障而处于断路器跳闸状态的服务和过滤并发的连接数量超过阀值得服
     *      务，然后对剩余的服务列表安装轮询策略进行访问。
     * WeightedResponseTimeRule（响应时间加权策略）：据平均响应时间计算所有的服务的权重，响应时间越快服务权重越大，容易被选中的概率
     *      就越高。刚启动时，如果统计信息不中，则使用RoundRobinRule(轮询)策略，等统计的信息足够了会自动的切换到WeightedResponseTimeRule。响应时间长，权重低，被选择的概率低。反之，同样道理。此策略综合了各种因素（网络，磁盘，IO等），这些因素直接影响响应时间。
     * RetryRule       先按照RoundRobinRule(轮询)的策略获取服务，如果获取的服务失败则在指定的时间会进行重试，进行获取可用的服务。
     *      如多次获取某个服务失败，就不会再次获取该服务。主要是在一个时间段内，如果选择一个服务不成功，就继续找可用的服务，直到超时
     *
     *
     * @return
     */
    @Bean
    public IRule myRule() {
        //return new RandomRule();
        // return new RetryRule();
        return new RoundRobinRule();
    }

}
