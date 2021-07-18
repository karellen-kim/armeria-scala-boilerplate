package app

import org.slf4j.LoggerFactory

import scala.concurrent.Future

object HelloService {
  private val logger = LoggerFactory.getLogger(getClass)
}

/*class HelloService extends HelloServiceGrpc.HelloService {
  import HelloService._

  override def hello(request: HelloRequest): Future[HelloReply] = {
    val name = request.name
    logger.info("Received message: {}", name)
    val reply = HelloReply().withMessage(s"How are u, $name")
    Future.successful(reply)
  }

}*/
