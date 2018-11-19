package com.funtime.grpc;

import com.funtime.grpc.configuration.HeaderServerInterceptor;
import io.grpc.*;

public class UserTokenInterceptor implements ClientInterceptor {

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method,
                                                               CallOptions callOptions, Channel next) {
        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                headers.put(HeaderServerInterceptor.OPENID_HEADER_KEY, "ASDFGHJKLQWERTYY");
                super.start(responseListener, headers);
            }
        };
    }
}