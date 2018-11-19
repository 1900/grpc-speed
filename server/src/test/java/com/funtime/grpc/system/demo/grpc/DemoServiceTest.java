package com.funtime.grpc.system.demo.grpc;

import com.funtime.grpc.GrpcTestBase;
import com.funtime.grpc.demo.grpc.*;
import com.funtime.grpc.common.pager.grpc.CommonService;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import org.junit.BeforeClass;
import org.junit.Test;

public class DemoServiceTest extends GrpcTestBase {

    private static DemoServiceGrpc.DemoServiceBlockingStub stub;

    @BeforeClass
    public static void initStub() {
        stub = DemoServiceGrpc.newBlockingStub(channel);
    }

    @Test
    public void get() throws Exception {

        GetAllRequest request = GetAllRequest.newBuilder()
                .setPage(0)
                .setSize(5)
                .build();
        GetAllReply reply = stub.getDemoInfo(request);
        CommonService.Pager page = reply.getPager();
        System.out.println("当前页：" + page.getPage());
        System.out.println("当前页大小：" + page.getSize());
        System.out.println("分页总数：" + page.getTotalPages());
        System.out.println("当前页上的元素数：" + page.getNumberElements());
        System.out.println("元素总数：" + page.getTotalElements());
        System.out.println("是否有上一页：" + page.getHasPrevious());
        System.out.println("是否为第一页：" + page.getIsFirst());
        System.out.println("是否有下一页：" + page.getHasNext());
        System.out.println("是否为最后一页：" + page.getIsLast());
        System.out.println("返回数据是否有内容：" + page.getHasContent());

        try {
            String json = JsonFormat.printer().print(reply);
            System.out.println(json);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}