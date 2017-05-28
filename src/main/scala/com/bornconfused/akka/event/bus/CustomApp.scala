package com.bornconfused.akka.event.bus

import akka.actor.{ActorSystem, Props}
import com.bornconfused.akka.event.bus.model.{Message, MessageEvent}
import com.bornconfused.akka.event.bus.service.{CustomEventBus, Publisher, Subscriber1, Subscriber2}


object CustomApp extends App {

  val system = ActorSystem("MySystem")
  val eventBus = new CustomEventBus
  val CHANNEL_1 = "1"
  val CHANNEL_2 = "2"

  val publisher = system.actorOf(Props(classOf[Publisher], eventBus))
  system.actorOf(Props(classOf[Subscriber1], eventBus))
  system.actorOf(Props(classOf[Subscriber2], eventBus))

  publisher ! MessageEvent(CHANNEL_1, Message(text = "hello subscriber 1"))
  publisher ! MessageEvent(CHANNEL_2, Message(text = "hello subscriber 2"))
}










