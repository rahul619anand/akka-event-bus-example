package com.bornconfused.akka.event.bus.service

import akka.actor.Actor
import com.bornconfused.akka.event.bus.model.{Message, MessageEvent}

/**
  * Created by ranand on 5/29/2017 AD.
  */
class Subscriber1(eventBus: CustomEventBus) extends Actor {

  override def receive: Receive = {
    case event: MessageEvent =>
      println(s"Subscriber 1 : received msg: ${event.message}")
      eventBus.publish(new MessageEvent("3" , new Message ("Ack 1")))
  }

  override def preStart(): Unit = eventBus.subscribe(self, "1")
}
