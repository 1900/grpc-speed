package com.funtime.grpc.configuration;

import com.funtime.grpc.Constants;
import io.grpc.*;
import org.lognet.springboot.grpc.GRpcGlobalInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GRpcGlobalInterceptor
public class HeaderServerInterceptor implements ServerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(HeaderServerInterceptor.class.getName());

    public  static final Metadata.Key<String> OPENID_HEADER_KEY =
            Metadata.Key.of(Constants.OPEN_ID_KEY, Metadata.ASCII_STRING_MARSHALLER);

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata metadata, ServerCallHandler<ReqT, RespT> next) {
        logger.info("header received from client:" + metadata);

        Context context = Context.current().withValue(Constants.CONTEXT_OPEN_ID, metadata.get(OPENID_HEADER_KEY));
        return Contexts.interceptCall(context, call, metadata, next);
    }
}