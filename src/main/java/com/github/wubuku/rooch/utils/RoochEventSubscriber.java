package com.github.wubuku.rooch.utils;

import org.web3j.protocol.Web3jService;

public class RoochEventSubscriber {
    public static final String SUBSCRIBE_EVENT_METHOD = "rooch_subscribeEvent";
    public static final String UNSUBSCRIBE_EVENT_METHOD = "rooch_unsubscribeEvent";

    private final Web3jService web3jService;

    public RoochEventSubscriber(Web3jService web3jService) {
        this.web3jService = web3jService;
    }
//
//    public Flowable<EventNotification> subscribe(RoochEventFilter eventFilter) {
//        return web3jService.subscribe(
//                new Request<>(SUBSCRIBE_EVENT_METHOD, Collections.singletonList(eventFilter), web3jService,
//                        EthSubscribe.class),
//                UNSUBSCRIBE_EVENT_METHOD, EventNotification.class);
//    }
//
//    public <T extends Notification<?>> Flowable<T> subscribe(RoochEventFilter eventFilter, Class<T> responseType) {
//        return web3jService.subscribe(
//                new Request<>(SUBSCRIBE_EVENT_METHOD, Collections.singletonList(eventFilter), web3jService,
//                        EthSubscribe.class),
//                UNSUBSCRIBE_EVENT_METHOD, responseType);
//    }

}
