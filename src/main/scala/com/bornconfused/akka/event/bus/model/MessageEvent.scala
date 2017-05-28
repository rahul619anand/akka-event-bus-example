package com.bornconfused.akka.event.bus.model

/**
  * Created by ranand on 5/29/2017 AD.
  */
case class MessageEvent(val channel:String, val message:Message)
