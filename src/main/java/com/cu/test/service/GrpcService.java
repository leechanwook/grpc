package com.cu.test.service;

import com.cu.proto.SampleRequest;
import com.cu.proto.SampleResponse;
import com.cu.proto.SampleServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class GrpcService {
    private static final int PORT = 3030;
    public static final String HOST = "localhost";
    private SampleServiceGrpc.SampleServiceBlockingStub blockingStub;
    private ManagedChannel channel;


    @PostConstruct
    public void test(){
        this.channel = ManagedChannelBuilder.forAddress(HOST, PORT)
                .usePlaintext()
                .build();
        this.blockingStub = SampleServiceGrpc.newBlockingStub(channel);
    }




    public String sampleCall(String user, String message) {
        final SampleRequest sampleRequest = SampleRequest.newBuilder()
                .setUserId("test.yoon")
                .setMessage("grpc request")
                .build();

        SampleResponse response = blockingStub.sampleCall(sampleRequest);
        JSONObject item = new JSONObject();
        item.put("message", response.getMessage());
        item.put("teste", response.getTest());

        return item.toString();
    }




}
