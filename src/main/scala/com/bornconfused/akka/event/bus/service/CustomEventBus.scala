package com.bornconfused.akka.event.bus.service

import akka.event.{ActorEventBus, LookupClassification}
import com.bornconfused.akka.event.bus.model.MessageEvent

/**
  * Created by ranand on 5/29/2017 AD.
  */
class CustomEventBus extends ActorEventBus with LookupClassification {
  type Event = MessageEvent
  type Classifier = String

  protected def mapSize(): Int = 3

  protected def classify(event: Event): Classifier =
    event.channel

  protected def publish(event: Event, subscriber: Subscriber): Unit =
    subscriber ! event

}
