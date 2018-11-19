package com.funtime.grpc.system.demo.grpc;


import com.funtime.grpc.system.demo.domain.Demo;
import com.funtime.grpc.system.demo.service.DemoService;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@GRpcService
public class DemoServiceGrpcImpl extends DemoServiceGrpc.BannerServiceImplBase {
    @Autowired
    private DemoService demoService;

    @Override
    public void getAll(GetAllRequest request, StreamObserver<GetAllReply> responseObserver) {
        List<Demo> demos = demoService.getAll();

        List<DemoInfo> infs = new ArrayList<>();
        demos.forEach(b -> {
            DemoInfo info = DemoInfo.newBuilder()
                    .setId(b.getId())
                    .setTitle(b.getTitle())
                    .setSubTitle(b.getSubTitle())
                    .setImage(b.getImage())
                    .setLinkUrl(b.getLinkUrl())
                    .build();
            infs.add(info);
        });
        GetAllReply reply = GetAllReply.newBuilder()
                .addAllBanner(infs)
                .build();

        responseObserver.onNext(reply);
    }
}
