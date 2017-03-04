package pl.wendigo.chrome.domain.profiler

/**
 * ProfilerDomain represents remote debugger protocol domain.
 *
 * This class was autogenerated by main.go. Do not edit :)
 */
class ProfilerDomain internal constructor(private val connection : pl.wendigo.chrome.RemoteChromeConnection) {

	/**
	 *
	 */
	fun enable() : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.enable", null, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 *
	 */
	fun disable() : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.disable", null, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * Changes CPU profiler sampling interval. Must be called before CPU profiles recording started.
	 */
	fun setSamplingInterval(input : SetSamplingIntervalRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.setSamplingInterval", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 *
	 */
	fun start() : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("$domainName.start", null, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 *
	 */
	fun stop() : io.reactivex.Flowable<StopResponse> {
        return connection.runAndCaptureResponse("$domainName.stop", null, StopResponse::class.java)
	}

  /**
   * Sent when new profile recodring is started using console.profile() call.
   */
  fun onConsoleProfileStarted() : io.reactivex.Flowable<ConsoleProfileStartedEvent> {
      return connection.captureEvents("$domainName.consoleProfileStarted", ConsoleProfileStartedEvent::class.java)
  }

  /**
   *
   */
  fun onConsoleProfileFinished() : io.reactivex.Flowable<ConsoleProfileFinishedEvent> {
      return connection.captureEvents("$domainName.consoleProfileFinished", ConsoleProfileFinishedEvent::class.java)
  }

  companion object {
    private const val domainName = "Profiler"
  }
}

data class SetSamplingIntervalRequest (
    /**
     * New sampling interval in microseconds.
     */
    val interval : Int

)

data class StopResponse (
  /**
   * Recorded profile.
   */
  val profile : Profile

)

data class ConsoleProfileStartedEvent (
  /**
   *
   */
  val id : String,

  /**
   * Location of console.profile().
   */
  val location : pl.wendigo.chrome.domain.debugger.Location,

  /**
   * Profile title passed as an argument to console.profile().
   */
  val title : String? = null

)

data class ConsoleProfileFinishedEvent (
  /**
   *
   */
  val id : String,

  /**
   * Location of console.profileEnd().
   */
  val location : pl.wendigo.chrome.domain.debugger.Location,

  /**
   *
   */
  val profile : Profile,

  /**
   * Profile title passed as an argument to console.profile().
   */
  val title : String? = null

)

