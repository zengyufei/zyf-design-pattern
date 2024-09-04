package com.zyf.designPattern.chain;

import cn.hutool.core.util.TypeUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 抽象责任链上下文
 */
public final class AbstractChainContext<T> implements ApplicationListener<ContextRefreshedEvent> {

    private final Map<String, List<AbstractChainHandler>> abstractChainHandlerContainer = new HashMap<>();

    /**
     * 责任链组件执行
     *
     * @param mark         责任链组件标识
     * @param requestParam 请求参数
     */
    public void handler(String mark, T requestParam) {
        List<AbstractChainHandler> abstractChainHandlers = abstractChainHandlerContainer.get(mark);
        if (CollectionUtils.isEmpty(abstractChainHandlers)) {
            throw new RuntimeException(String.format("[%s] Chain of Responsibility ID is undefined.", mark));
        }
        abstractChainHandlers.forEach(each -> {
            final Type typeArgument = TypeUtil.getTypeArgument(each.getClass(), 0);
            if (typeArgument != requestParam.getClass()) {
                throw new IllegalArgumentException("类型不正确! 请确认 mark 正确!!");
            }
            each.handler(requestParam);
        });
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Map<String, AbstractChainHandler> chainFilterMap = event.getApplicationContext().getBeansOfType(AbstractChainHandler.class);
        chainFilterMap.forEach((beanName, bean) -> {
            List<AbstractChainHandler> abstractChainHandlers = abstractChainHandlerContainer.get(bean.mark());
            if (CollectionUtils.isEmpty(abstractChainHandlers)) {
                abstractChainHandlers = new ArrayList();
            }
            abstractChainHandlers.add(bean);
            List<AbstractChainHandler> actualAbstractChainHandlers = abstractChainHandlers.stream()
                    .sorted(Comparator.comparing(Ordered::getOrder))
                    .collect(Collectors.toList());
            abstractChainHandlerContainer.put(bean.mark(), actualAbstractChainHandlers);
        });
    }
}
