package app

import com.linecorp.armeria.common.{HttpRequest, HttpResponse, HttpStatus}
import com.linecorp.armeria.server.{AbstractHttpService, ServiceRequestContext}

class MyHttpService extends AbstractHttpService {

  @throws[Exception]
  override def doGet(ctx: ServiceRequestContext,
                      req: HttpRequest): HttpResponse = {
    HttpResponse.of(HttpStatus.OK)
  }

  @throws[Exception]
  override def doPost(ctx: ServiceRequestContext,
                     req: HttpRequest): HttpResponse = {
    HttpResponse.of(HttpStatus.OK)
  }
}
