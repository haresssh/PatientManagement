package hub.haresh.billingservice.grpc;

import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceGrpc.BillingServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingAccount(billing.BillingRequest request,
                                     StreamObserver<BillingResponse> responseObserver) {

        log.info("createBillingAccount request={}", request.toString());
        responseObserver.onNext(BillingResponse.newBuilder().setAccountId("haresh-account-id").setActive("true").build());
        responseObserver.onCompleted();
    }
}
