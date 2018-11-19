package com.funtime.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class GrpcTestBase {

    protected static ManagedChannel channel;

    @BeforeClass
    public static void initChannel() {
        channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .intercept(new UserTokenInterceptor())
                .build();
    }

    @AfterClass
    public static void shutdownChannel() {
        channel.isShutdown();
    }
}
