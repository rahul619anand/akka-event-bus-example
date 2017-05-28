package com.bornconfused.akka.event.bus.service

import akka.actor.Actor
import com.bornconfused.akka.event.bus.model.MessageEvent

/**
  * Created by ranand on 5/29/2017 AD.
  */
class Publisher(eventBus: CustomEventBus) extends Actor {

  override def receive: Receive = {
    case event: MessageEvent =>
      event.channel match {
        case "3" => println(s"Publisher : received response : ${event.message}")
        case _ => println(s"Publisher : publishing msg : $event")
                  eventBus.publish(event)
      }
  }

  override def preStart(): Unit = eventBus.subscribe(self, "3")
}
