package app

import scala.concurrent.ExecutionContext

object ServiceModule {
  def ec = ExecutionContext.global

  //def helloService = new HelloService()

  //def helloServiceDefinition = HelloServiceGrpc.bindService(helloService, ec)
}
