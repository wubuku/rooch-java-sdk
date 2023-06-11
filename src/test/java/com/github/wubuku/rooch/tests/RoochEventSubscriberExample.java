package com.github.wubuku.rooch.tests;

import java.io.IOException;

public class RoochEventSubscriberExample {

    public static void main(String[] args) throws IOException {
//
//        RoochEventFilter eventFilter = new RoochEventFilter.MoveEventType("0x2::devnet_nft::MintNFTEvent");
//
//        //String serverUrl = "ws://localhost:9000";
//        WebSocketService service = new WebSocketService(serverUrl, false);
//        AtomicReference<Boolean> isClosed = new AtomicReference<>(false);
//
//        //service.connect();
//        service.connect(
//                (s) -> {
//                },
//                (e) -> {
//                    System.out.println("error: " + e);
//                },
//                () -> {
//                    System.out.println("close");
//                    isClosed.set(true);
//                });
//
//        RoochEventSubscriber subscriber = new RoochEventSubscriber(service);
//
//        Flowable<MintNFTEventNotification> moveEventNotificationFlowable
//                = subscriber.subscribe(eventFilter, MintNFTEventNotification.class);
//
//        Disposable disposable = moveEventNotificationFlowable
////                .timeout(10, TimeUnit.SECONDS)
////                .doOnError(e -> {
////                    System.out.println("error: " + e);
////                })
//                .subscribe(n -> {
//                    if (n.getParams() != null && n.getParams().getResult() != null) {
//                        System.out.println(n.getParams().getResult().toString());
//                    } else {
//                        System.out.println(n);
//                    }
//                });
//
//        while (true) {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (isClosed.get()) {
//                disposable.dispose();
//                break;
//            }
//        }
//
////        for (MintNFTEventNotification notification : moveEventNotificationFlowable.blockingIterable()) {
////            if (notification.getParams() != null && notification.getParams().getResult() != null) {
////                System.out.println(notification.getParams().getResult().toString());
////            } else {
////                System.out.println(notification);
////            }
////        }
//
//        System.out.println("done");
    }

//    public static class MintNFTEventNotification extends org.web3j.protocol.websocket.events.Notification<com.github.wubuku.rooch.bean.RoochMoveEventEnvelope<JsonRpcTests.MintNFTEvent>> {
//
//    }

}
