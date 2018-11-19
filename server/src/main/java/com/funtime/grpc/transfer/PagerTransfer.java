package com.funtime.grpc.transfer;

import com.funtime.grpc.common.pager.grpc.CommonService;
import org.springframework.data.domain.Page;

public class PagerTransfer {

    public static CommonService.Pager transferPager(Page page) {
        return CommonService.Pager.newBuilder()
                .setPage(page.getNumber())
                .setSize(page.getSize())
                .setTotalPages(page.getTotalPages())
                .setNumberElements(page.getNumberOfElements())
                .setTotalElements(page.getTotalElements())
                .setHasPrevious(page.hasPrevious())
                .setIsFirst(page.isFirst())
                .setHasNext(page.hasNext())
                .setIsLast(page.isLast())
                .setHasContent(page.hasContent())
                .build();
    }
}