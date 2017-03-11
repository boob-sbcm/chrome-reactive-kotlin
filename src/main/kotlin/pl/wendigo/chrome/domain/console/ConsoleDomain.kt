package pl.wendigo.chrome.domain.console

/**
 * This domain is deprecated - use Runtime or Log instead.
 */
@pl.wendigo.chrome.ProtocolDeprecated class ConsoleDomain internal constructor(private val connection : pl.wendigo.chrome.DebuggerConnection) {

	/**
	 * Enables console domain, sends the messages collected so far to the client by means of the <code>messageAdded</code> notification.
	 */
	  fun enable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Console.enable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Disables console domain, prevents further console messages from being reported to the client.
	 */
	  fun disable() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Console.disable", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

	/**
	 * Does nothing.
	 */
	  fun clearMessages() : io.reactivex.Flowable<pl.wendigo.chrome.ResponseFrame> {
        return connection.runAndCaptureResponse("Console.clearMessages", null, pl.wendigo.chrome.ResponseFrame::class.java)
	}

  
  /**
   * Issued when new console message is added.
   */
   fun messageAdded() : io.reactivex.Flowable<MessageAddedEvent> {
      return connection.captureEvents("Console.messageAdded", MessageAddedEvent::class.java)
   }
}








/**
 * Represents responseFrame from Console. method call.
 *
 * Issued when new console message is added.
 */
data class MessageAddedEvent(
  /**
   * Console message that has been added.
   */
  val message : ConsoleMessage

) : pl.wendigo.chrome.DebuggerEvent(domain = "Console", name = "messageAdded")

