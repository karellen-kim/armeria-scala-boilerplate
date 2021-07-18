package app

import com.linecorp.armeria.common.grpc.GrpcSerializationFormats
import com.linecorp.armeria.server.Server
import com.linecorp.armeria.server.docs.DocService
import com.linecorp.armeria.server.grpc.GrpcService
import com.linecorp.armeria.server.healthcheck.HealthCheckService
import io.grpc.protobuf.services.ProtoReflectionService
import org.slf4j.LoggerFactory

object Main extends App {
  private val logger = LoggerFactory.getLogger(getClass)
  private val DEFAULT_PORT = 9000

  val myGrpcService = GrpcService
    .builder()
    //.addService(ServiceModule.helloServiceDefinition)
    .addService(ProtoReflectionService.newInstance())
    .supportedSerializationFormats(GrpcSerializationFormats.values())
    .enableUnframedRequests(true)
    .build()

  val server =
    Server
      .builder()
      .service("/", new MyHttpService)
      .service(myGrpcService)
      .service("/monitor/l7check", HealthCheckService.of())
      .serviceUnder("/docs", new DocService)
      .http(DEFAULT_PORT)
      .build()

  server.start().join()
}
