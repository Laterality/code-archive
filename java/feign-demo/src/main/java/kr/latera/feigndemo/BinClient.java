package kr.latera.feigndemo;

import feign.RequestLine;

public interface BinClient {
    @RequestLine("GET /json")
    HttpBinJsonResponse requestJson();
}
